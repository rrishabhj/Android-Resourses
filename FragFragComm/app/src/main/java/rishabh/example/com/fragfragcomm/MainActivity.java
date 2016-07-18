package rishabh.example.com.fragfragcomm;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements FragmentOne.SendNameface{


    FragmentTwo fragmentTwo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    @Override
    public void setName(String message) {
        fragmentTwo=(FragmentTwo)getFragmentManager().findFragmentById(R.id.frag_two);
        fragmentTwo.updateName(message);
    }
}
