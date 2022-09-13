package dev.sukhrob.nested_recyclerview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import dev.sukhrob.nested_recyclerview.databinding.ActivityMainBinding
import dev.sukhrob.nested_recyclerview.dialog.MyDialog

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var dialog: MyDialog

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initViewBinding()
        setClickListeners()

        dialog = MyDialog()
        dialog.selected = {
            // do something after get data from MyDialog
        }
    }

    private fun setClickListeners() {
        binding.btnOpenDialog.setOnClickListener {
            openDialog()
        }
    }

    private fun initViewBinding() {
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    private fun openDialog() {
        dialog.show(supportFragmentManager, "my_dialog")
    }
}