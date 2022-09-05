package org.d3ifcool.githubuser.activity

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import org.d3ifcool.githubuser.R
import org.d3ifcool.githubuser.User
import org.d3ifcool.githubuser.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val list = ArrayList<User>()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.rvGitUser.setHasFixedSize(true)
        list.addAll(listUsers)
        showRecyclerList()
    }

    private val listUsers: ArrayList<User>

        @SuppressLint("Recycle")
        get() {
            val dataName = resources.getStringArray(R.array.data_name)
            val usernameUser = resources.getStringArray(R.array.username_user)
            val dataPhoto = resources.obtainTypedArray(R.array.data_photo)
            val location = resources.getStringArray(R.array.location)
            val repository = resources.getStringArray(R.array.repository)
            val following = resources.getStringArray(R.array.following)
            val follower = resources.getStringArray(R.array.follower)
            val company = resources.getStringArray(R.array.company)
            val listUser = ArrayList<User>()
            for (i in dataName.indices) {
                val user = User(dataName[i],usernameUser[i], dataPhoto.getResourceId(i, -1), company[i], location[i], repository[i], follower[i], following[i])
                listUser.add(user)
            }
            return listUser
        }
    private fun showRecyclerList() {
        binding.rvGitUser.layoutManager = LinearLayoutManager(this)
        val listUserAdapter = ListUserAdapter(list)
        binding.rvGitUser.adapter = listUserAdapter

        listUserAdapter.setOnItemClickCallback(object : ListUserAdapter.OnItemClickCallback {
            override fun onItemClicked(data: User) {
                showSelectedHero(data)
            }
        })
    }

    private fun showSelectedHero(user: User) {
        Toast.makeText(this, "Kamu memilih " + user.name, Toast.LENGTH_SHORT).show()
        val moveWithUserDataIntent = Intent(this@MainActivity, DetailActivity::class.java)
        moveWithUserDataIntent.putExtra(DetailActivity.EXTRA_USER, user)
        startActivity(moveWithUserDataIntent)
    }
}