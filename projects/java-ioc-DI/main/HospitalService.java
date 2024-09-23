package main;

public class HospitalService {

    private RepoService repoService;

//    public HospitalService(RepoService repoService) {
//       // repoService = new StudentService();
//        this.repoService = repoService;
//    }


    public void setRepoService(RepoService repoService) {
        this.repoService = repoService;
    }

    void saveMember(String name){
        repoService.save(name);
    }
}
