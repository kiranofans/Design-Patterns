package data.Model.Repo;

import data.Model.User;

public class UserRepository implements LoginRepository {

    private User user;

    @Override
    public User getUser() {
        if(user == null){
            user = new User("kira","123456");
            user.setId(001);
            return user;
        }
        return user;
    }

    @Override
    public void saveUser(User user) {
        if(user != null){
            user = getUser();
        }
        this.user = user;
    }


}
