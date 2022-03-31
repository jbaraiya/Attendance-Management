package com.rku.attendencetakingapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;

import com.google.android.material.button.MaterialButton;

public class StudentDashboard extends AppCompatActivity {


    EditText classIDEditText, subjectCodeEditText;
    MaterialButton btnTakeAttendance;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_dashboard);
    }
}