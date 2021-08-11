package com.callor.library.service;

import com.callor.library.model.NaverBookDTO;

public interface NaverBookService {

    public NaverBookDTO getBooks(String search);
}
