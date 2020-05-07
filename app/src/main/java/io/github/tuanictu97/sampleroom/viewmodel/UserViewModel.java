package io.github.tuanictu97.sampleroom.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

import io.github.tuanictu97.sampleroom.entities.User;
import io.github.tuanictu97.sampleroom.reposiroty.UserRepository;

public class UserViewModel extends AndroidViewModel {
    private UserRepository mUserRepository;
    private LiveData<List<User>> mListUser;
    public UserViewModel(@NonNull Application application) {
        super(application);

        mUserRepository = new UserRepository(application);
        mListUser = mUserRepository.getAllUser();
    }

    public LiveData<List<User>> getAllUser(){
        return mUserRepository.getAllUser();
    }

    public void insert(User user){
        mUserRepository.insert(user);
    }
}
