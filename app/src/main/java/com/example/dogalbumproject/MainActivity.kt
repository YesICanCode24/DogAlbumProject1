package com.example.dogalbumproject

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.net.toUri
import coil.load
import com.example.dogalbumproject.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val viewModel: DogViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        getRandomDogPhoto()
    }

    fun getRandomDogPhoto() {

        val randomPhotoButton = binding.button4

        viewModel.dogPhoto.observe(this, {val imgUri = it.imageUrl!!.toUri().buildUpon().scheme("https").build()
            binding.imageView.load(imgUri)
            })
        randomPhotoButton.setOnClickListener {
            viewModel.getNewPhoto()
        }



    }
}