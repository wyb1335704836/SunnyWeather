package com.unnyweather.android.ui.place

import androidx.lifecycle.*

import com.unnyweather.android.logic.Repository
import com.unnyweather.android.logic.model.Place

class PlaceViewModel : ViewModel() {
    fun savePlace(place:Place)=Repository.savePlace(place)
    fun getSavedPlace()=Repository.getSavedPlace()
    fun isPlaceSaved()=Repository.isPlaceSaved()

    private val searchLiveData = MutableLiveData<String>()

    val placeList = ArrayList<Place>()

    val placeLiveData = Transformations.switchMap(searchLiveData) { query ->
        Repository.searchPlaces(query)
    }

    fun searchPlaces(query: String) {
        searchLiveData.value = query
    }



}