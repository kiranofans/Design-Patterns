package Data;

import android.content.Context;

import androidx.room.Room;
import androidx.room.RoomDatabase;

import Data.db.dao.UserDao;

public abstract class AbstractAppDatabase extends RoomDatabase {
    //lazy initialize

    private static final String DATABASE_NAME = "wave-database";
    private static volatile AbstractAppDatabase appDbInstance;

    private AbstractAppDatabase(){
        //Reflection proof
        if(appDbInstance!=null){
            throw new RuntimeException("Usr getInstance() to get the single instance of"+
                    " this AbstractAppDatabase class");
        }
    }

    public static AbstractAppDatabase getInstance(Context context){
        //Double-check locking method
        if(appDbInstance == null){
            synchronized (AbstractAppDatabase.class){
                if(appDbInstance == null) appDbInstance = Room.databaseBuilder
                        (context.getApplicationContext(), AbstractAppDatabase.class,
                                DATABASE_NAME).allowMainThreadQueries()
                        .fallbackToDestructiveMigration().build();
            }
        }
        return appDbInstance;
    }


    public static void destroyInstance(){
        appDbInstance = null;
    }

    public abstract UserDao userDao();
}
