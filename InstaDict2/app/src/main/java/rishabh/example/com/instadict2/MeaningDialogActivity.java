package rishabh.example.com.instadict2;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by Jindal on 6/28/2016.
 */
public class MeaningDialogActivity extends AppCompatActivity {

    private static final String TAG = "SlidingDrawerActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dialog);
    }


    @Override
    protected void onPause() {
        super.onPause();
        finish();
    }
}
