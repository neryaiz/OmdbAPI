import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import org.json.JSONObject;
import structure.SearchRes;
import structure.GetIDorTitleRes;

public class OmdbApi {

    final String MYURL = "http://www.omdbapi.com/?";
    final String API_KEY = "apikey=772f549d";
    final String AMPERSAND = "&";
    int statusExpected = 0;
    static JSONObject res;
    //String reqExample = "http://www.omdbapi.com/?apikey=772f549d&i=tt0111161";

    public static GetIDorTitleRes sendGetIDorTitleRequest(String req, int statusExpected) throws Exception{
        GetIDorTitleRes getIDorTitleRes = null;
        try {
            res = OmdbApi.transport(req, statusExpected);
            //[ToDo] casting from Json to struct

        } catch (Exception e) {
            e.printStackTrace();
        }
        return getIDorTitleRes;
    }

    public static SearchRes sendSearchRequest(String req, int statusExpected) throws Exception{
        SearchRes searchRes = null;
        try {
            res = OmdbApi.transport(req, statusExpected);
            //[ToDo] casting from Json to struct

        } catch (Exception e) {
            e.printStackTrace();
        }
        return searchRes;
    }

    public static JSONObject transport(String req, int statusExpected) throws Exception {
        statusExpected = statusExpected != 0 ? statusExpected : 200; //For positive tests the status is 200
        String url = req;
        URL obj = new URL(url);
        HttpURLConnection con = (HttpURLConnection) obj.openConnection();
        // optional default is GET
        con.setRequestMethod("GET");
        //add request header
        con.setRequestProperty("User-Agent", "Mozilla/5.0");
        int responseCode = con.getResponseCode();

        if (!validateStatus(con.getResponseCode(),statusExpected)){
            throw new Exception("Test failed.");
        }
        System.out.println("\nSending 'GET' request to URL : " + url);
        System.out.println("Response Code : " + responseCode);
        BufferedReader in = new BufferedReader(
                new InputStreamReader(con.getInputStream()));
        String inputLine;
        StringBuffer response = new StringBuffer();
        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        in.close();

        //print in String
        System.out.println(response.toString());

        //Read JSON response and print
        JSONObject myResponse = new JSONObject(response.toString());
        System.out.println("result after Reading JSON Response");
        System.out.println("statusCode- "+myResponse.getString("statusCode"));
        System.out.println("statusMessage- "+myResponse.getString("statusMessage"));

        return myResponse;
    }

    public static boolean validateStatus(int resStatus, int expectedStatus){
        if (resStatus != expectedStatus){
            System.out.println("The Status received: " + resStatus +" is not as expected: " + expectedStatus);
            return false;
        }
        return true;
    }

    //[ToDo] create func that validate the data

    //[ToDo] create func that validate the poster link
}

