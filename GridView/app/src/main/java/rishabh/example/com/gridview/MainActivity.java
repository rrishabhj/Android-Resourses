package rishabh.example.com.gridview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.GridView;

public class MainActivity extends AppCompatActivity {

    GridView gridView;
    ArrayAdapter<String> baseAdapter;

    String icons[];
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        gridView=(GridView)findViewById(R.id.gridView);
        icons=getResources().getStringArray(R.array.icon_name);
        baseAdapter=new ArrayAdapter<String>(this,R.layout.raw_layout,R.id.textView,icons);
        gridView.setAdapter(baseAdapter);
    }
}
