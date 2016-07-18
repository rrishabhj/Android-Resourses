package g2.revise;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Button b1,b2;
    TextView text;
    int counter=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {



        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        b1=(Button)findViewById(R.id.button);
        b2=(Button)findViewById(R.id.button2);
        text=(TextView)findViewById(R.id.textView);

       b1.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               counter++;
               text.setText(""+counter);
           }
       });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                counter--;
                text.setText(""+counter);
            }
        });


    }
}
