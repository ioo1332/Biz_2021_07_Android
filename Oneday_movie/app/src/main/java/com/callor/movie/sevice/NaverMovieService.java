package com.callor.movie.sevice;

import com.callor.movie.model.NaverMovieDTO;

public interface NaverMovieService {

    public NaverMovieDTO getMovie(String search);
}
