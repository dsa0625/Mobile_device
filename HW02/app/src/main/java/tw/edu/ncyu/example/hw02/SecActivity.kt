package tw.edu.ncyu.example.hw02

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class SecActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sec)

        val IdName = findViewById<EditText>(R.id.IdName)
        val IdHeight = findViewById<EditText>(R.id.IdHeight)
        val IdWeight = findViewById<EditText>(R.id.IdWeight)
        val confirm_button = findViewById<Button>(R.id.confirm_button)

        confirm_button.setOnClickListener{
            if (IdName.length() < 1)
            {
                Toast.makeText(this,"輸入名子",Toast.LENGTH_SHORT).show()
            }
            else
            {
                    val h = IdHeight.text.toString().toFloat()
                    val w = IdWeight.text.toString().toFloat()
                    val result = w/(h*h)
                    val b = Bundle()
                    b.putString("Name",IdName.text.toString())
                    b.putFloat("result",result)
                setResult(Activity.RESULT_OK, Intent().putExtras(b))
                finish()
            }

        }

    }


}