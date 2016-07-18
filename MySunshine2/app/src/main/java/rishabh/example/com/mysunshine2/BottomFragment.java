package rishabh.example.com.mysunshine2;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;


public class BottomFragment extends Fragment {

    ListView listView;
    WeatherListAdaptor weatherListAdaptor;
    String[] data = {
            "Mon 6/23 - Sunny - 31/17",
            "Tue 6/24 - Foggy - 21/8",
            "Wed 6/25 - Cloudy - 22/17",
            "Thurs 6/26 - Rainy - 18/11",
            "Fri 6/27 - Foggy - 21/10",
            "Sat 6/28 - TRAPPED IN WEATHERSTATION - 23/18",
            "Sun 6/29 - Sunny - 20/7"
    };
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_bottom, container, false);
        listView=(ListView)view.findViewById(R.id.listview);
        weatherListAdaptor=new WeatherListAdaptor(getContext(),R.layout.raw_layout_list);
        listView.setAdapter(weatherListAdaptor);
        setListData();
        return view;
    }
    void setListData(){

        for(int i=0;i<3;i++){
            Bitmap bitmap= BitmapFactory.decodeResource(getContext().getResources(),
                    R.drawable.ic_snow);
            SunshineData sunshineData=new SunshineData("17","31","MOn","sunny",bitmap);
            weatherListAdaptor.add(sunshineData);
        }
    }

}
