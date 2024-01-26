package com.example.shemajamebelin7.screen

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.shemajamebelin7.ListProvider.menuList
import com.example.shemajamebelin7.R
import com.example.shemajamebelin7.adapeter.MenuAdapter
import com.example.shemajamebelin7.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var toggle: ActionBarDrawerToggle
    private lateinit var adapter: MenuAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupAdapter()

       toggle = ActionBarDrawerToggle(this, binding.root, R.string.open, R.string.close)
        binding.root.addDrawerListener(toggle)
        toggle.syncState()
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        listeners()
    }


    private fun listeners() {

        with(binding){
            btnBusiness.setOnClickListener {
                it.setBackgroundResource(R.drawable.bg_btn_blue)
                btnPersonal.setBackgroundResource(R.drawable.bg_btn_white)
            }
            btnPersonal.setOnClickListener {
                it.setBackgroundResource(R.drawable.bg_btn_blue)
                btnBusiness.setBackgroundResource(R.drawable.bg_btn_white)
            }
        }
    }

    private fun setupAdapter() {
        val rv = binding.rvMenu
        adapter = MenuAdapter { Toast.makeText(this, it.title, Toast.LENGTH_SHORT).show() }
        rv.adapter = adapter
        rv.layoutManager = LinearLayoutManager(this)
        adapter.submitList(menuList)
    }


}


