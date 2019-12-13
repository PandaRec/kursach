package com.example.myapplication4;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GestureDetectorCompat;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.Layout;
import android.text.StaticLayout;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.widget.TableLayout;
import android.widget.TextView;

import java.sql.Time;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;


public class FourthActivity extends AppCompatActivity {

    private GestureDetectorCompat lSwipeDetector;

    TableLayout main_layout;
    TextView tvTxt;
    int i;
    String group;
    int day;
    ArrayList<String> timetable_pre;

    //String[][] timetable;

    //private static final int SWIPE_MIN_DISTANCE = 130;
    //private static final int SWIPE_MAX_DISTANCE = 300;
    //private static final int SWIPE_MIN_VELOCITY = 200;

    private static final int SWIPE_MIN_DISTANCE = 50;//130
    private static final int SWIPE_MAX_DISTANCE = 900;//300
    private static final int SWIPE_MIN_VELOCITY = 100;//900



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fourth);
//boolean first_open=false;
        Intent intent = getIntent();
        group=intent.getStringExtra("group");
        day=intent.getIntExtra("day",0);
        day=4;





        //i=intent.getIntExtra("counter",0);
        i=4;



        // i = 1;
        lSwipeDetector = new GestureDetectorCompat(this, new MyGestureListener());
        main_layout = (TableLayout) findViewById(R.id.main_layout);

        tvTxt = (TextView) findViewById(R.id.m0_0);
       // tvTxt.setText(""+i);
        tvTxt.setText("Четверг "+group);


        TextView t0_1 = (TextView) findViewById(R.id.m0_1);
        TextView t0_2 = (TextView) findViewById(R.id.m0_2);
        TextView t0_3 = (TextView) findViewById(R.id.m0_3);
        TextView t0_4 = (TextView) findViewById(R.id.m0_4);
        TextView t0_5 = (TextView) findViewById(R.id.m0_5);
        TextView t0_6 = (TextView) findViewById(R.id.m0_6);


        TextView t1_1 = (TextView) findViewById(R.id.m1_1);
        TextView t1_2 = (TextView) findViewById(R.id.m1_2);
        TextView t1_3 = (TextView) findViewById(R.id.m1_3);
        TextView t1_4 = (TextView) findViewById(R.id.m1_4);
        TextView t1_5 = (TextView) findViewById(R.id.m1_5);
        TextView t1_6 = (TextView) findViewById(R.id.m1_6);

        TextView t2_1 = (TextView) findViewById(R.id.m2_1);
        TextView t2_2 = (TextView) findViewById(R.id.m2_2);
        TextView t2_3 = (TextView) findViewById(R.id.m2_3);
        TextView t2_4 = (TextView) findViewById(R.id.m2_4);
        TextView t2_5 = (TextView) findViewById(R.id.m2_5);
        TextView t2_6 = (TextView) findViewById(R.id.m2_6);

        TextView t3_1 = (TextView) findViewById(R.id.m3_1);
        TextView t3_2 = (TextView) findViewById(R.id.m3_2);
        TextView t3_3 = (TextView) findViewById(R.id.m3_3);
        TextView t3_4 = (TextView) findViewById(R.id.m3_4);
        TextView t3_5 = (TextView) findViewById(R.id.m3_5);
        TextView t3_6 = (TextView) findViewById(R.id.m3_6);

        TextView t4_1 = (TextView) findViewById(R.id.m4_1);
        TextView t4_2 = (TextView) findViewById(R.id.m4_2);
        TextView t4_3 = (TextView) findViewById(R.id.m4_3);
        TextView t4_4 = (TextView) findViewById(R.id.m4_4);
        TextView t4_5 = (TextView) findViewById(R.id.m4_5);
        TextView t4_6 = (TextView) findViewById(R.id.m4_6);

        TextView t5_1 = (TextView) findViewById(R.id.m5_1);
        TextView t5_2 = (TextView) findViewById(R.id.m5_2);
        TextView t5_3 = (TextView) findViewById(R.id.m5_3);
        TextView t5_4 = (TextView) findViewById(R.id.m5_4);
        TextView t5_5 = (TextView) findViewById(R.id.m5_5);
        TextView t5_6 = (TextView) findViewById(R.id.m5_6);

        TextView t6_1 = (TextView) findViewById(R.id.m6_1);
        TextView t6_2 = (TextView) findViewById(R.id.m6_2);
        TextView t6_3 = (TextView) findViewById(R.id.m6_3);
        TextView t6_4 = (TextView) findViewById(R.id.m6_4);
        TextView t6_5 = (TextView) findViewById(R.id.m6_5);
        TextView t6_6 = (TextView) findViewById(R.id.m6_6);

