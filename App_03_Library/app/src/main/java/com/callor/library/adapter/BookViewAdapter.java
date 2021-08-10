package com.callor.library.adapter;

import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

/**
 * RecyclerView 에 데이터를 보여주기 위한 Helper class
 */
public class BookViewAdapter extends RecyclerView.Adapter {


    @NonNull
    @Override
    /**
     * onCreateViewHolder
     * item 을 그리는 item.xml 파일을 읽어서 사용할 준비를하기
     * item.xml 파일을 view 로
     */
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    /**
     * 생성된 Holder 와 실제 데이터 (한개의데이터)를 연결하는 작업
     * 한개의 데이터를 연결하는 작업을 수행하지만
     * RecyclerView 에 의해서 데이터들의 개수만큼 반복적으로 호출되어
     * 화면에 데이터를 그리는 작업을 수행
     */
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

    }

    @Override
    /**
     * onCreateViewHolder 에서 생성된 holder 를 사용하여
     * onBindViewHolder 가 데이터 한개를 그리기를 수행하면
     * RecyclerView 에게 지금 데이터가 몇개 인지 알려주고
     * 데이터 개수만큼 반복적으로 Holder 를 그려라 라는 값을 알려주는 method
     */
    public int getItemCount() {
        return 0;
    }

    /**
     * onCreateViewHolder() method 가 사용하는 클래스
     * 실제 item.xml 에 작성된 각각의 view component 를
     * 실제적으로 사용할수 있도록 각각 개별 객체(view 객체)로 생성하기 위한 보조 클래스
     *
     * 초기에 RecyclerView 인 ListView 시절에는 선택사항으로 만들지 않아도 되었는데
     * RecyclerView 에서는 반드시 있어야하는 필수 클래스
     */
    public static class BookItemHolder extends RecyclerView.ViewHolder{

        public BookItemHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
}
