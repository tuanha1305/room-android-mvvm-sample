package io.github.tuanictu97.sampleroom.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;


import io.github.tuanictu97.sampleroom.R;
import io.github.tuanictu97.sampleroom.adapter.UserListAdapter;

import io.github.tuanictu97.sampleroom.entities.User;
import io.github.tuanictu97.sampleroom.viewmodel.UserViewModel;

public class MainActivity extends AppCompatActivity {
    private UserViewModel userViewModel;
    private UserListAdapter adapter;
    private RecyclerView recyclerViewUser;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();

        // Get a new or existing ViewModel from the ViewModelProvider.
        userViewModel = new ViewModelProvider(this).get(UserViewModel.class);

        userViewModel.getAllUser().observe(this, users -> adapter.setUser(users));
    }

    private void initView() {
        recyclerViewUser = findViewById(R.id.recyclerViewUser);
        adapter = new UserListAdapter(this);
        recyclerViewUser.setAdapter(adapter);
        recyclerViewUser.setLayoutManager(new LinearLayoutManager(this));
    }
}
