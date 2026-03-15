package dam_a51635.helloworldoptional

import android.os.Build
import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val systemInfo = findViewById<TextView>(R.id.systemInfo)
        val info = getString(
            R.string.system_info_template,
            Build.MANUFACTURER,
            Build.MODEL,
            Build.BRAND,
            Build.TYPE,
            Build.USER,
            Build.VERSION.BASE_OS.ifEmpty { "1" },
            Build.VERSION.INCREMENTAL,
            Build.VERSION.SDK_INT,
            Build.VERSION.RELEASE,
            Build.DISPLAY
        )
        systemInfo.text = info

    }
}