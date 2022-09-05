package org.d3ifcool.githubuser.activity

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import org.d3ifcool.githubuser.R

@SuppressLint("CustomSplashScreen")
class SplashActivity : AppCompatActivity() {
    private lateinit var imageSplash: ImageView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        imageSplash = findViewById(R.id.idSplash)
        imageSplash.alpha = 0f
        imageSplash.animate().setDuration(1500).alpha(1f).withEndAction {
            val i = Intent(this, MainActivity::class.java)
            startActivity(i)
            overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out)
            finish()
        }
    }
}