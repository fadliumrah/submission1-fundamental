package com.fadli.githubappuser

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.fadli.githubappuser.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private val dataUser = ArrayList<User>()

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        dataUser.addAll(listUsers)
        showRecyclerUser()

    }

    private val listUsers: ArrayList<User>
        @SuppressLint("Recycle")
        get() {
            val dataName = resources.getStringArray(R.array.name)
            val dataUserName = resources.getStringArray(R.array.username)
            val dataAvatar = resources.obtainTypedArray(R.array.avatar)
            val dataCompany = resources.getStringArray(R.array.company)
            val dataLocation = resources.getStringArray(R.array.location)
            val dataRepository = resources.getStringArray(R.array.repository)
            val dataFollower = resources.getStringArray(R.array.followers)
            val dataFollowing = resources.getStringArray(R.array.following)

            val listUser = ArrayList<User>()
            for (i in dataName.indices) {
                val user = User(dataName[i],dataUserName[i],dataAvatar.getResourceId(i, -1) ,dataCompany[i],dataLocation[i],dataFollowing[i], dataFollower[i],dataRepository[i])
                listUser.add(user)
            }
            return listUser
        }

    private fun showRecyclerUser() {
        binding.rvUser.layoutManager = LinearLayoutManager(this)
        val listUserAdapter = ListUserAdapter(listUsers)
        binding.rvUser.adapter = listUserAdapter
        listUserAdapter.setOnItemClickCallback(object : ListUserAdapter.OnItemClickCallBack{
            override fun onItemClicked(data: User) = showSelectedUser(data)
        })
    }

    private fun showSelectedUser(data: User) {
        val moveObjectWithIntent = Intent(this@MainActivity, UserDetail::class.java)
        moveObjectWithIntent.putExtra(UserDetail.EXTRA_DETAIL_USER, data)
        startActivity(moveObjectWithIntent)
    }
}