package test.cyz.com.jmnews;


import android.os.Bundle;

import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


public class MyFragment1 extends Fragment {

    public MyFragment1() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        Log.d("gridView", "Fragment1:" +  container.toString());
        return inflater.inflate(R.layout.fragment_my_fragment1, container, false);
    }



}
