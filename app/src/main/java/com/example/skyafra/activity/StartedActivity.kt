package com.example.skyafra.activity

import android.animation.AnimatorSet
import android.animation.ObjectAnimator
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.skyafra.databinding.ActivityStartedBinding
import com.example.skyafra.fragment.HomeFragment2
import com.google.firebase.Firebase
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.auth

class StartedActivity : AppCompatActivity() {

    private lateinit var binding: ActivityStartedBinding
    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityStartedBinding.inflate(layoutInflater)
        setContentView(binding.root)

        auth = Firebase.auth

        val currentUser = auth.currentUser
        if (currentUser != null) {
            startActivity(Intent(this, MainActivity::class.java))
            finish()
            return
        }

        binding.btnLogin.setOnClickListener{
            startActivity(Intent(this, LoginActivity::class.java))
        }

        binding.btnRegister.setOnClickListener{
            startActivity(Intent(this, RegisterActivity::class.java))
        }

        playAnimation()
    }

    private fun playAnimation() {

        ObjectAnimator.ofFloat(binding.imgIllustrationStarted, View.TRANSLATION_X, -30f, 30f)
            .apply {
                duration = 6000
                repeatCount = ObjectAnimator.INFINITE
                repeatMode = ObjectAnimator.REVERSE
            }.start()

        val title = ObjectAnimator.ofFloat(binding.tvStartedTitle, View.ALPHA, 1f).setDuration(1000)
        val subtitle = ObjectAnimator.ofFloat(binding.tvStartedSubTitle, View.ALPHA, 1f).setDuration(1000)
        val login = ObjectAnimator.ofFloat(binding.btnLogin, View.ALPHA, 1f).setDuration(1000)
        val register = ObjectAnimator.ofFloat(binding.btnRegister, View.ALPHA, 1f).setDuration(1000)
        val appname = ObjectAnimator.ofFloat(binding.tvAppName, View.ALPHA, 1f).setDuration(1000)

        val together = AnimatorSet().apply {
            playTogether(login, register)
        }

        AnimatorSet().apply {
            playSequentially(title, subtitle, appname, together)
            start()

        }
    }
}