//if(first_open==false) {
    //утсновка расписания
    TimeTable tm = new TimeTable();
    ArrayList<TextView> al1 = new ArrayList<>();


    al1.add(t1_3);
    al1.add(t1_4);
    al1.add(t1_5);
    al1.add(t1_6);

    al1.add(t2_3);
    al1.add(t2_4);
    al1.add(t2_5);
    al1.add(t2_6);

    al1.add(t3_3);
    al1.add(t3_4);
    al1.add(t3_5);
    al1.add(t3_6);

    al1.add(t4_3);
    al1.add(t4_4);
    al1.add(t4_5);
    al1.add(t4_6);

    al1.add(t5_3);
    al1.add(t5_4);
    al1.add(t5_5);
    al1.add(t5_6);

    al1.add(t6_3);
    al1.add(t6_4);
    al1.add(t6_5);
    al1.add(t6_6);


    //ArrayList<String> timetable_pre;// = new ArrayList<String>();
    timetable_pre = intent.getStringArrayListExtra("timetable");

    String[][] timetable = new String[timetable_pre.size() / 4][4];

    int counter1 = 0;

    for (int i = 0; i < timetable.length; i++) {
        for (int j = 0; j < timetable[0].length; j++) {
            timetable[i][j] = timetable_pre.get(counter1);
            counter1++;
        }
    }



int counter = 0;


    if (tm.CountrOfWeeks() % 2 == 0) {
        //четная неделя

        for (int i = day * 12 + 1; i < day * 12 + 11 - 12; i += 2) {
            //if(tm.DecodeStringLesson(timetable[i][0],tm.CountrOfWeeks())==true){

            //t1_3.setText(ma.TimeTable[i][0]);
            //t1_4.setText(ma.TimeTable[i][1]);
            //t1_5.setText(ma.TimeTable[i][2]);
            //t1_6.setText(ma.TimeTable[i][3]);
            al1.get(counter).setText(timetable[i][0] + "\n");
            al1.get(counter + 1).setText(timetable[i][1] + "\n");
            al1.get(counter + 2).setText(timetable[i][2] + "\n");
            al1.get(counter + 3).setText(timetable[i][3] + "\n");


            //}
            counter += 4;

        }


    }
    else {
        //не четная неделя

        for (int i = day * 12 - 12; i < day * 12 + 11 - 12; i += 2) {
            // if(tm.DecodeStringLesson(timetable[i][0],tm.CountrOfWeeks())==true){


        al1.get(counter).setText(timetable[i][0] + "\n");
        al1.get(counter + 1).setText(timetable[i][1] + "\n");
        al1.get(counter + 2).setText(timetable[i][2] + "\n");
        al1.get(counter + 3).setText(timetable[i][3] + "\n");


        counter += 4;

        //}
        }

    }




//}
        //int measuredHeight = (new StaticLayout(measuredText, paint, targetWidth, Layout.Alignment.ALIGN_NORMAL, 1.0f, 0.0f, true)).getHeight();
/*
for(int i=0;i<al1.size();i++){
    al1.get(i).requestLayout();
}
*/

        ArrayList<Integer> list = new ArrayList<Integer>();

