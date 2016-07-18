package rishabh.example.com.fragfragcomm;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

/**
 * Created by Jindal on 6/29/2016.
 */
public class FragmentOne extends Fragment {
    SendNameface sendNameface;
    EditText editText;
    Button button;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v;
        v=inflater.inflate(R.layout.fragment_one_layout,container,false);
        editText=(EditText)v.findViewById(R.id.display_name);
        button=(Button)v.findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String message=editText.getText().toString();
                sendNameface.setName(message);
            }
        });
        return v;
    }

    public interface SendNameface{
        public void setName(String message);
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            sendNameface = (SendNameface) activity;
        }catch (ClassCastException e){
            e.printStackTrace();
        }
    }
}
