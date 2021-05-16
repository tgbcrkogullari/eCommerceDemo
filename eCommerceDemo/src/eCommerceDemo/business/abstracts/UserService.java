package eCommerceDemo.business.abstracts;

import eCommerceDemo.entities.concretes.User;

public interface UserService {
	void register(User user);
	void logIn(String email, String password);

}
