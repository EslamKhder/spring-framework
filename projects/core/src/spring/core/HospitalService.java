package spring.core;

public class HospitalService {

    private RepoService repoService;

    private String serviceName;
    
    /*public HospitalService(RepoService repoService) {
       // repoService = new StudentService();
        this.repoService = repoService;
    }*/
    
    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }
    
    public String getServiceName() {
        return serviceName;
    }
    public void setRepoService(RepoService repoService) {
        this.repoService = repoService;
    }

    void saveMember(String name){
        repoService.save(name);
    }
}
