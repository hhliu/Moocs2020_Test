package cycu.nclab.moocs.moocs2020_test

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.os.Message
import android.util.Log
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity

var count = 0
class MainActivity : AppCompatActivity(), View.OnClickListener {
    val TAG = MainActivity::class.simpleName
    val demoCase = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        count++
        Log.d(TAG, "enter onCreate(), #$count")
    }

    override fun onStart() {
        super.onStart()
        Log.d(TAG, "enter onStart(), #$count")

        when (demoCase) {
            0 ->                 // 找到此Activity的root View，並增加click監聽
                this.findViewById<ViewGroup>(android.R.id.content).setOnClickListener(this)
//                window.decorView.rootView.setOnClickListener(this)
            1 -> {
                // 使用Handler自動切換螢幕畫面
                val msg: Message = myHandler.obtainMessage() // 從Global Message Pool裡面取一個message出來，
                // 比新建立一個有效率。
                // Ctr+Q 查看指令文件
                myHandler.sendMessageDelayed(msg, 500) // 0.5秒後執行
            }
        }
    }

    override fun onStop() {
        Log.d(TAG, "enter onStop(), #$count")
        super.onStop()
    }

    override fun onResume() {
        super.onResume()
        Log.d(TAG, "enter onResume(), #$count")
    }

    override fun onPause() {
        Log.d(TAG, "enter onPasue(), #$count")
        super.onPause()
    }

    override fun onDestroy() {
        Log.d(TAG, "enter onDestroy(), #$count")
        count--
        super.onDestroy()
    }

    override fun onClick(p0: View?) {
        when (p0!!.id){
            android.R.id.content -> {
                startActivity(Intent(this, Bookkeeping::class.java))

                // 增加過場動畫

                // 增加過場動畫
                overridePendingTransition(
                    android.R.anim.slide_in_left,
                    android.R.anim.slide_out_right
                )

                // 強制activity終止
                finish()
            }
        }
    }

    // ---------------------使用handler的範例------------------------------------------------------
    private val myHandler: Handler = object : Handler(Looper.getMainLooper()) {
        override fun handleMessage(msg: Message) {
            startActivity(Intent(this@MainActivity, Bookkeeping::class.java))

            // 增加過場動畫
            overridePendingTransition(
                android.R.anim.slide_in_left,
                android.R.anim.slide_out_right
            )
            finish()
        }
    }
    // -------------------------------------------------------------------------------------------

}