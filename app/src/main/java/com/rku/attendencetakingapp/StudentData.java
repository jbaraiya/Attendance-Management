package com.rku.attendencetakingapp;


import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.ListView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class StudentData extends AppCompatActivity {
    String url = "http://attendancemanagementsystem.epizy.com/api/get_classwise_student.php/";
    ArrayList<GetClasswiseStudent> list=new ArrayList<GetClasswiseStudent>();
    GetStudentAdapter getStudentAdapter;
    ListView listView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_data);

        listView=(ListView) findViewById(R.id.listView);

        getData();


    }
    void getData()
    {



        //Controller controller=new Controller();
        Retrofit retrofit=new Retrofit.Builder().baseUrl(url).addConverterFactory(GsonConverterFactory.create()).build();
        APISet apiSet=retrofit.create(APISet.class);
        Call<List<GetClasswiseStudent>> call=apiSet.getClasswiseStudent();
        call.enqueue(new Callback<List<GetClasswiseStudent>>() {
            @Override
            public void onResponse(Call<List<GetClasswiseStudent>> call, Response<List<GetClasswiseStudent>> response) {

                List<GetClasswiseStudent>list=response.body();
                //RecyclerStudentAttendance data=new RecyclerStudentAttendance(list);
                //recyclerView.setAdapter(data);
            }
            @Override
            public void onFailure(Call<List<GetClasswiseStudent>> call, Throwable t) {
            }
        });

//        StringRequest stringRequest=new StringRequest(Request.Method.GET, url,
//                new Response.Listener<String>() {
//                    @Override
//                    public void onResponse(String response) {
//
//
//                        try {
//                            JSONArray jsonArray=new JSONArray(response);
//                            String first_name, last_name;
//
//
//                            for (int i=0;i<jsonArray.length();i++)
//                            {
//                                JSONObject jsonObject=jsonArray.getJSONObject(i);
//                                first_name=jsonObject.getString("first_name");
//                                last_name=jsonObject.getString("last_name");
//
//                                list.add(new GetClasswiseStudent(first_name,last_name));
//                                //getStudentAdapter.notifyDataSetChanged();
//                            }
//                            getStudentAdapter=new GetStudentAdapter(StudentData.this,list);
//                            listView.setAdapter(getStudentAdapter);
//
//                        }
//                        catch (JSONException e){
//                            e.printStackTrace();
//                        }
//
//
//                    }
//                }, new Response.ErrorListener() {
//            @Override
//            public void onErrorResponse(VolleyError error) {
//                Toast.makeText(StudentData.this, error.getMessage(), Toast.LENGTH_SHORT).show();
//
//            }
//        });
//        RequestQueue requestQueue= Volley.newRequestQueue(StudentData.this);
//        requestQueue.add(stringRequest);

    }
}




/*Retrofit retrofit=new Retrofit.Builder().baseUrl(url).addConverterFactory(GsonConverterFactory.create()).build();
        APISet apiSet=retrofit.create(APISet.class);
        Call<List<GetClasswiseStudent>> call=apiSet.getClasswiseStudent();
        call.enqueue(new Callback<List<GetClasswiseStudent>>() {
            @Override
            public void onResponse(Call<List<GetClasswiseStudent>> call, Response<List<GetClasswiseStudent>> response) {

                list=response.body();
                //RecyclerStudentAttendance data=new RecyclerStudentAttendance(list);
                //recyclerView.setAdapter(data);
            }
            @Override
            public void onFailure(Call<List<GetClasswiseStudent>> call, Throwable t) {
            }
        });
        //recyclerView=(RecyclerView) findViewById(R.id.recyclerView);

        //recyclerView.setLayoutManager(new LinearLayoutManager(this));
        //getData();

    }
    public void getData()
    {

    }*/