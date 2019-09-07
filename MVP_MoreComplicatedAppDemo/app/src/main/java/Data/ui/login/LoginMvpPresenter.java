package Data.ui.login;

import Data.ui.MvpPresenter;

public interface LoginMvpPresenter<V extends LoginMvpView> extends MvpPresenter {

    void onLoginClick();
}
