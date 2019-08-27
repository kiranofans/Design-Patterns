package RemoteRetroiftService;

import Model.NewsMod;
import Utils.ApiConstants;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface RetrofitApi {

    @GET(ApiConstants.END_POINT_EVERYTHING)
    Call<NewsMod> getEverything(@Query("apiKey") String api_key, @Query("pageSize") int pageSize,
                                @Query("sortBy") String sort_by);
}
