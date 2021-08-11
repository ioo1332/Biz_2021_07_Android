package com.callor.library.adapter;

import android.media.Image;
import android.text.Html;
import android.text.Spanned;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.callor.library.R;
import com.callor.library.model.NaverBookDTO;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * RecyclerView 에 데이터를 보여주기 위한 Helper class
 */
public class BookViewAdapter extends RecyclerView.Adapter {

    // RecyclerView 에 표현할 데이터 들
    private List<NaverBookDTO> bookList;

    /**
     * RecyclerView 에서 사용할 데이터 (bookList)를 어떻게 외부에서 Adapter에 보낼것인가
     * 생성자 이용, setter() 사용하여 주입
     *
     * RecyclerView 의 Adapter를 객체로 생성할때 화면에 보여줄 데이터를 전달하자
     * 데이터를 매개변수가 갖는 생성자를 만든다
     *
     * 이후의 코드는 화면에 보여줄 데이터가 있다는 전제하에 코드가 진행된다
     */
    public BookViewAdapter(List<NaverBookDTO> bookList) {
        this.bookList = bookList;
    }





    @NonNull
    @Override
    /**
     * onCreateViewHolder
     * item 을 그리는 item.xml 파일을 읽어서 사용할 준비를하기
     * item.xml 파일을 view 로 생성하고 데이터와 연결할 준비
     */
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        // inflater(확장)
        // *.xml 파일에 설정된 view 정보를 읽어서 자바 코드에서 사용하기 위한 객체로 생성하는것

        // item.xml 파일을 읽어와서 Holder 로 만들기전에 확장(펼치기) 위한 도구
        LayoutInflater layoutInflater=LayoutInflater.from(parent.getContext());
        // book_item_view.xml 내용이 view 객체로 변환되었다
        View view = layoutInflater.inflate(R.layout.book_item_view,parent,false);
        // 생성된 view 객체를 BookViewHolder 클래스의 생성자에 주입하면서
        // ViewHoler 객체를 생성하기
        BookItemHolder viewHoler=new BookItemHolder(view);
        // 생성된 viewHolder 객체를 RecyclerView 에게 return 하기
        return viewHoler;
    }

    @Override
    /**
     * 생성된 Holder 와 실제 데이터 (한개의데이터)를 연결하는 작업
     * 한개의 데이터를 연결하는 작업을 수행하지만
     * RecyclerView 에 의해서 데이터들의 개수만큼 반복적으로 호출되어
     * 화면에 데이터를 그리는 작업을 수행
     *
     * RecyclerView 가 onBindViewHolder() method 를 호출하면서
     * 몇번째 데이터를 Binding 할것인지에 대한 index로 position 변수에 값을 전달해준다
     */
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        /**
         * 매개변수로 받은 holer를 우리가 선언한 bookItemHolder로 형변환 시키고 이후 코드를 진행
         */
        BookItemHolder bookHolder= (BookItemHolder) holder;
        // 전체 데이터에서 그리고자 하는 데이터를 추출한다
        // 이때 매개 변수로 전달받은 position 을 사용하여 데이터를 getter 한다
        NaverBookDTO bookDTO=bookList.get(position);
        String item_title=bookDTO.getTitle();
        Spanned sp_title= Html.fromHtml(item_title,Html.FROM_HTML_MODE_LEGACY);
        bookHolder.item_title.setText(sp_title);

        String item_desc=bookDTO.getDescription();
        Spanned sp_desc=Html.fromHtml(item_desc,Html.FROM_HTML_MODE_LEGACY);
        bookHolder.item_desc.setText(sp_desc);

        /**
         * Naver API 를 통해서 전달받은 데이터중 image 정보 표시하기
         * Naver API 에선느 도서에 대한 image 를 이미지 주소 문자열로 보낸다
         *
         * HTML 에서는 단순히 img src="" 코드를 사용하여 연결하면
         * 자동으로 다운로드를 받으면서 이미지를 보여준다
         *
         * 하지만 안드로이드에서는 디바이스 자체가 성능이 낮기 때문에
         * 직접 이미지를 다운로드 하면 문제를 일으킬수있다
         * 안드로이드에서 이미지 링크를 실제 이미지로 보여주는데
         * picasso, Glide 와 같은 3rd party 라이브러리를 사용하여 화면에 이미지를 구현한다
         *
         *          Picasso           Glide
         * 속도      다소느림            빠름
         * 메모리   적게 소모           많이 소모
         * 기능       단순           다양한기능존재
         */

        if(!bookDTO.getImage().isEmpty()){
            Picasso.get().load(bookDTO.getImage())
                    .into(bookHolder.item_image);
        }
    }

    @Override
    /**
     * onCreateViewHolder 에서 생성된 holder 를 사용하여
     * onBindViewHolder 가 데이터 한개를 그리기를 수행하면
     * RecyclerView 에게 지금 데이터가 몇개 인지 알려주고
     * 데이터 개수만큼 반복적으로 Holder 를 그려라 라는 값을 알려주는 method
     */
    public int getItemCount() {

        return bookList==null?0:bookList.size();
    }

    /**
     * onCreateViewHolder() method 가 사용하는 클래스
     * 실제 item.xml 에 작성된 각각의 view component 를
     * 실제적으로 사용할수 있도록 각각 개별 객체(view 객체)로 생성하기 위한 보조 클래스
     *
     * 초기에 RecyclerView 인 ListView 시절에는 선택사항으로 만들지 않아도 되었는데
     * RecyclerView 에서는 반드시 있어야하는 필수 클래스
     *
     * 우리가 작성할 코드는
     * item.xml 에 설정된 view Component 개별 오소를
     * 추출하여 각각 객체로 만드는일
     *
     * book_view_item.xml 에는
     * textView가 있다
     * 이 textView 를 사용할수 있도록 객체로 만드는일
     */
    public static class BookItemHolder extends RecyclerView.ViewHolder{

        public TextView item_title;
        public ImageView item_image;
        public TextView item_desc;

        public BookItemHolder(@NonNull View itemView) {

            super(itemView);
            item_title=itemView.findViewById(R.id.book_item_title);
            item_desc=itemView.findViewById(R.id.book_item_desc);
            item_image=itemView.findViewById(R.id.book_item_image);
        }
    }
}
