package rishabh.example.com.googlemapsdemo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Intent intent=new Intent(this,MapsActivity.class);
        startActivity(intent);

        //FragmentTransaction fragmentTransaction=getFragmentManager().beginTransaction();
       // fragmentTransaction.add(R.id.container,new MapsActivity());
    }
}