/*
        t0_1.measure(MeasureSpec.makeMeasureSpec(231, MeasureSpec.AT_MOST),
                MeasureSpec.makeMeasureSpec(0, MeasureSpec.UNSPECIFIED));

        t0_2.measure(MeasureSpec.makeMeasureSpec(262, MeasureSpec.AT_MOST),
                MeasureSpec.makeMeasureSpec(0, MeasureSpec.UNSPECIFIED));

        t0_3.measure(MeasureSpec.makeMeasureSpec(358, MeasureSpec.AT_MOST),
                MeasureSpec.makeMeasureSpec(0, MeasureSpec.UNSPECIFIED));

        t0_4.measure(MeasureSpec.makeMeasureSpec(140, MeasureSpec.AT_MOST),
                MeasureSpec.makeMeasureSpec(0, MeasureSpec.UNSPECIFIED));

        t0_5.measure(MeasureSpec.makeMeasureSpec(280, MeasureSpec.AT_MOST),
                MeasureSpec.makeMeasureSpec(0, MeasureSpec.UNSPECIFIED));

        t0_6.measure(MeasureSpec.makeMeasureSpec(120, MeasureSpec.AT_MOST),
                MeasureSpec.makeMeasureSpec(0, MeasureSpec.UNSPECIFIED));

*/

        t0_1.measure(MeasureSpec.makeMeasureSpec((int)(55 * Resources.getSystem().getDisplayMetrics().density), MeasureSpec.AT_MOST),
                MeasureSpec.makeMeasureSpec(0, MeasureSpec.UNSPECIFIED));

        t0_2.measure(MeasureSpec.makeMeasureSpec((int)(70 * Resources.getSystem().getDisplayMetrics().density), MeasureSpec.AT_MOST),
                MeasureSpec.makeMeasureSpec(0, MeasureSpec.UNSPECIFIED));

        t0_3.measure(MeasureSpec.makeMeasureSpec((int)(100 * Resources.getSystem().getDisplayMetrics().density), MeasureSpec.AT_MOST),
                MeasureSpec.makeMeasureSpec(0, MeasureSpec.UNSPECIFIED));

        t0_4.measure(MeasureSpec.makeMeasureSpec((int)(40 * Resources.getSystem().getDisplayMetrics().density), MeasureSpec.AT_MOST),
                MeasureSpec.makeMeasureSpec(0, MeasureSpec.UNSPECIFIED));

        t0_5.measure(MeasureSpec.makeMeasureSpec((int)(80 * Resources.getSystem().getDisplayMetrics().density), MeasureSpec.AT_MOST),
                MeasureSpec.makeMeasureSpec(0, MeasureSpec.UNSPECIFIED));

        t0_6.measure(MeasureSpec.makeMeasureSpec((int)(55 * Resources.getSystem().getDisplayMetrics().density), MeasureSpec.AT_MOST),
                MeasureSpec.makeMeasureSpec(0, MeasureSpec.UNSPECIFIED));

        int a=t0_1.getMeasuredHeight();

        int b=t0_2.getMeasuredHeight();

        int c=t0_3.getMeasuredHeight();

        int d=t0_4.getMeasuredHeight();

        int e=t0_5.getMeasuredHeight();

        int f=t0_6.getMeasuredHeight();

        list.add(a);
        list.add(b);
        list.add(c);
        list.add(d);
        list.add(e);
        list.add(f);
        int max = Collections.max(list);
        list.clear();

        t0_1.setHeight(max);
        t0_2.setHeight(max);
        t0_3.setHeight(max);
        t0_4.setHeight(max);
        t0_5.setHeight(max);
        t0_6.setHeight(max);
/*
        t1_1.measure(MeasureSpec.makeMeasureSpec(231, MeasureSpec.AT_MOST),
                MeasureSpec.makeMeasureSpec(0, MeasureSpec.UNSPECIFIED));

        t1_2.measure(MeasureSpec.makeMeasureSpec(262, MeasureSpec.AT_MOST),
             MeasureSpec.makeMeasureSpec(0, MeasureSpec.UNSPECIFIED));

        t1_3.measure(MeasureSpec.makeMeasureSpec(358, MeasureSpec.AT_MOST),
               MeasureSpec.makeMeasureSpec(0, MeasureSpec.UNSPECIFIED));

        t1_4.measure(MeasureSpec.makeMeasureSpec(140, MeasureSpec.AT_MOST),
              MeasureSpec.makeMeasureSpec(0, MeasureSpec.UNSPECIFIED));

        t1_5.measure(MeasureSpec.makeMeasureSpec(280, MeasureSpec.AT_MOST),
              MeasureSpec.makeMeasureSpec(0, MeasureSpec.UNSPECIFIED));

        t1_6.measure(MeasureSpec.makeMeasureSpec(120, MeasureSpec.AT_MOST),
                MeasureSpec.makeMeasureSpec(0, MeasureSpec.UNSPECIFIED));
*/

        t1_1.measure(MeasureSpec.makeMeasureSpec((int)(55 * Resources.getSystem().getDisplayMetrics().density), MeasureSpec.AT_MOST),
                MeasureSpec.makeMeasureSpec(0, MeasureSpec.UNSPECIFIED));

        t1_2.measure(MeasureSpec.makeMeasureSpec((int)(70 * Resources.getSystem().getDisplayMetrics().density), MeasureSpec.AT_MOST),
                MeasureSpec.makeMeasureSpec(0, MeasureSpec.UNSPECIFIED));

        t1_3.measure(MeasureSpec.makeMeasureSpec((int)(100 * Resources.getSystem().getDisplayMetrics().density), MeasureSpec.AT_MOST),
                MeasureSpec.makeMeasureSpec(0, MeasureSpec.UNSPECIFIED));

        t1_4.measure(MeasureSpec.makeMeasureSpec((int)(40 * Resources.getSystem().getDisplayMetrics().density), MeasureSpec.AT_MOST),
                MeasureSpec.makeMeasureSpec(0, MeasureSpec.UNSPECIFIED));

        t1_5.measure(MeasureSpec.makeMeasureSpec((int)(80 * Resources.getSystem().getDisplayMetrics().density), MeasureSpec.AT_MOST),
                MeasureSpec.makeMeasureSpec(0, MeasureSpec.UNSPECIFIED));

        t1_6.measure(MeasureSpec.makeMeasureSpec((int)(55 * Resources.getSystem().getDisplayMetrics().density), MeasureSpec.AT_MOST),
                MeasureSpec.makeMeasureSpec(0, MeasureSpec.UNSPECIFIED));

        a=t1_1.getMeasuredHeight();

        b=t1_2.getMeasuredHeight();

        c=t1_3.getMeasuredHeight();

        d=t1_4.getMeasuredHeight();

        e=t1_5.getMeasuredHeight();

        f=t1_6.getMeasuredHeight();

        list.add(a);
        list.add(b);
        list.add(c);
        list.add(d);
        list.add(e);
        list.add(f);
        max = Collections.max(list);
        list.clear();


        t1_1.setHeight(max);
        t1_2.setHeight(max);
        t1_3.setHeight(max);
        t1_4.setHeight(max);
        t1_5.setHeight(max);
        t1_6.setHeight(max);
