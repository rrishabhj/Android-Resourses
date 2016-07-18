package g2.calculator;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);





    }
    public void showToast(){
        Toast toast=Toast.makeText(this,"calculator in progress",Toast.LENGTH_SHORT);
        toast.show();
    }
}
