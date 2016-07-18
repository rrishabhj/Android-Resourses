package rishabh.example.com.listviewcustonadaptor;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    ListView listView;
     MovieAdaptor adaptor;

    int[] movie_poster= {
            R.mipmap.poster_1,
            R.mipmap.poster_2,
            R.mipmap.poster_3,
            R.mipmap.poster_4
    };
    String[] m_name,m_rating;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView=(ListView)findViewById(R.id.list);


        m_name=getResources().getStringArray(R.array.movie_name);
        m_rating=getResources().getStringArray(R.array.movie_ratings);

        adaptor=new MovieAdaptor(getApplicationContext(),R.layout.raw_layout);
        listView.setAdapter(adaptor);

        for(int i=0;i<4;i++){
            MovieDataProvider dataProvider=new MovieDataProvider(movie_poster[i],m_name[i],m_rating[i]);
            adaptor.add(dataProvider);

        }
    }
}
