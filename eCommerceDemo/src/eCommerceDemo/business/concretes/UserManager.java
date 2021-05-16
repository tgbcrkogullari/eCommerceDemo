package eCommerceDemo.business.concretes;

import eCommerceDemo.business.abstracts.UserCheckService;
import eCommerceDemo.business.abstracts.UserService;
import eCommerceDemo.business.abstracts.UserUnusedEmailService;
import eCommerceDemo.business.abstracts.UserVerifyService;
import eCommerceDemo.dataAccess.abstracts.UserDao;
import eCommerceDemo.entities.concretes.User;

public class UserManager implements UserService {

		UserCheckService userCheckService;
		UserDao userDao;
		UserUnusedEmailService userUnusedEmailService;
		UserVerifyService userVerifyService;
		
	public UserManager(UserCheckService userCheckService, UserDao userDao,
				UserUnusedEmailService userUnusedEmailService, UserVerifyService userVerifyService) {
			super();
			this.userCheckService = userCheckService;
			this.userDao = userDao;
			this.userUnusedEmailService = userUnusedEmailService;
			this.userVerifyService = userVerifyService;
		}

	@Override
	public void register(User user) {
		if(userCheckService.nameController(user.getFirstName(), user.getLastName()) && userCheckService.emailController(user.getEmail()) 
			&& userCheckService.passwordController(user.getPassword()) && userUnusedEmailService.isEmailAvailable(user.getEmail())) {
			
			userDao.add(user);
			userVerifyService.sendVerifyEmail(user.getEmail());
		}
		
	}

	@Override
	public void logIn(String email, String password) {
		
		boolean flag = false;
		for(User user : userDao.getAll()) {
			
			if(email.equals(user.getEmail()) && password.equals(user.getPassword())) {
				System.out.println(user.getFirstName() + " " + user.getLastName() + " Kullanýcý giriþ yaptý.");
				flag = true;
				return;
			}
			if(! flag) {
				System.out.println("Kullanýcý bulunamadý.");
			}
		}
		
	}

}
