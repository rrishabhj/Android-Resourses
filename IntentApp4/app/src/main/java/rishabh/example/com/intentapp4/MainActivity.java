package rishabh.example.com.intentapp4;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    Button button;
    EditText editText1,editText2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button=(Button)findViewById(R.id.button);
        editText1=(EditText)findViewById(R.id.name);
        editText2=(EditText)findViewById(R.id.mobile);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getApplicationContext(),ActivityTwo.class);

                intent.putExtra("name",editText1.getText().toString());
                intent.putExtra("mob",editText2.getText().toString());
                startActivityForResult(intent,1);
            }
        });
    }
}
