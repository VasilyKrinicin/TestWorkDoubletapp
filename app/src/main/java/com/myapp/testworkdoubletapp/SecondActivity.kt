package com.myapp.testworkdoubletapp

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.myapp.testworkdoubletapp.databinding.ActivitySecondBinding
import kotlin.math.pow

class SecondActivity(): AppCompatActivity() {

    private lateinit var binding: ActivitySecondBinding
    override fun onCreate (savedInstanceState: Bundle?) {
        Log.i(TAG, "massage onCreate ${hashCode()}")
        binding = ActivitySecondBinding.inflate(layoutInflater)
        setContentView(binding.root)
        super.onCreate(savedInstanceState)
        val message = intent.getIntExtra(KEY,0)
        binding.textViewResult.text = message.toFloat().pow(2).toString()
        binding.ButtonBack.setOnClickListener {
            onBackPressed()
        }
    }

    companion object{
        private const val KEY="1234"
        private const val TAG="SecondActivity"

        fun getIntent(context: Context, message: Int): Intent {
            return Intent(context, SecondActivity::class.java).putExtra(KEY, message)
        }
    }

    override fun onResume() {
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
    override fun onDestroy() {
        Log.i(TAG, "massage onDestroy ${hashCode()}")
        super.onDestroy()
    }
}