package com.example.tabview

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.google.android.material.tabs.TabLayout

class MainActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val tab = findViewById<TabLayout>(R.id.tabloyout)
        var fragment : Fragment = RedFragment()

        val fragmentTransaction = supportFragmentManager. beginTransaction()
        fragmentTransaction.replace(R.id.fregmelayout, fragment)
        fragmentTransaction.commit()

        tab.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener{
            override fun onTabSelected(tab: TabLayout.Tab?) {
                when(tab!!.position){
                    0 -> fragment = RedFragment()
                    1 -> fragment = YellowFragment()
                    2 -> fragment = BlueFragment()
                    3 -> fragment = GreenFragment()
                    4 -> fragment = PurpleFragment()
                }
                val ft = supportFragmentManager.beginTransaction()
                ft.replace(R.id.fregmelayout, fragment)
                ft.commit()
            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {

            }

            override fun onTabReselected(tab: TabLayout.Tab?) {

            }
        }
        )

    }
}