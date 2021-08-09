package com.callor.library.model;

import java.util.List;

/**
 * JSON 데이터를 자동 mapping 하여 parsing 을 수행하기 위해
 * JSON 데이터의 상위(parent)에 해당하는 클래스를 선언
 *
 * 실제 필요한 데이터는 items 에 담긴 데이터 이다
 */
public class NaverParent {

   public String rss;//	-	디버그를 쉽게 하고 RSS 리더기만으로 이용할 수 있게 하기 위해 만든 RSS 포맷의 컨테이너이며 그 외의 특별한 의미는 없다.
    public String channel;//	-	검색 결과를 포함하는 컨테이너이다. 이 안에 있는 title, link, description 등의 항목은 참고용으로 무시해도 무방하다.
    public String lastBuildDate;//	datetime	검색 결과를 생성한 시간이다.
    public String total;//	integer	검색 결과 문서의 총 개수를 의미한다.
    public String start;//	integer	검색 결과 문서 중, 문서의 시작점을 의미한다.
    public String display;//	integer	검색된 검색 결과의 개수이다.
    public List<BookDTO> items;//	-	XML 포멧에서는 item 태그로, JSON 포멧에서는 items 속성으로 표현된다. 개별 검색 결과이며 title, link, description을 포함한다.

    @Override
    public String toString() {
        return "NaverParent{" +
                "rss='" + rss + '\'' +
                ", channel='" + channel + '\'' +
                ", lastBuildDate='" + lastBuildDate + '\'' +
                ", total='" + total + '\'' +
                ", start='" + start + '\'' +
                ", display='" + display + '\'' +
                ", items=" + items +
                '}';
    }
}
