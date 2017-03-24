package test.cyz.com.picassa.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.GridView;

import java.util.ArrayList;
import java.util.List;

import test.cyz.com.picassa.R;
import test.cyz.com.picassa.adapter.PeopleAdapter;

/**
 * A simple {@link Fragment} subclass.
 */
public class PeopleFragment extends Fragment {

    private List<String> list = new ArrayList();

    public PeopleFragment() {
        // Required empty public constructor
    }

    private void addList(){
        list.add("中国");
        list.add("美国");
        list.add("英国");
        list.add("德国");
        list.add("俄国");
        list.add("法国");
        list.add("大人国");
        list.add("小人国");
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        FrameLayout peopleLayout = (FrameLayout) inflater.inflate(R.layout.fragment_people, container, false);
        GridView people_grid = (GridView) peopleLayout.findViewById(R.id.people_grid);
        addList();
        PeopleAdapter peopleAdapter = new PeopleAdapter(getActivity(), list, people_grid);
        people_grid.setAdapter(peopleAdapter);
        return peopleLayout;
    }

}
