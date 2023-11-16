package com.example.generalowiewiary.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import androidx.viewpager2.widget.ViewPager2
import com.example.generalowiewiary.R
import com.example.generalowiewiary.ui.gallery.PhotosFragment
import com.example.generalowiewiary.ui.home.BiographyFragment
import com.example.generalowiewiary.ui.videos.VideosFragment
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

//class TopMenuFragment :  Fragment() {
//    private lateinit var tabLayout: TabLayout
//    private lateinit var viewPager: ViewPager2
//
//    override fun onCreateView(
//        inflater: LayoutInflater,
//        container: ViewGroup?,
//        savedInstanceState: Bundle?
//    ): View? {
//        val view = inflater.inflate(R.layout.fragment_top_menu, container, false)
//
//        tabLayout = view.findViewById(R.id.tab_layout)
//        viewPager = view.findViewById(R.id.view_pager)
//
//        val fragmentList = arrayListOf(
//            BiographyFragment(),
//            PhotosFragment(),
//            VideosFragment()
//        )
//
//        val adapter = ViewPagerAdapter(
//            fragmentList,
//            this.childFragmentManager,
//            lifecycle
//        )
//
//        viewPager.adapter = adapter
//
//        TabLayoutMediator(tabLayout, viewPager) { tab, position ->
//            when (position) {
//                0 -> {
//                    tab.text = "John G Lake"
//                }
//                1 -> {
//                    tab.text = "Smith Wigglesworth"
//                }
//                2 -> {
//                    tab.text = "Kathryn Kuhlman"
//                }
//            }
//        }.attach()
//
//        return view
//    }
//}
//
//class ViewPagerAdapter(
//    private val fragmentList: List<Fragment>,
//    fragmentManager: FragmentManager,
//    lifecycle: Lifecycle
//) : FragmentStateAdapter(fragmentManager, lifecycle) {
//
//    override fun getItemCount(): Int = fragmentList.size
//
//    override fun createFragment(position: Int): Fragment {
//        return fragmentList[position]
//    }
//}

class TopMenuFragment :  Fragment() {
    private lateinit var tabLayout: TabLayout
    private lateinit var viewPager: ViewPager2

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_top_menu, container, false)

        tabLayout = view.findViewById(R.id.tab_layout)
        viewPager = view.findViewById(R.id.view_pager)

        val fragmentList = arrayListOf(
            PersonFragment("John G Lake"),
            PersonFragment("Smith Wigglesworth"),
            PersonFragment("Kathryn Kuhlman"),
            PersonFragment("Aleksander Dowie")
        )

        val adapter = ViewPagerAdapter(
            fragmentList,
            this.childFragmentManager,
            lifecycle
        )

        viewPager.adapter = adapter

        TabLayoutMediator(tabLayout, viewPager) { tab, position ->
            tab.text = fragmentList[position].personName
        }.attach()

        return view
    }
}

class ViewPagerAdapter(
    private val fragmentList: List<PersonFragment>,
    fragmentManager: FragmentManager,
    lifecycle: Lifecycle
) : FragmentStateAdapter(fragmentManager, lifecycle) {

    override fun getItemCount(): Int = fragmentList.size

    override fun createFragment(position: Int): Fragment {
        return fragmentList[position]
    }
}

class PersonFragment(val personName: String) : Fragment() {
    private lateinit var selectedTab: String

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val layout = if (::selectedTab.isInitialized) {
            when (selectedTab) {
                "Biografia" -> R.layout.fragment_biography
                "Zdjęcia" -> R.layout.fragment_photos
                "Filmy" -> R.layout.fragment_videos
                else -> R.layout.fragment_biography
            }
        } else {
            R.layout.fragment_biography
        }

        return inflater.inflate(layout, container, false)
    }

    fun selectTab(tab: String) {
        selectedTab = tab
    }
}