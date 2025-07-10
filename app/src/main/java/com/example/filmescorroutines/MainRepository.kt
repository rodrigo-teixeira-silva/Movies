package com.example.filmescorroutines

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.withContext

class MainRepository {
    fun getFilmes(callback: (List<Filme>) -> Unit) {
        Thread {
            Thread.sleep(2000)
            callback(
                listOf(
                    Filme(1, "Título 01"),
                    Filme(2, "Título 02")
                )
            )
        }.start()
    }

    suspend fun getFilmeCouroutine(): List<Filme> {
        return withContext(Dispatchers.Default) {
           delay(3000)
            listOf(
                Filme(1, "Título 01"),
                Filme(2, "Título 02")
            )
        }
    }

}
