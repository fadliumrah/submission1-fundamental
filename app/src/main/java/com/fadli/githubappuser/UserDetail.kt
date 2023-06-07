package com.fadli.githubappuser

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.ActionBar
import com.bumptech.glide.Glide



class UserDetail : AppCompatActivity() {

    companion object {
        const val EXTRA_DETAIL_USER = "extra_detail_user"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        (supportActionBar as ActionBar).title = "Detail User"
        setContentView(R.layout.activity_user_detail)

        val user = intent.getParcelableExtra<User>(EXTRA_DETAIL_USER) as User
        val image = user.avatar
        Glide.with(this).load(image).into(findViewById(R.id.item_avatar))

        val name : TextView = findViewById(R.id.tv_name_detail)
        val company : TextView = findViewById(R.id.tv_company)
        val location : TextView = findViewById(R.id.tv_location)
        val repository : TextView = findViewById(R.id.tv_repository)
        val follower : TextView = findViewById(R.id.followers)
        val following : TextView = findViewById(R.id.following)

        name.text = user.name
        company.text = user.company
        location.text = user.location
        repository.text = user.repository
        follower.text = user.follower
        following.text = user.following

    }
}