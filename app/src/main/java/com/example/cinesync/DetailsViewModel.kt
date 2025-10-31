package com.example.cinesync

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.schedulers.Schedulers

class DetailsViewModel : ViewModel() {
    var details by mutableStateOf<TitleDetailsResponse?>(null)
    var isLoading by mutableStateOf(true)

    private val apiKey = "E7AfJ20S6Ied8JB1UPsJ8OX65fa3yy0rceWb3qlW"

    fun fetchDetails(titleId: Int) {
        isLoading = true
        ApiClient.api.getTitleDetails(titleId, apiKey)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({ response ->
                details = response
                isLoading = false
            }, { error ->
                error.printStackTrace()
                isLoading = false
            })
    }
}