/*
        t2_1.measure(MeasureSpec.makeMeasureSpec(231, MeasureSpec.AT_MOST),
                MeasureSpec.makeMeasureSpec(0, MeasureSpec.UNSPECIFIED));

        t2_2.measure(MeasureSpec.makeMeasureSpec(262, MeasureSpec.AT_MOST),
                MeasureSpec.makeMeasureSpec(0, MeasureSpec.UNSPECIFIED));

        t2_3.measure(MeasureSpec.makeMeasureSpec(358, MeasureSpec.AT_MOST),
                MeasureSpec.makeMeasureSpec(0, MeasureSpec.UNSPECIFIED));

        t2_4.measure(MeasureSpec.makeMeasureSpec(140, MeasureSpec.AT_MOST),
                MeasureSpec.makeMeasureSpec(0, MeasureSpec.UNSPECIFIED));

        t2_5.measure(MeasureSpec.makeMeasureSpec(280, MeasureSpec.AT_MOST),
                MeasureSpec.makeMeasureSpec(0, MeasureSpec.UNSPECIFIED));

        t2_6.measure(MeasureSpec.makeMeasureSpec(120, MeasureSpec.AT_MOST),
                MeasureSpec.makeMeasureSpec(0, MeasureSpec.UNSPECIFIED));
*/

        t2_1.measure(MeasureSpec.makeMeasureSpec((int)(55 * Resources.getSystem().getDisplayMetrics().density), MeasureSpec.AT_MOST),
                MeasureSpec.makeMeasureSpec(0, MeasureSpec.UNSPECIFIED));

        t2_2.measure(MeasureSpec.makeMeasureSpec((int)(70 * Resources.getSystem().getDisplayMetrics().density), MeasureSpec.AT_MOST),
                MeasureSpec.makeMeasureSpec(0, MeasureSpec.UNSPECIFIED));

        t2_3.measure(MeasureSpec.makeMeasureSpec((int)(100 * Resources.getSystem().getDisplayMetrics().density), MeasureSpec.AT_MOST),
                MeasureSpec.makeMeasureSpec(0, MeasureSpec.UNSPECIFIED));

        t2_4.measure(MeasureSpec.makeMeasureSpec((int)(40 * Resources.getSystem().getDisplayMetrics().density), MeasureSpec.AT_MOST),
                MeasureSpec.makeMeasureSpec(0, MeasureSpec.UNSPECIFIED));

        t2_5.measure(MeasureSpec.makeMeasureSpec((int)(80 * Resources.getSystem().getDisplayMetrics().density), MeasureSpec.AT_MOST),
                MeasureSpec.makeMeasureSpec(0, MeasureSpec.UNSPECIFIED));

        t2_6.measure(MeasureSpec.makeMeasureSpec((int)(55 * Resources.getSystem().getDisplayMetrics().density), MeasureSpec.AT_MOST),
                MeasureSpec.makeMeasureSpec(0, MeasureSpec.UNSPECIFIED));

        a=t2_1.getMeasuredHeight();

        b=t2_2.getMeasuredHeight();

        c=t2_3.getMeasuredHeight();

        d=t2_4.getMeasuredHeight();

        e=t2_5.getMeasuredHeight();

        f=t2_6.getMeasuredHeight();




        list.add(a);
        list.add(b);
        list.add(c);
        list.add(d);
        list.add(e);
        list.add(f);
        max = Collections.max(list);
        list.clear();


        t2_1.setHeight(max);
        t2_2.setHeight(max);
        t2_3.setHeight(max);
        t2_4.setHeight(max);
        t2_5.setHeight(max);
        t2_6.setHeight(max);
