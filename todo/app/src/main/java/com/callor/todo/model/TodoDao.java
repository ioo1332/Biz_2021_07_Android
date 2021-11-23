package com.callor.todo.model;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;


public interface TodoDao {

    @Query("SELECT * FROM todo ORDER BY id DESC")
    List<Todo> select();

    // "INSERT INTO todo (id, content) VALUES(1, '밥 먹기')
    @Query("INSERT INTO todo (content,completed) VALUES(:content,:completed)")
    void insert(String content,Boolean completed);

    @Insert
    void insert(Todo todo);

    @Query("DELETE FROM todo WHERE id = :id")
    void delete(int id);

    @Delete
    void delete(Todo todo);

    @Query("UPDATE todo SET completed = 1 WHERE id = :id")
    void complete(int id);


}
