package Data.ui;

public interface MvpPresenter<V extends MvpView> {

    void onAttach(V mvpView);

    void onDetach();

    void handleApiError(Throwable error);

    void setUserAsLoggedOut();
}
