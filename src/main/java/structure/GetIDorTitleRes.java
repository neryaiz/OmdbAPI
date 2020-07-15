package structure;

import java.net.URL;

public class GetIDorTitleRes {
    public String title;
    public String year;
    public String imdbID;
    public String type;
    public String plot;
    public URL poster;


    public GetIDorTitleRes(String title, String year, String imdbID, String type, String plot, URL poster) {
        this.title = title;
        this.year = year;
        this.imdbID = imdbID;
        this.type = type;
        this.plot = plot;
        this.poster = poster;
    }

    @Override
    public String toString() {
        return "GetIDorTitleRes to implement";
    }
}
