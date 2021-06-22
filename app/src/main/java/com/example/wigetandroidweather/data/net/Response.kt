package com.example.wigetandroidweather.data.net

import com.squareup.moshi.Json

data class Response(

	@Json(name="count")
	val count: Int? = null,

	@Json(name="cod")
	val cod: String? = null,

	@Json(name="message")
	val message: String? = null,

	@Json(name="list")
	val list: List<ListItem?>? = null
){

 data class Clouds(

	@Json(name="all")
	val all: Int? = null
)

data class Sys(

	@Json(name="country")
	val country: String? = null
)

data class Wind(

	@Json(name="deg")
	val deg: Double? = null,

	@Json(name="speed")
	val speed: Double? = null
)

 data class Main(

	@Json(name="temp")
	val temp: Double? = null,

	@Json(name="temp_min")
	val tempMin: Double? = null,

	@Json(name="humidity")
	val humidity: Int? = null,

	@Json(name="pressure")
	val pressure: Int? = null,

	@Json(name="feels_like")
	val feelsLike: Double? = null,

	@Json(name="temp_max")
	val tempMax: Double? = null
)

data class WeatherItem(

	@Json(name="icon")
	val icon: String? = null,

	@Json(name="description")
	val description: String? = null,

	@Json(name="main")
	val main: String? = null,

	@Json(name="id")
	val id: Int? = null
)

data class Coord(

	@Json(name="lon")
	val lon: Double? = null,

	@Json(name="lat")
	val lat: Double? = null
)

data class ListItem(

	@Json(name="dt")
	val dt: Int? = null,

	@Json(name="rain")
	val rain: Any? = null,

	@Json(name="coord")
	val coord: Coord? = null,

	@Json(name="snow")
	val snow: Any? = null,

	@Json(name="name")
	val name: String? = null,

	@Json(name="weather")
	val weather: List<WeatherItem?>? = null,

	@Json(name="main")
	val main: Main? = null,

	@Json(name="id")
	val id: Int? = null,

	@Json(name="clouds")
	val clouds: Clouds? = null,

	@Json(name="sys")
	val sys: Sys? = null,

	@Json(name="wind")
	val wind: Wind? = null
)
}