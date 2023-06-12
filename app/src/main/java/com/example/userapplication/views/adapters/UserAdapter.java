package com.example.userapplication.views.adapters;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.userapplication.data.model.User;
import com.example.userapplication.databinding.ListItemUserBinding;

import java.util.ArrayList;
import java.util.List;

public class UserAdapter extends RecyclerView.Adapter<UserAdapter.UserViewHolder> {


    List<User> list = new ArrayList<>();

    public void setList(List<User> list) {
        this.list = list;
    }

    @NonNull
    @Override
    public UserViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new UserViewHolder(ListItemUserBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull UserViewHolder holder, int position) {
        User user = list.get(position);

        holder.binding.name.setText(user.getName());
        holder.binding.age.setText(String.valueOf(user.getAge()));
        holder.binding.email.setText(user.getEmail());
        holder.binding.phone.setText(String.valueOf(user.getMobile()));
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    static class UserViewHolder extends RecyclerView.ViewHolder {
        public ListItemUserBinding binding;

        public UserViewHolder(@NonNull ListItemUserBinding itemView) {
            super(itemView.getRoot());
            this.binding = itemView;
        }
    }
}
