package rishabh.example.com.fragactivitycomm;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity implements ColorFragment.ColorChanger{

    LinearLayout linearLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        FragmentManager fragmentManager=getFragmentManager();
        FragmentTransaction fragmentTransaction=fragmentManager.beginTransaction();

        linearLayout=(LinearLayout)findViewById(R.id.linear_layout);

        ColorFragment colorFragment=new ColorFragment();
        fragmentTransaction.add(R.id.fragment_container,colorFragment);
        fragmentTransaction.commit();


    }

    @Override
    public void colorchange(String color) {
        switch (color){
            case "blue": linearLayout.setBackgroundColor(Color.BLUE);
                break;
            case "green": linearLayout.setBackgroundColor(Color.GREEN);
                break;
            case "red": linearLayout.setBackgroundColor(Color.RED);
                break;
        }
    }
}
