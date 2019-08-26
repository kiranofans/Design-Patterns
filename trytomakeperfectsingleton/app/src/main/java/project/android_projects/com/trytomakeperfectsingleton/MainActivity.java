package project.android_projects.com.trytomakeperfectsingleton;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * Singleton classes should be thread-safe, which means
 * when comes to multi threads, the hashcode should be
 * always the same for multiple class instances.
 * Singleton classes also should be reflection proof, so
 * if the instances have different hash codes the RuntimeException will throw
 */
public class MainActivity extends AppCompatActivity {
    private EagerInitSingletonExample eagerSingleton;
    private LazyInitSingletonExample lazySingleton, lazySingleton2;

    private TextView tv1, tv2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        eagerSingleton = EagerInitSingletonExample.getInstance();

        /*lazySingleton = LazyInitSingletonExample.getInstance();
        lazySingleton2 = null;*/
        //lazySingleton2 = LazyInitSingletonExample.getInstance();

        tv1 = findViewById(R.id.tv_1);
        tv2 = findViewById(R.id.tv_2);


        //Check hash codes to see if the singleton effects better
        //If both instance have different hash code, it means the Singleton class failed the test
        //The hash codes for both instance of LazyinitSingletonExample class should be the SAME

        threadTest();

    }

    private void reflectionTest() {
        /** For making reflection proof Singleton, it needs to throw a run time exception
         * in constructor, so if the hash codes of both instance are different (for example,
         * if one of the instances is null), the sys will throw the RuntimeException
         * */
        try {
            Class<LazyInitSingletonExample> lazyClass = LazyInitSingletonExample.class;
            Constructor<LazyInitSingletonExample> constructor = lazyClass.getDeclaredConstructor();

            constructor.setAccessible(true);
            lazySingleton2 = constructor.newInstance();

            tv1.setText("lazy Singleton reflection 1: " + lazySingleton.hashCode());
            tv2.setText("lazy Signleton reflection 2: " + lazySingleton2.hashCode());

        } catch (NoSuchMethodException | InvocationTargetException
                | IllegalAccessException | InstantiationException exception) {

        }
    }

    private void threadTest() {
        /** this may sometime result in different hash codes if it's NOT thread-safe */
        //Thread 1
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                lazySingleton = LazyInitSingletonExample.getInstance();
                tv1.setText("Lazy thread 1: " + lazySingleton.hashCode());
            }
        });

        //Thread 2
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                lazySingleton2 = LazyInitSingletonExample.getInstance();
                tv2.setText("Lazy thread 2: " + lazySingleton2.hashCode());
            }
        });

        //Start threadTest
        t1.start();
        t2.start();
    }
}
