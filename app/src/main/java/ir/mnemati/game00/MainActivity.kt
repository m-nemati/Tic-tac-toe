package ir.mnemati.game00

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import ir.mnemati.game00.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    var flag = true // ture -> O , false -> x

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.imgCell1.setOnClickListener {
            if (flag) {
                binding.imgCell1.setImageResource(R.drawable.oo)
                flag = false
            }
            else{
                binding.imgCell1.setImageResource(R.drawable.x)
                flag = true
            }

        }
        binding.imgCell2.setOnClickListener {
            if (flag) {
                binding.imgCell2.setImageResource(R.drawable.oo)
                flag = false
            }
            else{
                binding.imgCell2.setImageResource(R.drawable.x)
                flag = true
            }

        }
        binding.imgCell6.setOnClickListener {

        }
        binding.imgCell9.setOnClickListener {

        }

    }

}