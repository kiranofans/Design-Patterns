package component;

import android.app.Application;
import android.content.Context;

import javax.inject.Singleton;

import AppModule.ApplicationModule;
import Data.DataManager;
import dagger.Component;
import root.MVPAppDemo;

@Singleton
@Component(modules = ApplicationModule.class)
public interface ApplicationComponent {
    /** Dagger2*/

    void inject(MVPAppDemo app);

    @ApplicationContext
    Context context();

    Application application();

    DataManager getDataManager();

}
