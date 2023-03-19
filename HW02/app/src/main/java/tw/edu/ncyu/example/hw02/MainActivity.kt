package tw.edu.ncyu.example.hw02

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        data?.extras?.let{
            if(requestCode == 1 && resultCode == Activity.RESULT_OK)
            {
                findViewById<TextView>(R.id.BMI).text =
                    "BMI值: ${it.getFloat("result")}\n\n"
                findViewById<TextView>(R.id.Name).text =
                    "姓名: ${it.getString("Name")}\n\n"
            }


        }
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        findViewById<Button>(R.id.button).setOnClickListener{
            val intent = Intent(this,SecActivity::class.java)
            startActivityForResult(intent,1)
        }

    }
}