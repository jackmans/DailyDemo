package test.cyz.com.picassa.adapter;


import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import test.cyz.com.picassa.MyImageView;
import test.cyz.com.picassa.R;
import test.cyz.com.picassa.bean.ImageBean;

/**
 * A simple {@link Fragment} subclass.
 */
public class PeopleAdapter extends BaseAdapter{

    private List<String> list;
    private LayoutInflater inflater;
    private GridView gridView;
    private Context context;

    public PeopleAdapter(Context context, List list, GridView gridView){
        this.context = context;
        this.list = list;
        this.gridView = gridView;
        inflater = LayoutInflater.from(context);
    }


    @Override
    public Object getItem(int i) {
        return list.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup viewGroup) {
        final ViewHolder viewHolder;
//        String path = mImageBean.getImagePath();
        if(convertView == null){
            viewHolder = new ViewHolder();
            convertView = inflater.inflate(R.layout.layout_people_item, null);
            viewHolder.mImageView = (MyImageView) convertView.findViewById(R.id.people_image);
            convertView.setTag(viewHolder);
        }else{
            viewHolder = (PeopleAdapter.ViewHolder) convertView.getTag();
            viewHolder.mImageView.setImageResource(R.drawable.friends_sends_pictures_no);
        }
        viewHolder.mImageView.setImageResource(R.drawable.arrow);
        return convertView;
    }

    public static class ViewHolder{
        public MyImageView mImageView;
        public TextView mTextViewTitle;
        public TextView mTextViewCounts;
    }


}