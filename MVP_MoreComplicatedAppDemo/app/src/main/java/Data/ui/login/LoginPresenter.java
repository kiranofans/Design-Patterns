package Data.ui.login;

import android.os.Handler;

import javax.inject.Inject;

import Data.DataManager;
import Data.ui.BasePresenter;
import Model.UserProfile;
import Utils.LoggedInMode;
import Utils.RxJava.RxJavaSchedulerProvider;
import io.reactivex.disposables.CompositeDisposable;

public class LoginPresenter<V extends LoginMvpView> extends BasePresenter<V>
        implements LoginMvpPresenter<V> {

    @Inject
    public LoginPresenter(DataManager manager, RxJavaSchedulerProvider schedulerProvider, CompositeDisposable compositeDisposable) {
        super(manager, schedulerProvider, compositeDisposable);
    }

    @Override
    public void onLoginClick() {
        if(getMvpView() != null){
            if (getMvpView().getEmail().trim().equals("") || getMvpView()
                    .getPassword().trim().equals("")) {
                getMvpView().showInputError();
            } else {
                getMvpView().showLoading();
                new Handler().postDelayed(() -> {
                    if (!isViewAttached()) {
                        return;
                    }
                    // set demo user
                    UserProfile mProfile = new UserProfile();
                    mProfile.setFirstName("Dinesh");
                    mProfile.setLastName("Kumar");
                    mProfile.setEmail("dinesh@gmail.com");
                    mProfile.setUserId("1");
                    //update preferences
                    getDataManager().updateUserInfo("access toekn", 1l,
                            LoggedInMode.LOGGED_IN_MODE_SERVER, "",
                            mProfile.getEmail(), "");
                    getMvpView().onLoginSuccess(mProfile);

                    getMvpView().hideLoading();
                }, 1000);

            }
        }
    }
}