/*
        t3_1.measure(MeasureSpec.makeMeasureSpec(231, MeasureSpec.AT_MOST),
                MeasureSpec.makeMeasureSpec(0, MeasureSpec.UNSPECIFIED));

        t3_2.measure(MeasureSpec.makeMeasureSpec(262, MeasureSpec.AT_MOST),
                MeasureSpec.makeMeasureSpec(0, MeasureSpec.UNSPECIFIED));

        t3_3.measure(MeasureSpec.makeMeasureSpec(358, MeasureSpec.AT_MOST),
                MeasureSpec.makeMeasureSpec(0, MeasureSpec.UNSPECIFIED));

        t3_4.measure(MeasureSpec.makeMeasureSpec(140, MeasureSpec.AT_MOST),
                MeasureSpec.makeMeasureSpec(0, MeasureSpec.UNSPECIFIED));

        t3_5.measure(MeasureSpec.makeMeasureSpec(280, MeasureSpec.AT_MOST),
                MeasureSpec.makeMeasureSpec(0, MeasureSpec.UNSPECIFIED));

        t3_6.measure(MeasureSpec.makeMeasureSpec(120, MeasureSpec.AT_MOST),
                MeasureSpec.makeMeasureSpec(0, MeasureSpec.UNSPECIFIED));
*/

        t3_1.measure(MeasureSpec.makeMeasureSpec((int)(55 * Resources.getSystem().getDisplayMetrics().density), MeasureSpec.AT_MOST),
                MeasureSpec.makeMeasureSpec(0, MeasureSpec.UNSPECIFIED));

        t3_2.measure(MeasureSpec.makeMeasureSpec((int)(70 * Resources.getSystem().getDisplayMetrics().density), MeasureSpec.AT_MOST),
                MeasureSpec.makeMeasureSpec(0, MeasureSpec.UNSPECIFIED));

        t3_3.measure(MeasureSpec.makeMeasureSpec((int)(100 * Resources.getSystem().getDisplayMetrics().density), MeasureSpec.AT_MOST),
                MeasureSpec.makeMeasureSpec(0, MeasureSpec.UNSPECIFIED));

        t3_4.measure(MeasureSpec.makeMeasureSpec((int)(40 * Resources.getSystem().getDisplayMetrics().density), MeasureSpec.AT_MOST),
                MeasureSpec.makeMeasureSpec(0, MeasureSpec.UNSPECIFIED));

        t3_5.measure(MeasureSpec.makeMeasureSpec((int)(80 * Resources.getSystem().getDisplayMetrics().density), MeasureSpec.AT_MOST),
                MeasureSpec.makeMeasureSpec(0, MeasureSpec.UNSPECIFIED));

        t3_6.measure(MeasureSpec.makeMeasureSpec((int)(55 * Resources.getSystem().getDisplayMetrics().density), MeasureSpec.AT_MOST),
                MeasureSpec.makeMeasureSpec(0, MeasureSpec.UNSPECIFIED));

        a=t3_1.getMeasuredHeight();

        b=t3_2.getMeasuredHeight();

        c=t3_3.getMeasuredHeight();

        d=t3_4.getMeasuredHeight();

        e=t3_5.getMeasuredHeight();

        f=t3_6.getMeasuredHeight();

        list.add(a);
        list.add(b);
        list.add(c);
        list.add(d);
        list.add(e);
        list.add(f);
        max = Collections.max(list);
        list.clear();


        t3_1.setHeight(max);
        t3_2.setHeight(max);
        t3_3.setHeight(max);
        t3_4.setHeight(max);
        t3_5.setHeight(max);
        t3_6.setHeight(max);
