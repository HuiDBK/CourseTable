package com.example.mrliu.coursetable.fagment;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.mrliu.coursetable.R;
import com.example.mrliu.coursetable.bean.CourseTable;
import com.example.mrliu.coursetable.customview.MyTextView;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.Timer;
import java.util.TimerTask;

public class SecondTabFragment extends Fragment implements View.OnClickListener {

    private List<CourseTable> courses;
    private int rabbit_img [] = {R.drawable.rabbit1,R.drawable.rabbit2,R.drawable.rabbit3,R.drawable.rabbit4,R.drawable.rabbit5};
    private HashMap<Integer, TextView> tv_map;
    private TextView mon;
    private TextView tue;
    private TextView wed;
    private TextView thu;
    private TextView fri;
    private TextView morning;
    private MyTextView custom_morning;
    private TextView tv_am;
    private TextView tv_course1;
    private TextView tv_course2;
    private TextView tv_course3;
    private TextView tv_course4;
    private TextView tv_course5;
    private TextView rest_am;
    private TextView tv_course6;
    private TextView tv_course7;
    private TextView tv_course8;
    private TextView tv_course9;
    private TextView tv_course10;
    private TextView rest_lunch;
    private TextView tv_pm;
    private TextView tv_course11;
    private TextView tv_course12;
    private TextView tv_course13;
    private TextView tv_course14;
    private TextView tv_course15;
    private TextView rest_pm;
    private TextView tv_course16;
    private TextView tv_course17;
    private TextView tv_course18;
    private TextView tv_course19;
    private TextView tv_course20;
    private TextView tv_dinner;
    private TextView tv_course21;
    private TextView tv_course22;
    private TextView tv_course23;
    private TextView tv_course24;
    private TextView tv_course25;
    private TextView tv_night_rest;
    private MyTextView tv_weekend;

    //课程表时间周期

    //催睡觉时间(0:0-4:30)
    private Date date1 = setDate(0, 0);
    private Date date2 = setDate(4, 30);

    //起床时间(6:50-7:35)
    private Date date3 = setDate(6, 50);
    private Date date4 = setDate(7, 35);

    //早晨时间(7:35-8:10)
    private Date date5 = setDate(8, 10);

    //一、二节课(8:15-9:50)
    private Date date6 = setDate(8, 15);
    private Date date7 = setDate(9, 50);

    //三、四节课(10:10-11:45)
    private Date date8 = setDate(10, 10);
    private Date date9 = setDate(11, 45);

    //午休时间(11:45-13:55)
    private Date date10 = setDate(13, 55);

    //五、六节课(14:00-15:35)
    private Date date11 = setDate(14, 00);
    private Date date12 = setDate(15, 35);

    //七、八节课
    private Date date13 = setDate(15, 55);
    private Date date14 = setDate(17, 30);

    //晚餐时间
    private Date date15 = setDate(18, 25);

    //九、十节课
    private Date date16 = setDate(18, 30);
    private Date date17 = setDate(20, 5);

    //准备睡觉时间
    private Date date18 = setDate(22, 30);
    private Date date19 = setDate(23, 50);

    private String[] weeks = {"星期一", "星期二", "星期三", "星期四", "星期五"};
    private String week;
    private List<TextView> text_views;
    private List<TextView> tv_weeks;
    private ImageView rabbit;
    private ImageView rabbit2;
    private ImageView rabbit3;
    private ImageView rabbit4;
    private ImageView rabbit5;
    private ImageView rabbit6;
    private ImageView rabbit7;
    private ImageView rabbit8;
    private List<ImageView> rabbits;
    private Random random;

    //设置时间
    private Date setDate(int hours, int minutes) {
        Date date = new Date();
        date.setHours(hours);
        date.setMinutes(minutes);
        return date;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d("SecondTabFragment", "onCreate");
    }

