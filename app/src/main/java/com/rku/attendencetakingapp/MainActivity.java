package com.rku.attendencetakingapp;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.MaterialAutoCompleteTextView;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    String url = "http://192.168.189.27/api/";
    EditText uidEditText;
    EditText passwordEditText;
    RadioGroup radioGroup;
    RadioButton radioButton;
    MaterialButton btnLogin;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ActionBar actionBar=getSupportActionBar();
        actionBar.hide();
        uidEditText=(EditText) findViewById(R.id.uidEditText);
        passwordEditText=(EditText) findViewById(R.id.passwordEditText);
        radioGroup=(RadioGroup) findViewById(R.id.radioGrooup);
        btnLogin=(MaterialButton) findViewById(R.id.btnLogin);
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(validate())
                {
                    int radioButtonId=radioGroup.getCheckedRadioButtonId();
                    radioButton=findViewById(radioButtonId);
                    if(radioButton.getText().equals("Admin"))
                    {
                        Intent adminDashboard=new Intent(MainActivity.this,AdminDashboard.class);
                        startActivity(adminDashboard);
                        finish();
                    }
                    else
                    {
                        Intent studentDashboard=new Intent(MainActivity.this,StudentDashboard.class);
                        startActivity(studentDashboard);
                        finish();
                    }
                }

            }
        });



    }
    public boolean validate()
    {
        boolean isValid=true;
        String uid=uidEditText.getText().toString();
        String password= passwordEditText.getText().toString();
        if(uid.isEmpty() || password.isEmpty())
        {
            if(uid.isEmpty())
            {
                uidEditText.setError("UID is empty");
                isValid=false;
                if(password.isEmpty())
                {
                    passwordEditText.setError("Password is empty");
                }
            }
            if(password.isEmpty())
            {
                passwordEditText.setError("Password is empty");
                isValid=false;
            }
        }
        return isValid;
    }


}









/*
        Spinner materialAutoCompleteTextView;
            boolean isValid=true;
            String name = "";
        ArrayList<String> userdata;
            ArrayAdapter<String> adapter;
            ProgressDialog pd;
            MaterialButton btn;
// show progressbar
              pd=new ProgressDialog(MainActivity.this);
                pd.show();
                pd.setContentView(R.layout.progressbar);

                // check internet connectivity
                if(!checkConnectivity(this))
                {
                pd.dismiss();
                Toast.makeText(this, "Your are not connected to internet", Toast.LENGTH_SHORT).show();
                finish();
                }
                else
                {
                pd.dismiss();

                // initialize field
                materialAutoCompleteTextView= (Spinner) findViewById(R.id.spinner);
                uidEditText=(EditText) findViewById(R.id.uidEditText);
                passwordEditText=(EditText) findViewById(R.id.passwordEditText);
                btn=(MaterialButton)findViewById(R.id.btnLogin);



                Retrofit retrofit = new Retrofit.Builder().baseUrl(url).addConverterFactory(GsonConverterFactory.create()).build();
                APISet apiSet = retrofit.create(APISet.class);
        Call<List<ResponseUserType>> call = apiSet.getUserType();

        call.enqueue(new Callback<List<ResponseUserType>>() {
@Override
public void onResponse(Call<List<ResponseUserType>> call, Response<List<ResponseUserType>> response) {
        userdata=new ArrayList<String>();
        userdata.add("Select user type");
        List<ResponseUserType> list= response.body();

        for (int i = 0; i<list.size(); i++)
        {
        userdata.add(list.get(i).getUSER_TYPE());
        Log.i("User", list.get(i).getUSER_TYPE());
        }

        adapter=new ArrayAdapter<String>(MainActivity.this, android.R.layout.simple_spinner_item,userdata);
        adapter.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
        materialAutoCompleteTextView.setAdapter(adapter);
        }

@Override
public void onFailure(Call<List<ResponseUserType>> call, Throwable t) {

        }
        });
        // check item selected in spinner
        materialAutoCompleteTextView.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
@Override
public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

        if(parent.toString().equals("Select user type"))
        {
        isValid=false;
        //materialAutoCompleteTextView.setError("User type is empty");
        }
        else
        {
        name=view.toString();
        }
        }
@Override
public void onNothingSelected(AdapterView<?> parent) {
        isValid=false;
        }
        });



        btn.setOnClickListener(new View.OnClickListener() {
@Override
public void onClick(View v) {
        // boolean variable to check whether UID and Password is empty or not
        // boolean variable is false if UID or Password or User type is empty otherwise user will go to next activity

        // check uid and password is empty to set error message
        String uid=uidEditText.getText().toString().trim();
        String password=passwordEditText.getText().toString().trim();
        if (uid.isEmpty() || password.isEmpty())
        {
        if (uid.isEmpty())
        {
        uidEditText.setError("UID is empty");
        if (password.isEmpty()) {
        passwordEditText.setError("Password is empty");
        }
        }
        if (password.isEmpty()) {
        passwordEditText.setError("Password is empty");
        }
        isValid=false;
        }
        if(isValid)
        {
        if(name.equals("Admin"))
        {
        Intent adminDashboard=new Intent(MainActivity.this,AdminDashboard.class);
        startActivity(adminDashboard);
        finish();
        }
        if(name.equals("Faculty"))
        {
        Intent facultyDashboard=new Intent(MainActivity.this,StudentDashboard.class);
        startActivity(facultyDashboard);
        finish();
        }
        }
        }
        });
        boolean checkConnectivity(MainActivity mainActivity)
    {
        ConnectivityManager connectivityManager=(ConnectivityManager) mainActivity.getSystemService(Context.CONNECTIVITY_SERVICE);

        NetworkInfo wifiCon=connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_WIFI);
        NetworkInfo dataCon=connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_MOBILE);

        if(wifiCon!=null && wifiCon.isConnected() || dataCon!=null && dataCon.isConnected())
        {
            return true;
        }
        return false;

    }


        }*/
