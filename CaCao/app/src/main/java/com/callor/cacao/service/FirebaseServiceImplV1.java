package com.callor.cacao.service;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.callor.cacao.adapter.ChattAdapter;
import com.callor.cacao.model.Chatt;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
/**
 * ChildEventListener
 * Firebase 의 RealtimeDataBase 에 변화 (CUD)가 발생하면
 * Firebase 에서 Android 모든 App 에 신호를 보내고
 * 그 신호를 event 로 받아서 처리하는 클래슬르 작성하기 위한 interface
 */
public class FirebaseServiceImplV1 implements ChildEventListener {
    /**
     * ChattAdapter 객체가 하는일
     * RecyclerView 와 연동하여 데이터를 화며에 그리기 위한 중간 연결도구
     * Adapter 를 MainActivity 로 부터 전달받아
     * FireBase Database 에 데이터가 추가되면 데이터를 가져와서 화면에 그리기 위한 코드를 작성한다
     */
    private ChattAdapter adapter;

    public FirebaseServiceImplV1(ChattAdapter adapter) {
        this.adapter = adapter;
    }
    /**
    *   CUD 중에서 새로운 데이터가 추가되는 (insert,create) event 가 발생하면 실행되는 method
     *   이 method 에서 데이터가 추가되었다는 신호를 받으면 데이터를 가져와서
     *   Adapter 의 chattList 에 데이터를 추가한다
     *   그리고 RecyclerView 에게 알림을 전한다
    */
    @Override
    public void onChildAdded(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {

        Chatt chattVO=snapshot.getValue(Chatt.class);
        adapter.addChattList(chattVO);
    }

    @Override
    public void onChildChanged(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {

    }

    @Override
    public void onChildRemoved(@NonNull DataSnapshot snapshot) {

    }

    @Override
    public void onChildMoved(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {

    }

    @Override
    public void onCancelled(@NonNull DatabaseError error) {

    }
}
