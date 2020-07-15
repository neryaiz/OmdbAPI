package structure;

import java.net.URL;

public class SearchRes {
    public String title;
    public String year;
    public String imdbID;
    public String type;
    public URL poster;

    public SearchRes(String title, String year, String imdbID, String type, URL poster) {
        this.title = title;
        this.year = year;
        this.imdbID = imdbID;
        this.type = type;
        this.poster = poster;
    }

    @Override
    public String toString() {
        return "SearchRes to implement";
    }
}
