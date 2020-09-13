package com.raywenderlich.android.rwandroidtutorial

// Presenter constructor takes in an instance of the view, along with the dependency injector
// The Presenter holds on to an instance of the WeatherRepository, which is the Model
// The Presenter also holds on the a reference to the view; however it interacts with the interface only

// Important to note that the presenter has no code that uses the Android APIs
// 1
class MainPresenter(view: MainContract.View,
                    dependencyInjector: DependencyInjector)
    : MainContract.Presenter {
    // 2
    private val weatherRepository: WeatherRepository = dependencyInjector.weatherRepository()

    // 3
    private var view: MainContract.View? = view

    override fun onDestroy() {
        this.view = null
    }

    override fun onViewCreated() {
        loadWeather()
    }

    override fun onLoadWeatherTapped() {
        loadWeather()
    }

    private fun loadWeather() {
        val weather = weatherRepository.loadWeather()
        val weatherState = weatherStateForWeather(weather)

        // Make sure to call the displayWeatherState on the view
        view?.displayWeatherState(weatherState)
    }

    private fun weatherStateForWeather(weather: Weather) : WeatherState {
        if (weather.rain!!.amount!! > 0) {
            return WeatherState.RAIN
        }
        return WeatherState.SUN
    }
}
