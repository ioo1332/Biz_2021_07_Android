package com.callor.cacao.adapter;

import android.graphics.Color;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.callor.cacao.R;
import com.callor.cacao.model.Chatt;
import com.google.firebase.database.ChildEventListener;

import java.util.List;

public class ChattAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private List<Chatt> chattList;
    private String name;

    public void addChattList(Chatt chatt){
        chattList.add(chatt);
        notifyItemInserted(chattList.size()-1);

    }

    public ChattAdapter(List<Chatt> chattList) {
        //this.chattList = chattList;
        this(chattList,"익명");
    }
    public ChattAdapter(List<Chatt> chattList, String name) {
        this.chattList = chattList;
        this.name=name;
    }


    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View item_layout = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.chatt_item,parent,false );

        ChattViewHolder viewHolder=new ChattViewHolder(item_layout);

        return viewHolder;

    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        Chatt chat=chattList.get(position);
        ChattViewHolder chattViewHolder= (ChattViewHolder) holder;
        chattViewHolder.item_name.setText(chat.getName());
        chattViewHolder.item_msg.setText(chat.getMsg());
        /**
         * 현재 App에서 보낸 메시지를 db에서 가져왔으면 (fetch)
         * this.name 변수에는 app에 설정된 nickname 이 담겨있다
         * 그리고 firebase 에서 가져온 데이터에서 이름이 nickname과 같으면
         * 오른쪽 정렬하여 보여라
         */
        if(this.name.equals(chat.getName())){
            // 이름과 메시지를 오른쪽 정렬
            chattViewHolder.item_name.setTextAlignment(View.TEXT_ALIGNMENT_TEXT_END);
            chattViewHolder.item_msg.setTextAlignment(View.TEXT_ALIGNMENT_TEXT_END);
            chattViewHolder.msgLinear.setGravity(Gravity.END);
            chattViewHolder.item_msg.setBackgroundColor(Color.parseColor("#FFEB3B"));
        }
    }

    @Override
    public int getItemCount() {
        return chattList==null ? 0: chattList.size();
    }
    public static class ChattViewHolder extends RecyclerView.ViewHolder{

        public TextView item_name;
        public TextView item_msg;
        public LinearLayout msgLinear;

        public ChattViewHolder(@NonNull View itemView) {
            super(itemView);
            item_name=itemView.findViewById(R.id.item_name);
            item_msg=itemView.findViewById(R.id.item_msg);
            /**
             * item_name과 item_msg 를 감싸고 있는 layout(LinearLayout)에 접근하기 위하여 객체로 생성
             */
            msgLinear=itemView.findViewById(R.id.msg_linear);
        }
    }

}
