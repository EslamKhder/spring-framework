package spring.core.start;

public class AdminService implements UserService {

	@Override
	public void saveUser(String user) {
		// TODO Auto-generated method stub
		System.out.println("save user with name " + user + " on AdminService");
	}

}
