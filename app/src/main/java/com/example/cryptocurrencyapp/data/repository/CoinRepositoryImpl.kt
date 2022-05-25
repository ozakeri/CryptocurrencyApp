package com.example.cryptocurrencyapp.data.repository

import com.example.cryptocurrencyapp.data.remote.CoinApi
import com.example.cryptocurrencyapp.data.remote.datamodel.Coin
import com.example.cryptocurrencyapp.data.remote.datamodel.Coins
import com.example.cryptocurrencyapp.domain.repository.CoinRepository
import javax.inject.Inject

class CoinRepositoryImpl @Inject constructor(
    private val api: CoinApi
) : CoinRepository {

    override suspend fun getCoins(): List<Coins> {
        return api.getCoins()
    }

    override suspend fun getCoinById(coinId: String): Coin {
        return api.getCoinById(coinId)
    }
}