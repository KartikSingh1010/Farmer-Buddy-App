package com.example.farmersapp.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.viewpager.widget.PagerAdapter
import com.example.farmersapp.R
import com.example.farmersapp.models.ScreenItem

class IntroViewPagerAdapter(var mContexts: Context, var mListScreens: List<ScreenItem>) : PagerAdapter() {

    var mContext: Context = mContexts
    var mListScreen: List<ScreenItem> = mListScreens

    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        val inflater: LayoutInflater =
            mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        val layoutScreen: View = inflater.inflate(R.layout.layout_screen, null)
        val imgSlide = layoutScreen.findViewById<ImageView>(R.id.intro_img)
        val title: TextView = layoutScreen.findViewById<TextView>(R.id.intro_title)
        val description: TextView = layoutScreen.findViewById<TextView>(R.id.intro_description)
        title.text = mListScreen[position].getmTitle()
        description.text = mListScreen[position].getmDescription()
        imgSlide.setImageResource(mListScreen[position].getmScreenImg())
        container.addView(layoutScreen)
        return layoutScreen
    }

    override fun getCount(): Int {
        return mListScreen.size
    }

    override fun isViewFromObject(view: View, o: Any): Boolean {
        return view === o
    }

    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
        container.removeView(`object` as View)
    }
}