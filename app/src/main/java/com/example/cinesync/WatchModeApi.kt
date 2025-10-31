package com.example.cinesync

import io.reactivex.rxjava3.core.Single
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface WatchModeApi {
    @GET("list-titles")
    fun getMovies(
        @Query("apiKey") apiKey: String,
        @Query("types") type: String = "movie"
    ): Single<TitlesResponse>

    @GET("list-titles")
    fun getTvShows(
        @Query("apiKey") apiKey: String,
        @Query("types") type: String = "tv_series,tv_miniseries,tv_special,tv_movie"
    ): Single<TitlesResponse>

    @GET("title/{title_id}/details/")
    fun getTitleDetails(
        @Path("title_id") titleId: Int,
        @Query("apiKey") apiKey: String
    ): Single<TitleDetailsResponse>
}