package com.callor.word.config;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

import com.callor.word.dao.WordDao;
import com.callor.word.model.WordDTO;

import java.util.concurrent.ExecutorService;

/**
 * RoomDatabase 를 상속받아 DB Connection, Session 을 만드는 클래스
 * 이 클래스는 반드시 abstract 키워드를 추가하여
 * 추상 클래스로 선언을 해야한다
 *
 * 일부는 직접 코드를 구현하는 method 를 포함하고
 * 일부는 interface 처럼 코드가 구현되지않은 method 를 함께 포함하는 클래스이다
 */

/**
 * entities 항목의 내용
 * 만약 db table 이 없으면 WordDTO 클래스를 참조하여 table 을 만들어라
 * version 항목의 내용
 * 혹시 사용과정에서 table 에 변경사항이 발생 할수 있는데
 * 여기서는 table 에 변경이 이루어지면 WordDTO 클래스에 칼럼들을 변경하는 작업을 수행한다
 * 그리고 version 넘버를 현재 값보다 큰값으로 변경한다
 * 변경된 version 넘버를 기준으로 새롭게 table 을 재구성 한다
 */
@Database(entities = {WordDTO.class}, version = 1)
public abstract class WordDataBase extends RoomDatabase{

    static WordDataBase dbConn;

    // 데이터 관련 코드에서 사용할 DB Connection (session) 객체를 return 하는 method
    public static WordDataBase getDataBase(final Context context){
        if(dbConn==null){
            dbConn= Room.databaseBuilder(
                    context.getApplicationContext()
                    ,WordDataBase.class,"word_database"
            ).addCallback(null).build();
        }
        return dbConn;
    }

    /**
     * 시스템이 생성하여 Dao 를 만드는 코드로 재작성
     * @return
     */
    abstract WordDao wordDao();
}
