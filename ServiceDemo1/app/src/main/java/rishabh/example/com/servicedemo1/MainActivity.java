package rishabh.example.com.servicedemo1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void startSer(View view){
        Intent i=new Intent(this,MyServices.class);
        startService(i);
    }
    public void stopSer(View view){
        Intent i=new Intent(this,MyServices.class);
        stopService(i);
    }
}
