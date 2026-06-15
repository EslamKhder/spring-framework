package spring.core.service.impl;

public interface AccountService {
	void createAccount(String username, String password);
	void createPost(Long userd, String text);
}
