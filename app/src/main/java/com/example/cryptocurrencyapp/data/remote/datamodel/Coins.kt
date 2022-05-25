package com.example.cryptocurrencyapp.data.remote.datamodel

import com.example.cryptocurrencyapp.domain.model.CoinCopy

data class Coins(
    val id: String,
    val is_active: Boolean,
    val is_new: Boolean,
    val name: String,
    val rank: Int,
    val symbol: String,
    val type: String
)

fun Coins.toCoin(): CoinCopy {
    return CoinCopy(
        id = id,
        isActive = is_active,
        name = name,
        rank = rank,
        symbol = symbol
    )
}