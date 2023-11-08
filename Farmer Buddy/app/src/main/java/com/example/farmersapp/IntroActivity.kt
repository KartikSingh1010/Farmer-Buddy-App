package com.example.farmersapp

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import androidx.appcompat.app.AppCompatActivity
import com.example.farmersapp.adapters.IntroViewPagerAdapter
import com.example.farmersapp.databinding.ActivityIntroBinding
import com.example.farmersapp.models.ScreenItem
import com.google.android.material.tabs.TabLayout

class IntroActivity : AppCompatActivity() {

    var introViewPagerAdapter: IntroViewPagerAdapter? = null
    var position = 0
    var btnAnim: Animation? = null
    lateinit var binding: ActivityIntroBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityIntroBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        btnAnim = AnimationUtils.loadAnimation(applicationContext, R.anim.button_animation)

        val mList: MutableList<ScreenItem> = ArrayList()

        //changed here
        mList.add(
            ScreenItem(
                "Crops Information",
                "Details about crop prices , pesticides and fertilizers , harvesting time and more",
                R.drawable.ic_crop_img
            )
        )
        mList.add(
            ScreenItem(
                "Favourable Crops",
                "Recommends best crops according to soil types , temperature and rainfall in an area",
                R.drawable.crop_rec
            )
        )

        mList.add(
            ScreenItem(
                "Soil moisture level",
                "Soil moisture is an important indicator in farming that helps to reduce water consumption.",
                R.drawable.water_level
            )
        )
        mList.add(
            ScreenItem(
                "Agriculture Policies",
                "Information about important agriculture schemes introduced by the government",
                R.drawable.schemes
            )
        )

        // setup viewpager
        introViewPagerAdapter = IntroViewPagerAdapter(this, mList)
        binding.screenViewpager.adapter = introViewPagerAdapter

        // setup tab layout with viewpager
        binding.tabIndicator.setupWithViewPager(binding.screenViewpager)

        // Get Started button click listener
        binding.btnGetStarted.setOnClickListener(View.OnClickListener {

            startActivity( Intent(applicationContext, LoginActivity::class.java))
            savePrefsData()
            finish()
        })


        // next button click Listener
        binding.btnNext.setOnClickListener(View.OnClickListener {
            position = binding.screenViewpager.currentItem
            if (position < mList.size) {
                position++
                binding.screenViewpager.currentItem = position
            }
            if (position == mList.size - 1) { // when we reach to the last screen

                loadLastScreen()
            }
        })


        // skip button click listener
        binding.tvSkip.setOnClickListener(View.OnClickListener {
            binding.screenViewpager.currentItem = mList.size
        })


        // tabLayout add change listener
        binding.tabIndicator.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab?) {
                if (tab!!.position == mList.size - 1) {
                    loadLastScreen()
                }
            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {
            }

            override fun onTabReselected(tab: TabLayout.Tab?) {
            }

        })
    }

    private fun savePrefsData() {
        val pref = applicationContext.getSharedPreferences("myPrefs", MODE_PRIVATE)
        val editor = pref.edit()
        editor.putBoolean("isIntroOpened", true)
        editor.apply()
    }

    private fun restorePrefData(): Boolean {
        val pref = applicationContext.getSharedPreferences(
            "myPrefs",
            MODE_PRIVATE
        )
        return pref.getBoolean("isIntroOpened", false)

    }

    // show the GET STARTED Button and hide the indicator and the next button
    private fun loadLastScreen() {
        binding.btnNext.visibility = View.INVISIBLE
        binding.btnGetStarted.visibility = View.VISIBLE
        binding.tvSkip.visibility = View.INVISIBLE
        binding.tabIndicator.visibility = View.INVISIBLE
        // setup animation
        binding.btnGetStarted.animation = btnAnim
    }

    override fun onStart() {
        super.onStart()
        if (restorePrefData()) {
            startActivity(Intent(this, LoginActivity::class.java))
            finish()
        }
    }
}