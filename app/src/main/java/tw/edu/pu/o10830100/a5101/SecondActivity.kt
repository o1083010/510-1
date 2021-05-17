package tw.edu.pu.o10830100.a5101

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_second.*

class SecondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        val intent = getIntent()
        val you:Double = intent.getDoubleExtra("You",0.0)
        val correct:Double = intent.getDoubleExtra("Correct",0.0)
        val ok = String.format("%.1f",correct)

        yourans.text = you.toString()
        correctans.text = ok
        if(correctans.text != yourans.text){
            truefalse.text = "您答錯了！"
        }
        else truefalse.text = "您答對了！"

        back.setOnClickListener(object : View.OnClickListener{
            override fun onClick(v: View?) {
              finish()
            }
        })
    }
}