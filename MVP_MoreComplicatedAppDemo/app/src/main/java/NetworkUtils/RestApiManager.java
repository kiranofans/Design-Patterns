package NetworkUtils;

import java.util.List;

import javax.inject.Inject;

import Model.FeedItem;
import Model.LoginRequest;
import Model.UserProfile;
import Model.WrapperResponse;
import io.reactivex.Single;

public class RestApiManager implements RestApiHelper {
    NetworkService networkService;
    @Inject
    public RestApiManager(NetworkService apiSevice){
        networkService = apiSevice;
    }

    @Override
    public Single<WrapperResponse<UserProfile>> doLoginApiCall(LoginRequest loginRequest) {
        return networkService.doLoginApiCall(loginRequest);
    }

    @Override
    public Single<WrapperResponse<List<FeedItem>>> getFeedList() {
        return networkService.getFeedList();
    }
}
