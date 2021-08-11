package com.callor.topnews.adapter;

import android.text.Html;
import android.text.Spanned;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.callor.topnews.databinding.NewsItemViewBinding;
import com.callor.topnews.model.NaverNewsDTO;

import java.util.List;

/**
 * RecyclerView Helper class
 * RecyclerView Adapter 클래스를 상속받고
 * RecyclerView ViewHolder 클래스를 상속받은
 * inner class 를 포함 한다
 */
public class NewsViewAdpater extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private List<NaverNewsDTO> newsList;

    public NewsViewAdpater(List<NaverNewsDTO> newsList) {
        this.newsList = newsList;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        
        LayoutInflater layoutInflater=LayoutInflater.from(parent.getContext());
        NewsItemViewBinding viewBinding=NewsItemViewBinding.inflate(layoutInflater,parent,false);
        
        return new NewsViewHolder(viewBinding);

    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

        /**
         * 매개변수로 받은 holder는 
         * recyclerView.ViewHolder type 으로 실제 사용해야하는
         * NewsViewHolder 의 부모 클래스 type 이다
         * 때문에 실제 사용하기 위해서는 NewsViewHolder type 으로
         * 형변환 해야한다
         */
        NewsViewHolder viewHolder= (NewsViewHolder) holder;

        NewsItemViewBinding newsBinding=viewHolder.viewBinding;
        
        NaverNewsDTO newsDTO=newsList.get(position);

        viewHolder.viewBinding.newsItemTitle.setText(newsDTO.getTitle());
        Spanned newsTitle= Html.fromHtml(newsDTO.getTitle(),Html.FROM_HTML_MODE_LEGACY);
        Spanned newsDesc= Html.fromHtml(newsDTO.getDescription(),Html.FROM_HTML_MODE_LEGACY);
        newsBinding.newsItemTitle.setText(newsDTO.getTitle());
        newsBinding.newsItemDesc.setText(newsDTO.getDescription());

    }

    @Override
    public int getItemCount() {
        
        return newsList==null?0:newsList.size();
    }

    public static class  NewsViewHolder extends RecyclerView.ViewHolder{
        /**
         * binding 속성을 사용하면
         * item_view.xml 에 설정된 view component 를 일일이 찾아서 
         * 초기화 하는 코드가 필요 없어 진다
         * item_View.xml 파일에 의해 생성된 
         * ItemViewBinding 클래스를 사용하여 모든 view copmponent 를 한꺼번에 viewHolder 로 생성 할수 있다
         */
        public NewsItemViewBinding viewBinding;

        public NewsViewHolder(@NonNull NewsItemViewBinding viewBinding) {
            super(viewBinding.getRoot());
            this.viewBinding=viewBinding;
        }
    }
}
