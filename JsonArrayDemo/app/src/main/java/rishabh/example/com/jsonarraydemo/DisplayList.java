package rishabh.example.com.jsonarraydemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

public class DisplayList extends AppCompatActivity {

    RecyclerView recyclerView;
    ArrayList<Contact> arrayList;
    RecyclerView.Adapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_list);
        recyclerView=(RecyclerView)findViewById(R.id.recyclerview);
        RecyclerView.LayoutManager layoutManager=new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);
        BackgroundTask backgroundTask=new BackgroundTask(DisplayList.this);
        arrayList=backgroundTask.getList();
        adapter=new RecyclerViewAdaptor(arrayList);
        recyclerView.setAdapter(adapter);
    }
}
