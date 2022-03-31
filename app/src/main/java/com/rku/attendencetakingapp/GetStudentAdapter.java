package com.rku.attendencetakingapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class GetStudentAdapter extends ArrayAdapter {
    Context context;
    ArrayList<GetClasswiseStudent> list;

    public GetStudentAdapter(@NonNull Context context, ArrayList<GetClasswiseStudent> list) {

        super(context, R.layout.single_student_data_view, list);
        this.context=context;
        this.list=list;

    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.single_student_data_view,null);

        TextView first_name, last_name;
        RadioGroup radioGroup;
        RadioButton radioButton;
        first_name=parent.findViewById(R.id.first_name);
        last_name=parent.findViewById(R.id.last_name);

        first_name.setText(list.get(position).getFirst_name());
        last_name.setText(list.get(position).getLast_name());

        return view;

    }
}
