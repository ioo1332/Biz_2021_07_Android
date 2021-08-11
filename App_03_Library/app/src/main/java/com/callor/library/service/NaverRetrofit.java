package com.callor.library.service;

import com.callor.library.model.NaverParent;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Query;

/**
 * Retrofit 을 사용하여 API 접속할때
 * 최종 end pint, header, method type, parameter 등을
 * 설정하는 인터페이스
 */
public interface NaverRetrofit {
    /**
     * method 의 return type 을 void 형식이 아닌 Call 클래스 type 으로 설정
     */
    // 1. 가장 기본타입 아무일도 할수없음
    public Call getBook();

    /**
     * // 2. naver Open API를 사용하기 위해서는
     * 반드시 header 에 client id 와 client secret 값을 전달해줘야한다
     * header 에 client id 와 client secret 를 전달하기 위하여
     * 가. method 의 매개변수에 해당속성을 지정해준다
     * 나. @Header() annotation 을 부착
     * 다. @Header() annotation Header 의 이름을 지정한다
     * X-Naver-Client-Id=asdf 형식으로 요청한다
     *
     * 3. method 에 end point와 요청 method type 을 지정한다
     * 요청 method type : @GET,@POST,@PUT,@DELETE
     *
     * 4. openAPI 를 통해 데이터를 요청할때 값, 변수 등을 보내고 싶을때
     * queryString 을 만드는데 여기에서는 @Query() 를 사용하여 지정한다
     *
     * 5. return type 인 call 클래스에 data 를 mapping 할 DTO(VO) 클래스를
     * generic 으로 설정해준다
     *
     * @return
     */
    @GET("book.json")
    public Call<NaverParent> getBook(
            @Header("X-Naver-Client-Id") String clientId,
            @Header("X-Naver-Client-Secret") String clintSecret,
            @Query("query") String query,
            @Query("start") int start,
            @Query("display") int display

    );

}
