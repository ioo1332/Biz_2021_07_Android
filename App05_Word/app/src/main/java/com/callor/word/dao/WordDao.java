package com.callor.word.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.callor.word.model.WordDTO;

import java.util.List;
@Dao
public interface WordDao {
    /**
     * 데이터를 selectAll() 하는 method 에 return type 을 다음과 같이 지정한다
     * LiveData<데이터리스트>
     *
     * 만약 selectAll() 수행하는 데이터가 100개정도 된다고 할때
     * 화면에 실제 보여지는 데이터는 10개 단위라고 하자
     *
     * List<DTO>타입의 method 를 사용하면 100개 데이터를 모두 읽어서
     * list 에 담아서 메모리에 저장을한다
     * 이는 메모리에 부담이 되고 디바이스 시스템에 무리를 줄수도 있다
     *
     * 하지만 LiveData 로 감싼 리스트는 안드로이드 OS
     * 차원에서 적절히 메모리를 분배하여 리스트를 관리 해주는 효과가 있다
     *
     * 리스트를 보고있는동안에 새로운 데이터가 insert 되었다면
     * 일반적인 환경에서는 다시 selectAll 을 수행하여 데이터를 가져와야한다
     *
     * LiveData 로 감싼 데이터는 새로 추가된 데이터만 select 하여 기존 list 에 추가 해준다
     * @return
     */
    @Query("SELECT*FROM tbl_word ORDER BY word")
    public LiveData<List<WordDTO>> selectAll();

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    public void insert(WordDTO wordDTO);

    @Query("DELETE FROM tbl_word")
    public void deleteAll(); // 초기화 시키기
}
