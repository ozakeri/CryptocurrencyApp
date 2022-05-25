package com.example.cryptocurrencyapp.data.remote

import com.example.cryptocurrencyapp.data.remote.datamodel.Coin
import com.example.cryptocurrencyapp.data.remote.datamodel.Coins
import retrofit2.http.GET
import retrofit2.http.Path

interface CoinApi {


    @GET("/v1/coins")
    suspend fun getCoins(): List<Coins>

    @GET("/v1/coins/{coinId}")
    suspend fun getCoinById(@Path("coinId") coinId: String): Coin

}