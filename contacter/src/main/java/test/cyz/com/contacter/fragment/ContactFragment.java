package test.cyz.com.contacter.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.RelativeLayout;

import java.util.ArrayList;
import java.util.List;

import test.cyz.com.contacter.R;
import test.cyz.com.contacter.adapter.ContactListAdapter;
import test.cyz.com.contacter.bean.ContactBean;


public class ContactFragment extends Fragment {
    private RelativeLayout relativeLayout;
    private ListView lv_contact;
    List<ContactBean> listBean = new ArrayList<ContactBean>();


    @Override
    public View onCreateView(LayoutInflater inflater,  ViewGroup container,  Bundle savedInstanceState) {

        RelativeLayout relativeLayout = (RelativeLayout) inflater.inflate(R.layout.fragment_contact, container);
        lv_contact = (ListView) relativeLayout.findViewById(R.id.lv_contact_list);
        ContactListAdapter contactListAdapter = new ContactListAdapter(getActivity(), R.layout.contact_list_item, listBean);

        return null;
    }
}