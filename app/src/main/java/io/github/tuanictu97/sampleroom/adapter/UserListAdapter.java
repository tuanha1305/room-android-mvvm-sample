package io.github.tuanictu97.sampleroom.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import io.github.tuanictu97.sampleroom.R;
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
        View itemView = LayoutInflater.from(context).inflate(R.layout.recyclerview_item, parent, false);

        return new UserViewHolder(itemView);
    }

    @SuppressLint({"DefaultLocale", "SetTextI18n"})
    @Override
    public void onBindViewHolder(@NonNull UserViewHolder holder, int position) {
        if(mListUser != null){
            User user = mListUser.get(position);
            holder.textViewUserId.setText(String.format("%d", user.getId()));
            holder.textViewUserName.setText(user.getFullName());
            holder.textViewEmail.setText(user.getEmail());
        }else{
            holder.textViewUserId.setText("No id");
        }
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
        private final TextView textViewUserId;
        private final TextView textViewUserName;
        private final TextView textViewEmail;
        UserViewHolder(@NonNull View itemView) {
            super(itemView);
            textViewUserId = itemView.findViewById(R.id.textViewUserId);
            textViewUserName = itemView.findViewById(R.id.textViewUserName);
            textViewEmail = itemView.findViewById(R.id.textViewUserEmail);
        }
    }
}
