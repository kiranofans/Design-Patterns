package Data.db.dao;

import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

import Model.User;

import static androidx.room.OnConflictStrategy.REPLACE;

public interface UserDao {
    //Dao: data access object

    @Query("SELECT * FROM user")
    List<User> getAll();

    @Insert(onConflict = REPLACE)
    void insertUser(User mUser);

    @Insert
    void insertAllUser(User... mUsersList);

    @Delete
    void deleteUser(User mUser);

    @Update
    void updateUser(User mUser);

    @Query("SELECT * FROM user WHERE uid = :uId")
    User getUserById(int uId);


    @Query("SELECT * FROM user WHERE uid IN (:userIds)")
    List<User> loadAllByIds(int[] userIds);

    @Query("SELECT * FROM user WHERE first_name LIKE :first AND " +
            "last_name LIKE :last LIMIT 1")
    User findByName(String first, String last);
}
