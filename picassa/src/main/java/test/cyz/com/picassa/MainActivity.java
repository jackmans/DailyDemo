package test.cyz.com.picassa;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import test.cyz.com.picassa.fragment.CategoryFragment;
import test.cyz.com.picassa.fragment.PeopleFragment;
import test.cyz.com.picassa.fragment.PhotosFragment;

public class MainActivity extends FragmentActivity implements View.OnClickListener{

    private ImageView tv_photos;
    private ImageView tv_people;
    private ImageView tv_album;
    private LinearLayout ly_btm;
    private LinearLayout ly_photos;
    private LinearLayout ly_people;
    private LinearLayout ly_album;
    FragmentManager fragmentManager;
    private Fragment photosFragment;
    private Fragment peopleFragment;
    private Fragment categoryFragment;
    FragmentTransaction transaction;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        fragmentManager = getSupportFragmentManager();
        setSelection(0);
    }

    private void initView(){
        ly_photos = (LinearLayout) findViewById(R.id.ly_photos);
        ly_people =  (LinearLayout)findViewById(R.id.ly_people);
        ly_album =  (LinearLayout)findViewById(R.id.ly_album);
        ly_btm = (LinearLayout)findViewById(R.id.ly_btm_titleBar);
        ly_photos.setOnClickListener(this);
        ly_people.setOnClickListener(this);
        ly_album.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.ly_photos:
                setSelection(0);
                break;
            case R.id.ly_people:
                setSelection(1);
                break;
            case R.id.ly_album:
                setSelection(2);
                break;
        }
    }

    private void setSelection(int index){
        transaction = fragmentManager.beginTransaction();
        hideFragment();
        clearColor();
        switch (index){
            case 0:
                ly_photos.setSelected(true);
                if(photosFragment != null){
                    transaction.show(photosFragment);
                }
                else{
                    photosFragment =  new PhotosFragment();
                    transaction.add(R.id.fl_container, photosFragment);
                }
                break;
            case 1:
                ly_people.setSelected(true);
                if(peopleFragment != null){
                    transaction.show(peopleFragment);
                }
                else{
                    peopleFragment =  new PeopleFragment();
                    transaction.add(R.id.fl_container, peopleFragment);
                }
                break;
            case 2:
                ly_album.setSelected(true);
                if(categoryFragment != null){
                    transaction.show(categoryFragment);
                }
                else{
                    categoryFragment =  new CategoryFragment();
                    transaction.add(R.id.fl_container, categoryFragment);
                }
                break;
        }
        transaction.commit();

    }

    private void hideFragment(){
        if (photosFragment != null) {
            transaction.hide(photosFragment);
        }
        if (peopleFragment != null) {
            transaction.hide(peopleFragment);
        }
        if (categoryFragment != null) {
            transaction.hide(categoryFragment);
        }
    }


    private void clearColor(){
        ly_photos.setSelected(false);
        ly_people.setSelected(false);
        ly_album.setSelected(false);
    }


}