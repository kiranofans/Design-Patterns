package Utils;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

import Model.NewsMod;

public class ViewModelClass extends AndroidViewModel {
    /** ViewModelClass contains RepositoryClass instance;
     * and viewModel class will be initialized in Activity or Fragment*/

    private RepositoryClass repositoryClass;

    public ViewModelClass(@NonNull Application application) {
        super(application);
        repositoryClass = new RepositoryClass(application);
    }

    public LiveData<List<NewsMod.ArticleMod>> getArticles(){
        return repositoryClass.getMutableLiveData();
    }
}
