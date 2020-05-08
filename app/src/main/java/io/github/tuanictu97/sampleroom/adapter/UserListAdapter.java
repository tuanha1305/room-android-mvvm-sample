package io.github.tuanictu97.sampleroom.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import io.github.tuanictu97.sampleroom.R;
import io.github.tuanictu97.sampleroom.databinding.RecyclerviewItemBinding;
import io.github.tuanictu97.sampleroom.entities.User;

public class UserListAdapter extends RecyclerView.Adapter<UserListAdapter.UserViewHolder>{
    private Context context;
    public UserListAdapter(Context context){
        this.context = context;
    }
    private List<User> mListUser; // Cached copy of users
    @NonNull
    @Override
    public UserViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        RecyclerviewItemBinding userItemBinding =
                DataBindingUtil.inflate(LayoutInflater.from(context), R.layout.recyclerview_item, parent, false);
        return new UserViewHolder(userItemBinding);
    }

    @SuppressLint({"DefaultLocale", "SetTextI18n"})
    @Override
    public void onBindViewHolder(@NonNull UserViewHolder holder, int position) {
        User user = mListUser.get(position);
        holder.userItemBinding.setUser(user);
    }

    public void setUser(List<User> listUser){
        mListUser = listUser;
        notifyDataSetChanged();
    }


    @Override
    public int getItemCount() {
        if(mListUser != null){
            return mListUser.size();
        }else
            return 0;
    }

    static class UserViewHolder extends RecyclerView.ViewHolder{
        private RecyclerviewItemBinding userItemBinding;
        UserViewHolder(@NonNull RecyclerviewItemBinding userItemBinding) {
            super(userItemBinding.getRoot());
            this.userItemBinding = userItemBinding;
        }
    }
}
