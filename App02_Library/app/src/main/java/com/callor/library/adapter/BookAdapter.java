package com.callor.library.adapter;

import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.callor.library.model.BookDTO;

import java.util.List;

public class BookAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private List<BookDTO> bookList;

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return bookList==null?0:bookList.size();
    }

    /**
     * 각 데이터 item 을 표현하기 위한 View 객체 생성하기
     */
    public static class BookViewHolder extends RecyclerView.ViewHolder{

        public BookViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
}
