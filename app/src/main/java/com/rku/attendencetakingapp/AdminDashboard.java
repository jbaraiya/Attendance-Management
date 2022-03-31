package com.rku.attendencetakingapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.GridView;

public class AdminDashboard extends AppCompatActivity {


    int image[] = {R.drawable.classmates,R.drawable.teacher,R.drawable.classroom,R.drawable.graduation};
    String name[]={"Student","Faculty","Class","Subject"};
    GridView gridView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_dashboard);
        gridView=(GridView) findViewById(R.id.gridView);
        GridAdapter gridAdapter=new GridAdapter(image,name,this);
        gridView.setAdapter(gridAdapter);
    }
}