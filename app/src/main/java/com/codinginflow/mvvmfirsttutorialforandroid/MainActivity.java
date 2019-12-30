package com.codinginflow.mvvmfirsttutorialforandroid;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.codinginflow.mvvmfirsttutorialforandroid.databinding.ActivityMainBinding;
import com.codinginflow.mvvmfirsttutorialforandroid.model.User;
import com.codinginflow.mvvmfirsttutorialforandroid.viewModel.Presenter;
import com.codinginflow.mvvmfirsttutorialforandroid.viewModel.UserModel;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding activityMainBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityMainBinding= DataBindingUtil.setContentView(this,R.layout.activity_main);

        UserModel userModel=new UserModel(new User("Email","Password"));
        activityMainBinding.setLogin(userModel);

        activityMainBinding.setClick(new Presenter() {
            @Override
            public void onSaveClick(View view) {
                Toast.makeText(MainActivity.this, ""+activityMainBinding.getLogin().getEmail(), Toast.LENGTH_SHORT).show();
            }
        });

    }
}
