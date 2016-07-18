package rishabh.example.com.fragmentbasic;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

/**
 * Created by Jindal on 6/27/2016.
 */
public class FragmentOne extends Fragment {

    ListView listView;
    ArrayAdapter arrayAdapter;
    String[] version;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v=inflater.inflate(R.layout.fragment_one_layout,container,false);

        version=getResources().getStringArray(R.array.android_version);

        arrayAdapter=new ArrayAdapter(getActivity(),R.layout.raw_layout,R.id.textView,version);
        listView=(ListView) v.findViewById(R.id.listView);
        listView.setAdapter(arrayAdapter);

        return v;
    }
}
