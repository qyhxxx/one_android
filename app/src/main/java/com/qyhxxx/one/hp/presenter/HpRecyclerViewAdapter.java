package com.qyhxxx.one.hp.presenter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.qyhxxx.one.R;
import com.qyhxxx.one.hp.bean.Hp;

import java.util.ArrayList;
import java.util.List;

public class HpRecyclerViewAdapter extends RecyclerView.Adapter<HpRecyclerViewAdapter.ViewHolder> {
    private Context mContext;
    private List<Hp> mHpList = new ArrayList<>();

    public HpRecyclerViewAdapter(Context context) {
        mContext = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.hp_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Hp hp = mHpList.get(position);
        Glide.with(mContext).load(hp.getHp_img_url()).into(holder.hpImg);
        holder.hpContent.setText(hp.getHp_content());
        holder.hpAuthor.setText(hp.getHp_author());
    }

    @Override
    public int getItemCount() {
        return mHpList.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        ImageView hpImg;
        TextView hpContent;
        TextView hpAuthor;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            hpImg = itemView.findViewById(R.id.hp_img);
            hpContent = itemView.findViewById(R.id.hp_content);
            hpAuthor = itemView.findViewById(R.id.hp_author);
        }
    }

    public void addList(List<Hp> list) {
        mHpList.addAll(list);
        notifyItemRangeInserted(mHpList.size(), list.size());
    }
}
