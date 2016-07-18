package rishabh.example.com.upbutton;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class Main2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        getActionBar().setDisplayShowHomeEnabled(true);
    }

    public void child2(View view) {

        startActivity(new Intent(getApplicationContext(),Main3Activity.class));

    }
}
