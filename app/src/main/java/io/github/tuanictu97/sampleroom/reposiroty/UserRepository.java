package io.github.tuanictu97.sampleroom.reposiroty;

import android.app.Application;

import androidx.lifecycle.LiveData;

import java.util.List;

import io.github.tuanictu97.sampleroom.database.UserDao;
import io.github.tuanictu97.sampleroom.database.UserDatabase;
import io.github.tuanictu97.sampleroom.entities.User;

public class UserRepository {
    private UserDao userDao;
    private LiveData<List<User>> mAllUser;

    public UserRepository(Application application){
        UserDatabase db = UserDatabase.getDatabase(application);
        userDao = db.userDao();

        mAllUser = userDao.getAllUser();
    }

    public LiveData<List<User>> getAllUser(){
        return mAllUser;
    }

    public void insert(final User user){
        UserDatabase.databaseWriteExecutor.execute(() -> {
            userDao.insert(user);
        });
    }
}
