package root;

import javax.inject.Singleton;

import dagger.Component;
import project.android_projects.com.mvp_pattern_app_demo.MainActivity;

@Singleton
@Component(modules = {AppModule.class, LoginModule.class})
public interface AppComponent {

    void inject(MainActivity mainTarget);
}
