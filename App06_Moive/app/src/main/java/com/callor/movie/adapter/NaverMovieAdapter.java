package com.callor.movie.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.callor.movie.databinding.MovieItemViewBinding;
import com.callor.movie.model.MovieDTO;

import java.util.List;

public class NaverMovieAdapter
        extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    // 리스트를 보이기 위한 데이터
    private List<MovieDTO> movieList;
    public NaverMovieAdapter(List<MovieDTO> movieList) {
        this.movieList = movieList;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater
                = LayoutInflater.from(parent.getContext());
        MovieItemViewBinding moviewBinding
                = MovieItemViewBinding
                .inflate(layoutInflater,
                        parent,
                        false);

        return new NaverMovieViewHolder(moviewBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        NaverMovieViewHolder movieViewHolder
                = (NaverMovieViewHolder) holder;

        MovieDTO movieDTO = movieList.get(position);
        MovieItemViewBinding binding
                = movieViewHolder.movieBinding;
        binding.movieItemTitle.setText(movieDTO.getTitle());
        binding.movieItemDirect.setText(movieDTO.getDirector());
        binding.movieItemActor.setText(movieDTO.getActor());
    }
    @Override
    public int getItemCount() {
        return movieList == null ? 0 : movieList.size();
    }

    public static class NaverMovieViewHolder extends RecyclerView.ViewHolder {

        public MovieItemViewBinding movieBinding;
        public NaverMovieViewHolder(@NonNull MovieItemViewBinding movieBinding) {
            super(movieBinding.getRoot());
            this.movieBinding = movieBinding;
        }
    }

}