package com.example.myapplication4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.res.AssetManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Field;
import java.sql.Time;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;






public class MainActivity extends AppCompatActivity {


    EditText ed;
    TextView tw;
    TextView tw1;
    int numberofday=0;
    String[][] TimeTable;
    ArrayList<String> arrayList;
    String dateofweek=null;
    TimeTable tm = new TimeTable();


    private final static String FILE_NAME = "content.txt";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);





TimeTable tm = new TimeTable();
tm.CountrOfWeeks();
//tm.ReadFile();
        arrayList=ReadTimeTable();
        String temp;
        for(int i=0;i<arrayList.size();i++){
            if(arrayList.get(i).contains("|")){
                temp=arrayList.get(i);
                temp=temp.replace("|","");
                arrayList.set(i,temp);
            }
        }
        tw =(TextView) findViewById(R.id.label);
        tw1 =(TextView) findViewById(R.id.label1);//  для проверки что в файле ( для этого ужно убрать переход на ативити)
        ed = (EditText) findViewById(R.id.editText);

        Calendar c = Calendar.getInstance();
        c.setTime(new Date());
        int dd = c.get(Calendar.DAY_OF_WEEK);


        switch (dd) {
            case 1:dateofweek="Воскресенье"; break;
            case 2:dateofweek="Понедельник";break;
            case 3:dateofweek="Вторник";break;
            case 4:dateofweek="Среда";break;
            case 5:dateofweek="Четверг";break;
            case 6:dateofweek="Пятница";break;
            case 7:dateofweek="Суббота";break;
            default:break;
        }
switch (dateofweek){
    case "Понедельник": numberofday=1; break;
    case "Вторник":numberofday=2; break;
    case "Среда":numberofday=3; break;
    case "Четверг":numberofday=4; break;
    case "Пятница":numberofday=5; break;
    case "Суббота":numberofday=6; break;
    case "Воскресенье":numberofday=7; break;

    default:break;
}


        System.out.println("**************");

        FileInputStream fin = null;
        try {
            fin = openFileInput(FILE_NAME);
        }
        catch (FileNotFoundException e){}
