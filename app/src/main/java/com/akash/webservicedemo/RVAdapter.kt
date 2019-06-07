package com.akash.webservicedemo

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.nostra13.universalimageloader.core.ImageLoader
import com.squareup.picasso.Picasso

class RVAdapter(var context : Context,var arraylist : ArrayList<Product>) : RecyclerView.Adapter <RecyclerView.ViewHolder>(){
    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): RecyclerView.ViewHolder {
var productview = LayoutInflater.from(context).inflate(R.layout.fragment_output,p0,false)
  return productviewholder(productview)
    }
    override fun getItemCount(): Int {
return arraylist.size
    }

    override fun onBindViewHolder(p0: RecyclerView.ViewHolder, p1: Int) {


(p0 as productviewholder).init(arraylist[p1].img_id,arraylist[p1].country_id,arraylist[p1].name_id,arraylist[p1].city_id)
    }

inner class productviewholder(myviews: View):RecyclerView.ViewHolder(myviews) {

    var img_id = myviews.findViewById<ImageView>(R.id.img_view)
    var country_id = myviews.findViewById<TextView>(R.id.country)
    var name_id = myviews.findViewById<TextView>(R.id.name)
    var city_id = myviews.findViewById<TextView>(R.id.city)

    fun init(img :String ,country :String,name:String,city:String){


        //img_id.setImageResource(img)
        //Piccaso

        //Picasso.b.load(img).fit().into(img_id)
        val universalImageLoader = UniversalImageLoader(context)
        ImageLoader.getInstance().init(universalImageLoader.config)
        img_id.setImageResource(R.drawable.ic_launcher_background)

        UniversalImageLoader.setImage(img,img_id,null,"")
     //   var pp:Picasso=Picasso.Builder(context).build()

      //  pp.load(img)
        country_id.text=name.toString()
        name_id.text =country.toString()
        city_id.text =city.toString()



    }



}
    }
