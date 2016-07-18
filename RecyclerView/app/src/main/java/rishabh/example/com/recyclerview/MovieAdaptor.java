package rishabh.example.com.recyclerview;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Jindal on 7/12/2016.
 */
public class MovieAdaptor extends RecyclerView.Adapter<MovieAdaptor.MyViewHolder> {

    private List<Movie> movielist;
    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.raw_recycler_layout,parent,false);

        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        Movie movie=movielist.get(position);
        holder.title.setText(movie.getTitle());
        holder.genre.setText(movie.getGenre());
        holder.year.setText(movie.getYear());

    }

    @Override
    public int getItemCount() {
        return movielist.size();
    }

    public MovieAdaptor(List<Movie> movielist) {
        this.movielist = movielist;
    }

    class MyViewHolder extends RecyclerView.ViewHolder{

        TextView title,genre,year;
        public MyViewHolder(View itemView) {
            super(itemView);
            title=(TextView)itemView.findViewById(R.id.title);
            genre=(TextView)itemView.findViewById(R.id.genre);
            year=(TextView)itemView.findViewById(R.id.year);
        }
    }


}
