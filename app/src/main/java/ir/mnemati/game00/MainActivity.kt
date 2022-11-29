package ir.mnemati.game00

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.Toast
import ir.mnemati.game00.databinding.ActivityMainBinding
import kotlin.system.exitProcess

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    var flag = 0   // 0 -> oo , 1 -> x
    var cells = arrayOf(10,11,12,13,14,15,16,17,18) // empty = 10..18, oo -> 0, x -> 1
    var winnerFind = false
    var finishGameFlag = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.btnReset.setOnClickListener {
            flag = 0
            winnerFind = false
            finishGameFlag = false
            binding.btnReset.isEnabled = false
            cells = arrayOf(10,11,12,13,14,15,16,17,18)
            binding.imgCell0.setImageBitmap(null)
            binding.imgCell1.setImageBitmap(null)
            binding.imgCell2.setImageBitmap(null)
            binding.imgCell3.setImageBitmap(null)
            binding.imgCell4.setImageBitmap(null)
            binding.imgCell5.setImageBitmap(null)
            binding.imgCell6.setImageBitmap(null)
            binding.imgCell7.setImageBitmap(null)
            binding.imgCell8.setImageBitmap(null)

        }



    }

    fun checkWinner(){
        if (   cells[0] == cells[1] && cells[1] == cells[2]
            || cells[3] == cells[4] && cells[4] == cells[5]
            || cells[6] == cells[7] && cells[7] == cells[8]
            || cells[0] == cells[3] && cells[3] == cells[6]
            || cells[1] == cells[4] && cells[4] == cells[7]
            || cells[2] == cells[5] && cells[5] == cells[8]
            || cells[0] == cells[4] && cells[4] == cells[8]
            || cells[2] == cells[4] && cells[4] == cells[6]) {
            winnerFind = true
            binding.btnReset.isEnabled = true
            if (flag == 0)
                Toast.makeText(this, "X is winner", Toast.LENGTH_SHORT).show()
            else
                Toast.makeText(this, "O is winner", Toast.LENGTH_SHORT).show()
        }


    }
    fun finishedGame(){
        var sumOfCells = 0
        for(i in 0..8){
            sumOfCells += cells[i]
        }
        if (sumOfCells < 10){
            Toast.makeText(this, "Draw!", Toast.LENGTH_SHORT).show()
            finishGameFlag = true
            binding.btnReset.isEnabled = true
        }
    }

    fun clickOnImages(view: View){
        if (winnerFind || finishGameFlag) {
            Toast.makeText(this, "End of the game, please reset game and play again", Toast.LENGTH_SHORT).show()
            return@clickOnImages
        }
        val clickedImage: ImageView = view as ImageView
        var tagId = clickedImage.getTag().toString().toInt()
        if (cells[tagId] == 0 || cells[tagId] == 1){
            Toast.makeText(this, "Select an other cell", Toast.LENGTH_SHORT).show()
        }
        else{
            clickedImage.translationY = -1500f
            cells[tagId] = flag
            if (flag == 0) {
                clickedImage.setImageResource(R.drawable.oo)
                flag = 1
            }
            else{
                clickedImage.setImageResource(R.drawable.x)
                flag = 0
            }
            clickedImage.animate().translationYBy(1500f).rotation(3600f).duration = 500
        }
        checkWinner()
        finishedGame()
    }

}