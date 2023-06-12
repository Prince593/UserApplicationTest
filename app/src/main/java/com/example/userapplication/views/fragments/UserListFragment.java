package com.example.userapplication.views.fragments;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.userapplication.data.model.User;
import com.example.userapplication.databinding.FragmentUserListBinding;
import com.example.userapplication.utils.callbacks.OnManageFragment;
import com.example.userapplication.viewmodel.UserViewModel;
import com.example.userapplication.views.adapters.UserAdapter;

import java.util.ArrayList;
import java.util.List;

public class UserListFragment extends Fragment {

    Context context;

    FragmentUserListBinding binding;
    UserAdapter userAdapter;

    List<User> list = new ArrayList<>();

    UserViewModel userViewModel;

    OnManageFragment onManageFragment;

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        this.context = context;

        try {
            onManageFragment = (OnManageFragment) context;
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

    public static UserListFragment newInstance() {

        Bundle args = new Bundle();

        UserListFragment fragment = new UserListFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = FragmentUserListBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        userAdapter = new UserAdapter();
        userAdapter.setList(list);

        binding.recyclerView.setHasFixedSize(true);
        binding.recyclerView.setLayoutManager(new LinearLayoutManager(context));
        binding.recyclerView.setAdapter(userAdapter);


        //ViewModel
        userViewModel = new ViewModelProvider(requireActivity()).get(UserViewModel.class);

        userViewModel.getUsers().observe(getViewLifecycleOwner(), users -> {
            list = users;
            userAdapter.setList(list);
            userAdapter.notifyDataSetChanged();
        });



        binding.btnAddUser.setOnClickListener(v -> {
            if(onManageFragment!=null){
                onManageFragment.addFragment(AddUserFragment.newInstance());
            }
        });


    }
}
