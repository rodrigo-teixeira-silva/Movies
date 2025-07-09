package com.example.filmescorroutines

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class MainViewModel(private val repository: MainRepository) : ViewModel() {

    val filmesLiveData = MutableLiveData<List<Filme>>()

    fun getFilmes() {
        repository.getFilmes { filmes ->
            filmesLiveData.postValue(filmes)
        }
    }

    class MaisviewModelFactory(private val repository: MainRepository) : ViewModelProvider.Factory {
        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            return MainViewModel(repository) as T
        }
    }
}
