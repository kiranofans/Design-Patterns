package data.Model;

public class User {
    private int id;
    private String userName;
    private String password;

    public User(String firstName, String lastName) {
        this.userName = firstName;
        this.password = lastName;
    }


    public void setId(int id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }


    public String getPassword() {
        return password;
    }
}
