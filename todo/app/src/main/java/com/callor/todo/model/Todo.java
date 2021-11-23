package com.callor.todo.model;

import androidx.room.PrimaryKey;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Todo {

    @PrimaryKey
    private int id;
    // To-do의 내용
    private String content;
    // 완료 여부
    private boolean completed;
}
