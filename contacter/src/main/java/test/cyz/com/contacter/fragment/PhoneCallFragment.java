package test.cyz.com.contacter.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import test.cyz.com.contacter.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class PhoneCallFragment extends Fragment {


    public PhoneCallFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_phone_call, container, false);
    }

}