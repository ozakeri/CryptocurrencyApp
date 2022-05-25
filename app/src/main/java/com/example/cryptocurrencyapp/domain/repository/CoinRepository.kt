package com.example.cryptocurrencyapp.domain.repository

import com.example.cryptocurrencyapp.data.remote.datamodel.Coin
import com.example.cryptocurrencyapp.data.remote.datamodel.Coins

interface CoinRepository {
    suspend fun getCoins(): List<Coins>
    suspend fun getCoinById(coinId: String): Coin
}