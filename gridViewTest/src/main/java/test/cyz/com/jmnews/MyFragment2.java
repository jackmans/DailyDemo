package test.cyz.com.jmnews;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


/**
 * A simple {@link Fragment} subclass.
 */
public class MyFragment2 extends Fragment {


    public MyFragment2() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        Log.d("gridView", "Fragment2:" +  container.toString());
        return inflater.inflate(R.layout.fragment_my_fragment2, container, false);
    }

}