    //加载fragment启动
    @Override
    public void onStart() {
        List<Integer> tv_ids = new ArrayList<>();
        for (CourseTable course : courses) {
            if (course.getCourse_name().equals("")) {
                tv_ids.add(course.getTvId());
                Log.d("SecondTabFragment", "course.getTvId():" + course.getTvId());
            }
        }
        super.onStart();
        Timer timer = new Timer();
        TimerTask timerTask = new TimerTask() {
            @Override
            public void run() {
                Date date = new Date();
                String current_time = new SimpleDateFormat("HH:mm").format(date);
                week = new SimpleDateFormat("EEEE").format(date);
                long current_time_millis = date.getTime();

                Log.d("SecondTabFragment", week);
                Log.d("SecondTabFragment", current_time);
                Log.d("SecondTabFragment", "------------------------------");

                //确认星期几
                if (week.equals(weeks[0])) {
                    resetWeekBg();
                    mon.setBackgroundColor(Color.parseColor("#e3f9fd"));
                    mon.setTextColor(Color.RED);
                    getActivity().runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            tv_night_rest.setVisibility(TextView.VISIBLE);
                            tv_weekend.setVisibility(TextView.GONE);
                        }
                    });
                } else if (week.equals(weeks[1])) {
                    resetWeekBg();
                    tue.setBackgroundColor(Color.parseColor("#e3f9fd"));
                    tue.setTextColor(Color.RED);
                } else if (week.equals(weeks[2])) {
                    resetWeekBg();
                    wed.setBackgroundColor(Color.parseColor("#e3f9fd"));
                    wed.setTextColor(Color.RED);
                } else if (week.equals(weeks[3])) {
                    resetWeekBg();
                    thu.setBackgroundColor(Color.parseColor("#e3f9fd"));
                    thu.setTextColor(Color.RED);
                } else if (week.equals(weeks[4])) {
                    resetWeekBg();
                    fri.setBackgroundColor(Color.parseColor("#e3f9fd"));
                    fri.setTextColor(Color.RED);
                } else {
                    resetWeekBg();
                    resetBackground();
                    Log.d("SecondTabFragment", "fri:" + fri);
                    getActivity().runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            tv_night_rest.setVisibility(TextView.GONE);
                            tv_weekend.setVisibility(TextView.VISIBLE);
                        }
                    });

                    if (date14.getTime() < current_time_millis && current_time_millis < date15.getTime()) {
                        //晚餐时间
                        tv_dinner.setBackgroundColor(Color.GREEN);
                    } else if (date18.getTime() <= current_time_millis && current_time_millis <= date19.getTime()) {
                        //晚安时间
                        getActivity().runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                morning.setVisibility(TextView.GONE);
                                custom_morning.setVisibility(TextView.VISIBLE);
                                custom_morning.setText("Good                 Night");
                            }
                        });
                    } else if (date1.getTime() <= current_time_millis && current_time_millis <= date2.getTime()) {
                        //别熬夜睡觉时间
                        getActivity().runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                morning.setVisibility(TextView.GONE);
                                custom_morning.setVisibility(TextView.VISIBLE);
                                custom_morning.setText("睡       觉       别       熬       夜");
                            }
                        });
                    } else if (date3.getTime() <= current_time_millis && current_time_millis <= date4.getTime()) {
                        //起床时间
                        getActivity().runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                morning.setVisibility(TextView.GONE);
                                custom_morning.setVisibility(TextView.VISIBLE);
                                custom_morning.setText("起               床               啦");
                            }
                        });
                    } else if (date4.getTime() < current_time_millis && current_time_millis <= date5.getTime()) {
                        //早晨时间
                        getActivity().runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                custom_morning.setVisibility(TextView.GONE);
                                morning.setVisibility(View.VISIBLE);
                            }
                        });
                    } else if (date9.getTime() < current_time_millis && current_time_millis < date10.getTime()) {
                        //午休时间
                        rest_lunch.setBackgroundColor(Color.GREEN);
                    }
                }

                for (CourseTable course : courses) {
                    int tvId = course.getTvId();
                    switch (tvId % 5) {
                        //星期一课程
                        case 1:
                            if (week.equals(weeks[0])) {
                                courseComment(current_time_millis, tvId, course);     //课程提醒
                            }
                            break;
                        //星期二课程
                        case 2:
                            if (week.equals(weeks[1])) {
                                courseComment(current_time_millis, tvId, course);
                            }
                            break;
                        //星期三课程
                        case 3:
                            if (week.equals(weeks[2])) {
                                courseComment(current_time_millis, tvId, course);
                            }
                            break;
                        //星期四课程
                        case 4:
                            if (week.equals(weeks[3])) {
                                courseComment(current_time_millis, tvId, course);
                            }
                            break;
                        //星期五课程
                        case 5:
                            if (week.equals(weeks[4])) {
                                courseComment(current_time_millis, tvId, course);
                            }
                            break;
                    }
                }

            }
        };
        timer.schedule(timerTask, 100, 1000 * 60);
    }

    //重置星期颜色
    private void resetWeekBg() {
        for (TextView tv : tv_weeks) {
            tv.setBackgroundResource(R.drawable.selector_color_textview);
            tv.setTextColor(Color.parseColor("#8a000000"));
        }
    }

    //课程提醒
    private void courseComment(long current_time_millis, int id, CourseTable course) {
        if (date6.getTime() <= current_time_millis && current_time_millis <= date7.getTime()) {
            //一二节课时间
            if (course.getCourse_time().equals(date6)) {
                changeBg(id);
            }
        } else if (date7.getTime() < current_time_millis && current_time_millis < date8.getTime()) {
            resetBackground();
            //课间休息时间
            rest_am.setBackgroundColor(Color.GREEN);
        } else if (date8.getTime() <= current_time_millis && current_time_millis <= date9.getTime()) {
            //三四节课时间
            if (course.getCourse_time().equals(date8)) {
                changeBg(id);
            }
        } else if (date9.getTime() < current_time_millis && current_time_millis < date10.getTime()) {
            resetBackground();
            if (week.equals(weeks[4])) {
                getActivity().runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        tv_night_rest.setVisibility(TextView.GONE);
                        tv_weekend.setVisibility(TextView.VISIBLE);
                    }
                });
            }
            //午休时间
            rest_lunch.setBackgroundColor(Color.GREEN);
        } else if (date11.getTime() <= current_time_millis && current_time_millis <= date12.getTime()) {
            //五六节课时间
            if (course.getCourse_time().equals(date11)) {
                changeBg(id);
            }
        } else if (date12.getTime() < current_time_millis && current_time_millis < date13.getTime()) {
            //课间休息时间
            resetBackground();
            rest_pm.setBackgroundColor(Color.GREEN);
        } else if (date13.getTime() <= current_time_millis && current_time_millis <= date14.getTime()) {
            //七八节课时间
            if (course.getCourse_time().equals(date13)) {
                changeBg(id);
            }
        } else if (date14.getTime() < current_time_millis && current_time_millis < date15.getTime()) {
            //晚餐时间
            resetBackground();
            tv_dinner.setBackgroundColor(Color.GREEN);
        } else if (date16.getTime() <= current_time_millis && current_time_millis <= date17.getTime()) {
            //九十节课时间
            if (course.getCourse_time().equals(date16)) {
                changeBg(id);
            }
        } else if (date17.getTime() < current_time_millis && current_time_millis < date18.getTime()) {
            //上完课了
            resetBackground();
            tv_night_rest.setBackgroundColor(Color.GREEN);
        } else if (date18.getTime() <= current_time_millis && current_time_millis <= date19.getTime()) {

            getActivity().runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    //晚安时间
                    resetBackground();
                    morning.setVisibility(TextView.GONE);
                    custom_morning.setVisibility(TextView.VISIBLE);
                    custom_morning.setText("Good                 Night");
                }
            });
        } else if (date1.getTime() <= current_time_millis && current_time_millis <= date2.getTime()) {
            //别熬夜睡觉时间
            getActivity().runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    resetBackground();
                    morning.setVisibility(TextView.GONE);
                    custom_morning.setVisibility(TextView.VISIBLE);
                    custom_morning.setText("睡       觉       别       熬       夜");
                }
            });
        } else if (date3.getTime() <= current_time_millis && current_time_millis <= date4.getTime()) {
            //起床时间
            getActivity().runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    resetBackground();
                    custom_morning.setVisibility(TextView.VISIBLE);
                    morning.setVisibility(TextView.GONE);
                    custom_morning.setText("起               床               啦");
                }
            });
        } else if (date4.getTime() < current_time_millis && current_time_millis <= date5.getTime()) {
            //早晨时间
            getActivity().runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    resetBackground();
                    custom_morning.setVisibility(TextView.GONE);
                    morning.setVisibility(View.VISIBLE);
                }
            });
        }
    }

    //课程颜色提醒
    private void changeBg(int id) {
        resetBackground();
        TextView textView = tv_map.get(id);
        textView.setBackgroundColor(Color.parseColor("#fff2df"));
    }

    //重置课程颜色
    private void resetBackground() {
        for (TextView tv : text_views) {
            tv.setBackgroundResource(R.drawable.selector_color_textview);
        }

        Set<Map.Entry<Integer, TextView>> entrySet = tv_map.entrySet();
        for (Map.Entry<Integer, TextView> es : entrySet) {
            TextView tv = es.getValue();
            tv.setBackgroundResource(R.drawable.selector_color_textview);
        }
    }


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        Log.d("SecondTabFragment", "scendFragment");
        View view = inflater.inflate(R.layout.fragment_table2, container, false);
        initView(view);
        initCourseData();
        setCourseData();


        return view;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        Log.d("SecondTabFragment", "onAttach");
    }

    //初始化控件
    private void initView(View view) {
        mon = (TextView) view.findViewById(R.id.mon);
        mon.setOnClickListener(this);
        tue = (TextView) view.findViewById(R.id.tue);
        tue.setOnClickListener(this);
        wed = (TextView) view.findViewById(R.id.wed);
        wed.setOnClickListener(this);
        thu = (TextView) view.findViewById(R.id.thu);
        thu.setOnClickListener(this);
        fri = (TextView) view.findViewById(R.id.fri);
        fri.setOnClickListener(this);
        morning = (TextView) view.findViewById(R.id.morning);
        morning.setOnClickListener(this);
        custom_morning = (MyTextView) view.findViewById(R.id.custom_morning);
        custom_morning.setOnClickListener(this);
        tv_am = (TextView) view.findViewById(R.id.tv_am);
        tv_am.setOnClickListener(this);
        tv_course1 = (TextView) view.findViewById(R.id.tv_course1);
        tv_course1.setOnClickListener(this);
        tv_course2 = (TextView) view.findViewById(R.id.tv_course2);
        tv_course2.setOnClickListener(this);
        tv_course3 = (TextView) view.findViewById(R.id.tv_course3);
        tv_course3.setOnClickListener(this);
        tv_course4 = (TextView) view.findViewById(R.id.tv_course4);
        tv_course4.setOnClickListener(this);
        tv_course5 = (TextView) view.findViewById(R.id.tv_course5);
        tv_course5.setOnClickListener(this);
        rest_am = (TextView) view.findViewById(R.id.rest_am);
        rest_am.setOnClickListener(this);
        tv_course6 = (TextView) view.findViewById(R.id.tv_course6);
        tv_course6.setOnClickListener(this);
        tv_course7 = (TextView) view.findViewById(R.id.tv_course7);
        tv_course7.setOnClickListener(this);
        tv_course8 = (TextView) view.findViewById(R.id.tv_course8);
        tv_course8.setOnClickListener(this);
        tv_course9 = (TextView) view.findViewById(R.id.tv_course9);
        tv_course9.setOnClickListener(this);
        tv_course10 = (TextView) view.findViewById(R.id.tv_course10);
        tv_course10.setOnClickListener(this);
        rest_lunch = (TextView) view.findViewById(R.id.rest_lunch);
        rest_lunch.setOnClickListener(this);
        tv_pm = (TextView) view.findViewById(R.id.tv_pm);
        tv_pm.setOnClickListener(this);
        tv_course11 = (TextView) view.findViewById(R.id.tv_course11);
        tv_course11.setOnClickListener(this);
        tv_course12 = (TextView) view.findViewById(R.id.tv_course12);
        tv_course12.setOnClickListener(this);
        tv_course13 = (TextView) view.findViewById(R.id.tv_course13);
        tv_course13.setOnClickListener(this);
        tv_course14 = (TextView) view.findViewById(R.id.tv_course14);
        tv_course14.setOnClickListener(this);
        tv_course15 = (TextView) view.findViewById(R.id.tv_course15);
        tv_course15.setOnClickListener(this);
        rest_pm = (TextView) view.findViewById(R.id.rest_pm);
        rest_pm.setOnClickListener(this);
        tv_course16 = (TextView) view.findViewById(R.id.tv_course16);
        tv_course16.setOnClickListener(this);
        tv_course17 = (TextView) view.findViewById(R.id.tv_course17);
        tv_course17.setOnClickListener(this);
        tv_course18 = (TextView) view.findViewById(R.id.tv_course18);
        tv_course18.setOnClickListener(this);
        tv_course19 = (TextView) view.findViewById(R.id.tv_course19);
        tv_course19.setOnClickListener(this);
        tv_course20 = (TextView) view.findViewById(R.id.tv_course20);
        tv_course20.setOnClickListener(this);
        tv_dinner = (TextView) view.findViewById(R.id.tv_dinner);
        tv_dinner.setOnClickListener(this);
        tv_course21 = (TextView) view.findViewById(R.id.tv_course21);
        tv_course21.setOnClickListener(this);
        tv_course22 = (TextView) view.findViewById(R.id.tv_course22);
        tv_course22.setOnClickListener(this);
        tv_course23 = (TextView) view.findViewById(R.id.tv_course23);
        tv_course23.setOnClickListener(this);
        tv_course24 = (TextView) view.findViewById(R.id.tv_course24);
        tv_course24.setOnClickListener(this);
        tv_course25 = (TextView) view.findViewById(R.id.tv_course25);
        tv_course25.setOnClickListener(this);
        tv_night_rest = (TextView) view.findViewById(R.id.tv_night_rest);
        tv_night_rest.setOnClickListener(this);
        tv_weekend = (MyTextView) view.findViewById(R.id.tv_weekend);
        tv_weekend.setOnClickListener(this);
        rabbit = (ImageView) view.findViewById(R.id.rabbit1);
        random = new Random();
        rabbit.setOnClickListener(this);
        rabbit2 = (ImageView) view.findViewById(R.id.rabbit2);
        rabbit2.setOnClickListener(this);
        rabbit3 = (ImageView) view.findViewById(R.id.rabbit3);
        rabbit3.setOnClickListener(this);
        rabbit4 = (ImageView) view.findViewById(R.id.rabbit4);
        rabbit4.setOnClickListener(this);
        rabbit5 = (ImageView) view.findViewById(R.id.rabbit5);
        rabbit5.setOnClickListener(this);
        rabbit6 = (ImageView) view.findViewById(R.id.rabbit6);
        rabbit6.setOnClickListener(this);
        rabbit7 = (ImageView) view.findViewById(R.id.rabbit7);
        rabbit7.setOnClickListener(this);
        rabbit8 = (ImageView) view.findViewById(R.id.rabbit8);
        rabbit8.setOnClickListener(this);

        rabbits = new ArrayList<>();
        rabbits.add(rabbit);
        rabbits.add(rabbit2);
        rabbits.add(rabbit3);
        rabbits.add(rabbit4);
        rabbits.add(rabbit5);
        rabbits.add(rabbit6);
        rabbits.add(rabbit7);
        rabbits.add(rabbit8);

        final int position = random.nextInt(rabbits.size());
        final int img_index = random.nextInt(rabbit_img.length);

        rabbits.get(position).setImageResource(rabbit_img[img_index]);
    }

    //设置控件数据
    private void setCourseData() {
        Set<Map.Entry<Integer, TextView>> tv_set = tv_map.entrySet();
        for (CourseTable course : courses) {
            for (Map.Entry<Integer, TextView> entry : tv_set) {
                //通过判断id是否相同来设置数据
                if (course.getTvId() == entry.getKey()) {
                    Log.d("SecondTabFragment", "id相同");
                    String result = course.getCourse_name() + "\n" + course.getCourse_teacher() + "\n" + course.getCourse_address();
                    TextView textView = entry.getValue();
                    textView.setText(result);
                }
            }
        }
    }

    //初始化课程数据
    private void initCourseData() {

        courses = new ArrayList<>();
        CourseTable course1 = new CourseTable("市场营销", "戴伟", "11-1403教室", 1);
        CourseTable course2 = new CourseTable("企业管理", "王小琴", "11-1406教室", 2);
        CourseTable course3 = new CourseTable("", "", "", 3);
        CourseTable course4 = new CourseTable("快递时代", "卫洋帅", "11-1404教室", 4);
        CourseTable course5 = new CourseTable("", "", "", 5);

        CourseTable course6 = new CourseTable("市场营销", "戴伟", "11-1403教室", 6);
        CourseTable course7 = new CourseTable("企业管理", "王小琴", "11-1406教室", 7);
        CourseTable course8 = new CourseTable("体育(二)", "冯娟", "10-0101操场", 8);
        CourseTable course9 = new CourseTable("", "", "", 9);
        CourseTable course10 = new CourseTable("心理健康", "邓丁", "11-4303教室", 10);

        CourseTable course11 = new CourseTable("汽车文化", "冯高友", "11-1405教室", 11);
        CourseTable course12 = new CourseTable("English(二)", "吕凡", "11-1404教室", 12);
        CourseTable course13 = new CourseTable("统计学", "黄燕琳", "10-1403操场", 13);
        CourseTable course14 = new CourseTable("大思政", "冀俊平", "11-4301教室", 14);
        CourseTable course15 = new CourseTable("", "", "", 15);

        CourseTable course16 = new CourseTable("PhotoShop", "罗祥敏", "耘志楼203", 16);
        CourseTable course17 = new CourseTable("", "", "", 17);
        CourseTable course18 = new CourseTable("", "", "", 18);
        CourseTable course19 = new CourseTable("计算机文化", "李敏", "耘志楼221", 19);
        CourseTable course20 = new CourseTable("", "", "", 20);

        CourseTable course21 = new CourseTable("形式与政策", "王姣", "11-4204教室", 21);
        CourseTable course22 = new CourseTable("商品学", "柳青青", "11-1403教室", 22);
        CourseTable course23 = new CourseTable("科技与素养", "李升", "10-1409操场", 23);
        CourseTable course24 = new CourseTable("文案写作", "曹芳梅", "11-4301教室", 24);
        CourseTable course25 = new CourseTable("", "", "", 25);


        course1.setWeek("");
        courses.add(course1);
        courses.add(course2);
        courses.add(course3);
        courses.add(course4);
        courses.add(course5);
        courses.add(course6);
        courses.add(course7);
        courses.add(course8);
        courses.add(course9);
        courses.add(course10);
        courses.add(course11);
        courses.add(course12);
        courses.add(course13);
        courses.add(course14);
        courses.add(course15);
        courses.add(course16);
        courses.add(course17);
        courses.add(course18);
        courses.add(course19);
        courses.add(course20);
        courses.add(course21);
        courses.add(course22);
        courses.add(course23);
        courses.add(course24);
        courses.add(course25);


        tv_map = new HashMap<>();
        tv_map.put(1, tv_course1);
        tv_map.put(2, tv_course2);
        tv_map.put(3, tv_course3);
        tv_map.put(4, tv_course4);
        tv_map.put(5, tv_course5);
        tv_map.put(6, tv_course6);
        tv_map.put(7, tv_course7);
        tv_map.put(8, tv_course8);
        tv_map.put(9, tv_course9);
        tv_map.put(10, tv_course10);
        tv_map.put(11, tv_course11);
        tv_map.put(12, tv_course12);
        tv_map.put(13, tv_course13);
        tv_map.put(14, tv_course14);
        tv_map.put(15, tv_course15);
        tv_map.put(16, tv_course16);
        tv_map.put(17, tv_course17);
        tv_map.put(18, tv_course18);
        tv_map.put(19, tv_course19);
        tv_map.put(20, tv_course20);
        tv_map.put(21, tv_course21);
        tv_map.put(22, tv_course22);
        tv_map.put(23, tv_course23);
        tv_map.put(24, tv_course24);
        tv_map.put(25, tv_course25);

        Log.d("SecondTabFragment", "courses.size():" + courses.size());
        Log.d("SecondTabFragment", "tv_map.size():" + tv_map.size());
        Log.d("SecondTabFragment", "--------------------------");

        for (CourseTable course : courses) {
            if (1 <= course.getTvId() && course.getTvId() <= 5) {
                //一二节课的时间
                course.setCourse_time(date6);
            } else if (course.getTvId() <= 10) {
                //三四节课的时间
                course.setCourse_time(date8);
            } else if (course.getTvId() <= 15) {
                //五六
                course.setCourse_time(date11);
            } else if (course.getTvId() <= 20) {
                //七八
                course.setCourse_time(date13);
            } else {
                //九十
                course.setCourse_time(date16);
            }

        }

        text_views = new ArrayList<>();
        text_views.add(morning);
        text_views.add(custom_morning);
        text_views.add(rest_am);
        text_views.add(rest_lunch);
        text_views.add(rest_pm);
        text_views.add(tv_dinner);
        text_views.add(tv_night_rest);
        text_views.add(tv_weekend);

        tv_weeks = new ArrayList<>();
        tv_weeks.add(mon);
        tv_weeks.add(tue);
        tv_weeks.add(wed);
        tv_weeks.add(thu);
        tv_weeks.add(fri);

    }

    //控件点击事件
    @Override
    public void onClick(View v) {

        switch (v.getId()){
            case R.id.rabbit1:
            case R.id.rabbit2:
            case R.id.rabbit3:
            case R.id.rabbit4:
            case R.id.rabbit5:
            case R.id.rabbit6:
            case R.id.rabbit7:
            case R.id.rabbit8:
                final int position = random.nextInt(rabbits.size());
                final int img_index = random.nextInt(rabbit_img.length);
                for(ImageView img : rabbits){
                    img.setVisibility(ImageView.GONE);
                }
                rabbits.get(position).setVisibility(ImageView.VISIBLE);
                rabbits.get(position).setImageResource(rabbit_img[img_index]);
                break;
        }
    }
}
