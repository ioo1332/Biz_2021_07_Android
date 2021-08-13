package com.callor.word.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;

import com.callor.word.R;
import com.callor.word.databinding.MyWordItemBinding;
import com.callor.word.model.WordDTO;

import java.net.PortUnreachableException;

/**
 * RecyclerView.Adaper 를 상속받은 Adapter 를 만들지만
 * Live Data 와 연동하기 위하여 확장된 ListAdapter 를 상속받아 클래스를 선언한다
 *
 * ListAdapter 는 RecyclerView 를 확장한 클래스로
 * Adapter 를 선언할때 상속을 받으면서
 * Generic 으로 RecyclerViewHolder 와 함께 DTO 클래스를 지정해주어야 한다
 *
 * getItems() method 는 포함히지않는다
 *
 * 자동으로 생성되는 생성자를 반드시 만들어 두어야 한다
*/
public class WordViewAdapter extends ListAdapter<WordDTO,RecyclerView.ViewHolder> {


    protected WordViewAdapter(@NonNull DiffUtil.ItemCallback<WordDTO> diffCallback) {
        super(diffCallback);
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater layoutInflater
                =LayoutInflater.from(parent.getContext());
        MyWordItemBinding wordItemBinding
                =MyWordItemBinding.inflate(layoutInflater,parent,false);

        return new WordViewHolder(wordItemBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        WordViewHolder wordViewHolder= (WordViewHolder) holder;
        wordViewHolder.itemBinding.itemKorea.setText("");
        wordViewHolder.itemBinding.itemKorea.setText("");

    }

    public static class WordViewHolder extends RecyclerView.ViewHolder{

        public MyWordItemBinding itemBinding;

        public WordViewHolder(@NonNull MyWordItemBinding itemView) {
            super(itemView.getRoot());
            itemBinding = itemView;
        }
        public void bind(MyWordItemBinding wordItemBinding){
            itemBinding=wordItemBinding;

        }

    }
}