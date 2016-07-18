package rishabh.example.com.mysunshine;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Jindal on 7/13/2016.
 */
public class WeatherListAdaptor extends ArrayAdapter {
    List<DataProvider> list=new ArrayList();
    public WeatherListAdaptor(Context context, int resource) {
        super(context, resource);
    }


    class DataHandler{
        TextView day,type,minTemp,maxTemp;
    }
    @Override
    public void add(Object object) {
        super.add(object);
        list.add((DataProvider)object);
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
            handler.day=(TextView)row.findViewById(R.id.dayh);
            handler.type=(TextView)row.findViewById(R.id.type);
            handler.minTemp=(TextView)row.findViewById(R.id.minTemp);
            handler.manTemp=(TextView)row.findViewById(R.id.maxTemp);

            row.setTag(handler);
        }else{
            handler=(DataHandler)row.getTag();
        }
        DataProvider dataProvider=(DataProvider)this.getItem(position);
        handler.day.setText(dataProvider.getDay());
        handler.type.setText(dataProvider.getType());
        handler.minTemp.setText(dataProvider.getMinTemp());
        handler.maxTemp.setText(dataProvider.getMaxTemp());

        return row;
    }

}
