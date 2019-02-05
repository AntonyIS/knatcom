package com.example.myapplication;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

@Entity(tableName = "students")
public class Student {
    @NonNull
    @PrimaryKey(autoGenerate = true)
    int id;
    String names;
    int age;

    public Student() {
    }

    public Student(int id, String names, int age) {
        this.id = id;
        this.names = names;
        this.age = age;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNames() {
        return names;
    }

    public void setNames(String names) {
        this.names = names;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
