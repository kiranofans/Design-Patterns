package NetworkUtils;

import java.util.List;

import Model.FeedItem;
import Model.LoginRequest;
import Model.UserProfile;
import Model.WrapperResponse;
import io.reactivex.Single;

public interface RestApiHelper {
    Single<WrapperResponse<UserProfile>> doLoginApiCall(LoginRequest loginRequest);

    Single<WrapperResponse<List<FeedItem>>> getFeedList();
}
