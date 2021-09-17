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

public class Fragment2 extends Fragment {
    private EditText edtEmail;
    private Button btnUpdate;
    private View mView;
    private UpdateData mUpdateData;
    public interface UpdateData {
        void UpdateData(String email);
    }
    public Fragment2() {
        // Required empty public constructor
    }
    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        mUpdateData = (UpdateData) getActivity();
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        mView = inflater.inflate(R.layout.fragment_2, container, false);
        edtEmail = mView.findViewById(R.id.edtEmail);
        btnUpdate = mView.findViewById(R.id.btnUpdate);
        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateData();
            }
        });
        return mView;
    }

    private void updateData() {
        String strEmail = edtEmail.getText().toString().trim();
        mUpdateData.UpdateData(strEmail);
    }
    public void nhanData(String email){
        edtEmail.setText(email);
    }
}