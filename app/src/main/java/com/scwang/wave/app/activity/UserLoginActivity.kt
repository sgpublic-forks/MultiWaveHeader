package com.scwang.wave.app.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.scwang.wave.app.databinding.ActivityUserLoginBinding
import com.scwang.wave.app.fragment.WaveConsoleFragment
import com.scwang.wave.app.util.StatusBarUtil


class UserLoginActivity : AppCompatActivity() {
    private val ViewBinding: ActivityUserLoginBinding by lazy {
        ActivityUserLoginBinding.inflate(layoutInflater)
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(ViewBinding.root)
        //状态栏透明和间距处理
        StatusBarUtil.immersive(this)

        ViewBinding.login.setOnClickListener {
//            startActivity(Intent(this, MainActivity::class.java))
            FragmentActivity.start(this, WaveConsoleFragment::class.java)
        }

    }
}
