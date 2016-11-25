package test.cyz.com.newsappone.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.List;
import java.util.zip.Inflater;

import test.cyz.com.newsappone.R;
import test.cyz.com.newsappone.domain.News;

/**
 * Created by M on 2016/11/22.
 */
public class ListViewAdapter extends ArrayAdapter{
    private Context c;
    private List<News> listViewNews;
    private int mResource;

    public ListViewAdapter(Context context, int resource, List<News> list) {
        super(context, resource, list);
        this.c = context;
        this.mResource = resource;
        this.listViewNews = list;
    }

    @Override
    public int getCount() {
        return listViewNews.size();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View view;
        LayoutInflater layoutInflater = LayoutInflater.from(c);
        if(convertView != null){
            view = convertView;
        }
        else{
            News selectNews = listViewNews.get(position);
            view = layoutInflater.inflate(mResource, null);
            TextView tv_title = (TextView) view.findViewById(R.id.tv_newsTitle);
            TextView tv_author = (TextView) view.findViewById(R.id.tv_news_Author);
            TextView tv_time = (TextView) view.findViewById(R.id.tv_newsTime);
            tv_title.setText(selectNews.getTitle());
            tv_title.setTextSize(15);
            tv_author.setText(selectNews.getAuthor());
            tv_time.setText((CharSequence) selectNews.getTime());

        }

        return view;
    }
}
