package project.android_projects.com.mvp_morecomplicatedappdemo;

public interface MainMvpPresenter<V extends MainMvpView> extends MainPresenter<V>{
    void onViewPrepared();
}