/*
        t4_1.measure(MeasureSpec.makeMeasureSpec(231, MeasureSpec.AT_MOST),
                MeasureSpec.makeMeasureSpec(0, MeasureSpec.UNSPECIFIED));

        t4_2.measure(MeasureSpec.makeMeasureSpec(262, MeasureSpec.AT_MOST),
                MeasureSpec.makeMeasureSpec(0, MeasureSpec.UNSPECIFIED));

        t4_3.measure(MeasureSpec.makeMeasureSpec(358, MeasureSpec.AT_MOST),
                MeasureSpec.makeMeasureSpec(0, MeasureSpec.UNSPECIFIED));

        t4_4.measure(MeasureSpec.makeMeasureSpec(140, MeasureSpec.AT_MOST),
                MeasureSpec.makeMeasureSpec(0, MeasureSpec.UNSPECIFIED));

        t4_5.measure(MeasureSpec.makeMeasureSpec(280, MeasureSpec.AT_MOST),
                MeasureSpec.makeMeasureSpec(0, MeasureSpec.UNSPECIFIED));

        t4_6.measure(MeasureSpec.makeMeasureSpec(120, MeasureSpec.AT_MOST),
                MeasureSpec.makeMeasureSpec(0, MeasureSpec.UNSPECIFIED));
*/

        t4_1.measure(MeasureSpec.makeMeasureSpec((int)(55 * Resources.getSystem().getDisplayMetrics().density), MeasureSpec.AT_MOST),
                MeasureSpec.makeMeasureSpec(0, MeasureSpec.UNSPECIFIED));

        t4_2.measure(MeasureSpec.makeMeasureSpec((int)(70 * Resources.getSystem().getDisplayMetrics().density), MeasureSpec.AT_MOST),
                MeasureSpec.makeMeasureSpec(0, MeasureSpec.UNSPECIFIED));

        t4_3.measure(MeasureSpec.makeMeasureSpec((int)(100 * Resources.getSystem().getDisplayMetrics().density), MeasureSpec.AT_MOST),
                MeasureSpec.makeMeasureSpec(0, MeasureSpec.UNSPECIFIED));

        t4_4.measure(MeasureSpec.makeMeasureSpec((int)(40 * Resources.getSystem().getDisplayMetrics().density), MeasureSpec.AT_MOST),
                MeasureSpec.makeMeasureSpec(0, MeasureSpec.UNSPECIFIED));

        t4_5.measure(MeasureSpec.makeMeasureSpec((int)(80 * Resources.getSystem().getDisplayMetrics().density), MeasureSpec.AT_MOST),
                MeasureSpec.makeMeasureSpec(0, MeasureSpec.UNSPECIFIED));

        t4_6.measure(MeasureSpec.makeMeasureSpec((int)(55 * Resources.getSystem().getDisplayMetrics().density), MeasureSpec.AT_MOST),
                MeasureSpec.makeMeasureSpec(0, MeasureSpec.UNSPECIFIED));

        a=t4_1.getMeasuredHeight();

        b=t4_2.getMeasuredHeight();

        c=t4_3.getMeasuredHeight();

        d=t4_4.getMeasuredHeight();

        e=t4_5.getMeasuredHeight();

        f=t4_6.getMeasuredHeight();

        list.add(a);
        list.add(b);
        list.add(c);
        list.add(d);
        list.add(e);
        list.add(f);
        max = Collections.max(list);
        list.clear();


        t4_1.setHeight(max);
        t4_2.setHeight(max);
        t4_3.setHeight(max);
        t4_4.setHeight(max);
        t4_5.setHeight(max);
        t4_6.setHeight(max);
/*
        t5_1.measure(MeasureSpec.makeMeasureSpec(231, MeasureSpec.AT_MOST),
                MeasureSpec.makeMeasureSpec(0, MeasureSpec.UNSPECIFIED));

        t5_2.measure(MeasureSpec.makeMeasureSpec(262, MeasureSpec.AT_MOST),
                MeasureSpec.makeMeasureSpec(0, MeasureSpec.UNSPECIFIED));

        t5_3.measure(MeasureSpec.makeMeasureSpec(358, MeasureSpec.AT_MOST),
                MeasureSpec.makeMeasureSpec(0, MeasureSpec.UNSPECIFIED));

        t5_4.measure(MeasureSpec.makeMeasureSpec(140, MeasureSpec.AT_MOST),
                MeasureSpec.makeMeasureSpec(0, MeasureSpec.UNSPECIFIED));

        t5_5.measure(MeasureSpec.makeMeasureSpec(280, MeasureSpec.AT_MOST),
                MeasureSpec.makeMeasureSpec(0, MeasureSpec.UNSPECIFIED));

        t5_6.measure(MeasureSpec.makeMeasureSpec(120, MeasureSpec.AT_MOST),
                MeasureSpec.makeMeasureSpec(0, MeasureSpec.UNSPECIFIED));
*/

        t5_1.measure(MeasureSpec.makeMeasureSpec((int)(55 * Resources.getSystem().getDisplayMetrics().density), MeasureSpec.AT_MOST),
                MeasureSpec.makeMeasureSpec(0, MeasureSpec.UNSPECIFIED));

        t5_2.measure(MeasureSpec.makeMeasureSpec((int)(70 * Resources.getSystem().getDisplayMetrics().density), MeasureSpec.AT_MOST),
                MeasureSpec.makeMeasureSpec(0, MeasureSpec.UNSPECIFIED));

        t5_3.measure(MeasureSpec.makeMeasureSpec((int)(100 * Resources.getSystem().getDisplayMetrics().density), MeasureSpec.AT_MOST),
                MeasureSpec.makeMeasureSpec(0, MeasureSpec.UNSPECIFIED));

        t5_4.measure(MeasureSpec.makeMeasureSpec((int)(40 * Resources.getSystem().getDisplayMetrics().density), MeasureSpec.AT_MOST),
                MeasureSpec.makeMeasureSpec(0, MeasureSpec.UNSPECIFIED));

        t5_5.measure(MeasureSpec.makeMeasureSpec((int)(80 * Resources.getSystem().getDisplayMetrics().density), MeasureSpec.AT_MOST),
                MeasureSpec.makeMeasureSpec(0, MeasureSpec.UNSPECIFIED));

        t5_6.measure(MeasureSpec.makeMeasureSpec((int)(55 * Resources.getSystem().getDisplayMetrics().density), MeasureSpec.AT_MOST),
                MeasureSpec.makeMeasureSpec(0, MeasureSpec.UNSPECIFIED));

        a=t5_1.getMeasuredHeight();

        b=t5_2.getMeasuredHeight();

        c=t5_3.getMeasuredHeight();

        d=t5_4.getMeasuredHeight();

        e=t5_5.getMeasuredHeight();

        f=t5_6.getMeasuredHeight();

        list.add(a);
        list.add(b);
        list.add(c);
        list.add(d);
        list.add(e);
        list.add(f);
        max = Collections.max(list);
        list.clear();


        t5_1.setHeight(max);
        t5_2.setHeight(max);
        t5_3.setHeight(max);
        t5_4.setHeight(max);
        t5_5.setHeight(max);
        t5_6.setHeight(max);
