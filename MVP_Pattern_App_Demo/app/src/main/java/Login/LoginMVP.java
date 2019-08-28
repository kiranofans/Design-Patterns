package Login;

import android.view.View;

import data.Model.User;

public interface LoginMVP {
    /**
     * Creating login contract interface
     * View
     */

    interface LoginView {
        String getUsername();

        String getPassword();

        void showInputError();

        void setUsername(String username);

        void setPassword(String password);

        void showUserSavedMessage();
    }

    interface Presenter {
        void setView(LoginView loginView);

        void loginBtnClicked();

        void getCurrentUser();
    }

    interface Model {
        void createUser(String username, String password);

        User getUser();
    }
}
