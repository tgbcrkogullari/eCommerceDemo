package eCommerceDemo;

import eCommerceDemo.business.abstracts.UserService;
import eCommerceDemo.business.concretes.UserCheckManager;
import eCommerceDemo.business.concretes.UserManager;
import eCommerceDemo.business.concretes.UserUnusedEmailManager;
import eCommerceDemo.business.concretes.UserVerifyManager;
import eCommerceDemo.core.GoogleManagerAdapter;
import eCommerceDemo.core.GoogleService;
import eCommerceDemo.dataAccess.abstracts.UserDao;
import eCommerceDemo.dataAccess.concretes.HibernateUserDao;
import eCommerceDemo.entities.concretes.User;

public class Main {

	public static void main(String[] args) {
		User user = new User(1,"Tuðba","Çýrakoðullarý","tgbcrkogullari@gmail.com","123456");
		
		GoogleService googleService = new GoogleManagerAdapter();
		
		UserDao userDao = new HibernateUserDao();
		UserService userService = new UserManager(new UserCheckManager(), userDao, new UserUnusedEmailManager(userDao), new UserVerifyManager());
		userService.register(user);
		
		userService.logIn("tgbcrkogullari@gmail.com", "123456");
		
		googleService.logInWithGoogle();
		
		

	}

}
