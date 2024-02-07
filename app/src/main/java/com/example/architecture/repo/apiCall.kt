package ir.ali.mvvm_sample.repo

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.liveData
import kotlinx.coroutines.*
import kotlinx.coroutines.Dispatchers.Default
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.Dispatchers.Main
import retrofit2.HttpException
import java.io.IOException

fun <T> apiCall(emitter: RemoteErrorEmitter,responseFunction: suspend () -> T) : LiveData<T?> {
    return liveData {
        val respone = privateApiCall(emitter,responseFunction)
        emit(respone)
    }
}


private suspend fun <T> privateApiCall(emitter: RemoteErrorEmitter, responseFunction: suspend () -> T): T? {
    try{
        return responseFunction()
    }catch (e: Exception){
        withContext(Dispatchers.Main){
            e.printStackTrace()
            Log.e("ApiCalls", "Call error: ${e.localizedMessage}", e.cause)
            when(e){
                is HttpException -> {
                    val body = e.response()?.errorBody()
                    emitter.onError("Error")
                }
                is TimeoutCancellationException -> emitter.onError(ErrorType.TIMEOUT)
                is IOException -> emitter.onError(ErrorType.NETWORK)
                else -> emitter.onError(ErrorType.UNKNOWN)
            }
        }
        return null
    }
}

