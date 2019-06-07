package com.akash.webservicedemo

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.widget.LinearLayout
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.Response
import com.android.volley.toolbox.JsonArrayRequest
import com.android.volley.toolbox.Volley
import com.nostra13.universalimageloader.core.ImageLoader
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.fragment_output.*
import kotlin.math.log

class MainActivity : AppCompatActivity() {
private var recc :RecyclerView? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
var myproductlist = ArrayList<Product>()
Log.d("test","yes!!!")

  fun initImageLoader() {
            val universalImageLoader = UniversalImageLoader(this@MainActivity)
            ImageLoader.getInstance().init(universalImageLoader.config)
        }



var webserviceURL= "https://api.androidhive.info/json/movies.json"


            val reqQ : RequestQueue = Volley .newRequestQueue(this@MainActivity)

            val jsonfetch:JsonArrayRequest=  JsonArrayRequest(Request.Method.GET,webserviceURL,null,Response.Listener {


                response ->
Log.d("1st","1st response")
for (index in 0.until(response.length())){



    var img:String = response.getJSONObject(index).getString("image")
    var country:String = response.getJSONObject(index).getString("title")
    var name:String = response.getJSONObject(index).getString("rating")
    var city:String = response.getJSONObject(index).getString("releaseYear")

    val p = Product(img,country,name,city)

    myproductlist.add(p)


}
Log.d("2nd","2setting up adpter")
val rvadapter = RVAdapter(this@MainActivity,myproductlist)

//                recc = findViewById<RecyclerView>(R.id.rec)
//
//                var ll:LinearLayoutManager= LinearLayoutManager(this)
//
//recc.layoutManager = LinearLayoutManager(this)
Log.d("3rd","Setting up Recycler view")
                val recyclerView = findViewById(R.id.rec) as RecyclerView
                recyclerView.layoutManager = LinearLayoutManager(this, LinearLayout.VERTICAL, false)
                recyclerView.adapter = rvadapter





            }, Response.ErrorListener {
                error ->

Log.d("eroor","catched")


            })


            reqQ.add(jsonfetch)
        }




    }
