package start.group.demo910.controller.vm;

public class PlayerVM {
    private Long id;
    private String name;

    public PlayerVM() {
    }

    public PlayerVM(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
