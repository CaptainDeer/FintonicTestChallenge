package com.captaindeer.beersintheworld.ui.allBeers

import android.content.Context
import com.captaindeer.beersintheworld.data.local.LocalDatabase
import com.captaindeer.beersintheworld.data.local.entities.BeerEntity
import com.captaindeer.beersintheworld.data.remote.RetrofitBuilder
import com.captaindeer.beersintheworld.utils.OnLine
import kotlinx.coroutines.*
import kotlin.coroutines.CoroutineContext

class AllBeersPresenter(private val context: Context, private val view: AllBeersInterface.View) :
    AllBeersInterface.Presenter, CoroutineScope {

    private val job = Job()
    override val coroutineContext: CoroutineContext = job + Dispatchers.IO

    private var retrofit = RetrofitBuilder()
    private val database = LocalDatabase(context)

    override fun getBeers() {
        if (OnLine.isNetworkAvailable(context)) {

            launch {
                retrofit = RetrofitBuilder()
                val response = retrofit.getBeers()
                if (response.isSuccessful){
                    response.body()?.forEach { beer ->
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
                    withContext(Dispatchers.Main){
                        view.setBeers(database.productDao().updatePosts() as ArrayList)
                    }
                }else{
                    view.onError(response.errorBody().toString())
                }
            }
        } else {
            view.onError("No internet detected.")
            view.setBeers(database.productDao().updatePosts() as ArrayList)
        }
    }

    override fun onCancel() {
        job.cancel()
    }

}