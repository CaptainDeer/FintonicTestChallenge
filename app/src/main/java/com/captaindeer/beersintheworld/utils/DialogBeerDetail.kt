package com.captaindeer.beersintheworld.utils

import android.annotation.SuppressLint
import android.app.Dialog
import android.content.Context
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import com.captaindeer.beersintheworld.R
import com.captaindeer.beersintheworld.data.local.entities.BeerEntity
import com.squareup.picasso.Picasso

@SuppressLint("StaticFieldLeak")
object DialogBeerDetail {

    private lateinit var dialog: Dialog
    private lateinit var img_detail: ImageView
    private lateinit var tv_id: TextView
    private lateinit var tv_detail_name: TextView
    private lateinit var tv_details_brewer: TextView
    private lateinit var tv_detail_description: TextView
    private lateinit var tv_detail_contributed: TextView
    private lateinit var btn_ok: Button


    fun showBeerDetail(context: Context, beerEntity: BeerEntity) {
        dialog = Dialog(context)
        dialog.setContentView(R.layout.beers_detail)

        tv_detail_name = dialog.findViewById(R.id.tv_detail_name)
        tv_detail_name.text = beerEntity.name
        tv_id = dialog.findViewById(R.id.tv_id)
        tv_id.text = beerEntity.id.toString()
        img_detail = dialog.findViewById(R.id.img_detail)
        Picasso.get().load(beerEntity.image_url).placeholder(R.drawable.notfound).into(img_detail)
        tv_details_brewer = dialog.findViewById(R.id.tv_details_brewer)
        tv_details_brewer.text = beerEntity.brewers_tips
        tv_detail_description = dialog.findViewById(R.id.tv_detail_description)
        tv_detail_description.text = beerEntity.description
        tv_detail_contributed = dialog.findViewById(R.id.tv_detail_contributed)
        tv_detail_contributed.text = beerEntity.contributed_by

        btn_ok = dialog.findViewById(R.id.btn_ok)
        btn_ok.setOnClickListener {
            closeDialog()
        }


        dialog.show()



    }

    private fun closeDialog(){
        dialog.dismiss()
    }

}