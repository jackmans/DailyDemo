package test.cyz.com.jmnews;

import android.content.Context;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by M on 2016/8/31.
 */
public class CategoryAdapter extends BaseAdapter {

    private Context context;
    private List<String> cateList;
    private LayoutInflater mflater;
    private int mResource;

    public CategoryAdapter(Context context, int Resource,List<String> cateList){
        this.context = context;
        this.cateList = cateList;
        this.mResource = Resource;
        this.mflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return cateList.size();
    }

    @Override
    public Object getItem(int i) {
        return cateList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View convertView, ViewGroup viewGroup) {
        String item = (String)getItem(i);
        View view;
        if(convertView != null){
            view = convertView;
        }
        else{
            view = mflater.inflate(mResource, null);
        }
        TextView cateText = (TextView) view.findViewById(R.id.category_item);
        cateText.setText(item);
        return view;
    }
}
