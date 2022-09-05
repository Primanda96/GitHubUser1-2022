package org.d3ifcool.githubuser.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import org.d3ifcool.githubuser.User
import org.d3ifcool.githubuser.databinding.ActivityDetailBinding

class DetailActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDetailBinding

    companion object {
        const val EXTRA_USER = "extra_user"
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar!!.setDisplayHomeAsUpEnabled(true)

        val user = intent.getParcelableExtra<User>(EXTRA_USER) as User
        binding.receivedName.text = user.name.toString()
        user.avatar?.let { binding.receivedAvatar.setImageResource(it) }
        binding.receivedUsername.text = user.username.toString()
        binding.receivedCompany.text = user.company.toString()
        binding.receivedLocation.text = user.location.toString()
        binding.receivedFollowing.text = user.following.toString()
        binding.receivedFollower.text = user.follower.toString()
        binding.receivedRepository.text = user.repository.toString()
    }
}