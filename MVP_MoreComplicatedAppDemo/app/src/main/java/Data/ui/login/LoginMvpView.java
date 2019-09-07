package Data.ui.login;

import Data.ui.MvpView;
import Model.UserProfile;

public interface LoginMvpView extends MvpView {

    void onLoginSuccess(UserProfile userProfile);

    String getEmail();
    String getPassword();
    void showInputError();

    void setPassword(String userId);

    void setEmail(String password);
}
