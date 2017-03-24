package test.cyz.com.newsappone.fragment;


import android.content.Intent;
import android.os.Bundle;

import android.support.v4.app.Fragment;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Switch;

import test.cyz.com.newsappone.R;
import test.cyz.com.newsappone.SettingLoginActivity;

/**
 * A simple {@link Fragment} subclass.
 */
public class SettingFragment extends Fragment implements View.OnClickListener{

    LinearLayout ly_settingFrag;

    public SettingFragment() {

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        ly_settingFrag = (LinearLayout) inflater.inflate(R.layout.fragment_setting, container, false);
        ImageView iv_email = (ImageView)ly_settingFrag.findViewById(R.id.iv_email);
        iv_email.setOnClickListener(this);
        return ly_settingFrag;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.iv_email:
                Intent intent = new Intent();
                intent.setClass(getActivity(), SettingLoginActivity.class);
                startActivity(intent);
                getActivity().overridePendingTransition(android.R.anim.slide_in_left, android.R.anim.slide_out_right);
                break;
            default:
                break;
        }
    }
}
