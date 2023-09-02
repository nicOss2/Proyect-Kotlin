package com.curso.comparar.compararapp.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import com.curso.comparar.compararapp.databinding.ActivityMainBinding
import com.curso.comparar.compararapp.viewmodel.MainViewModel

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val mainViewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        mainViewModel.compare.observe(this) {
            Log.i("nico", "$it")
            binding.tvCompare.text = it.result
        }



        binding.btnCompare.setOnClickListener {
            val cadena1 = binding.edFirstString.text.toString()
            val cadena2 = binding.edSecondString.text.toString()
            mainViewModel.compareStrings(cadena1, cadena2)
        }
    }


}
