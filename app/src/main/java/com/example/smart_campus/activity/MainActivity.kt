package com.example.smart_campus.activity

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.example.smart_campus.BuildConfig
import com.example.smart_campus.LoginService
import com.example.smart_campus.R
import com.example.smart_campus.SmartCampusApp
import com.example.smart_campus.model.Login
import com.google.android.gms.tasks.OnCompleteListener
import com.google.firebase.messaging.FirebaseMessaging
import com.google.gson.JsonObject
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

//@AndroidEntryPoint// DI 필요
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login_page)
        //파베 테스트
        FirebaseMessaging.getInstance().token.addOnCompleteListener(OnCompleteListener { task ->
            if(!task.isSuccessful){
                return@OnCompleteListener
            }
            val token = task.result
        })
        val token = SmartCampusApp.prefs.token
        if(token=="NoTOKEN"){
            val intent = Intent(applicationContext, LoginActivity::class.java)
            finish()
            startActivity(intent)
        }else{
            val intent = Intent(applicationContext, HomeActivity::class.java)
            finish()
            startActivity(intent)
        }

//        val token = SmartCampusApp.prefs.token
//        if (token!="NO_TOKEN"){
//            val intent = Intent(applicationContext, HomeActivity::class.java)
//            finish()
//            startActivity(intent)
//        }else{
//            SmartCampusApp.prefs.token="NO_TOKEN"
//        }
//        loginBtn.setOnClickListener() {
//            Log.e("dddd", "onCreate: $userAuth",)
//
//            loginService.requestLogin(userAuth).enqueue(object : Callback<Login> {
//                //                loginService.requestLogin(paramData).enqueue(object :Callback<Login>{
//                override fun onResponse(call: Call<Login>, response: Response<Login>) {
//                    val loginData = response.body()
//                    if (loginData != null) {
//                        SmartCampusApp.prefs.token = loginData.response.jwt_token
//                        val intent = Intent(applicationContext, HomeActivity::class.java)
//                        finish()
//                        startActivity(intent)
//                    }
//                }
//                override fun onFailure(call: Call<Login>, t: Throwable) {
//                    Log.e("err", "onFailure: ${t.message}",)
//                }
//            })
//        }
    }
}