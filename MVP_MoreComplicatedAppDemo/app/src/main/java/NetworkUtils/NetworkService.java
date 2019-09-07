package NetworkUtils;

import java.util.List;

import Model.FeedItem;
import Model.LoginRequest;
import Model.UserProfile;
import Model.WrapperResponse;
import io.reactivex.Single;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface NetworkService {

    @GET("feed.json")
    Single<WrapperResponse<List<FeedItem>>> getFeedList();


    @POST("login")
    Single<WrapperResponse<UserProfile>> doLoginApiCall(@Body LoginRequest mRequest);
}
