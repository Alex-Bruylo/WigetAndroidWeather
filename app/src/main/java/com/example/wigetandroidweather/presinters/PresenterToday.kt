package com.example.wigetandroidweather.presinters
import com.example.wigetandroidweather.MainContract
import com.example.wigetandroidweather.data.repository.Repository
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.schedulers.Schedulers
import javax.inject.Inject


class PresenterToday @Inject constructor(var repository: Repository,
                                         var today: MainContract.View.Today):
        MainContract.Presinter.Today{
        override fun loadDataToday() {
            today.showLoader()
                repository.getWeather().
                observeOn(AndroidSchedulers.mainThread()).subscribeOn(Schedulers.io()).subscribe(
                    { response->today.showData(response)
                     today.hideLoader()},
                        {  rez->today.netError(rez) })
        }


}