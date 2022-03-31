package com.rku.attendencetakingapp;

public class GetClasswiseStudent {


    public String student_id, first_name, last_name, class_id;

    public GetClasswiseStudent() {
    }

    public GetClasswiseStudent(String student_id, String first_name, String last_name, String class_id) {
        this.student_id = student_id;
        this.first_name = first_name;
        this.last_name = last_name;
        this.class_id = class_id;
    }

    public String getStudent_id() {
        return student_id;
    }

    public void setStudent_id(String student_id) {
        this.student_id = student_id;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getClass_id() {
        return class_id;
    }

    public void setClass_id(String class_id) {
        this.class_id = class_id;
    }
}
