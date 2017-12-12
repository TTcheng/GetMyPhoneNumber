package com.example.wangchuncheng.getmyphonenumber;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;

/**
 * Created by WangChunCheng on 2017/12/11.
 */

class MyAdapter extends BaseAdapter{
    private List<PhoneInfo> mPhoneInfoList;
    private Context mContext;
    private LinearLayout mLayout;
    public MyAdapter(List<PhoneInfo> phoneInfoList,Context context){
        this.mPhoneInfoList=phoneInfoList;
        this.mContext = context;
    }
    @Override
    public int getCount() {
        return mPhoneInfoList.size();
    }

    @Override
    public Object getItem(int position) {
        return mPhoneInfoList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        /**
         LayoutInflater inflater = LayoutInflater.from(mContext);
        mLayout = (LinearLayout) inflater.inflate(R.layout.contact_show_info,null);
        TextView nametv = mLayout.findViewById(R.id.name_tv);
        TextView numbertv = mLayout.findViewById(R.id.number_tv);
        nametv.setText(mPhoneInfoList.get(position).getName());
        numbertv.setText(mPhoneInfoList.get(position).getNumber());
         */
        //优化  滑动时不会重新加载 存储在viewHolder对象中
        ViewHolder viewHolder;
        if(convertView==null){
            convertView=LayoutInflater.from(mContext).inflate(R.layout.contact_show_info,null);
            viewHolder = new ViewHolder();
            viewHolder.nameTv = convertView.findViewById(R.id.name_tv);
            viewHolder.numberTv = convertView.findViewById(R.id.number_tv);
            viewHolder.nameTv.setText(mPhoneInfoList.get(position).getName());
            viewHolder.numberTv.setText(mPhoneInfoList.get(position).getNumber());
            convertView.setTag(viewHolder);
        }else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        return convertView;
    }
    private static class ViewHolder{
        TextView nameTv,numberTv;
    }
}
