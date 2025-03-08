package spring.core.start;

public class SocailService {

	private UserService userService;
	
	public void setUserService(UserService userService) { // setUserService   UserService  userService
		this.userService = userService;
	}

	void save(String name) {
		userService.saveUser(name);
	}
}
