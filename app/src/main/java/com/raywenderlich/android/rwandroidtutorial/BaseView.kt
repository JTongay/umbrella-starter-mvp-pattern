package com.raywenderlich.android.rwandroidtutorial

// All views in the app should implement this interface
// Since all views interact with a presenter, the view gets the generic type T for the presenter and it MUST implement setPresenter
interface BaseView<T> {
    fun setPresenter(presenter : T)
}