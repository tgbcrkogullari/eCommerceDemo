package eCommerceDemo.business.concretes;

import eCommerceDemo.business.abstracts.UserUnusedEmailService;
import eCommerceDemo.dataAccess.abstracts.UserDao;
import eCommerceDemo.entities.concretes.User;

public class UserUnusedEmailManager implements UserUnusedEmailService {
	
	UserDao userDao;
	
	public UserUnusedEmailManager(UserDao userDao) {
		super();
		this.userDao = userDao;
	}

	@Override
	public boolean isEmailAvailable(String email) {
		
		for(User user : userDao.getAll()) {
			if(email.equals(user.getEmail())) {
				System.out.println("Bu email adresi daha �nce kullan�lm��t�r.L�tfen ba�ka bir adres giriniz.");
				return false;
			}
		}
		
		return true;
	}

}
