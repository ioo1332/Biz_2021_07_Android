# Hello Android

* empty Activity Template을 이용한 App 생성

## 기본 화면 구성
* activity_*.xml 파일에 xml 코드로 화면 구현 작성
* activity의 가장 상위(바깥쪽)은 *Layout tag 로 시작한다
* Layout tag에는 다양한 view(content, 도구, property)를
사용하여 화면을 생성한다
* Graphic 화면을 도구를 사용하여 화면을 그리기기도 하고
* xml 코드를 직접 작성하여 화면을 그리기도 한다
* 보통은 Graphic 화면 도구를 사용하여 전체적인 모양을 생성한 후
xml 코드를 수정하여 화면 구현을 정밀하게 조정한다.

## 모든 tag의 기본속성
* android:layout_width, android:layout_height
* 기본속성을 생략하면 보통 오류가 발생한다.

## layout_height, layout_width의 속성 값
* match_parent : 자신을 감싼 tag에 가득차도록
* wrap_content : 자신이 감싸고 있는 tag, text, content만큼 만
* 고정된 숫자값 : dp, sp, dpi, px 등의 단위로 고정값을 지정

## 화면의 글꼴 단위 : dp, sp
* dp:Density Independent pixel
해상도와 관계없이 독립적인 픽셀 단위
디바이스에서 글꼴의 크기를 조절했을 때도 고유의 비율을 유지하기
* sp:Scale Independent pixel
화면 크기와 관계없이 독립적인 픽셀 단위
디바이스에서 글꼴의 크기를 변경하면 실제 보여지는 글꼴도
크기가 비율대로 변경된다
