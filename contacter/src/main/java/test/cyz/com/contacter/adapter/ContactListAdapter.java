package test.cyz.com.contacter.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import java.util.ArrayList;
import java.util.List;

import test.cyz.com.contacter.bean.ContactBean;

/**
 * Created by M on 2017/1/12.
 */
public class ContactListAdapter extends ArrayAdapter {

    private List<ContactBean> list;
    private Context ct;
    private int listItem;

    public ContactListAdapter(Context context, int resource, List objects) {
        super(context, resource, objects);
        this.ct = context;
        this.listItem = resource;
        this.list = objects;

    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return super.getItem(position);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {



        return super.getView(position, convertView, parent);
    }


}
