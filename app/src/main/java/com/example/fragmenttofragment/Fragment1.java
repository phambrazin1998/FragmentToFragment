package com.example.fragmenttofragment;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

public class Fragment1 extends Fragment {

    private EditText edtEmail;
    private Button btnSend;
    private View mView;
    private SendData mSendData;
    public interface SendData {
        void sendData(String email);
    }

    public Fragment1() {
        // Required empty public constructor
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        mSendData = (SendData) getActivity();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        mView = inflater.inflate(R.layout.fragment_1, container, false);
        edtEmail = mView.findViewById(R.id.edtEmail);
        btnSend = mView.findViewById(R.id.btnSend);
        btnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendData();
            }
        });
        return mView;
    }

    private void sendData() {
     String strEmail = edtEmail.getText().toString().trim();
     mSendData.sendData(strEmail);
    }
    public void updateData(String email){
        edtEmail.setText(email);
    }
}