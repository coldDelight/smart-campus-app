package com.example.smart_campus.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.auth0.android.jwt.JWT
import com.example.smart_campus.R
import com.example.smart_campus.SmartCampusApp
import com.example.smart_campus.databinding.ActivityMyPageBinding
import com.example.smart_campus.databinding.ActivityNoticeDetailBinding
import com.google.android.gms.oss.licenses.OssLicensesMenuActivity

class MyPageActivity : AppCompatActivity() {
    private val binding by lazy { ActivityMyPageBinding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        val jwt = SmartCampusApp.prefs.token?.let { JWT(it) }
        val uid = jwt?.getClaim("STUDENT_ID")?.asString()
        val name = jwt?.getClaim("NM")?.asString()
        val dept = jwt?.getClaim("DEPT_NM")?.asString()
        binding.tvMyName.text = name
        binding.tvMyDept.text = dept
        binding.tvMyUid.text = uid

        binding.logoutBtn.setOnClickListener {
            SmartCampusApp.prefs.token=R.string.default_jwt.toString()
            val intent = Intent(applicationContext, LoginActivity::class.java)
            finishAffinity()
            startActivity(intent)
        }
        binding.myBackBtn.setOnClickListener {
            finish()
        }
        binding.textView26.setOnClickListener{
            Intent(applicationContext, OssLicensesMenuActivity::class.java).also {
                OssLicensesMenuActivity.setActivityTitle("오픈소스 라이선스")
                startActivity(it)
            }
        }
    }
}