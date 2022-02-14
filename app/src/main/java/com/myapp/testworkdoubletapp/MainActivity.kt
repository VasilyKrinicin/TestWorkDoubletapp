package com.myapp.testworkdoubletapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.myapp.testworkdoubletapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    var countConfigurate = 0
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        Log.i(TAG, "massage onCreate ${hashCode()}")
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        if (savedInstanceState != null) {
            countConfigurate = savedInstanceState.getInt(KEY)
        }
        binding.buttonCreateSecondActivity.setOnClickListener {
           /* val sendIntent = Intent(
                this, SecondActivity::class.java
            ).apply {
                val bundle = Bundle().apply { putInt(KEY, countConfigurate) }
                putExtras(bundle)
            }
            startActivity(sendIntent)*/
         startActivity(SecondActivity.getIntent(this, countConfigurate))

    }

}

override fun onResume() {
    binding.TextViewCount.text = countConfigurate.toString()
    Log.i(TAG, "massage onResume ${hashCode()}")
    super.onResume()

}

override fun onStop() {
    Log.i(TAG, "massage onStop ${hashCode()}")
    super.onStop()

}

override fun onStart() {
    Log.i(TAG, "massage onStart ${hashCode()}")
    super.onStart()
}

override fun onPause() {
    Log.i(TAG, "massage onPause ${hashCode()}")
    super.onPause()
}

override fun onSaveInstanceState(outState: Bundle) {
    super.onSaveInstanceState(outState)
    outState.putInt(KEY, countConfigurate)
    Log.i(TAG, "massage onSaveInstanceState ${hashCode()}")
}

override fun onRestoreInstanceState(savedInstanceState: Bundle) {
    super.onRestoreInstanceState(savedInstanceState)
    countConfigurate = savedInstanceState.getInt(KEY) + 1
    Log.i(TAG, "massage onRestoreInstanceState ${hashCode()}")
}

override fun onDestroy() {
    Log.i(TAG, "massage onDestroy ${hashCode()}")
    super.onDestroy()
}

companion object {
    private const val KEY = "1234"
    private const val TAG = "MainActivity"
}
}
