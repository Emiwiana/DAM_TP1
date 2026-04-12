package dam_A51635.coolweatherapp

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.google.gson.Gson
import java.io.InputStreamReader
import java.net.URL

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        fetchWeatherData(38.72f, 9.15f)
    }

    var day = true

    private fun WeatherAPI_Call ( lat: Float , long : Float ) : WeatherData {
        val reqString = buildString {
            append("https://api.open-meteo.com/v1/forecast?")
            append("latitude=${lat}&longitude=${long}&")
            append("current_weather=true &")
            append("hourly=temperature_2m,weathercode,pressure_msl,windspeed_10m ")
        }
        val url = URL(reqString);
        url.openStream().use {
            val request = Gson().fromJson (InputStreamReader(it, "UTF-8"), WeatherData :: class.java )
            return request
        }
    }

    private fun fetchWeatherData (lat: Float , long : Float ) : Thread {
        return Thread {
            val weather = WeatherAPI_Call (lat , long )
            updateUI(weather)
        }
    }

    @SuppressLint("SetTextI18n", "UseCompatLoadingForDrawables")
    private fun updateUI (request : WeatherData ) {
        runOnUiThread {
            //val weatherImage : ImageView = findViewById(R.id.weatherImage )

            val pressure : TextView = findViewById(R.id.pressureValue)
            val windSpeed : TextView = findViewById(R.id.windSpeedValue)
            val windDirection : TextView = findViewById(R.id.windDirectionValue)
            val temperature : TextView = findViewById(R.id.temperatureValue)
            val time : TextView = findViewById(R.id.timeValue)

            pressure.text = request.hourly.pressure_msl[12].toString()+ " hPa"
            windSpeed.text = request.current_weather.windspeed.toString()+ " km/H"
            windDirection.text = request.current_weather.winddirection.toString()
            temperature.text = request.current_weather.temperature.toString()+ " ºC"
            time.text = request.current_weather.time

            /*
            // TODO ...
            val mapt = getWeatherCodeMap ();
            val wCode = mapt[request.current_weather.weathercode]
            val wImage = when (wCode) {
                WMO_WeatherCode.CLEAR_SKY,
                WMO_WeatherCode.MAINLY_CLEAR,
                WMO_WeatherCode.PARTLY_CLOUDY ->if(day) wCode?. image +"day" else
                    wCode?.image +"night"
                else -> wCode?.image
            }
            val res = getResources ()
            weatherImage.setImageResource(R.drawable.fog)
            val resID = res.getIdentifier (wImage , " drawable ", getPackageName ());
            val drawable = this.getDrawable (resID);
            weatherImage.setImageDrawable (drawable);
            // TODO ...
            */
        }
    }
}