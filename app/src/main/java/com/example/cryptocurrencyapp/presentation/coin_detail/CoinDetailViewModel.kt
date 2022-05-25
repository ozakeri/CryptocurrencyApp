package com.example.cryptocurrencyapp.presentation.coin_detail

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.cryptocurrencyapp.common.Constant
import com.example.cryptocurrencyapp.common.Resource
import com.example.cryptocurrencyapp.domain.use_case.get_coins_usecase.GetCoinUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach

@HiltViewModel
class CoinDetailViewModel(
    val useCase: GetCoinUseCase,
    saveStateHandle: SavedStateHandle
) : ViewModel() {

    private val _state = mutableStateOf(CoinDetailState())
    val state: State<CoinDetailState> = _state

    init {
        saveStateHandle.get<String>(Constant.PARAM_COIN_ID)?.let { coinId ->
            getCoinById(coinId)
        }

    }


    fun getCoinById(coinId: String) {

        useCase(coinId).onEach { result ->
            when (result) {
                is Resource.Success -> {
                    _state.value = CoinDetailState(coin = result.data)
                }

                is Resource.Loading -> {
                    _state.value = CoinDetailState(loading = true)
                }

                is Resource.Error -> {
                    _state.value = CoinDetailState(error = "An unexpected error occured")
                }
            }
        }.launchIn(viewModelScope)

    }

}