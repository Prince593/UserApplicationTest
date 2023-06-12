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

import com.example.userapplication.R;
import com.example.userapplication.data.model.User;
import com.example.userapplication.databinding.FragmentAddUserBinding;
import com.example.userapplication.utils.callbacks.OnManageFragment;
import com.example.userapplication.viewmodel.UserViewModel;

public class AddUserFragment extends Fragment {

    Context context;

    FragmentAddUserBinding binding;

    OnManageFragment onManageFragment;

    UserViewModel userViewModel;

    public static AddUserFragment newInstance() {

        Bundle args = new Bundle();

        AddUserFragment fragment = new AddUserFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        this.context = context;

        try {
            onManageFragment = (OnManageFragment) context;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = FragmentAddUserBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        binding.toolbar.setNavigationIcon(R.drawable.baseline_arrow_back_24);


        binding.btnAddUser.setOnClickListener(v -> {
            if (true) {
                addUser();
            }
        });


        userViewModel = new ViewModelProvider(requireActivity()).get(UserViewModel.class);
    }

    private void addUser() {
        String name = binding.editName.getEditableText().toString().trim();
        String age = binding.editAge.getEditableText().toString().trim();
        String email = binding.editEmail.getEditableText().toString().trim();
        String phone = binding.editPhone.getEditableText().toString().trim();

        User user = new User(name, email, Long.parseLong(phone), Integer.parseInt(age));

        userViewModel.addUser(user);

        if (onManageFragment != null) {
            onManageFragment.removeCurrentFragment();
        }

    }
}
