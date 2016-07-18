package rishabh.example.com.listviewbasic;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    ListView listView;
    ArrayAdapter arrayAdapter;
    String[] version={
           " Android 1.6. Donut.",
            "Android 2.1. Eclair.",
            "Android 2.2. Froyo.",
            "Android 2.3. Gingerbread.",
           " Android 3.0. Honeycomb.",
           " Android 4.0. Ice Cream Sandwic,h.",
            "Android 4.1. Jelly Bean.",
            "Android 4.4. KitKat."

    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        listView=(ListView)findViewById(R.id.list);
        arrayAdapter=new ArrayAdapter(getApplicationContext(),R.layout.raw_list_layout,R.id.misterytext,version);
        listView.setAdapter(arrayAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getBaseContext(),parent.getItemAtPosition(position)+":selected item",Toast.LENGTH_SHORT).show();
            }
        });
    }
}
