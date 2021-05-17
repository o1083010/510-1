package tw.edu.pu.o10830100.a5101

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        generate()

        btn2.setOnClickListener(object : View.OnClickListener {
            override fun onClick(v: View?) {
                generate()
            }
        })

        btn1.setOnClickListener(object : View.OnClickListener {
            override fun onClick(v: View?) {
                intent = Intent(this@MainActivity, SecondActivity::class.java).apply {
                    if (operator.text == "+") {
                        putExtra("You", edt.text.toString().toDouble())
                        putExtra("Correct", (x.text.toString().toDouble() + y.text.toString().toDouble()))
                    } else if (operator.text == "-") {
                        putExtra("You", edt.text.toString().toDouble())
                        putExtra("Correct", (x.text.toString().toDouble() - y.text.toString().toDouble()))
                    } else if (operator.text == "x") {
                        putExtra("You", edt.text.toString().toDouble())
                        putExtra("Correct", (x.text.toString().toDouble() * y.text.toString().toDouble()))
                    } else if (operator.text == "/") {
                        val ansnum = (edt.text.toString().toDouble())
                        val correctnum = (x.text.toString().toDouble() / y.text.toString().toDouble())

                        putExtra("You", ansnum)
                        putExtra("Correct", correctnum)
                    }
                    startActivity(intent)
                }
            }
        })
    }
    fun generate(){
        val ops = arrayOf("+","-","x","/")
        val i = (0..3).random()
        val ranx = (1..100).random()
        val rany = (1..100).random()
        x.text = ranx.toString()
        y.text = rany.toString()
        operator.text = ops[i].toString()
    }
}
