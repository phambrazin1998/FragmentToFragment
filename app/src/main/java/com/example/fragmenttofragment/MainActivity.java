package com.example.fragmenttofragment;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity implements Fragment1.SendData,Fragment2.UpdateData {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.add(R.id.frame1, new Fragment1());
        fragmentTransaction.add(R.id.frame2, new Fragment2());
        fragmentTransaction.commit();
    }

    @Override
    public void sendData(String email) {
        Fragment2 fragment2 = (Fragment2) getSupportFragmentManager().findFragmentById(R.id.frame2);
        fragment2.nhanData(email);
    }

    @Override
    public void UpdateData(String email) {
        Fragment1 fragment1 = (Fragment1) getSupportFragmentManager().findFragmentById(R.id.frame1);
        fragment1.updateData(email);
    }
}