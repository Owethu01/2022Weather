package owethu.nxumalo.myapplication2022;

import static android.service.controls.ControlsProviderService.TAG;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.util.Log;

import java.net.URL;

public class MainActivity extends AppCompatActivity {
private final String Tag = "AccuWeatherURL";
Fragment FiveDayWeather;
    Fragment Tide_Fragment;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FiveDayWeather = new FiveDayWeather();
        Tide_Fragment = new Tide_Fragment();


        URL accuWeatherURL = NetworkUtil.buildURL();
        Log.i(Tag, "onCreate: " + accuWeatherURL);


        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.replace(R.id.Weather_Frame, FiveDayWeather);
        transaction.commit();
    }



}