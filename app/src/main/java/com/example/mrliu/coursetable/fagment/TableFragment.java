package com.example.mrliu.coursetable.fagment;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.Html;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.mrliu.coursetable.R;
import com.example.mrliu.coursetable.bean.CourseTable;
import com.example.mrliu.coursetable.customview.MyTextView;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

public class TableFragment extends Fragment implements View.OnClickListener {

    private final long CLASS_REST = 1000 * 60 * 10; //10分钟休息
    private final long SHOT_TIME = 1500;
    private TextView course_table_comment;
    private GridLayout course_grid;

    private List<LinearLayout> linearLayouts = new ArrayList<>();
    private List<CourseTable> courseTables = new ArrayList<>();
    private List<TextView> textViews = new ArrayList<>();
    private String[] weeks = {"星期一", "星期二", "星期三", "星期四", "星期五"};
    private Date date1;
    private Date date2;
    private Date date3;
    private Date date4;
    private Date date5;
    private Date date6;
    private Date date7;
    private Date date9;
    private Date date8;
    private Date date10;
    private Date date11;

    private LinearLayout linear1;
    private LinearLayout linear2;
    private LinearLayout linear3;
    private LinearLayout linear4;
    private LinearLayout linear5;
    private LinearLayout linear6;
    private LinearLayout linear7;
    private LinearLayout linear8;
    private LinearLayout linear9;
    private LinearLayout linear10;
    private LinearLayout linear12;
    private LinearLayout linear11;
    private LinearLayout linear13;
    private LinearLayout linear14;
    private LinearLayout linear15;
    private LinearLayout linear16;
    private LinearLayout linear17;
    private LinearLayout linear18;
    private LinearLayout linear19;
    private LinearLayout linear20;

    private TextView class_rest_am;
    private TextView lunch_rest;
    private TextView class_rest_pm;
    private TextView class_extra_active;
    private TextView original_get_up;
    private TextView custom_get_up;
    private TextView monday;
    private TextView tuesday;
    private TextView wednesday;
    private TextView thursday;
    private TextView friday;
    private MyTextView weekend;

