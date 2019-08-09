package Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import project.android_projects.com.tictocgamewithmvc.R;

public class TicTocBoardRecViewAdapter extends RecyclerView.Adapter<TicTocBoardRecViewAdapter.TicTocViewHolder>{
    private Context mContext;

    private List<String> ticTocXoList;

    private OnItemClickListenerCallback mListener;

    public TicTocBoardRecViewAdapter(Context context, List<String> ticTocItems) {
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
    public void onBindViewHolder(TicTocViewHolder holder, int pos){
        holder.ticTocTxtView.setText(ticTocXoList.get(pos));
    }

    @Override
    public int getItemCount() {
        return ticTocXoList.size();
    }

    public class TicTocViewHolder extends RecyclerView.ViewHolder{
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
    }
    public interface OnItemClickListenerCallback {
        void onItemClick(int position);
    }
}
