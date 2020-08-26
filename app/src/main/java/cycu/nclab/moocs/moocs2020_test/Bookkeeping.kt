package cycu.nclab.moocs.moocs2020_test

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

var bCount = 0
class Bookkeeping : AppCompatActivity() {
    val TAG = Bookkeeping::class.simpleName

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bookkeeping_constraintlayout)

        bCount++
        Log.d(TAG, "enter onCreate(), #$bCount")
    }

    override fun onStart() {
        super.onStart()
        Log.d(TAG, "enter onStart(), #$bCount")
    }

    override fun onStop() {
        Log.d(TAG, "enter onStop(), #$bCount")
        super.onStop()
    }

    override fun onResume() {
        super.onResume()
        Log.d(TAG, "enter onResume(), #$bCount")
    }

    override fun onPause() {
        Log.d(TAG, "enter onPasue(), #$bCount")
        super.onPause()
    }

    override fun onDestroy() {
        Log.d(TAG, "enter onDestroy(), #$bCount")
        bCount--
        super.onDestroy()
    }
}