package com.captaindeer.beersintheworld.ui.main

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.captaindeer.beersintheworld.R
import com.captaindeer.beersintheworld.data.remote.responses.BeerResponse
import com.captaindeer.beersintheworld.ui.adapters.BeerItemAdapter
import com.captaindeer.beersintheworld.ui.adapters.listeners.ListenerItem
import com.captaindeer.beersintheworld.ui.allBeers.AllBeersFragment
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.fragment_all_beers.*

class MainActivity : AppCompatActivity(), MainInterface.View {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val allBeersFragment = AllBeersFragment()

        setSupportActionBar(toolbar)

        supportFragmentManager.beginTransaction().apply {
            replace(R.id.fl_main, allBeersFragment)
            commit()
        }

    }

    override fun onError(msg: String) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show()
    }

    override fun changeFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction().apply {
            FragmentTransaction.TRANSIT_FRAGMENT_OPEN
            replace(R.id.fl_main, fragment)
            commit()
        }
    }
}