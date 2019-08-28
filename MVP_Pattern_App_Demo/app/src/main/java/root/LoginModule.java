package root;

import Login.LoginMVP;
import Login.LoginPresenter;
import dagger.Module;
import dagger.Provides;
import data.Model.LoginModel;
import data.Model.Repo.LoginRepository;
import data.Model.Repo.UserRepository;

@Module
public class LoginModule {

    @Provides
    public LoginMVP.Presenter provideLoginPresenter(LoginMVP.Model model){
        return new LoginPresenter(model);//Initialize login presenter model
    }

    @Provides
    public LoginMVP.Model provideLoginActivityModel(LoginRepository repository){
        return new LoginModel(repository);
    }

    @Provides
    public LoginRepository provideLoginRepository(){
        return new UserRepository();
    }
}
