package rishabh.example.com.myapplication;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }
    
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        switch(keyCode){
            case KeyEvent.KEYCODE_MENU:
                Toast.makeText(this, "Menu key pressed", Toast.LENGTH_SHORT).show();
                return true;
            case KeyEvent.KEYCODE_SEARCH:
                Toast.makeText(this, "Search key pressed", Toast.LENGTH_SHORT).show();
                return true;
            case KeyEvent.KEYCODE_BACK:
                onBackPressed();
                return true;
            case KeyEvent.KEYCODE_VOLUME_UP:
                event.startTracking();
                return true;
            case KeyEvent.KEYCODE_VOLUME_DOWN:
                Toast.makeText(this,"Volumen Down pressed", Toast.LENGTH_SHORT).show();
                return false;
        }
        return super.onKeyDown(keyCode, event);
    }
    @Override
    public boolean onKeyUp(int keyCode, KeyEvent event) {
        switch(keyCode){
            case KeyEvent.KEYCODE_MENU:
                Toast.makeText(this, "Menu key released", Toast.LENGTH_SHORT).show();
                return true;
            case KeyEvent.KEYCODE_SEARCH:
                Toast.makeText(this, "Search key released", Toast.LENGTH_SHORT).show();
                return true;
           /* case KeyEvent.KEYCODE_VOLUME_UP:
            ​
                if(event.isTracking() && !event.isCanceled())
                    Toast.makeText(this, "Volumen Up released", Toast.LENGTH_SHORT).show();
                return true;*/
            case KeyEvent.KEYCODE_VOLUME_DOWN:
                Toast.makeText(this, "Volumen Down released", Toast.LENGTH_SHORT).show();
                return true;
        }
        return super.onKeyDown(keyCode, event);
    }

    @Override
    public boolean onKeyLongPress(int keyCode, KeyEvent event) {
        Toast.makeText(this, "Pressed for a long time =) ", Toast.LENGTH_SHORT).show();
        return true;
    }
    @Override
    public void onBackPressed() {
        Toast.makeText(this, "Back key pressed =)", Toast.LENGTH_SHORT).show();
        super.onBackPressed();
    }
    @Override
    public boolean onTouchEvent(MotionEvent event) {
        float x = event.getX();
        float y = event.getY();
        Toast.makeText(this, "Touch press on x: " + x + " y: "+y, Toast.LENGTH_SHORT).show();
        return true;
    }

}
