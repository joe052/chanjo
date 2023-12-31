package com.antidote.mchanjo

import android.content.Context
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController

class SplashFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Use Handler with Looper.getMainLooper() to operate on the main thread
        Handler(Looper.getMainLooper()).postDelayed({
            // Check if the user has finished the onboarding process
            if (onBoardingFinished()){
                findNavController().navigate(R.id.action_splashFragment_to_loginActivity)
            } else {
                findNavController().navigate(R.id.action_splashFragment_to_viewPagerFragment)
            }
        }, 3000)
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_splash, container, false)
    }

    private fun onBoardingFinished(): Boolean {
        val sharedPref = requireActivity().getSharedPreferences("onBoarding", Context.MODE_PRIVATE)
        return sharedPref.getBoolean("Finished", false)
    }
}



//package com.antidote.mchanjo
//
//import android.content.Context
//import android.os.Bundle
//import android.os.Handler
//import androidx.fragment.app.Fragment
//import android.view.LayoutInflater
//import android.view.View
//import android.view.ViewGroup
//import androidx.navigation.fragment.findNavController
//
//
//class SplashFragment : Fragment() {
//    override fun onCreateView(
//        inflater: LayoutInflater, container: ViewGroup?,
//        savedInstanceState: Bundle?
//    ): View? {
//        Handler().postDelayed({
////            Check if the user has finished the onboarding process
//            if (onBoardingFinished()){
//                findNavController().navigate(R.id.action_splashFragment_to_loginActivity)
//
//            }else{
//                findNavController().navigate(R.id.action_splashFragment_to_viewPagerFragment)
//            }
//        }, 3000)
//        // Inflate the layout for this fragment
//        return inflater.inflate(R.layout.fragment_splash, container, false)
//    }
//    private fun onBoardingFinished():Boolean{
//        val sharedPref = requireActivity().getSharedPreferences("onBoarding", Context.MODE_PRIVATE)
//        return sharedPref.getBoolean("Finished", false)
//    }
//}