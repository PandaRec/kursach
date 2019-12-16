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
import java.security.PublicKey;
import java.sql.Time;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import static android.content.Context.MODE_PRIVATE;

public class TimeTable  {
    String[] todel={"1","2","3","4","5","6","7","8","9",",","0"};



// подсчет какая сейчас неделя
    public int CountrOfWeeks() {
        System.out.println("-------------------------------------------------------");
        Calendar c_sept = Calendar.getInstance();
        //Calendar c_ = Calendar.getInstance();
        Calendar c_now = Calendar.getInstance();
        c_now.setTime(new Date());

        c_sept.set(c_sept.get(Calendar.YEAR), 8, 1); // отсчет месяцев с 0
        int a = c_sept.get(Calendar.YEAR);
        int b = c_sept.get(Calendar.DATE);

        int day = c_sept.get(Calendar.DAY_OF_YEAR);
        int day1 = c_now.get(Calendar.DAY_OF_YEAR);

        System.out.println(day);
        System.out.println(day1);

        if (c_sept.get(Calendar.DAY_OF_MONTH) == 1) {
            day += 1;
        }



        System.out.println(day);
        int week = 1;
        int counter = 0;
        for (int i = day; i <= day1; i += 7) {
            counter += 1;
            if (i >= day && i <= day1) week = counter;//15
        }

        System.out.println(week);
        return week;
    }
// из строки получаем строку без цифр
    public String DecodeStringLesson(String lesson, int week) {

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


            if (lesson.contains(String.valueOf(week))) {
                if (lesson.split(" н ").length - 1 > 1) {
                    // если несколько предетов, выделяем нужный предмет и удаляем цифры
                    String[] temp = lesson.split(" н ", 0);
                    if (temp[0].contains(String.valueOf(week))) {
                        String newS = null;
                        for (int i = 0; i < temp[1].length(); i++) {
                            for (int j = 0; j < todel.length; j++) {
                                if (temp[1].contains(todel[i])) {
                                    newS = "";
                                    newS = temp[1].substring(0, temp[1].indexOf(todel[i]));
                                    newS += temp[1].substring(temp[1].indexOf(todel[i]) + 1);
                                    temp[1] = newS;
                                }
                            }


                        }
                        return temp[1]+="1";
                    } else if (temp[1].contains(String.valueOf(week))) {
                        return temp[2]+="2";
                    }


                    return "";
                } else {
                    //если один предмет, то просто удаляем цифры
                    String[] temp = lesson.split(" н ", 0);
                    if (temp[0].contains(String.valueOf(week))) {

                        return temp[1];
                    }


                    return "";

                }
                //else return "";
            } else return "";


        }

        else {
            return lesson;
        }
    }
//определяем количество предметов в одной паре
    public boolean CountOfLessons(String lesson){
        if (lesson.split(" н ").length - 1 > 1) {return true;}
        else return false;
        }
//оставляем нужный тип для конкретного предмета
public  String  DecodeStringType(String lesson,String type){
        if(lesson=="") return "";
    String[] temp =type.split(" ");
    if(lesson.charAt(lesson.length()-1)=='1'){
            //подошел первый предмет
            if(temp[0].contains("?")){

                String newS = "";
                newS = temp[0].substring(0, temp[0].indexOf("?"));
                newS += temp[0].substring(temp[0].indexOf("?") + 1);
                temp[0] = newS;
            }
            return temp[0];

        }
        else{
            //подошел второй пердмет
        if(temp[1].contains("?")){

            String newS = "";
            newS = temp[1].substring(0, temp[1].indexOf("?"));
            newS += temp[1].substring(temp[1].indexOf("?") + 1);
            temp[1] = newS;
        }
        return temp[1];


        }

    }
//оставляем нужного препода для конкретного предмета

    public String DecodeStringTeacher(String lesson,String teachers){
        if(lesson=="") return "";
        String[] temp =teachers.split("\\?");

        if(lesson.charAt(lesson.length()-1)=='1'){
            if(temp[0].contains("?")){

                String newS = "";
                newS = temp[0].substring(0, temp[0].indexOf("?"));
                newS += temp[0].substring(temp[0].indexOf("?") + 1);
                temp[0] = newS;
            }
            return temp[0];
        }
        else {
            if(temp[1].contains("?")){

                String newS = "";
                newS = temp[1].substring(0, temp[1].indexOf("?"));
                newS += temp[1].substring(temp[1].indexOf("?") + 1);
                temp[1] = newS;
            }
            return temp[1];

        }
    }
    //оставляем нужную адтирию для конкретного предмета

    public String DecodeStringClassroom(String lesson,String classrooms) {
        if (lesson == "") return "";
        String[] temp = classrooms.split(" ");
        if (temp.length > 2) {
            if (lesson.charAt(lesson.length() - 1) == '1') {
                if (temp[0].contains("\\?")) {
                    String newS = "";
                    newS = temp[0].substring(0, temp[0].indexOf("?"));
                    newS += temp[0].substring(temp[0].indexOf("?") + 1);
                    temp[0] = newS;
                } else if (temp[1].contains("\\?")) {
                    String newS = "";
                    newS = temp[1].substring(0, temp[1].indexOf("?"));
                    newS += temp[1].substring(temp[1].indexOf("?") + 1);
                    temp[1] = newS;
                }
                return temp[0] + temp[1];

            } else {

                if (temp[0].contains("\\?")) {
                    String newS = "";
                    newS = temp[0].substring(0, temp[0].indexOf("?"));
                    newS += temp[0].substring(temp[0].indexOf("?") + 1);
                    temp[0] = newS;
                } else if (temp[2].contains("\\?")) {
                    String newS = "";
                    newS = temp[2].substring(0, temp[2].indexOf("?"));
                    newS += temp[2].substring(temp[2].indexOf("?") + 1);
                    temp[2] = newS;
                }
                return temp[0] + temp[2];

            }
        } else if (temp.length > 1) {
            if (temp[0].contains("\\?")) {
                String newS = "";
                newS = temp[0].substring(0, temp[0].indexOf("?"));
                newS += temp[0].substring(temp[0].indexOf("?") + 1);
                temp[0] = newS;
            } else if (temp[1].contains("\\?")) {
                String newS = "";
                newS = temp[1].substring(0, temp[1].indexOf("?"));
                newS += temp[1].substring(temp[1].indexOf("?") + 1);
                temp[1] = newS;
            }
            return temp[0] + temp[1];


        } else {
            if (temp[0].contains("\\?")) {
                String newS = "";
                newS = temp[0].substring(0, temp[0].indexOf("?"));
                newS += temp[0].substring(temp[0].indexOf("?") + 1);
                temp[0] = newS;

            }

            return temp[0];


        }
    }

}

