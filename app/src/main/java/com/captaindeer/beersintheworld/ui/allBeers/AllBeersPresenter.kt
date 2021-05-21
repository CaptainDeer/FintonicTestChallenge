package com.captaindeer.beersintheworld.ui.allBeers

import android.content.Context
import com.captaindeer.beersintheworld.data.local.LocalDatabase
import com.captaindeer.beersintheworld.data.local.entities.BeerEntity
import com.captaindeer.beersintheworld.data.remote.RetrofitBuilder
import com.captaindeer.beersintheworld.data.remote.responses.BeerResponse
import com.captaindeer.beersintheworld.utils.OnLine
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class AllBeersPresenter(private val context: Context, private val view: AllBeersInterface.View) :
    AllBeersInterface.Presenter {
    private val retrofit = RetrofitBuilder()
    private val database = LocalDatabase(context)

    override fun getBeers() {
        if (OnLine.isNetworkAvailable(context)) {
            retrofit.getBeers().enqueue(object : Callback<ArrayList<BeerResponse>> {
                override fun onResponse(
                    call: Call<ArrayList<BeerResponse>>,
                    response: Response<ArrayList<BeerResponse>>
                ) {
                    when {
                        response.code() == 200 -> {
                            if (response.isSuccessful) {
                                val beers = response.body()
                                beers?.forEach { beer ->
                                    database.productDao().insert(
                                        BeerEntity(
                                            beer.id,
                                            beer.name,
                                            beer.description,
                                            beer.image_url,
                                            beer.brewers_tips,
                                            beer.contributed_by
                                        )
                                    )
                                }
                                view.setBeers(database.productDao().updatePosts() as ArrayList)
                            }
                        }
                        response.code() == 404 -> {
                            view.onError("Something is wrong. Try again please. 404")
                        }
                        response.code() == 500 -> {
                            view.onError("Internal server error. 500")
                        }
                    }
                }

                override fun onFailure(call: Call<ArrayList<BeerResponse>>, t: Throwable) {
                    view.onError(t.message!!)
                }
            })
        } else {
            view.onError("No internet detected.")
            view.setBeers(database.productDao().updatePosts() as ArrayList)
        }
    }

}