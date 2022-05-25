package com.example.cryptocurrencyapp.presentation.coin_detail

import com.example.cryptocurrencyapp.domain.model.CoinDetail

data class CoinDetailState(
    val coin: CoinDetail? = null,
    val loading: Boolean = false,
    val error: String = ""
)
