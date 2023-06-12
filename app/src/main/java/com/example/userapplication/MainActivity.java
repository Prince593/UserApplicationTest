package com.example.userapplication;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.example.userapplication.utils.callbacks.OnManageFragment;
import com.example.userapplication.views.fragments.AddUserFragment;
import com.example.userapplication.views.fragments.UserListFragment;

public class MainActivity extends AppCompatActivity implements OnManageFragment {


    Fragment currentFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        currentFragment = UserListFragment.newInstance();

        getSupportFragmentManager().beginTransaction().add(R.id.containerFragments, currentFragment).commit();


    }

    @Override
    public void addFragment(Fragment fragment) {
        getSupportFragmentManager().beginTransaction().hide(currentFragment).add(R.id.containerFragments, fragment).commit();
        currentFragment = fragment;
    }

    @Override
    public void removeCurrentFragment() {
        getSupportFragmentManager().beginTransaction().remove(currentFragment).commitNow();
        if (getSupportFragmentManager().getFragments().size() > 0) {
            currentFragment = getSupportFragmentManager().getFragments().get(0);
            getSupportFragmentManager().beginTransaction().show(currentFragment).commitNow();
        }
    }

    @Override
    public void onBackPressed() {
        if (currentFragment instanceof AddUserFragment) {
            removeCurrentFragment();
            return;
        }
        super.onBackPressed();
    }
}