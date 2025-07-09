package com.example.filmescorroutines

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
}
