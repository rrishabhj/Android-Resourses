package rishabh.example.com.listviewcustomadaptor2;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Jindal on 6/28/2016.
 */
public class CustomAdaptor extends ArrayAdapter {
    List list=new ArrayList();

    public CustomAdaptor(Context context, int resource) {
        super(context, resource);
    }

    class DataHandler{
        TextView small,large;
    }
    @Override
    public void add(Object object) {
        super.add(object);
        list.add(object);
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View row=convertView;
        DataHandler handler;
        if(row==null){
            LayoutInflater inflater=(LayoutInflater)getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            row=inflater.inflate(R.layout.raw_layout,parent,false);

            handler=new DataHandler();
            handler.large=(TextView)row.findViewById(R.id.textView);
            handler.small=(TextView)row.findViewById(R.id.textView2);
            row.setTag(handler);
        }else{
            handler=(DataHandler)row.getTag();
        }
        DataProvider dataProvider=(DataProvider)this.getItem(position);
        handler.large.setText(dataProvider.getSmall());
        handler.small.setText(dataProvider.getLarge());
        return row;
    }
}
