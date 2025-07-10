package com.example.filmescorroutines

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider

class MainFragment : Fragment() {

    companion object {
        fun newInstance() = MainFragment()
    }

    private lateinit var viewModel: MainViewModel
    private lateinit var textViewFilmes: TextView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.fragment_main, container, false) // Certo!
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        textViewFilmes = view.findViewById(R.id.textViewFilmes)

        viewModel = ViewModelProvider(
            this,
            MainViewModel.MaisviewModelFactory(MainRepository())
        )[MainViewModel::class.java]

        viewModel.filmesLiveData.observe(viewLifecycleOwner, Observer { filmes ->
            if (filmes.isNotEmpty()) {
                textViewFilmes.text = filmes[0].titulo
            }
        })

        viewModel.getFilmeCoroutine()
    }
}
