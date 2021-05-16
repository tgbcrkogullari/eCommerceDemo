package eCommerceDemo.business.concretes;

import eCommerceDemo.business.abstracts.UserVerifyService;

public class UserVerifyManager implements UserVerifyService  {

	@Override
	public void sendVerifyEmail(String email) {
		System.out.println("Do�rulama emaili g�nderildi" + email);
		
	}

	@Override
	public boolean isClickLink(String email, String verifyCode) {
		
		String code = "1a2b3c4d";
		if(code == verifyCode) {
		System.out.println("�yelik ba�ar�yla tamamland�" + email);
		return true;
		}else {
			System.out.println("�yelik tamamlanamad�." + email);
			return false;
		}
	}

}
