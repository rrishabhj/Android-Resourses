package rishabh.example.com.intentapp4;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

public class ActivityTwo extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activity_two);

        Intent intent=getIntent();
        Bundle bundle=intent.getExtras();
        Toast.makeText(getApplicationContext(),bundle.getString("name")+":name",Toast.LENGTH_SHORT).show();
    }
}
