package rishabh.example.com.mysunshine2;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Jindal on 7/13/2016.
 */
public class WeatherListAdaptor extends ArrayAdapter {
    List<SunshineData> list=new ArrayList();
    public WeatherListAdaptor(Context context, int resource) {
        super(context, resource);
    }


    class DataHandler{
        TextView low_temp,high_temp,day,forcast;
        ImageView forcast_icon;
    }
    @Override
    public void add(Object object) {
        super.add(object);
        list.add((SunshineData) object);
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
            row=inflater.inflate(R.layout.raw_layout_list,parent,false);

            handler=new DataHandler();
            handler.day=(TextView)row.findViewById(R.id.list_item_day_textview);
            handler.forcast=(TextView)row.findViewById(R.id.list_item_forcast_textview);
            handler.low_temp=(TextView)row.findViewById(R.id.list_item_low_textview);
            handler.high_temp=(TextView)row.findViewById(R.id.list_item_high_textview);
            handler.forcast_icon=(ImageView)row.findViewById(R.id.list_item_icon);

            row.setTag(handler);
        }else{
            handler=(DataHandler)row.getTag();
        }
        SunshineData sunshineData=(SunshineData) this.getItem(position);
        handler.day.setText(sunshineData.getDay());
        handler.forcast.setText(sunshineData.getForcast());
        handler.low_temp.setText(sunshineData.getLow_temp());;
        handler.high_temp.setText(sunshineData.getHigh_temp());
        handler.forcast_icon.setImageBitmap(sunshineData.getForcast_icon_resource());

        return row;
    }

}
