package com.example.myapplication;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

@Database(entities ={Student.class}, version =1)
public abstract class MyDatabase extends RoomDatabase {
    public  abstract StudentDao studentDao();

    private  static  volatile  MyDatabase INSTANCE;


    public static MyDatabase getInstance(final Context context){
        if (INSTANCE==null){
            synchronized (MyDatabase.class){
                INSTANCE= Room.databaseBuilder(context,MyDatabase.class, "students_db").allowMainThreadQueries().build();
            }
        }
        return  INSTANCE;
    }
}
