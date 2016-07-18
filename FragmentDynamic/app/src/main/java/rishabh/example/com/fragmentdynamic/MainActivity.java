package rishabh.example.com.fragmentdynamic;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView=(TextView)findViewById(R.id.new_user);

        FragmentManager fragmentManager=getFragmentManager();
        FragmentTransaction fragmentTransaction=fragmentManager.beginTransaction();
        LoginFragment loginFragment=new LoginFragment();
        fragmentTransaction.add(R.id.fragment_container,loginFragment);
        fragmentTransaction.commit();
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager fragmentManager=getFragmentManager();
                FragmentTransaction fragmentTransaction=fragmentManager.beginTransaction();
                RegisterFragment registerFragment=new RegisterFragment();
                fragmentTransaction.replace(R.id.fragment_container,registerFragment);
                fragmentTransaction.commit();
            }
        });
    }
}
