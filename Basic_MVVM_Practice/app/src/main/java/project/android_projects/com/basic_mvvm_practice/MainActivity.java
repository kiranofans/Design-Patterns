package project.android_projects.com.basic_mvvm_practice;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
/** Separation of concerns principles says UI-based classes (Activity, Fragment)
 * should only contain logic that handles UI and operating system interactions.
 * By keeping these classes as lean as possible, you can avoid many
 * lifecycle-related problems. */

    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
