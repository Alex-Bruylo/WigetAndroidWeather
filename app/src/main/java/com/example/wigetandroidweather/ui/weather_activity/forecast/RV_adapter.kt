package com.example.wigetandroidweather.ui.weather_activity.forecast

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.wigetandroidweather.R
import com.example.wigetandroidweather.data.net.ListItem
import com.example.wigetandroidweather.databinding.ItemBodyForecastBinding
import java.text.SimpleDateFormat

class RV_adapter(): RecyclerView.Adapter<RecyclerView.ViewHolder>() {

   private var data= mutableListOf<ListItem>()



    fun setData(data:MutableList<ListItem>){
        this.data=data
        notifyDataSetChanged()

    }



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when (viewType) {
            CellType.HEADER.ordinal -> HeaderWeatherHolder(LayoutInflater.from(parent.context).
            inflate(R.layout.item_head_forecast, parent, false))
            else -> FooterWeatherHolder(LayoutInflater.from(parent.context).
            inflate(R.layout.item_body_forecast, parent, false))
    }
}

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (data[position].dt?.let { getItemViewType(it) })

        {
            CellType.HEADER.ordinal -> {
                val headerViewHolder = holder as HeaderWeatherHolder
                headerViewHolder.bindView()
            }
            CellType.FOOTER.ordinal -> {
                val headerViewHolder = holder as FooterWeatherHolder
                headerViewHolder.bindView(data[position - 1])
            }

    }}

    override fun getItemCount(): Int=data.size+7
}

class HeaderWeatherHolder(var itemView: View) :RecyclerView.ViewHolder(itemView){

    fun  bindView(){}

}
class FooterWeatherHolder(var itemView: View) :RecyclerView.ViewHolder(itemView){

    fun  bindView(data: ListItem){}
}

enum class CellType(viewType: Int) {
    HEADER(0),
    FOOTER(1) }



 class utilsFun(){

    fun getDayOfWeek(dt: Int):String=SimpleDateFormat("EEEE").format(dt)


    fun getItemViewType(data: ListItem):CellType{

        val usedHeaders= mutableListOf<String>()

        if (usedHeaders.contains(data.dt?.let { getDayOfWeek(it) }))
            return CellType.FOOTER
        else { data.dt?.let { getDayOfWeek(it) }?.let { usedHeaders.add(it) }
            return CellType.HEADER
        }
    }


}




