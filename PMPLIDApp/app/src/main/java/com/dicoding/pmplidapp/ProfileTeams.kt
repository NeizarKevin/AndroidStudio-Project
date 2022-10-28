package com.dicoding.pmplidapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions

class ProfileTeams : AppCompatActivity() {
    private var title: String = "PMPLID Profile Teams"

    companion object {
        const val EXTRA_NAME = "extra_name"
        const val EXTRA_PHOTO = "extra_photo"
        const val EXTRA_SOSMED = "extra_sosmed"
        const val EXTRA_PROFILE = "extra_profile"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile_teams)

        supportActionBar?.title = title
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val tvSetName: TextView = findViewById(R.id.tv_item_name)
        val imgPhoto: ImageView = findViewById(R.id.img_item_photo)
        val tvSosmed: TextView = findViewById(R.id.tv_item_sosmed)
        val tvProfile: TextView = findViewById(R.id.tv_item_profile)
        val btnFavorite: Button = findViewById(R.id.btn_set_favorite)
        val btnShare: Button = findViewById(R.id.btn_set_share)

        val tName = intent.getStringExtra(EXTRA_NAME)
        val tImg = intent.getIntExtra(EXTRA_PHOTO, 0)
        val tSosmed = intent.getStringExtra(EXTRA_SOSMED)
        val tProfile = intent.getStringExtra(EXTRA_PROFILE)

        tvSetName.text = tName
        Glide.with(this)
            .load(tImg)
            .apply(RequestOptions())
            .into(imgPhoto)
        tvSosmed.text = tSosmed
        tvProfile.text = tProfile

        btnFavorite.setOnClickListener {
            Toast.makeText(
                btnFavorite.context,
                "Memberikan Favorite pada " + tName,
                Toast.LENGTH_SHORT
            ).show()
        }

        btnShare.setOnClickListener {
            val intent = Intent(Intent.ACTION_SEND)
            intent.type = "text/plain"
            intent.putExtra(Intent.EXTRA_TEXT, "Follow Akun Sosial Media " + tName + " :\n" + tSosmed)
            startActivity(Intent.createChooser(intent, "Share with..."))
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}