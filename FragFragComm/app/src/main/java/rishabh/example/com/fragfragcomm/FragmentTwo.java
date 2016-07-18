package rishabh.example.com.fragfragcomm;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by Jindal on 6/29/2016.
 */
public class FragmentTwo extends Fragment {
   TextView textView;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view;
        view=inflater.inflate(R.layout.fragment_two_layout,container,false);
        textView=(TextView)view.findViewById(R.id.textDisplay);

        return view;
    }

    public void updateName(String message){
        textView.setText(message);
    }
}
