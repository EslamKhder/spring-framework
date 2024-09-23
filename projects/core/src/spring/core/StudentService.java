package spring.core;
public class StudentService implements RepoService{
	
	
    @Override
    public void save(String name) {
        System.out.println("Saved Student .... " + name);
    }
}
