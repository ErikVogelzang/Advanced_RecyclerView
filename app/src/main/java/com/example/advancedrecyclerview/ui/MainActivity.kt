package com.example.advancedrecyclerview.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.advancedrecyclerview.model.ColorItem
import com.example.advancedrecyclerview.R
import com.example.advancedrecyclerview.model.MainActivityViewModel
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var viewModel: MainActivityViewModel
    private val colorList = arrayListOf<ColorItem>()
    private val colorAdapter = ColorAdapter(
        colorList,
        { colorItem -> onColorClick(colorItem) })

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initViews()
        initViewModel()
    }

    private fun initViews() {
        rvColors.layoutManager = LinearLayoutManager(
            this,
            LinearLayoutManager.VERTICAL,
            false)
        rvColors.adapter = colorAdapter
    }

    private fun initViewModel() {
        viewModel = ViewModelProvider(this).get(MainActivityViewModel::class.java)
        viewModel.colorItems.observe(this, Observer {
            colorList.clear()
            colorList.addAll(it)
            colorAdapter.notifyDataSetChanged()
        })
    }

    private fun onColorClick(colorItem: ColorItem) {
        Snackbar.make(rvColors, "This color is: ${colorItem.name}",
            Snackbar.LENGTH_LONG).show()

    }
}
