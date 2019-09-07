package Module;

import android.content.Context;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

import Data.ui.login.LoginMvpPresenter;
import Data.ui.login.LoginMvpView;
import Data.ui.login.LoginPresenter;
import Utils.RxJava.AppSchedulerProvider;
import Utils.RxJava.RxJavaSchedulerProvider;
import component.ActivityContext;
import component.PerActivity;
import dagger.Provides;
import io.reactivex.disposables.CompositeDisposable;
import project.android_projects.com.mvp_morecomplicatedappdemo.MainMvpPresenter;
import project.android_projects.com.mvp_morecomplicatedappdemo.MainMvpView;
import project.android_projects.com.mvp_morecomplicatedappdemo.MainPresenter;
import project.android_projects.com.mvp_morecomplicatedappdemo.RssAdapter;

public class ActivityModule {
    private AppCompatActivity mActivity;

    public ActivityModule(AppCompatActivity activity) {
        this.mActivity = activity;
    }

    @Provides
    @ActivityContext
    Context provideContext() {
        return mActivity;
    }

    @Provides
    AppCompatActivity provideActivity() {
        return mActivity;
    }

    @Provides
    CompositeDisposable provideCompositeDisposable() {
        return new CompositeDisposable();
    }


    @Provides
    RxJavaSchedulerProvider provideSchedulerProvider() {
        return new AppSchedulerProvider();
    }


    @Provides
    @PerActivity
    LoginMvpPresenter<LoginMvpView> provideLoginPresenter(LoginPresenter<LoginMvpView> presenter) {
        return presenter;
    }


    @Provides
    @PerActivity
    MainMvpPresenter<MainMvpView> provideMainPresenter(MainPresenter<MainMvpView> presenter) {
        return presenter;
    }


    @Provides
    RssAdapter provideRssAdapter() {
        return new RssAdapter(new ArrayList<>());
    }
}
