package owethu.nxumalo.myapplication2022;

import android.content.Context;
import android.net.Uri;
import android.util.Log;
import android.widget.Toast;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

public class NetworkUtil {

   private final static String Base_URL = "http://dataservice.accuweather.com/forecasts/v1/daily/5day/305605";
   private final static String API_KEY = "CoirbFMSayYVQQrQfI2eLZWl3mUx86ie";
   private final static String PARAM_API_KEY = "apikey";
   private static final String METRIC_PARAM = "metric";
    private static final String METRIC_VALUE = "true";
     private static String TAG = "Network_Util";

    public static URL buildURL()
    {
        Uri uri = Uri.parse(Base_URL)
        .buildUpon()
                .appendQueryParameter(PARAM_API_KEY, API_KEY)
                .appendQueryParameter(METRIC_PARAM, METRIC_VALUE)
                .build();

        URL url = null;

        try {
            url = new URL((uri).toString());
        } catch (MalformedURLException e) {
            e.printStackTrace();

            //Toast.makeText()
        }

        return url;
    }
public static String getResponse(URL url) throws IOException {  HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
    try {
       // HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
        InputStream in = httpURLConnection.getInputStream();
        Scanner scanner = new Scanner(in);

        scanner.useDelimiter("//A");

        boolean hasInput = scanner.hasNext();

        if(hasInput)
        {
            return scanner.next();
        }
        else
        {
            Log.i(TAG, "getResponse: " + scanner.next());

            return null;
        }
    }
    finally {
        httpURLConnection.disconnect();

    }

    }
}
