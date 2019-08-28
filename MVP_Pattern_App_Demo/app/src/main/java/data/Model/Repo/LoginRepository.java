package data.Model.Repo;

import data.Model.User;

public interface LoginRepository {

    User getUser();
    void saveUser(User user);
}
