package dev.sukhrob.nested_recyclerview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import dev.sukhrob.nested_recyclerview.databinding.ActivityMainBinding
import dev.sukhrob.nested_recyclerview.dialog.MyDialog

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initViewBinding()
        setClickListeners()
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
        MyDialog().show(supportFragmentManager, "my_dialog")
    }
}