package test.cyz.com.picassa.adapter;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Point;
import android.util.Log;
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
import test.cyz.com.picassa.util.NativeImageLoader;

/**
 * Created by M on 2017/3/21.
 */
public class PhotosAdapter extends BaseAdapter {

    private List<ImageBean> list;
//    private List ilist;
    private GridView gridView;
    private LayoutInflater mInflater;
    private Point mPoint = new Point(0, 0);
    private Context context;

    public PhotosAdapter(Context context, List<ImageBean> list, GridView mGridView){
        this.context = context;
        this.list = list;
        this.gridView = mGridView;
        mInflater = LayoutInflater.from(context);
    }

    public PhotosAdapter(){};

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
        ImageBean mImageBean = list.get(position);
        String path = mImageBean.getImagePath();
        if(convertView == null){
            viewHolder = new ViewHolder();
            convertView = mInflater.inflate(R.layout.layout_photos_item, null);
            viewHolder.mImageView = (MyImageView) convertView.findViewById(R.id.photo);

//            viewHolder.mTextViewTitle = (TextView) convertView.findViewById(R.id.group_title);
//            viewHolder.mTextViewCounts = (TextView) convertView.findViewById(R.id.group_count);

            //用来监听ImageView的宽和高
            viewHolder.mImageView.setOnMeasureListener(new MyImageView.OnMeasureListener() {

                @Override
                public void onMeasureSize(int width, int height) {
                    mPoint.set(width, height);
                }
            });
            convertView.setTag(viewHolder);
        }else{
            viewHolder = (ViewHolder) convertView.getTag();
            viewHolder.mImageView.setImageResource(R.drawable.friends_sends_pictures_no);
        }

//        viewHolder.mTextViewTitle.setText(mImageBean.getFolderName());
//        viewHolder.mTextViewCounts.setText(Integer.toString(mImageBean.getImageCounts()));
        //给ImageView设置路径Tag,这是异步加载图片的小技巧
        viewHolder.mImageView.setTag(path);


       // 利用NativeImageLoader类加载本地图片
        Bitmap bitmap = NativeImageLoader.getInstance().loadNativeImage(path, new NativeImageLoader.NativeImageCallBack() {

            @Override
            public void onImageLoader(Bitmap bitmap, String path) {
                ImageView mImageView = (ImageView) gridView.findViewWithTag(path);
                if(bitmap != null && mImageView != null){
                    mImageView.setImageBitmap(bitmap);
                }
            }
        });

        if(bitmap != null){
            viewHolder.mImageView.setImageBitmap(bitmap);
        }else{
            viewHolder.mImageView.setImageResource(R.drawable.friends_sends_pictures_no);
            Log.d("picassa","bitmap为空");
        }

//        Bitmap bitmap = BitmapFactory.decodeFile(path);
//        viewHolder.mImageView.setImageBitmap(bitmap);
//        Picasso.with(context).load(path).into(viewHolder.mImageView);
        return convertView;

    }

    public static class ViewHolder{
        public MyImageView mImageView;
        public TextView mTextViewTitle;
        public TextView mTextViewCounts;
    }


}
