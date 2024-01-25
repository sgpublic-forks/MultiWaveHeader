package com.scwang.wave.app.activity

import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.bottomnavigation.BottomNavigationView.OnNavigationItemSelectedListener
import com.scwang.wave.app.R
import com.scwang.wave.app.databinding.ActivityMainBinding
import com.scwang.wave.app.fragment.WaveConsoleFragment
import kotlin.reflect.KClass

class MainActivity : AppCompatActivity(), OnNavigationItemSelectedListener {
    private val ViewBinding: ActivityMainBinding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    enum class Tabs(val menuId: Int, val clazz: KClass<out androidx.fragment.app.Fragment>) {
        WavePair(R.id.navigation_home, WaveConsoleFragment::class),
        Wave(R.id.navigation_dashboard, WaveConsoleFragment::class),
        Wave2(R.id.navigation_notifications, WaveConsoleFragment::class),
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(ViewBinding.root)

        ViewBinding.navigation.setOnNavigationItemSelectedListener(this)
        ViewBinding.navigation.selectedItemId = R.id.navigation_home
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        supportFragmentManager
                .beginTransaction()
                .setTransition(androidx.fragment.app.FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                .replace(R.id.content, Tabs.values().first { it.menuId==item.itemId }.clazz.java.newInstance())
                .commit()
        return true
    }

}
