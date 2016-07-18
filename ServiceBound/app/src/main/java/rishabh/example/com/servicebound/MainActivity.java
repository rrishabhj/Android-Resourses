package rishabh.example.com.servicebound;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    MyService myService;
    TextView textView;
    Boolean bind=false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView=(TextView)findViewById(R.id.textView);


        Intent intent=new Intent(this,MyService.class);
        bindService(intent,serviceConnection,BIND_AUTO_CREATE);

    }
    public void getFmessage(View v){

        String message;
        message=myService.getFirstMessage();
        textView.setText(message);
    }
    public void getSMessage(View v){
        String message;
        message=myService.getSecondMessage();
        textView.setText(message);
    }

    ServiceConnection serviceConnection=new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {

            MyService.LocalData localData= (MyService.LocalData)iBinder;
            myService=localData.getService();
            bind=true;
        }

        @Override
        public void onServiceDisconnected(ComponentName componentName) {

            if(bind){
                unbindService(serviceConnection);
                bind=false;
            }
        }
    };

    @Override
    protected void onStop() {
        super.onStop();
        bind=false;
        unbindService(serviceConnection);
    }
}
