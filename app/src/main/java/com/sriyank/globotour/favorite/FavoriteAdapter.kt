package com.sriyank.globotour.favorite

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.sriyank.globotour.R
import com.sriyank.globotour.city.City

class FavoriteAdapter(val context: Context, val favoriteList: ArrayList<City>):
    RecyclerView.Adapter<FavoriteAdapter.FavoriteViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FavoriteViewHolder {
        val itemView = LayoutInflater.from(context).inflate(R.layout.list_item_favorite, parent, false)
        return FavoriteViewHolder(itemView)
    }

    override fun onBindViewHolder(favoriteViewHolder: FavoriteViewHolder, position: Int) {
        val city = favoriteList[position]
        favoriteViewHolder.setData(city, position)
    }

    override fun getItemCount(): Int = favoriteList.size

    inner class FavoriteViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private var currentPosition: Int = -1
        private var currentCity: City? = null
        private val txtCityName = itemView.findViewById<TextView>(R.id.txt_city_name)
        private val imgCityImage = itemView.findViewById<ImageView>(R.id.img_city)
        fun setData(city: City, position: Int) {
            txtCityName.text = city.name
            imgCityImage.setImageResource(city.imageId)
            this.currentPosition = position
            this.currentCity = city
        }

    }
}