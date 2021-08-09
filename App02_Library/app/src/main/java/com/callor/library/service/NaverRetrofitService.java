package com.callor.library.service;

import com.callor.library.model.NaverParent;



import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Query;

/**
 * Retrofit 를 사용할때 URL 정의
 * 만약 URL 이 http://naver.com/aaa/bbb/ccc/book.json 형태로 되어있을때
 * URL 의 끝의 ent point 인 book.json 은 @GET("book.json")으로 설정한다
 * RetroService 에서 instance 를 만들때 사용한 코드
 *  Retrofit.Builder().baseUrl() 부분에 매개변수로
 *  http://naver.com/aaa/bbb/ccc/ 를 전달 해준다
 *
 *  실제 Connection 객체를 만들때 baseUrl 과 @Get()에 설정된 EndPoint 를 합성하여
 *  http://naver.com/aaa/bbb/ccc/book.json 와 같은 URL 을 생성하게 된다
 *
 *  또한 @Query("query")설정된 부분이 있으면
 *  ?query=변수값 형식으로 queryString 을 생성한다
 *  /book.json?query=자바 형식으로 최종 queryString 이 생성된다.
 *
 * @Header()로 선언된 부분은 Http protocol 의 header 에 정보를 실어서 보낼때 사용한다 *
 */
public interface NaverRetrofitService {
    @GET("book.json") // Retrofit을 사용하여 GET method로 OpenAPI에 접속하라
    Call<NaverParent> getNaverBook(
            @Header("X-Naver-Client-Id") String clientId,
            @Header("X-Naver-Client-Secret") String clientSecret,
            @Query("query") String query
            //@Query("display")int display,
            //@Query("start")int start
    );
    // 최종 생성되는 queryString
    // book.json?query=자바&display=10&start=1
}