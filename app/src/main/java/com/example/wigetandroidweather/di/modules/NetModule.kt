package com.example.wigetandroidweather.di.modules


import com.example.wigetandroidweather.WEATHER_URL
import com.example.wigetandroidweather.data.net.API
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory
import retrofit2.converter.moshi.MoshiConverterFactory
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object NetModule {

        @Provides
        fun moshi():Moshi= Moshi.Builder().add(KotlinJsonAdapterFactory()).build()


        @Provides
        @Singleton
        fun retrofit(moshi:Moshi):Retrofit= Retrofit.
        Builder().addConverterFactory(MoshiConverterFactory.create(moshi)).
        addCallAdapterFactory(RxJava3CallAdapterFactory.create()).
        baseUrl(WEATHER_URL).build()



      @Provides
       @Singleton
        fun retrofitService(retrofit: Retrofit) : API = retrofit.create(API::class.java)


}