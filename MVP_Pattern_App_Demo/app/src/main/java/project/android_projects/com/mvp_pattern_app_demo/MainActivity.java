package project.android_projects.com.mvp_pattern_app_demo;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import javax.inject.Inject;

import Login.LoginMVP;
import root.AppApplication;

public class MainActivity extends AppCompatActivity implements LoginMVP.LoginView {

    //must add Inject annotation so dagger components interface will be used;
    // otherwise, loginView will be null
    @Inject
    LoginMVP.Presenter loginPresenter; //Dagger doesn't support Injection into private fields

    private EditText username, password;
    private Button loginBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Need to add android:name="root.AppApplication" to avoid CastException
        //root better be in lowercase
        ((AppApplication) getApplication()).getComponent().inject(this);


        initContent();
    }

    private void initContent() {
        username = findViewById(R.id.input_box_username);
        password = findViewById(R.id.input_box_password);
        loginBtn = findViewById(R.id.button_login);

        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loginPresenter.loginBtnClicked();
            }
        });

    }


    @Override
    protected void onResume() {
        super.onResume();
        loginPresenter.setView(this);
        loginPresenter.getCurrentUser();
    }

    @Override
    public String getUsername() {
        return username.getText().toString();
    }

    @Override
    public String getPassword() {
        return password.getText().toString();
    }

    @Override
    public void showInputError() {
        Toast.makeText(this, "Username or password cannot be empty",
                Toast.LENGTH_SHORT).show();
    }

    @Override
    public void setUsername(String username) {
        this.username.setText(username);
    }

    @Override
    public void setPassword(String password) {
        this.password.setText(password);
    }

    @Override
    public void showUserSavedMessage() {
        Toast.makeText(this, "User info saved successfully!",
                Toast.LENGTH_SHORT).show();
    }
}
