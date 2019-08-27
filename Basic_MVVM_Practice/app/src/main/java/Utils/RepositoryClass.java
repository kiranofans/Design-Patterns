package Utils;

import android.app.Application;
import android.util.Log;

import androidx.lifecycle.MutableLiveData;

import java.util.ArrayList;
import java.util.List;

import Model.NewsMod;
import RemoteRetroiftService.RetrofitApi;
import RemoteRetroiftService.RetrofitClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RepositoryClass {

    /** Repository class contains database or remote data source (REST APIs)
     * */
    private List<NewsMod.ArticleMod> articleList = new ArrayList<>();
    private MutableLiveData<List<NewsMod.ArticleMod>> mutableLiveData = new MutableLiveData<>();
    private Application application;

    public RepositoryClass(Application application) {
        this.application = application;
    }

    public MutableLiveData<List<NewsMod.ArticleMod>> getMutableLiveData() {
        RetrofitApi apiService = RetrofitClient.getRetrofitService();

        Call<NewsMod> callEverything = apiService.getEverything(ApiConstants.API_KEY,
                AppConstants.PARAM_PAGE_SIZE, AppConstants.PARAM_SORT_BY);

        callEverything.enqueue(new Callback<NewsMod>() {
            @Override
            public void onResponse(Call<NewsMod> call, Response<NewsMod> response) {
                NewsMod newsMod = response.body();
                if (newsMod != null && newsMod.getArticleList() != null) {
                    articleList = newsMod.getArticleList();
                    mutableLiveData.setValue(articleList);
                }
                Log.d("CHECK NULL", response.body()+" is null");
            }

            @Override
            public void onFailure(Call<NewsMod> call, Throwable t) {

            }
        });

        return mutableLiveData;
    }
}
