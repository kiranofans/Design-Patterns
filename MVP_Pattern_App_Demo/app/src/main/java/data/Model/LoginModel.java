package data.Model;

import Login.LoginMVP;
import data.Model.Repo.LoginRepository;

public class LoginModel implements LoginMVP.Model {
    /**
     * Model
     */
    private LoginRepository loginRepo;


    public LoginModel(LoginRepository repo) {
        loginRepo = repo;
    }

    @Override
    public void createUser(String username, String password) {
        loginRepo.saveUser(new User(username, password));
    }

    @Override
    public User getUser() {
        return loginRepo.getUser();
    }
}
