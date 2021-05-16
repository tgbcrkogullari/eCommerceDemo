package eCommerceDemo.business.concretes;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import eCommerceDemo.business.abstracts.UserCheckService;

public class UserCheckManager implements UserCheckService{

	@Override
	public boolean nameController(String firstName, String lastName) {
		if(firstName.length() < 2 && lastName.length() < 2) {
			System.out.println("Geçersiz isim ve soyisim girdiniz.Ýsim ve soyisim en az 2 karakter olmalýdýr.");
			return false;			
		}else {
		return true;
		}
	}

	@Override
	public boolean emailController(String email) {
		Pattern p = Pattern.compile("\\\\b[A-Z0-9._%-]+@[A-Z0-9.-]+\\\\.[A-Z]{2,4}\\\\b");
		Matcher m = p.matcher(email);
		
		if(m.find()) {
			return true;		
		}else {
			System.out.println("Geçersiz email adresi oluþturdunuz.");
		return false;
		}
	}

	@Override
	public boolean passwordController(String password) {
		if(password.length() < 6) {
			System.out.println("Geçersiz parola oluþturdunuz.Lütfen en az 6 karakter kullanýnýz.");
			return false;			
		}else {
		return true;
		}
	}

}