    private Context mContext;
    private View view;
    private ImageView rabbit_img;
    private AnimationDrawable animationDrawable;
    private Random random;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_table1, container, false);
        initView();
        return view;
    }


    /**
     * 初始化控件
     */
    private void initView() {
        mContext = getActivity();
        course_table_comment = (TextView) view.findViewById(R.id.course_table_comment);
        course_table_comment.setText(Html.fromHtml("表中带<font color='red'>*</font>号的教室为实训楼<br>" +
                "表中带<font color='red'>#号</font>的教室为红楼<br>" +
                "表中不带符合的教室为新楼"));
        linear1 = (LinearLayout) view.findViewById(R.id.linear1);
        linear1.setOnClickListener(this);
        linear2 = (LinearLayout) view.findViewById(R.id.linear2);
        linear2.setOnClickListener(this);
        linear3 = (LinearLayout) view.findViewById(R.id.linear3);
        linear3.setOnClickListener(this);
        linear4 = (LinearLayout) view.findViewById(R.id.linear4);
        linear4.setOnClickListener(this);
        linear5 = (LinearLayout) view.findViewById(R.id.linear5);
        linear5.setOnClickListener(this);
        linear6 = (LinearLayout) view.findViewById(R.id.linear6);
        linear6.setOnClickListener(this);
        linear7 = (LinearLayout) view.findViewById(R.id.linear7);
        linear7.setOnClickListener(this);
        linear8 = (LinearLayout) view.findViewById(R.id.linear8);
        linear8.setOnClickListener(this);
        linear9 = (LinearLayout) view.findViewById(R.id.linear9);
        linear9.setOnClickListener(this);
        linear10 = (LinearLayout) view.findViewById(R.id.linear10);
        linear10.setOnClickListener(this);
        linear11 = (LinearLayout) view.findViewById(R.id.linear11);
        linear11.setOnClickListener(this);
        linear12 = (LinearLayout) view.findViewById(R.id.linear12);
        linear12.setOnClickListener(this);
        linear13 = (LinearLayout) view.findViewById(R.id.linear13);
        linear13.setOnClickListener(this);
        linear14 = (LinearLayout) view.findViewById(R.id.linear14);
        linear14.setOnClickListener(this);
        linear15 = (LinearLayout) view.findViewById(R.id.linear15);
        linear15.setOnClickListener(this);
        linear16 = (LinearLayout) view.findViewById(R.id.linear16);
        linear16.setOnClickListener(this);
        linear17 = (LinearLayout) view.findViewById(R.id.linear17);
        linear17.setOnClickListener(this);
        linear18 = (LinearLayout) view.findViewById(R.id.linear18);
        linear18.setOnClickListener(this);
        linear19 = (LinearLayout) view.findViewById(R.id.linear19);
        linear19.setOnClickListener(this);
        linear20 = (LinearLayout) view.findViewById(R.id.linear20);
        linear20.setOnClickListener(this);
        course_grid = (GridLayout) view.findViewById(R.id.course_grid);
        class_rest_am = (TextView) view.findViewById(R.id.class_rest_am);
        class_rest_am.setOnClickListener(this);
        lunch_rest = (TextView) view.findViewById(R.id.lunch_rest);
        lunch_rest.setOnClickListener(this);
        class_rest_pm = (TextView) view.findViewById(R.id.class_rest_pm);
        class_rest_pm.setOnClickListener(this);
        class_extra_active = (TextView) view.findViewById(R.id.class_extra_active);
        class_extra_active.setOnClickListener(this);
        original_get_up = view.findViewById(R.id.original_get_up);
        original_get_up.setOnClickListener(this);
        custom_get_up = view.findViewById(R.id.custom_get_up);
        custom_get_up.setOnClickListener(this);

        initListData();

        //每分钟获取系统时间来判断上那节课
        final Timer timer = new Timer();
        TimerTask timerTask = new TimerTask() {
            @Override
            public void run() {
                long millis = System.currentTimeMillis();
                Date date = new Date(millis);
                SimpleDateFormat format = new SimpleDateFormat("HH:mm");
                String time = format.format(date);
                SimpleDateFormat weekFormat = new SimpleDateFormat("EEEE");
                String week = weekFormat.format(date);
                Log.d("CourseTableActivity", week + "---currentTime：" + time);

                //确认星期几
                if (week.equals(weeks[0])) {
                    monday.setTextColor(Color.parseColor("#3eede7"));
                    class_extra_active.setVisibility(TextView.VISIBLE);
                    weekend.setVisibility(TextView.GONE);
                } else if (week.equals(weeks[1])) {
                    tuesday.setTextColor(Color.parseColor("#3eede7"));
                } else if (week.equals(weeks[2])) {
                    wednesday.setTextColor(Color.parseColor("#3eede7"));
                } else if (week.equals(weeks[3])) {
                    thursday.setTextColor(Color.parseColor("#3eede7"));
                } else if (week.equals(weeks[4])) {
                    friday.setTextColor(Color.parseColor("#3eede7"));
                } else {
                    friday.setTextColor(Color.GRAY);
                    class_extra_active.setVisibility(TextView.GONE);
                    weekend.setVisibility(TextView.VISIBLE);
                }
                //起床时间(7:30-8:30)
                if (date7.getTime() <= millis && millis < date1.getTime()) {
                    getActivity().runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            //隐藏原生view,让文字闪烁view可见
                            original_get_up.setVisibility(TextView.GONE);
                            custom_get_up.setVisibility(TextView.VISIBLE);
                            custom_get_up.setBackgroundColor(Color.parseColor("#3300ffff"));
                            custom_get_up.setText("起                床                啦");
                            Log.d("CourseTableActivity", "起床---文字闪烁");
                        }
                    });
                } else if (date1.getTime() <= millis && millis <= (date1.getTime() + CLASS_REST)) {
                    Log.d("CourseTableActivity", "起床---不显示文字闪烁");
                    //隐藏原生view,让文字闪烁view可见
                    original_get_up.setVisibility(TextView.VISIBLE);
                    custom_get_up.setVisibility(TextView.GONE);
                    original_get_up.setText("早                自                习");
                }

                //睡觉时间(23:20-23:58)
                if (date8.getTime() <= millis && millis <= date9.getTime()) {
                    getActivity().runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            //隐藏原生view,让文字闪烁view可见
                            original_get_up.setVisibility(TextView.GONE);
                            custom_get_up.setVisibility(TextView.VISIBLE);
                            custom_get_up.setBackgroundColor(Color.parseColor("#3300ffff"));
                            custom_get_up.setText("睡                觉                啦");
                            Log.d("CourseTableActivity", "睡觉---文字闪烁");
                        }
                    });
                } else if (millis >= date10.getTime() && millis <= date11.getTime()) {
                    //晚安时间
                    Log.d("CourseTableActivity", "good night");
                    getActivity().runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            Log.d("CourseTableActivity", "不显示文字闪烁");
                            //隐藏原生view,让文字闪烁view可见
                            original_get_up.setVisibility(TextView.GONE);
                            custom_get_up.setVisibility(TextView.VISIBLE);
                            custom_get_up.setText("Good                           Night");
                        }
                    });
                }
                for (CourseTable course : courseTables) {
                    //判断星期几的课程
                    if (course.getWeek().equals(week)) {
                        //第一节课的课程
                        if (date1.getTime() <= millis && millis <= date2.getTime()) {
                            Log.d("CourseTableActivity", "week" + week + "---第一节课");
                            Log.d("CourseTableActivity", "time" + time);
                            //确认课程
                            if (course.getCourse_time().equals(date1)) {
                                //重置背景
                                resetBackground();
                                resetTextViewBg();
                                LinearLayout linearLayout = course.getLinearLayout();
                                linearLayout.setBackgroundColor(Color.parseColor("#3eede7"));
                            }
                        } else if (date2.getTime() < millis && millis < (date2.getTime() + CLASS_REST*2)) {
                            resetBackground();
                            Log.d("CourseTableActivity", "第一节课、第二节课之间的休息时间");
                            class_rest_am.setBackgroundColor(Color.GREEN);
                            return;
                        }


                        //第二节课的课程
                        if (date2.getTime() <= millis && millis <= date3.getTime()) {

                            Log.d("CourseTableActivity", "week" + week + "---第二节课");
                            Log.d("CourseTableActivity", "time" + time);
                            //确认课程
                            if (course.getCourse_time().equals(date2)) {
                                //重置背景
                                resetBackground();
                                resetTextViewBg();
                                LinearLayout linearLayout = course.getLinearLayout();
                                linearLayout.setBackgroundColor(Color.parseColor("#3eede7"));
                            }
                        } else if (date3.getTime() < millis && millis < date4.getTime()) {
                            Log.d("CourseTableActivity", "午休时间");
                            resetBackground();
                            lunch_rest.setBackgroundColor(Color.GREEN);
                            return;
                        }

                        //第三节课的课程
                        if (date4.getTime() <= millis && millis <= date5.getTime()) {
                            Log.d("CourseTableActivity", "week" + week + "---第三节课");
                            Log.d("CourseTableActivity", "time" + time);
                            Log.d("CourseTableActivity", "course.getCourse_time().equals(date4):" + course.getCourse_time().equals(date4));
                            //确认课程
                            if (course.getCourse_time().equals(date4)) {
                                //重置背景
                                resetBackground();
                                resetTextViewBg();
                                LinearLayout linearLayout = course.getLinearLayout();
                                linearLayout.setBackgroundColor(Color.parseColor("#3eede7"));
                            }
                        } else if (date5.getTime() < millis && millis < (date5.getTime() + CLASS_REST)) {
                            Log.d("CourseTableActivity", "第三和第四节课的课间时间");
                            resetBackground();
                            class_rest_pm.setBackgroundColor(Color.GREEN);
                            return;
                        }

                        //第四节课的课程
                        if (date5.getTime() <= millis && millis <= date6.getTime()) {
                            Log.d("CourseTableActivity", "week" + week + "---第四节课");
                            Log.d("CourseTableActivity", "time" + time);
                            //确认课程
                            if (course.getCourse_time().equals(date5)) {
                                //重置背景
                                resetBackground();
                                resetTextViewBg();
                                LinearLayout linearLayout = course.getLinearLayout();
                                linearLayout.setBackgroundColor(Color.parseColor("#3eede7"));
                            }
                        } else if (millis > date6.getTime() && millis <= date8.getTime()) {

                            //星期五
                            if (week.equals(weeks[4])) {
                                class_extra_active.setVisibility(TextView.GONE);
                                weekend.setVisibility(TextView.VISIBLE);
                                Log.d("CourseTableActivity", "放假啦");
                                return;
                            }
                            Log.d("CourseTableActivity", "上完课了,终于可以DBK");
                            class_extra_active.setBackgroundColor(Color.GREEN);
                            resetBackground();
                            return;
                        }

                    }
                }
            }
        };
        timer.schedule(timerTask, 50, 1000 * 60);

        monday = (TextView) view.findViewById(R.id.monday);
        monday.setOnClickListener(this);
        tuesday = (TextView) view.findViewById(R.id.tuesday);
        tuesday.setOnClickListener(this);
        wednesday = (TextView) view.findViewById(R.id.wednesday);
        wednesday.setOnClickListener(this);
        thursday = (TextView) view.findViewById(R.id.thursday);
        thursday.setOnClickListener(this);
        friday = (TextView) view.findViewById(R.id.friday);
        friday.setOnClickListener(this);
        weekend = (MyTextView) view.findViewById(R.id.weekend);
        weekend.setOnClickListener(this);
        rabbit_img = (ImageView) view.findViewById(R.id.rabbit_img);
        rabbit_img.setImageResource(R.drawable.rabbit_animation);

        animationDrawable = (AnimationDrawable) rabbit_img.getDrawable();
        random = new Random();
        rabbit_img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                animationDrawable.start();
                final long random_millis = nextLong(random, 1000) + SHOT_TIME;

                Timer timer1 = new Timer();
                timer1.schedule(new TimerTask() {
                    @Override
                    public void run() {
                        if (animationDrawable.isRunning()){
                            animationDrawable.stop();
                        }
                    }
                },random_millis);
            }
        });
    }

    //随机产生long类型随机数
    public long nextLong(Random rng, long n) {
        long bits, val;
        do {
            bits = (rng.nextLong() << 1) >>> 1;
            val = bits % n;
        } while (bits-val+(n-1) < 0L);
        return val;
    }

    /**
     * 初始化集合数据
     */
    private void initListData() {

        linearLayouts.add(linear1);
        linearLayouts.add(linear2);
        linearLayouts.add(linear3);
        linearLayouts.add(linear4);
        linearLayouts.add(linear5);
        linearLayouts.add(linear6);
        linearLayouts.add(linear7);
        linearLayouts.add(linear8);
        linearLayouts.add(linear9);
        linearLayouts.add(linear10);
        linearLayouts.add(linear11);
        linearLayouts.add(linear12);
        linearLayouts.add(linear13);
        linearLayouts.add(linear14);
        linearLayouts.add(linear15);
        linearLayouts.add(linear16);
        linearLayouts.add(linear17);
        linearLayouts.add(linear18);
        linearLayouts.add(linear19);
        linearLayouts.add(linear20);

        //课程时间周期
        date1 = setDate(8, 30);
        date2 = setDate(10, 0);
        date3 = setDate(11, 50);
        date4 = setDate(13, 40);
        date5 = setDate(15, 10);
        date6 = setDate(16, 40);

        //起床提示时间
        date7 = setDate(7, 30);

        //睡觉提示时间
        date8 = setDate(23, 20);
        date9 = setDate(23, 58);

        //晚安时间
        date10 = setDate(0, 0);
        date11 = setDate(3, 0);

        //星期一
        CourseTable course1 = new CourseTable(date1, linear1, weeks[0]);
        CourseTable course2 = new CourseTable(date2, linear6, weeks[0]);
        CourseTable course3 = new CourseTable(date4, linear11, weeks[0]);

        //星期二
        CourseTable course4 = new CourseTable(date2, linear7, weeks[1]);
        CourseTable course5 = new CourseTable(date5, linear17, weeks[1]);

        //星期三
        CourseTable course6 = new CourseTable(date2, linear8, weeks[2]);
        CourseTable course7 = new CourseTable(date4, linear13, weeks[2]);
        CourseTable course8 = new CourseTable(date5, linear18, weeks[2]);

        //星期四
        CourseTable course9 = new CourseTable(date2, linear9, weeks[3]);
        CourseTable course10 = new CourseTable(date4, linear14, weeks[3]);
        CourseTable course11 = new CourseTable(date5, linear19, weeks[3]);

        //星期五
        CourseTable course12 = new CourseTable(date1, linear5, weeks[4]);
        CourseTable course13 = new CourseTable(date5, linear20, weeks[4]);

        courseTables.add(course1);
        courseTables.add(course2);
        courseTables.add(course3);
        courseTables.add(course4);
        courseTables.add(course5);
        courseTables.add(course6);
        courseTables.add(course7);
        courseTables.add(course8);
        courseTables.add(course9);
        courseTables.add(course10);
        courseTables.add(course11);
        courseTables.add(course12);
        courseTables.add(course13);

        textViews.add(class_rest_am);
        textViews.add(class_rest_pm);
        textViews.add(class_extra_active);
        textViews.add(lunch_rest);
        textViews.add(original_get_up);
    }

    /**
     * 自定义设置日期
     *
     * @param hours
     * @param minutes
     * @return
     */
    private Date setDate(int hours, int minutes) {
        Date date = new Date();
        date.setHours(hours);
        date.setMinutes(minutes);
        Log.d("CourseTableActivity", date.toString());
        return date;
    }

    //控件点击事件
    @Override
    public void onClick(View v) {

    }

    /**
     * 重置课程布局(LinearLayout)背景
     */
    private void resetBackground() {
        for (LinearLayout linear : linearLayouts) {
            linear.setBackgroundResource(R.drawable.selector_color_linear);
        }
    }

    /**
     * 重置TextView(课外时间)背景
     */
    private void resetTextViewBg() {
        for (TextView tv : textViews) {
            tv.setBackgroundResource(R.drawable.selector_color_linear);
        }
    }
}
