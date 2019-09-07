package project.android_projects.com.mvp_morecomplicatedappdemo;

import javax.inject.Inject;

import Data.DataManager;
import Data.ui.BasePresenter;
import Utils.RxJava.RxJavaSchedulerProvider;
import io.reactivex.disposables.CompositeDisposable;

public class MainPresenter<V extends MainMvpView> extends BasePresenter<V>
        implements MainMvpPresenter<V> {

    @Inject
    public  MainPresenter(DataManager dataMgr, RxJavaSchedulerProvider schedulerProvider,
                          CompositeDisposable compositeDisposable){
        super(dataMgr,schedulerProvider,compositeDisposable);
    }

    @Override
    public void onViewPrepared() {
        getMvpView().showLoading();
        getCompositeDisposable().add(getDataManager()
                .getFeedList()
                .subscribeOn(getSchedulerProvider().io())
                .observeOn(getSchedulerProvider().ui())
                .subscribe(response -> {
                    if (!isViewAttached()) {
                        return;
                    }
                    getMvpView().hideLoading();
                    /**
                     * Update view here
                     */
                    getMvpView().updateFeed(response.getData());
                }, error -> {
                    if (!isViewAttached()) {
                        return;
                    }
                    getMvpView().hideLoading();

                    /**
                     * manage all kind of error in single place
                     */
                    handleApiError(error);
                }));
    }
}
