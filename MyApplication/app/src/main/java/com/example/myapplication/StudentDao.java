package com.example.myapplication;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import java.util.List;

@Dao
interface StudentDao {
    @Insert
    void insert(Student student);

    @Query("SELECT * FROM students")
    List<Student> getAllStudents();

    @Query("SELECT * FROM students WHERE id =:id")
    Student getStudent(int id);


    @Query("DELETE FROM students where id=:id")
    void delete(int id);

    @Update
    void  update(Student student);

    @Delete
    void  delete(Student student);

    @Query("SELECT COUNT(id) FROM students")
    int getStudentNumber();
}
