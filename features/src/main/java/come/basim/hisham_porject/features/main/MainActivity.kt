package come.basim.hisham_porject.features.main

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import come.basim.hisham_porject.features.R
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}