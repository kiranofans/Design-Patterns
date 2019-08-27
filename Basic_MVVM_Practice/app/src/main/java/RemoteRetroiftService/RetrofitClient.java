package RemoteRetroiftService;

import Utils.ApiConstants;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClient {
    private static Retrofit retrofit = null;

    public static RetrofitApi getRetrofitService(){
        if(retrofit != null){
            retrofit = new Retrofit.Builder().baseUrl(ApiConstants.BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create()).build();
        }
        return retrofit.create(RetrofitApi.class);
    }
}
