package rishabh.example.com.listviewcustonadaptor;

/**
 * Created by Jindal on 6/28/2016.
 */
public class MovieDataProvider {
    private int movie_resourse_parameter;
    private String movie_title;
    private String movie_rating;

    public MovieDataProvider(int movie_resourse_parameter, String movie_title, String movie_rating) {
        this.movie_resourse_parameter = movie_resourse_parameter;
        this.movie_title = movie_title;
        this.movie_rating = movie_rating;
    }

    public int getMovie_resourse_parameter() {
        return movie_resourse_parameter;
    }

    public void setMovie_resourse_parameter(int movie_resourse_parameter) {
        this.movie_resourse_parameter = movie_resourse_parameter;
    }

    public String getMovie_title() {
        return movie_title;
    }

    public void setMovie_title(String movie_title) {
        this.movie_title = movie_title;
    }

    public String getMovie_rating() {
        return movie_rating;
    }

    public void setMovie_rating(String movie_rating) {
        this.movie_rating = movie_rating;
    }
}
