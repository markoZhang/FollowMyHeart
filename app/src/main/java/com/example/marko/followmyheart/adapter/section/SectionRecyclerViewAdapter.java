package com.example.marko.followmyheart.adapter.section;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.example.marko.followmyheart.R;

import java.util.List;

public class SectionRecyclerViewAdapter extends BaseQuickAdapter<SectionBean,BaseViewHolder> {



    public SectionRecyclerViewAdapter(List data) {
        super(R.layout.item_section_content, data);
    }


    @Override
    protected void convert(BaseViewHolder helper, SectionBean item) {
        helper.setImageResource(R.id.iv_icon, item.getIv_icon())
                .setText(R.id.tv_icon, item.getTv_icon())
                .addOnClickListener(R.id.iv_icon);
    }


}
