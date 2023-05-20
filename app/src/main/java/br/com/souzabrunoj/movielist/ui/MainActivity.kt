package br.com.souzabrunoj.movielist.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.fragment.NavHostFragment
import br.com.souzabrunoj.movielist.R
import br.com.souzabrunoj.movielist.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val navController by lazy {
        (supportFragmentManager.findFragmentById(R.id.fc_nav_host_fragment) as NavHostFragment).navController
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

    }
}
