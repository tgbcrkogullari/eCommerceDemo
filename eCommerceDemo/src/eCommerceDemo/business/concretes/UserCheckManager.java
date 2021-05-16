package eCommerceDemo.business.concretes;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import eCommerceDemo.business.abstracts.UserCheckService;

public class UserCheckManager implements UserCheckService{

	@Override
	public boolean nameController(String firstName, String lastName) {
		if(firstName.length() < 2 && lastName.length() < 2) {
			System.out.println("Ge�ersiz isim ve soyisim girdiniz.�sim ve soyisim en az 2 karakter olmal�d�r.");
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
			System.out.println("Ge�ersiz email adresi olu�turdunuz.");
		return false;
		}
	}

	@Override
	public boolean passwordController(String password) {
		if(password.length() < 6) {
			System.out.println("Ge�ersiz parola olu�turdunuz.L�tfen en az 6 karakter kullan�n�z.");
			return false;			
		}else {
		return true;
		}
	}

}
