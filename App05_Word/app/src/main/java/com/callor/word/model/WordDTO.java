package com.callor.word.model;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


/**
 * 이 클래스느 DTO 역할을 수행하면서 
 * table 을 만들기 위한 구조화 method 이다
 */
@Entity(tableName = "tbl_word")
public class WordDTO {
    @PrimaryKey
    @NonNull
    @ColumnInfo(name ="word")
    private String word; // 영어 단어
    @ColumnInfo(name="korea")
    private String korea; // 한글 뜻

    @NonNull
    public String getWord() {
        return word;
    }

    public void setWord(@NonNull String word) {
        this.word = word;
    }

    public String getKorea() {
        return korea;
    }

    public void setKorea(String korea) {
        this.korea = korea;
    }

    @Override
    public String toString() {
        return "WordDTO{" +
                "word='" + word + '\'' +
                ", korea='" + korea + '\'' +
                '}';
    }
}
