package rishabh.example.com.experiment1;

import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        IntentFilter filter = new IntentFilter( Intent.ACTION_SCREEN_ON );
        filter.addAction( Intent.ACTION_SCREEN_OFF );
        registerReceiver(new ScreenReceiver(), filter);
    }


}
