package rishabh.example.com.listviewcustomadaptor2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    ListView listView;
    CustomAdaptor adaptor;
    String[] l_string,s_string;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView=(ListView)findViewById(R.id.list);
        l_string=getResources().getStringArray(R.array.large_string);
        s_string=getResources().getStringArray(R.array.small_string);

        adaptor=new CustomAdaptor(getApplicationContext(),R.layout.raw_layout);
        listView.setAdapter(adaptor);

        for(int i=0;i<3;i++){
            DataProvider dataProvider=new DataProvider(l_string[i],s_string[i]);
            adaptor.add(dataProvider);
        }
    }
}