/*
        t6_1.measure(MeasureSpec.makeMeasureSpec(231, MeasureSpec.AT_MOST),
                MeasureSpec.makeMeasureSpec(0, MeasureSpec.UNSPECIFIED));

        t6_2.measure(MeasureSpec.makeMeasureSpec(262, MeasureSpec.AT_MOST),
                MeasureSpec.makeMeasureSpec(0, MeasureSpec.UNSPECIFIED));

        t6_3.measure(MeasureSpec.makeMeasureSpec(358, MeasureSpec.AT_MOST),
                MeasureSpec.makeMeasureSpec(0, MeasureSpec.UNSPECIFIED));

        t6_4.measure(MeasureSpec.makeMeasureSpec(140, MeasureSpec.AT_MOST),
                MeasureSpec.makeMeasureSpec(0, MeasureSpec.UNSPECIFIED));

        t6_5.measure(MeasureSpec.makeMeasureSpec(280, MeasureSpec.AT_MOST),
                MeasureSpec.makeMeasureSpec(0, MeasureSpec.UNSPECIFIED));

        t6_6.measure(MeasureSpec.makeMeasureSpec(120, MeasureSpec.AT_MOST),
                MeasureSpec.makeMeasureSpec(0, MeasureSpec.UNSPECIFIED));
*/

        t6_1.measure(MeasureSpec.makeMeasureSpec((int)(55 * Resources.getSystem().getDisplayMetrics().density), MeasureSpec.AT_MOST),
                MeasureSpec.makeMeasureSpec(0, MeasureSpec.UNSPECIFIED));

        t6_2.measure(MeasureSpec.makeMeasureSpec((int)(70 * Resources.getSystem().getDisplayMetrics().density), MeasureSpec.AT_MOST),
                MeasureSpec.makeMeasureSpec(0, MeasureSpec.UNSPECIFIED));

        t6_3.measure(MeasureSpec.makeMeasureSpec((int)(100 * Resources.getSystem().getDisplayMetrics().density), MeasureSpec.AT_MOST),
                MeasureSpec.makeMeasureSpec(0, MeasureSpec.UNSPECIFIED));

        t6_4.measure(MeasureSpec.makeMeasureSpec((int)(40 * Resources.getSystem().getDisplayMetrics().density), MeasureSpec.AT_MOST),
                MeasureSpec.makeMeasureSpec(0, MeasureSpec.UNSPECIFIED));

        t6_5.measure(MeasureSpec.makeMeasureSpec((int)(80 * Resources.getSystem().getDisplayMetrics().density), MeasureSpec.AT_MOST),
                MeasureSpec.makeMeasureSpec(0, MeasureSpec.UNSPECIFIED));

        t6_6.measure(MeasureSpec.makeMeasureSpec((int)(55 * Resources.getSystem().getDisplayMetrics().density), MeasureSpec.AT_MOST),
                MeasureSpec.makeMeasureSpec(0, MeasureSpec.UNSPECIFIED));

        a=t6_1.getMeasuredHeight();

        b=t6_2.getMeasuredHeight();

        c=t6_3.getMeasuredHeight();

        d=t6_4.getMeasuredHeight();

        e=t6_5.getMeasuredHeight();

        f=t6_6.getMeasuredHeight();

        list.add(a);
        list.add(b);
        list.add(c);
        list.add(d);
        list.add(e);
        list.add(f);
        max = Collections.max(list);

        t6_1.setHeight(max);
        t6_2.setHeight(max);
        t6_3.setHeight(max);
        t6_4.setHeight(max);
        t6_5.setHeight(max);
        t6_6.setHeight(max);

        int lol =(int) (55 * Resources.getSystem().getDisplayMetrics().density);






        // frame.measure(View.MeasureSpec.makeMeasureSpec(maxWidth, View.MeasureSpec.AT_MOST),
        //       View.MeasureSpec.makeMeasureSpec(maxHeight, View.MeasureSpec.AT_MOST));


        // int c = tw.getMeasuredHeight(); // 123
        //int k = tw.getMeasuredWidth(); //231


















       // tvTxt.setText("" + i);

        main_layout.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                return lSwipeDetector.onTouchEvent(event);
            }
        });
    }

    private class MyGestureListener extends GestureDetector.SimpleOnGestureListener{
        @Override
        public boolean onDown(MotionEvent e) {
            return true;
        }
        @Override
        public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY){
            if (Math.abs(e1.getY() - e2.getY()) > SWIPE_MAX_DISTANCE)  {tvTxt.setText("первый иф не прошел");return false;}

            if (e2.getX() - e1.getX() > SWIPE_MIN_DISTANCE && Math.abs(velocityX) > SWIPE_MIN_VELOCITY) {
                if(i>1) i--;
                //tvTxt.setText("" + i);
                Intent intent;
                switch (i) {


                    case 1:
                        intent = new Intent(FourthActivity.this, FirstActivity.class);
                        intent.putExtra("group",group);
                       // intent.putExtra("day",day);
                        intent.putExtra("timetable",timetable_pre);
                        startActivity(intent);
                        break;
                    case 2:
                        intent = new Intent(FourthActivity.this, SecondActivity.class);
                        intent.putExtra("group",group);
                       // intent.putExtra("day",day);
                        intent.putExtra("timetable",timetable_pre);
                        startActivity(intent);
                        break;
                    case 3:
                        intent = new Intent(FourthActivity.this, ThirdActivity.class);
                        intent.putExtra("group",group);
                       // intent.putExtra("day",day);
                        intent.putExtra("timetable",timetable_pre);
                        startActivity(intent);
                        break;

                    case 5:
                        intent = new Intent(FourthActivity.this, FifthActivity.class);
                        intent.putExtra("group",group);
                       // intent.putExtra("day",day);
                        intent.putExtra("timetable",timetable_pre);
                        int dfjksfk=timetable_pre.size();
                        startActivity(intent);
                        break;

                    case 6:
                        intent = new Intent(FourthActivity.this, SixthActivity.class);
                        intent.putExtra("group",group);
                       // intent.putExtra("day",day);
                        intent.putExtra("timetable",timetable_pre);
                        startActivity(intent);
                        break;




                    default:break;
                }
            }


            if(e1.getX() - e2.getX() > SWIPE_MIN_DISTANCE && Math.abs(velocityX) > SWIPE_MIN_VELOCITY){
                if(i<6) i++;
                Intent intent;
                switch (i) {


                    case 1:
                        intent = new Intent(FourthActivity.this, FirstActivity.class);
                        intent.putExtra("group",group);
                       // intent.putExtra("day",day);
                        intent.putExtra("timetable",timetable_pre);
                        startActivity(intent);
                        break;
                    case 2:
                        intent = new Intent(FourthActivity.this, SecondActivity.class);
                        intent.putExtra("group",group);
                        startActivity(intent);
                        break;
                    case 3:
                        intent = new Intent(FourthActivity.this, ThirdActivity.class);
                        intent.putExtra("group",group);
                       // intent.putExtra("day",day);
                        intent.putExtra("timetable",timetable_pre);
                        startActivity(intent);
                        break;

                    case 5:
                        intent = new Intent(FourthActivity.this, FifthActivity.class);
                        intent.putExtra("group",group);
                       // intent.putExtra("day",day);
                        intent.putExtra("timetable",timetable_pre);
                        int dfjksfk=timetable_pre.size();
                        startActivity(intent);
                        break;

                    case 6:
                        intent = new Intent(FourthActivity.this, SixthActivity.class);
                        intent.putExtra("group",group);
                       // intent.putExtra("day",day);
                        intent.putExtra("timetable",timetable_pre);
                        startActivity(intent);
                        break;




                    default:break;
                    }
                }
            return false;
        }
    }
}
