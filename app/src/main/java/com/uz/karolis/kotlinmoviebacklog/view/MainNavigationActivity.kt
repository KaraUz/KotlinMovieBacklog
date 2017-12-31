package com.uz.karolis.kotlinmoviebacklog.view

import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.view.View
import android.widget.Toast
import com.uz.karolis.kotlinmoviebacklog.R
import com.uz.karolis.kotlinmoviebacklog.view.BackloggedMoviesFragment.BackloggedMovieFragment
import com.uz.karolis.kotlinmoviebacklog.domain.Movie
import kotlinx.android.synthetic.main.activity_main_navigation.*

class MainNavigationActivity : AppCompatActivity()
    , BackloggedMovieFragment.OnBackloggedMovieFragmentClickListener
{
    override fun onBackloggedMovieFragmentClick(movie: Movie) {
        Log.i("Test if active", "onBackloggedMovieFragmentClick triggered")
        Toast.makeText(this,"Backlogged movie: " + movie.title, Toast.LENGTH_SHORT).show()
    }

    private val mOnNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        when (item.itemId) {
            R.id.navigation_home -> {
                message.setText(R.string.title_home)
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_dashboard -> {
                message.setText(R.string.title_dashboard)
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_notifications -> {
                message.setText(R.string.title_notifications)
                return@OnNavigationItemSelectedListener true
            }
        }
        false
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_navigation)

        replaceFragment(R.id.main_navigation_frame, BackloggedMovieFragment.newInstance())
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)
    }

    private fun replaceFragment(whereId: Int,fragment: Fragment){
        if(findViewById<View>(R.id.main_navigation_frame) == null)
            return

        supportFragmentManager.beginTransaction()
                .replace(whereId, fragment)
                .commit()
    }
}
