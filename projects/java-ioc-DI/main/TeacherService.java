package main;

public class TeacherService implements RepoService{

    @Override
    public void save(String name) {
        System.out.println("Saved Teacher .... " + name);
    }
}
