package com.example.mrliu.coursetable.bean;

import android.widget.LinearLayout;

import java.util.Date;

public class CourseTable {
    final private String SCHOOL_NAME = "江西信息学院";
    final private String TIME_SCOPE = "2018-2019学年度 第二学期课程表";
    final private String CLASS_GRADE = "17软件7-8班";
    final private String START_COURSE_TIME = "开课日期：2019年2月28日";

    private String course_name;
    private Date course_time;
    private String course_address;
    private String course_teacher;
    private LinearLayout linearLayout;
    private int tvId;
    private String week;


    public String getWeek() {
        return week;
    }

    public void setWeek(String week) {
        this.week = week;
    }

    public CourseTable(Date course_time, LinearLayout linearLayout, String week) {
        this.course_time = course_time;
        this.linearLayout = linearLayout;

        this.week = week;
    }


    public int getTvId() {
        return tvId;
    }

    public void setTvId(int tvId) {
        this.tvId = tvId;
    }

    public CourseTable(String course_name, String course_teacher, String course_address, int tvId){
        this.course_name = course_name;
        this.course_teacher =course_teacher;
        this.course_address = course_address;
        this.tvId = tvId;

    }

    public LinearLayout getLinearLayout() {
        return linearLayout;
    }

    public void setLinearLayout(LinearLayout linearLayout) {
        this.linearLayout = linearLayout;
    }

    public String getCourse_name() {
        return course_name;
    }

    public void setCourse_name(String course_name) {
        this.course_name = course_name;
    }

    public Date getCourse_time() {
        return course_time;
    }

    public void setCourse_time(Date course_time) {
        this.course_time = course_time;
    }

    public String getCourse_address() {
        return course_address;
    }

    public void setCourse_address(String course_address) {
        this.course_address = course_address;
    }

    public String getCourse_teacher() {
        return course_teacher;
    }

    public void setCourse_teacher(String course_teacher) {
        this.course_teacher = course_teacher;
    }

    @Override
    public String toString() {
        return "CourseTable{" +
                "course_name='" + course_name + '\'' +
                ", course_time=" + course_time +
                '}';
    }
}
