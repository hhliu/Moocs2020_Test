package cycu.nclab.moocs.moocs2020_test

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

class ThreeWayForMonitorEvents : AppCompatActivity(), View.OnClickListener {
    private var isClicked: Boolean=false
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        /*方法三：在類別中implement onClickListener
         */
        button5!!.setOnClickListener(this)
        // ?：做 null check 後，不為空的話再執行
        //!!：保證不會是空值，執行就是了

        /* 方法二：直接寫在setOnClickListener中，缺點是對於每一個View要寫一個
        button5.setOnClickListener{
            if (isClicked){
                textView.setTextColor(Color.GREEN)
                isClicked = false
            }else{
                textView.setTextColor(Color.CYAN)
                isClicked = true
            }
        }
         */

        /* 方法二之一：建立監聽器
        button5.setOnClickListener(clickListener)
         */

    }

    override fun onClick(p0: View?) {
        when (p0!!.id) {
            R.id.textView -> firstFun()
            R.id.button5 -> secondFun()
        }
    }

    /* 方法二之一：建立監聽器
    private val clickListener = View.OnClickListener { view ->
        when (view.id) {
            R.id.textView -> firstFun()
            R.id.button5 -> secondFun()
        }
    }
     */

    private fun secondFun(){
        isClicked = if (isClicked){
            textView.setTextColor(Color.GREEN)
            false
        }else{
            textView.setTextColor(Color.CYAN)
            true
        }
    }

    private fun firstFun(){
        // do nothing.
    }



/* 方法一：使用onClicked屬性連結函式
    fun onButtonClicked(view: View) {
        if (isClicked){
            textView.setTextColor(Color.GREEN)
            isClicked = false
        }else{
            textView.setTextColor(Color.CYAN)
            isClicked = true
        }
    }
*/

}