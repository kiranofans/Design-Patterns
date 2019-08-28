package root;

import android.app.Application;

public class AppApplication extends Application {

    private AppComponent component;

    @Override
    public void onCreate() {
        super.onCreate();
        //Needs to run once generating it
        component = DaggerAppComponent.builder()
                //Rebuild project after setting up Dagger
                .appModule(new AppModule(this))
                .loginModule(new LoginModule()).build();
    }

    public AppComponent getComponent(){
        return component;
    }
}
