package com.example.marko.followmyheart.adapter.originalsection;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.marko.followmyheart.R;
import com.example.marko.followmyheart.adapter.section.SectionBean;

import java.util.List;

public class OriginalSectionAdapter extends RecyclerView.Adapter<OriginalSectionAdapter.SectionViewHolder> {

    private Context mContext;
    private List<SectionBean> mDatas;
    private OnItemClickListener mListener;

    public OriginalSectionAdapter(Context context, List<SectionBean> data) {
        this.mContext = context;
        this.mDatas = data;
    }


    public void setOnItemClickListener(OnItemClickListener mListener) {
        this.mListener = mListener;
    }

    @NonNull
    @Override
    public SectionViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int position) {

        return new SectionViewHolder(LayoutInflater.from(mContext).inflate(R.layout.item_section_content, viewGroup, false));
    }

    @Override
    public void onBindViewHolder(@NonNull SectionViewHolder viewHolder, int position) {
        viewHolder.ivIcon.setImageResource(mDatas.get(position).getIv_icon());
        viewHolder.tvIcon.setText(mDatas.get(position).getTv_icon());
        viewHolder.ivIcon.setOnClickListener(v -> mListener.onItemClick(position));
    }

    @Override
    public int getItemCount() {
        return mDatas == null ? 0 : mDatas.size();
    }

    class SectionViewHolder extends RecyclerView.ViewHolder {
        TextView tvIcon;
        ImageView ivIcon;

        public SectionViewHolder(@NonNull View itemView) {
            super(itemView);
            tvIcon = itemView.findViewById(R.id.tv_icon);
            ivIcon = itemView.findViewById(R.id.iv_icon);
        }
    }

    public interface OnItemClickListener {
        void onItemClick(int position);
    }

}
