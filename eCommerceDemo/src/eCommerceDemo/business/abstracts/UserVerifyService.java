package eCommerceDemo.business.abstracts;

public interface UserVerifyService {
	
	void sendVerifyEmail(String email);
	boolean isClickLink(String email, String verifyCode);

}
