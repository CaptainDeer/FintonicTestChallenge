package com.captaindeer.beersintheworld.ui.allBeers

import android.content.Context
import android.util.Log
import com.captaindeer.beersintheworld.data.remote.RetrofitBuilder
import com.captaindeer.beersintheworld.data.remote.responses.BeerResponse
import com.captaindeer.beersintheworld.utils.OnLine
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class AllBeersPresenter(private val context: Context, private val view: AllBeersInterface.View) :
    AllBeersInterface.Presenter {
    private val retrofit = RetrofitBuilder()

    override fun getBeers() {
        if (OnLine.isNetworkAvailable(context)) {
            retrofit.getBeers().enqueue(object : Callback<BeerResponse> {
                override fun onResponse(
                    call: Call<BeerResponse>,
                    response: Response<BeerResponse>
                ) {
                    when {
                        response.code() == 200 -> {
                            if (response.isSuccessful) {
                                val beers = response.body()


                                Log.e("TAG", "Beers Added ${beers.toString()}")

                                /**   beerrss[i] = BeerModel(
                                beer.id,
                                beer.name,
                                beer.description,
                                beer.image_url,
                                beer.method.fermentation.temp.value,
                                beer.method.fermentation.temp.unit,
                                beer.brewers_tips,
                                beer.contribuited_by
                                )
                                 */

                                // view.setBeers(beers)

                            }


                            //    Log.e("TAG", "Beers Added ${beers.toString()}")

                            //     view.setBeers(beerrss)


                        }
                        response.code() == 404 -> {
                            view.onError("Something is wrong. Try again please. 404")
                        }
                        response.code() == 500 -> {
                            view.onError("Internal server error. 500")
                        }
                    }
                }

                override fun onFailure(call: Call<BeerResponse>, t: Throwable) {
                    view.onError("Error aqui " + t.message!!)
                    Log.e("TAG", "Error ${t.message.toString()}")

                }
            })
        } else {
            view.onError("No internet detected.")
        }
    }

}