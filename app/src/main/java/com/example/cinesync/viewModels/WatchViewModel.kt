package com.example.cinesync.viewModels

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.example.cinesync.apiService.ApiClient
import com.example.cinesync.models.Title
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Single
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.schedulers.Schedulers

class WatchViewModel : ViewModel() {

    private val apiKey = "E7AfJ20S6Ied8JB1UPsJ8OX65fa3yy0rceWb3qlW"
    private val compositeDisposable = CompositeDisposable()

    var allMovies by mutableStateOf(listOf<Title>())
    var allTvShows by mutableStateOf(listOf<Title>())
    var titles by mutableStateOf(listOf<Title>())
    var isLoading by mutableStateOf(true)
    var isMovieSelected by mutableStateOf(true)

    init {
        fetchData()
    }

    fun toggleType() {
        isMovieSelected = !isMovieSelected
        filterData()
    }

    fun filterData() {
        titles = if (isMovieSelected) allMovies else allTvShows
    }

    fun fetchData() {
        isLoading = true

        val disposable = Single.zip(
            ApiClient.api.getMovies(apiKey),
            ApiClient.api.getTvShows(apiKey)
        ) { movies, tv ->
            Pair(movies.titles, tv.titles)
        }
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({ (movies, tv) ->
                allMovies = movies
                allTvShows = tv
                filterData()
                isLoading = false
            }, { error ->
                error.printStackTrace()
                titles = emptyList()
                isLoading = false
            })

        compositeDisposable.add(disposable)
    }

    override fun onCleared() {
        super.onCleared()
        compositeDisposable.clear()
    }
}