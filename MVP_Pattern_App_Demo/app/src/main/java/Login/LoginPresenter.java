package Login;

import android.util.Log;
import android.widget.Toast;

import androidx.annotation.Nullable;

import data.Model.User;

public class LoginPresenter implements LoginMVP.Presenter{
    /** Presenter */

    @Nullable
    private LoginMVP.LoginView loginView;
    private LoginMVP.Model loginModel;

    public LoginPresenter(LoginMVP.Model model){
        loginModel = model;
    }

    @Override
    public void setView(LoginMVP.LoginView loginView) {
        //Pass the view instance
        this.loginView = loginView;
    }

    @Override
    public void loginBtnClicked() {

        //Defining onClick() event
        if(loginView != null){
            if(loginView.getUsername().trim().equals("") ||
            loginView.getPassword().trim().equals("")){
                loginView.showInputError();
            }
            loginModel.createUser(loginView.getUsername(),loginView.getPassword());
            loginView.showUserSavedMessage();
        }
        Log.d("VIEW NULL CHECK","Login View is null");
    }

    @Override
    public void getCurrentUser() {
        //Return User class instance
        User user = loginModel.getUser();

        if(user != null && loginView != null){
            loginView.setUsername(user.getUserName());
            loginView.setPassword(user.getPassword());
        }
    }
}
