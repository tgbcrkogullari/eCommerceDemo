package eCommerceDemo.business.abstracts;

public interface UserCheckService {
	
	boolean nameController(String firstName, String lastName);
	boolean emailController(String email);
	boolean passwordController(String password);

}
