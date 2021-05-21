package com.captaindeer.beersintheworld.ui.allBeers

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import com.captaindeer.beersintheworld.R
import com.captaindeer.beersintheworld.data.remote.responses.BeerResponse
import com.captaindeer.beersintheworld.ui.adapters.BeerItemAdapter
import com.captaindeer.beersintheworld.ui.adapters.listeners.ListenerItem
import kotlinx.android.synthetic.main.fragment_all_beers.*

class AllBeersFragment : Fragment(),ListenerItem, AllBeersInterface.View {

    private var presenter: AllBeersPresenter? = null
    private var beerItemAdapter: BeerItemAdapter? = null

    private var beers = arrayListOf<BeerResponse>()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        presenter = AllBeersPresenter(requireContext(),this)
        beerItemAdapter = BeerItemAdapter(beers,this)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_all_beers, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        rv_all_beers.setHasFixedSize(true)
        rv_all_beers.layoutManager = GridLayoutManager(requireContext(),2)
        rv_all_beers.adapter = beerItemAdapter

        presenter!!.getBeers()

    }

    override fun setBeers(beers: ArrayList<BeerResponse>) {
        beerItemAdapter!!.updateData(beers)
    }

    override fun onError(msg: String) {
        Toast.makeText(requireContext(),msg,Toast.LENGTH_LONG).show()
    }

}