package rishabh.example.com.instadict2;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final ClipboardManager cm=(ClipboardManager) this.getSystemService(CLIPBOARD_SERVICE);
        ClipboardManager.OnPrimaryClipChangedListener listener=new ClipboardManager.OnPrimaryClipChangedListener() {
            @Override
            public void onPrimaryClipChanged() {
                Log.d("mainActivity", "Clip changed");
                ClipData cd = cm.getPrimaryClip();

                String clipstring = cd.getItemAt(0).getText().toString();
                Log.d("main activity", clipstring);
                Intent i = new Intent(getApplicationContext(), DialogService.class);
                startService(i);


            }

        };

}
}
