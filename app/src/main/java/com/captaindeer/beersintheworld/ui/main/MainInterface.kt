package com.captaindeer.beersintheworld.ui.main

import androidx.fragment.app.Fragment
import com.captaindeer.beersintheworld.data.remote.responses.BeerResponse
import com.captaindeer.beersintheworld.ui.bases.BaseView

interface MainInterface {

    interface Presenter {

    }

    interface View : BaseView {
        fun changeFragment(fragment: Fragment)
    }
}