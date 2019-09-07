package component;

import dagger.Component;
import project.android_projects.com.mvp_morecomplicatedappdemo.LoginActivity;
import project.android_projects.com.mvp_morecomplicatedappdemo.MainActivity;

@PerActivity
@Component(dependencies = ApplicationComponent.class, modules = ActivityModule.class)
public interface ActivityComponent {

    void inject(LoginActivity loginActivity);
    void inject(MainActivity mainActivity);
}
