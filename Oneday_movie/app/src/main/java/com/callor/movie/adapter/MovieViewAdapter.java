package com.callor.movie.adapter;

import android.text.Html;
import android.text.Spanned;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.callor.movie.R;
import com.callor.movie.model.NaverMovieDTO;
import com.squareup.picasso.Picasso;


import java.util.List;

public class MovieViewAdapter extends RecyclerView.Adapter {

    private List<NaverMovieDTO> movieList;

    public MovieViewAdapter(List<NaverMovieDTO>movieList){
        this.movieList=movieList;
    }


    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater layoutInflater=LayoutInflater.from(parent.getContext());
        View view=layoutInflater.inflate(R.layout.movie_item_view,parent,false);
        MovieItemHolder viewHolder=new MovieItemHolder(view);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

        MovieItemHolder movieItemHolder= (MovieItemHolder) holder;
        NaverMovieDTO movieDTO=movieList.get(position);
        String item_title=movieDTO.getTitle();
        Spanned sp_title= Html.fromHtml(item_title,Html.FROM_HTML_MODE_LEGACY);
        movieItemHolder.item_title.setText(sp_title);

        String item_director=movieDTO.getDirector();
        Spanned sp_director= Html.fromHtml(item_director,Html.FROM_HTML_MODE_LEGACY);
        movieItemHolder.item_director.setText("감독 : "+sp_director);

        String item_actor=movieDTO.getActor();
        Spanned sp_actor= Html.fromHtml(item_actor,Html.FROM_HTML_MODE_LEGACY);
        movieItemHolder.item_actor.setText("출연 배우 : "+sp_actor);

        String item_userRating=movieDTO.getUserRating();
        Spanned sp_userRating= Html.fromHtml(item_userRating,Html.FROM_HTML_MODE_LEGACY);
        movieItemHolder.item_userRating.setText("관객 평점 : "+sp_userRating);

        String item_link=movieDTO.getLink();
        Spanned sp_link= Html.fromHtml(item_link,Html.FROM_HTML_MODE_LEGACY);
        movieItemHolder.item_link.setText("바로 가기 : "+sp_link);

        if(!movieDTO.getImage().isEmpty()){
            Picasso.get().load(movieDTO.getImage()).into(movieItemHolder.item_image);

        }

    }

    @Override
    public int getItemCount() {
        return movieList==null?0:movieList.size();
    }

    public static class MovieItemHolder extends RecyclerView.ViewHolder{

        public TextView item_title;
        public ImageView item_image;
        public TextView item_director;
        public TextView item_userRating;
        public TextView item_actor;
        public TextView item_link;

        public MovieItemHolder(@NonNull View itemView) {
            super(itemView);
            item_title=itemView.findViewById(R.id.movie_item_title);
            item_image=itemView.findViewById(R.id.movie_item_image);
            item_director=itemView.findViewById(R.id.movie_item_director);
            item_actor=itemView.findViewById(R.id.movie_item_actor);
            item_userRating=itemView.findViewById(R.id.movie_item_userRating);
            item_link=itemView.findViewById(R.id.movie_item_link);

        }
    }
}
