package com.example.severalactivities

import android.content.Intent
import android.media.Image
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.ImageView
import com.example.severalactivities.databinding.ActivityActiv2Binding
import java.util.*

class activ2 : AppCompatActivity() {
    private lateinit var binding: ActivityActiv2Binding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityActiv2Binding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        val imageUserImageView: ImageView = findViewById(R.id.imageUser)
        val userAnimation: Animation = AnimationUtils.loadAnimation(this, R.anim.user)
        imageUserImageView.startAnimation(userAnimation)
        //получаем список аргументов, присланных из первого активити
        //и если эти аргументы не null, то обрабатываем
        val arguments = intent.extras
        var name: String = "UserName"
        var age: Int = 10
        var surname: String = "UserSurname"


        val health = binding.progressBarHealth.progress



        if (arguments != null) {
            //метод get позволяет получить значение по ключу
            name = arguments.get("name").toString()
            age = arguments.get("age").toString().toInt()
            surname = arguments.get("surname").toString()
        }

        binding.textView2.text =
            binding.textView2.text.toString() + ", " + name + " " + age + " " + surname

        val timer = object : CountDownTimer(20000, 1000) {
            override fun onTick(millisUntilFinished: Long) {
                binding.progressBarHealth.progress = binding.progressBarHealth.progress - 5
                binding.progressBarHunger.progress = binding.progressBarHunger.progress - 5
                binding.progressBarSleep.progress = binding.progressBarSleep.progress - 5
            }

            override fun onFinish() {
                println("Ааааа")
            }
        }
        timer.start()
        val btn_toact1 = binding.buttonToact1
        btn_toact1.setOnClickListener {
            val act1_start = Intent(this, MainActivity::class.java)
            startActivity(act1_start)
        }
        val btnHealt = binding.buttonHeal
        btnHealt.setOnClickListener {
            binding.progressBarHealth.progress = binding.progressBarHealth.progress + 10
        }
        val btnHunger = binding.buttonHunger
        btnHunger.setOnClickListener {
            binding.progressBarHunger.progress = binding.progressBarHunger.progress + 10
        }
        val btnSleep = binding.buttonSleep
        btnSleep.setOnClickListener {
            binding.progressBarSleep.progress = binding.progressBarSleep.progress + 10
        }

        val btnRotate = binding.imageUser
        btnRotate.setOnClickListener{
            val imageUserImageView: ImageView = findViewById(R.id.imageUser)
            val rotateAnimation: Animation = AnimationUtils.loadAnimation(this, R.anim.rotate)
            imageUserImageView.startAnimation(rotateAnimation)
        }
    }
}