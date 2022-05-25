package com.example.cryptocurrencyapp.presentation.coin_list

import com.example.cryptocurrencyapp.domain.model.CoinCopy

data class CoinListState(
    val loading: Boolean = false,
    val coins: List<CoinCopy> = emptyList(),
    val error: String = ""
)
