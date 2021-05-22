package com.captaindeer.beersintheworld.ui.allBeers

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.captaindeer.beersintheworld.R
import com.captaindeer.beersintheworld.data.local.entities.BeerEntity
import com.captaindeer.beersintheworld.ui.adapters.BeerItemAdapter
import com.captaindeer.beersintheworld.ui.adapters.ListBeerAdapter
import com.captaindeer.beersintheworld.ui.adapters.listeners.ListenerItem
import com.captaindeer.beersintheworld.utils.DialogBeerDetail
import kotlinx.android.synthetic.main.fragment_all_beers.*

class AllBeersFragment : Fragment(), ListenerItem, AllBeersInterface.View {

    private lateinit var presenter: AllBeersPresenter
    private lateinit var beerItemAdapter: BeerItemAdapter
    private lateinit var listBeerAdapter: ListBeerAdapter

    private var beers = arrayListOf<BeerEntity>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        presenter = AllBeersPresenter(requireContext(), this)
        beerItemAdapter = BeerItemAdapter(beers, this)
        listBeerAdapter = ListBeerAdapter(beers, this)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_all_beers, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        rv_all_beers.setHasFixedSize(true)
        rv_all_beers.layoutManager =
            LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
        rv_all_beers.adapter = beerItemAdapter

        rv2_all_beers.setHasFixedSize(true)
        rv2_all_beers.layoutManager = LinearLayoutManager(requireContext())
        rv2_all_beers.adapter = listBeerAdapter

        presenter.getBeers()
    }

    override fun onDestroy() {
        super.onDestroy()
        presenter.onCancel()
    }

    override fun onStop() {
        super.onStop()
        presenter.onCancel()
    }

    override fun setBeers(beers: ArrayList<BeerEntity>) {
        beerItemAdapter.updateData(beers)
    }

    override fun setListBeers(beers: ArrayList<BeerEntity>) {
        listBeerAdapter.updateData(beers)
    }

    override fun onError(msg: String) {
        Toast.makeText(requireContext(), msg, Toast.LENGTH_LONG).show()
    }

    override fun beerDetailDialog(beerEntity: BeerEntity) {
        DialogBeerDetail.showBeerDetail(requireContext(), beerEntity)
    }

}