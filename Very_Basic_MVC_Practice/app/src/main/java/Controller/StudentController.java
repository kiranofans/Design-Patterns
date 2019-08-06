package Controller;

import android.widget.TextView;

import Models.StudentModel;
import project.android_projects.com.mvcpatternexercise.MainActivity;

public class StudentController {
    private StudentModel studentMod;
    private TextView titleView,detailView;
    private String titleStr, detailStr;
    private MainActivity mainActivity;

    private int detailInfo;

    private TextView title, detail;

    public StudentController(StudentModel mod){
        this.studentMod = mod;
        this.mainActivity = new MainActivity();
    }

    public void setStudentName(String name){
        studentMod.setName(name);
    }

    public String getStudentName(){
        return studentMod.getName();
    }

    public void setId(String id){
        studentMod.setStudentID(id);
    }

    public String getId(){
        return studentMod.getStudentID();
    }

    public void setAge(int age){
        studentMod.setAge(age);
    }

    public int getAge(){
        return studentMod.getAge();
    }

    public void setScore(int score){
        studentMod.setScores(score);
    }

    public int getScore(){
        return studentMod.getScores();
    }
}
