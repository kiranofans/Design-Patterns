package Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import Models.Players;
import project.android_projects.com.tictocgamewithmvc.R;

public class MyRecViewAdapter extends RecyclerView.Adapter<BaseViewModel>{
    private Context mContext;

    private List<String> ticTocXoList;

    private OnItemClickListenerCallback mListener;

    public MyRecViewAdapter(Context context, List<String> ticTocItems) {
        this.mContext = context;
        this.ticTocXoList = ticTocItems;
    }

    public void setOnItemClickListener(OnItemClickListenerCallback listener){
        this.mListener = listener;
    }

    @NonNull
    @Override
    public TicTocViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //TextView txtView = (TextView) LayoutInflater.from(parent.getContext()).inflate(R.laout.)
        return new TicTocViewHolder(LayoutInflater.from(parent.getContext())
                .inflate(R.layout.recycle_view_items,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull BaseViewModel holder, int position) {
        holder.bind(ticTocXoList.get(position));
    }


    @Override
    public int getItemCount() {
        return ticTocXoList.size();
    }



    public class TicTocViewHolder extends BaseViewModel<Players>{
        public TextView ticTocTxtView;

        public TicTocViewHolder(@NonNull View itemView) {
            super(itemView);
            ticTocTxtView = (TextView) itemView.findViewById(R.id.tic_toc_btns);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(mListener != null){
                        int pos = getAdapterPosition();
                        if(pos != RecyclerView.NO_POSITION){
                            mListener.onItemClick(pos);
                        }
                    }
                }
            });
        }

        @Override
        public void bind(Players obj) {
            ticTocTxtView.setText(obj.getPlayerX());
        }

    }
    public interface OnItemClickListenerCallback {
        void onItemClick(int position);
    }
}
