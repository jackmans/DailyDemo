package test.cyz.com.picassa.fragment;


import android.app.ProgressDialog;
import android.content.ContentResolver;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.provider.MediaStore;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.GridView;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import test.cyz.com.picassa.MainActivity;
import test.cyz.com.picassa.R;
import test.cyz.com.picassa.adapter.PhotosAdapter;
import test.cyz.com.picassa.bean.ImageBean;

/**
 * A simple {@link Fragment} subclass.
 */
public class PhotosFragment extends Fragment {

    private HashMap<String, List<String>> mGruopMap = new HashMap<String, List<String>>();
//    private List list = new ArrayList();
    private List<ImageBean> beanList = new ArrayList<ImageBean>();
    private final static int SCAN_OK = 1;
    private ProgressDialog mProgressDialog;
    private PhotosAdapter adapter;
    private GridView mGridView;

    public PhotosFragment() {
        // Required empty public constructor
    }

    private Handler mHandler = new Handler(){

        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what) {
                case SCAN_OK:
                    //关闭进度条
                    mProgressDialog.dismiss();
                    adapter = new PhotosAdapter(getActivity(), beanList, mGridView);
                    mGridView.setAdapter(adapter);
                    break;
            }
        }

    };


//    private void initImages() {
//        //图片
//        int [] images = {
//                R.drawable.iv_detail_back,
//                R.drawable.iv_detail_back1,
//                R.drawable.iv_detail_back2,
//                R.drawable.iv_detail_edit_128,
//                R.drawable.iv_detail_menu,
//                R.drawable.iv_main_live,
//        };
//        for(int i = 0; i < images.length; i++){
//            list.add(images[i]);
//        }
//    }

    /**
     * 利用ContentProvider扫描手机中的图片，此方法在运行在子线程中
     */
    private void getImages() {
        //显示进度条
        mProgressDialog = ProgressDialog.show(getActivity(), null, "正在加载...");

        new Thread(new Runnable() {

            @Override
            public void run() {
                Uri mImageUri = MediaStore.Images.Media.EXTERNAL_CONTENT_URI;
                ContentResolver mContentResolver =getActivity().getContentResolver();

                //只查询jpeg和png的图片
                Cursor mCursor = mContentResolver.query(mImageUri, null,
                        MediaStore.Images.Media.MIME_TYPE + "=? or "
                                + MediaStore.Images.Media.MIME_TYPE + "=?",
                        new String[] { "image/jpeg", "image/png" }, MediaStore.Images.Media.DATE_MODIFIED);

                if(mCursor == null){
                    return;
                }

                while (mCursor.moveToNext()) {
                    //获取图片的路径
                    String path = mCursor.getString(mCursor
                            .getColumnIndex(MediaStore.Images.Media.DATA));

                    //获取该图片的父路径名
                    String parentName = new File(path).getParentFile().getName();
//
//
//
//                    if (!mGruopMap.containsKey(parentName)) {              //根据父路径名将图片放入到mGruopMap中
//                        List<String> chileList = new ArrayList<String>();
//                        chileList.add(path);
//                        mGruopMap.put(parentName, chileList);
//                    } else {
//                        mGruopMap.get(parentName).add(path);
//                    }
                    ImageBean image = new ImageBean(path);
                    beanList.add(image);
                }
                Log.d("picassa", beanList.toString());
                //通知Handler扫描图片完成
                mHandler.sendEmptyMessage(SCAN_OK);
                mCursor.close();
            }
        }).start();

    }

//    /**
//     * 组装分组界面GridView的数据源，因为我们扫描手机的时候将图片信息放在HashMap中
//     * 所以需要遍历HashMap将数据组装成List
//     *
//     * @param mGruopMap
//     * @return
//     */
//    private List<ImageBean> subGroupOfImage(HashMap<String, List<String>> mGruopMap){
//        if(mGruopMap.size() == 0){
//            return null;
//        }
//        List<ImageBean> list = new ArrayList<ImageBean>();
//
//        Iterator<Map.Entry<String, List<String>>> it = mGruopMap.entrySet().iterator();
//        while (it.hasNext()) {
//            Map.Entry<String, List<String>> entry = it.next();
//            ImageBean mImageBean = new ImageBean();
//            String key = entry.getKey();
//            List<String> value = entry.getValue();
//
//            mImageBean.setFolderName(key);
//            mImageBean.setImageCounts(value.size());
//            mImageBean.setImagePath(value.get(0));//获取该组的第一张图片
//
//            list.add(mImageBean);
//        }
//
//        return list;
//
//    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        FrameLayout frameLayout = (FrameLayout) inflater.inflate(R.layout.fragment_photos, container, false);
        mGridView = (GridView)frameLayout.findViewById(R.id.photo_grid);
        getImages();
//        initImages();
        return frameLayout;
    }

}
