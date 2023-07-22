package com.antidote.mchanjo.guidelines

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewpager2.widget.ViewPager2
import com.antidote.mchanjo.R



class ViewGuidelinesPageFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
//        This will return the view of the fragments
        val view = inflater.inflate(R.layout.fragment_view_pager, container, false)

        val fragmentList = arrayListOf<Fragment>(
            MalariaFirstScreen(),
            MalariaSecondScreen(),
            MalariaThirdScreen()
        )
        val adapter = ViewGuidelinesPageAdapter(fragmentList,requireActivity().supportFragmentManager, lifecycle)
        view.findViewById<ViewPager2>(R.id.viewPager).adapter = adapter
        return view
    }

}