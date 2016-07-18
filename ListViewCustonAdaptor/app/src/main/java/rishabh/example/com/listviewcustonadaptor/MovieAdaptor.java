package rishabh.example.com.listviewcustonadaptor;

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
 * Created by Jindal on 6/28/2016.
 */
public class MovieAdaptor extends ArrayAdapter {


    List list=new ArrayList();
    public MovieAdaptor(Context context, int resource) {
        super(context, resource);
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

    public  static class DataHandler{
        ImageView IMAGE_VIEW;
        TextView TEXT_VIEW1,TEXT_VIEW2;

    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        DataHandler handler;
        View row=convertView;

        if(row==null){

            LayoutInflater inflater=(LayoutInflater)getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            row=inflater.inflate(R.layout.raw_layout,parent,false);

            handler=new DataHandler();
            handler.IMAGE_VIEW=(ImageView)row.findViewById(R.id.imageView);
            handler.TEXT_VIEW1=(TextView)row.findViewById(R.id.textView2);
            handler.TEXT_VIEW2=(TextView)row.findViewById(R.id.textView);
            row.setTag(handler);

        }else{
            handler=(DataHandler)row.getTag();
        }
        MovieDataProvider dataProvider;
        dataProvider=(MovieDataProvider)this.getItem(position);
        handler.IMAGE_VIEW.setImageResource(dataProvider.getMovie_resourse_parameter());
        handler.TEXT_VIEW1.setText(dataProvider.getMovie_title());
        handler.TEXT_VIEW2.setText(dataProvider.getMovie_rating());



        return row;
    }
}
