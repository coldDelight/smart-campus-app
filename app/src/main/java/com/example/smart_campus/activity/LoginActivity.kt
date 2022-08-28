package com.example.smart_campus.activity

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.example.smart_campus.SmartCampusApp
import com.example.smart_campus.databinding.ActivityLoginPageBinding
import com.example.smart_campus.presentaion.viewmodel.LoginViewModel

class LoginActivity : AppCompatActivity() {
    private val binding by lazy { ActivityLoginPageBinding.inflate(layoutInflater) }
    private val viewModel by lazy { ViewModelProvider(this,
        LoginViewModel.Factory())[LoginViewModel::class.java] }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        binding.viewModel = viewModel
        binding.lifecycleOwner = this
        binding.buttonLoginLogin.setOnClickListener {
            val user_id = binding.userIdValue.text.toString()
            val pwd = binding.pwdValue.text.toString()
            viewModel.Login(user_id,pwd)
        }
        setObserver()
    }
    private fun setObserver() {
        viewModel.retrofitLogin.observe(this) {
            if(it.response.jwt_token!=""){
                SmartCampusApp.prefs.token= it.response.jwt_token
                val intent = Intent(applicationContext, HomeActivity::class.java)
                finish()
                startActivity(intent)
            }else{
                val myToast = Toast.makeText(this, it.error.message, Toast.LENGTH_SHORT)
                myToast.show()
            }
        }
    }
}