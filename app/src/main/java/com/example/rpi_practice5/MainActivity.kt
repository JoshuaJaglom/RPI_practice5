package com.example.rpi_practice5

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import com.example.rpi_practice5.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(R.layout.activity_main)
        setContentView(binding.root)
    }

    fun setGoodPicture(view: View) {
        binding.imageView.setImageResource(R.drawable.smile)
    }

    fun setBadPicture(view: View) {
        binding.imageView.setImageResource(R.drawable.sad)
    }

    fun setToast(view: View) {
        when {
            binding.vevent.text.trim().isNotEmpty() and binding.vtime.text.trim().isNotEmpty()
                    and binding.vdata.text.trim().isNotEmpty() and binding.post.text.trim().isNotEmpty() -> {
                val msg = """
                    Записано!
                    Событие: ${binding.vevent.text}
                    Дата: ${binding.vdata.text}
                    Время: ${binding.vtime.text}
                    Заметки: ${binding.post.text}
                """.trimIndent()
                val toast = Toast.makeText(applicationContext, msg, Toast.LENGTH_LONG).show()
            } else -> {
                Toast.makeText(
                    applicationContext,
                    "Не все поля заполнены!",
                    Toast.LENGTH_SHORT
                ).show()
            }
        }
    }
}