if(fin!=null) {
    File file = new File(getFileName(fin));

    if(file.exists()){
        //tw1.setText(""+CheckText());
        // тут устаовка расписания для всех активити
        //numberofday=6;//не забыть убрать
        Intent intent;
        switch (numberofday){
            case 1:
                intent = new Intent(MainActivity.this, FirstActivity.class);
                intent.putExtra("group",CheckText());
                //intent.putExtra("day",numberofday);
                intent.putExtra("timetable",arrayList);
                startActivity(intent);
                break;
            case 2:
                intent = new Intent(MainActivity.this, SecondActivity.class);
                intent.putExtra("group",CheckText());
               // intent.putExtra("day",numberofday);
                intent.putExtra("timetable",arrayList);
                startActivity(intent);
                break;
            case 3:
                intent = new Intent(MainActivity.this, ThirdActivity.class);
                intent.putExtra("group",CheckText());
               // intent.putExtra("day",numberofday);
                intent.putExtra("timetable",arrayList);
                startActivity(intent);
                break;
            case 4:
                intent = new Intent(MainActivity.this, FourthActivity.class);
                intent.putExtra("group",CheckText());
               // intent.putExtra("day",numberofday);
                intent.putExtra("timetable",arrayList);
                startActivity(intent);
                break;
            case 5:
                intent = new Intent(MainActivity.this, FifthActivity.class);
                intent.putExtra("group", CheckText());
               // intent.putExtra("day",numberofday);
                intent.putExtra("timetable",arrayList);
                startActivity(intent);
                break;
            case 6:
                intent = new Intent(MainActivity.this, SixthActivity.class);
                intent.putExtra("group",CheckText());
                //intent.putExtra("day",numberofday);
                intent.putExtra("timetable",arrayList);
                startActivity(intent);
                break;
            case 7:
                tw.setText("Сегодня "+dateofweek+" ,"+tm.CountrOfWeeks()+"неделя");
                ed.setVisibility(View.GONE);
                Button but = (Button) findViewById(R.id.button);
                but.setVisibility(View.GONE);

                default: break;
        }



    }
    else {
        tw.setText(dateofweek);



    }
}



    }



    public void subbmit(View view){

        String group= ed.getText().toString().toLowerCase();

        boolean result = group.matches("[а-я]{4}[-]{1}\\d{1}\\d{1}[-]{1}\\d{1}\\d{1}"); // это нужно оставить
        //boolean result =true; // это нужно убрать

        if(result==false) {
            Toast toast = Toast.makeText(this, "не верный ввод\nдолжно быть так:\nбсбо-07-18", Toast.LENGTH_LONG);
            toast.show();
            ed.setText("");
        }
        if(result==true){

                saveText();
                // тут установка расписания для всех активити

            Intent intent;

            switch (numberofday){
                case 1:
                    intent = new Intent(MainActivity.this, FirstActivity.class);
                    intent.putExtra("group",CheckText());
                    intent.putExtra("timetable",arrayList);
                    startActivity(intent);
                    break;
                case 2:
                    intent = new Intent(MainActivity.this, SecondActivity.class);
                    intent.putExtra("group",CheckText());
                    intent.putExtra("timetable",arrayList);
                    startActivity(intent);
                    break;
                case 3:
                    intent = new Intent(MainActivity.this, ThirdActivity.class);
                    intent.putExtra("group",CheckText());
                    intent.putExtra("timetable",arrayList);
                    startActivity(intent);
                    break;
                case 4:
                    intent = new Intent(MainActivity.this, FourthActivity.class);
                    intent.putExtra("group",CheckText());
                    intent.putExtra("timetable",arrayList);
                    startActivity(intent);
                    break;
                case 5:
                    intent = new Intent(MainActivity.this, FifthActivity.class);
                    intent.putExtra("group", CheckText());
                    intent.putExtra("timetable",arrayList);
                    startActivity(intent);
                    break;
                case 6:
                    intent = new Intent(MainActivity.this, SixthActivity.class);
                    intent.putExtra("group",CheckText());
                    intent.putExtra("timetable",arrayList);
                    startActivity(intent);
                    break;
                case 7:
                    tw.setText("Сегодня "+dateofweek);
                    ed.setVisibility(View.GONE);
                    Button but = (Button) findViewById(R.id.button);
                    but.setVisibility(View.GONE);
                    tw.setText("Сегодня "+dateofweek+" ,"+tm.CountrOfWeeks()+"неделя");

                default:break;
            }
                //openText(); // для проверки что находится в файле




        }



    }

    public void saveText(){

        FileOutputStream fos = null;

        try {
            String text = ed.getText().toString();

            fos = openFileOutput(FILE_NAME, MODE_PRIVATE);
            fos.write(text.getBytes());
            Toast.makeText(this, "Файл сохранен", Toast.LENGTH_SHORT).show();// потом убрать
        }
        catch(IOException ex) {

            Toast.makeText(this, ex.getMessage(), Toast.LENGTH_SHORT).show();
        }
        finally{
            try{
                if(fos!=null)
                    fos.close();
            }
            catch(IOException ex){

                Toast.makeText(this, ex.getMessage(), Toast.LENGTH_SHORT).show();
            }
        }
    }

    public void openText(){

        FileInputStream fin = null;

        try {
            fin = openFileInput(FILE_NAME);

            byte[] bytes = new byte[fin.available()];
            fin.read(bytes);
            String text = new String (bytes);
            tw.setText(text);
            //EditText textBox = (EditText) findViewById(R.id.save_text);

            //textBox.setText(getFileName(fin));


        }
        catch(IOException ex) {

            Toast.makeText(this, ex.getMessage(), Toast.LENGTH_SHORT).show();
        }
        finally{

            try{
                if(fin!=null)
                    fin.close();
            }
            catch(IOException ex){

                Toast.makeText(this, ex.getMessage(), Toast.LENGTH_SHORT).show();
            }
        }
    }

    public String CheckText(){

        FileInputStream fin = null;
        String text="";

        try {
            fin = openFileInput(FILE_NAME);

            byte[] bytes = new byte[fin.available()];
            fin.read(bytes);
             text = new String (bytes);
            //tw.setText(text);
            //EditText textBox = (EditText) findViewById(R.id.save_text);

            //textBox.setText(getFileName(fin));


        }
        catch(IOException ex) {

            Toast.makeText(this, ex.getMessage(), Toast.LENGTH_SHORT).show();
            return text;
        }
        finally{

            try{
                if(fin!=null){
                    fin.close();

                    return text;

                }

            }
            catch(IOException ex){

                Toast.makeText(this, ex.getMessage(), Toast.LENGTH_SHORT).show();
                return text;

            }
        }
        return text;
    }

    public static String getFileName(FileInputStream fis){
        //throws NoSuchFieldException, IllegalArgumentException, IllegalAccessException {
        try

        {
            Field nameField = FileInputStream.class.getDeclaredField("path");
            nameField.setAccessible(true);


            return (String) nameField.get(fis);
        }
        catch (NoSuchFieldException e){}
        catch (IllegalAccessException e){}
        return "";

    }

    public  ArrayList ReadTimeTable(){
       // String[][] timetable = new String[0][0];
        ArrayList<String> timetable_pre = new ArrayList<String>();
        AssetManager assetManager;
        InputStream is;
        BufferedReader br;

        assetManager = getAssets();

        try {
            is = assetManager.open("lol.txt");
            br = new BufferedReader(new InputStreamReader(is));
            String c=br.readLine();
            timetable_pre.add(c);
            while (c!=null) {
                c=br.readLine();
                if(c!=null)timetable_pre.add(c);
            }

            //while(c!=null){ c=br.readLine();timetable_pre.add(c);System.out.println(c);}
            int loles = timetable_pre.size();
            //timetable=new String[timetable_pre.size()/4][4];
            //System.out.println(timetable[0].length);//4
            //System.out.println(timetable.length);//75
/*
int counter=0;
             for(int i=0;i<timetable.length;i++){
                 for(int j=0;j<timetable[0].length;j++){
                     timetable[i][j]=timetable_pre.get(counter);
                     counter++;
                 }
             }

 */
            //System.out.println("lol");


           // System.out.println(c);
        }
        catch (IOException e) {}
        return timetable_pre;
    }



}
