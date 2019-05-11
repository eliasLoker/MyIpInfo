package com.example.myipinfo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;

import com.example.myipinfo.showip.ShowIpFragment;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Fragment fragment = getSupportFragmentManager().findFragmentById(R.id.fragment_container);
        if (fragment == null) {
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.fragment_container, ShowIpFragment.newInstance())
                    .commit();
        }
    }
}
