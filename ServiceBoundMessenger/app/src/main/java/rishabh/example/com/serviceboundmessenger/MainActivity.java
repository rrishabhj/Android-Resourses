package rishabh.example.com.serviceboundmessenger;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    Boolean bind=false;
    Messenger messenger;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void bindSer(View view){
        Intent intent=new Intent(this,MyServices.class);
        bindService(intent,serviceConnection,BIND_AUTO_CREATE);

    }
    public void sayHello(View view){
        switch (view.getId()){
            case R.id.button2:
                    Message message=Message.obtain(null,MyServices.JOB_1,0,0);
                try {
                    messenger.send(message);
                } catch (RemoteException e) {
                    e.printStackTrace();
                }
                break;
            case R.id.button3:
                Message message2=Message.obtain(null,MyServices.JOB_1,0,0);
                try {
                    messenger.send(message2);
                } catch (RemoteException e) {
                    e.printStackTrace();
                }
                break;
        }
    }
    ServiceConnection serviceConnection=new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
           messenger=new Messenger(iBinder);
            bind=true;
        }

        @Override
        public void onServiceDisconnected(ComponentName componentName) {

            unbindService(serviceConnection);
            bind=false;
        }
    };
}
