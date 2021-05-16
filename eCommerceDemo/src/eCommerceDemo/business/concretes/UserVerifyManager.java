package eCommerceDemo.business.concretes;

import eCommerceDemo.business.abstracts.UserVerifyService;

public class UserVerifyManager implements UserVerifyService  {

	@Override
	public void sendVerifyEmail(String email) {
		System.out.println("Doðrulama emaili gönderildi" + email);
		
	}

	@Override
	public boolean isClickLink(String email, String verifyCode) {
		
		String code = "1a2b3c4d";
		if(code == verifyCode) {
		System.out.println("Üyelik baþarýyla tamamlandý" + email);
		return true;
		}else {
			System.out.println("Üyelik tamamlanamadý." + email);
			return false;
		}
	}

}
