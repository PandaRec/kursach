package com.example.myapplication4;

import android.content.Context;
import android.content.res.AssetManager;
import android.view.Display;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.util.Calendar;
import java.util.Date;

import static android.content.Context.MODE_PRIVATE;

public class TimeTable  {

    public int CountrOfWeeks() {
        System.out.println("-------------------------------------------------------");
        Calendar c_sept = Calendar.getInstance();
        //Calendar c_ = Calendar.getInstance();
        Calendar c_now = Calendar.getInstance();
        c_now.setTime(new Date());

        //c.setTime(new Date());
        c_sept.set(c_sept.get(Calendar.YEAR), 8, 1); // отсчет месяцев с 0
        int a = c_sept.get(Calendar.YEAR);
        int b = c_sept.get(Calendar.DATE);

        int day = c_sept.get(Calendar.DAY_OF_YEAR);
        int day1 = c_now.get(Calendar.DAY_OF_YEAR);
        System.out.println(day);
        System.out.println(day1);

        if (c_sept.get(Calendar.DAY_OF_MONTH) == 1) {
            day += 1;
        } else if (c_sept.get(Calendar.DAY_OF_MONTH) == 7) {
            day += 2;
        }
        System.out.println(day);
        int week = 1;
        int counter = 0;
        for (int i = day; i < day1; i += 7) {
            counter += 1;
            if (i >= day && i <= day1) week = counter;//15
        }

        System.out.println(week);
        return week;
    }

    public boolean DecodeStringLesson(String lesson, int week) {

        if (lesson.contains("1") || lesson.contains("2") ||
                lesson.contains("3") || lesson.contains("4") ||
                lesson.contains("5") || lesson.contains("6") ||
                lesson.contains("7") || lesson.contains("8") ||
                lesson.contains("9") || lesson.contains("10") ||
                lesson.contains("11") || lesson.contains("12") ||
                lesson.contains("13") || lesson.contains("14") ||
                lesson.contains("15") || lesson.contains("16") ||
                lesson.contains("17") || lesson.contains("18") ||
                lesson.contains("19") || lesson.contains("20") && !lesson.contains("кр")) {


            if (lesson.contains(String.valueOf(week))) { return true; }
            else return false;
        }

        else return true;


    }

    public void ReadFile() {
        String[][] array;// = new String[][4];
        MainActivity m = new MainActivity();
//        m.Funk();








/*
        try {

            File file = new File("lol.txt");
            //создаем объект FileReader для объекта File
            FileReader fr = new FileReader(file);
            //создаем BufferedReader с существующего FileReader для построчного считывания
            BufferedReader reader = new BufferedReader(fr);
            // считаем сначала первую строку
            String line = reader.readLine();
            while (line != null) {
                System.out.println(line);
                // считываем остальные строки в цикле
                line = reader.readLine();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

 */



    }



}

