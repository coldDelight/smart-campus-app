package com.example.smart_campus

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.example.smart_campus.model.Login
import com.google.gson.JsonObject
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

//@AndroidEntryPoint// DI 필요
class MainActivity : AppCompatActivity() {
    //    private lateinit var binding: ActivityLoginPageBinding
//    private val viewModel : MyViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login_page)


        val retrofit = Retrofit.Builder()
            .baseUrl(BuildConfig.BASE_URL)
//            .baseUrl("http://210.119.104.203/:80/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val loginService: LoginService = retrofit.create(LoginService::class.java)
        val userAuth = JsonObject()
        userAuth.addProperty("user_id", "20171302")
        userAuth.addProperty("pwd", "1q2w3e4r~!")

        val loginBtn = findViewById<Button>(R.id.button_login_login)
        val token = SmartCampusApp.prefs.token
        Log.e("eee", "onCreate: ${token}", )
        if (token!="NO_TOKEN"){
            val intent = Intent(applicationContext, HomeActivity::class.java)
            startActivity(intent)
        }else{
            SmartCampusApp.prefs.token="NO_TOKEN"
        }
        loginBtn.setOnClickListener() {
            Log.e("dddd", "onCreate: $userAuth",)

            loginService.requestLogin(userAuth).enqueue(object : Callback<Login> {
                //                loginService.requestLogin(paramData).enqueue(object :Callback<Login>{
                override fun onResponse(call: Call<Login>, response: Response<Login>) {
                    val loginData = response.body()
                    if (loginData != null) {
                        SmartCampusApp.prefs.token = loginData.response.jwt_token
                        val intent = Intent(applicationContext, HomeActivity::class.java)
                        startActivity(intent)
                    }
                }
                override fun onFailure(call: Call<Login>, t: Throwable) {
                    Log.e("err", "onFailure: ${t.message}",)
                }

            })




        }
    }
}