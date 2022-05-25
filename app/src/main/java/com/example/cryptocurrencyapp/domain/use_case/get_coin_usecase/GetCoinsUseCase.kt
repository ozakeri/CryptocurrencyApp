package com.example.cryptocurrencyapp.domain.use_case.get_coin_usecase

import com.example.cryptocurrencyapp.common.Resource
import com.example.cryptocurrencyapp.data.remote.datamodel.toCoin
import com.example.cryptocurrencyapp.domain.model.CoinCopy
import com.example.cryptocurrencyapp.domain.repository.CoinRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetCoinsUseCase @Inject constructor(private val repository: CoinRepository) {

    operator fun invoke(): Flow<Resource<List<CoinCopy>>> = flow {
        try {

            emit(Resource.Loading<List<CoinCopy>>())
            val result = repository.getCoins().map { it.toCoin() }
            emit(Resource.Success<List<CoinCopy>>(result))

        } catch (e: HttpException) {
            emit(
                Resource.Error<List<CoinCopy>>(
                    e.localizedMessage ?: "An unexpected error occured"
                )
            )
        } catch (e: IOException) {
            emit(Resource.Error<List<CoinCopy>>("Couldn't reach server. Check your internet connection."))
        }
    }
}