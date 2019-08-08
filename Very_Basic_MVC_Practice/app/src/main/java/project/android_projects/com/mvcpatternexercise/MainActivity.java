package project.android_projects.com.mvcpatternexercise;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Observable;
import java.util.Observer;

import Models.StudentModel;

public class MainActivity extends AppCompatActivity implements Observer, View.OnClickListener {

    private StudentModel initModel, updateModel;

    private TextView nameTitle, nameDetail, idTitle, idDetail,
            scoreTitle, scoreDetail, ageTitle, ageDetail, explainTv;

    private Button prevBtn, nextBtn, homeBtn;
    private View nameView, idView, scoreView, ageView;

    private String str;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initContentView();

        updateModel = new StudentModel();
        initModel = getInitialData();
        updateModel.addObserver(this);//don't forget to add this line

    }

    @Override
    protected void onResume() {
        super.onResume();
        displayInitData(initModel);
    }

    private void initContentView() {
        explainTv = (TextView) findViewById(R.id.explain_tv);
        prevBtn = (Button) findViewById(R.id.prev_btn);
        nextBtn = (Button) findViewById(R.id.next_btn);
        homeBtn = (Button) findViewById(R.id.home_btn);

        nameView = findViewById(R.id.name_display);
        nameTitle = (TextView) nameView.findViewById(R.id.title);
        nameDetail = (TextView) nameView.findViewById(R.id.detail);

        idView = findViewById(R.id.id_display);
        idTitle = (TextView) idView.findViewById(R.id.title);
        idDetail = (TextView) idView.findViewById(R.id.detail);

        scoreView = findViewById(R.id.score_display);
        scoreTitle = (TextView) scoreView.findViewById(R.id.title);
        scoreDetail = (TextView) scoreView.findViewById(R.id.detail);

        ageView = findViewById(R.id.age_display);
        ageTitle = (TextView) ageView.findViewById(R.id.title);
        ageDetail = (TextView) ageView.findViewById(R.id.detail);

        str = "MVC in Android\n\nModel: class models, data" +
                "\nBusiness Logic: Observer" + "\nView: layouts" +
                " and views and other UI components" +
                " (also can be activities and fragments)" +
                "\nController:Activities or fragments";

        prevBtn.setOnClickListener(this);
        nextBtn.setOnClickListener(this);
        homeBtn.setOnClickListener(this);
    }

    private void displayInitData(StudentModel model) {

        nameTitle.setText("Student Name: ");
        nameDetail.setText(model.getName());

        idTitle.setText("Student ID: ");
        idDetail.setText(model.getStudentID());

        scoreTitle.setText("Score: ");
        scoreDetail.setText(model.getScores() + "");

        ageTitle.setText("Student Age: ");
        ageDetail.setText(model.getAge() + " years old");
        explainTv.setText(str);
    }

    private StudentModel getInitialData() {
        StudentModel student = new StudentModel();
        student.setName("John Doe");
        student.setStudentID("123456");
        student.setScores(82);
        student.setAge(17);
        return student;
    }

    @Override
    public void update(Observable observable, Object o) {
        displayInitData(updateModel);
        explainTv.setText("Data updated!\n" + str);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.next_btn:
                Log.d("TAG", "Clicked");
                updateModel.setName("Shu");
                updateModel.setStudentID("23456");
                updateModel.setScores(80);
                updateModel.setAge(16);
                break;
            case R.id.prev_btn:
                Log.d("TAG_PREV", "Clicked");
                updateModel.setName("Mama Mia");
                updateModel.setStudentID("54879");
                updateModel.setScores(80);
                updateModel.setAge(16);
                break;
            case R.id.home_btn:
                Log.d("TAG_HOME", "Clicked");
                displayInitData(initModel);
                break;
        }
    }
}
