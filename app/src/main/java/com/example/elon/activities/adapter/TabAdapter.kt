package com.example.elon.activities.adapter

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.elon.activities.DashBoard
import com.example.elon.activities.fragment.LinearQuizFragment
import com.example.elon.activities.fragment.LinearSkillFragment

class TabAdapter(fm: DashBoard) : FragmentStateAdapter(fm) {


    override fun getItemCount(): Int {
        return 2
    }

    override fun createFragment(position: Int): Fragment {

        return if (position == 0) {

            LinearQuizFragment()

        } else if (position == 1) {
            LinearSkillFragment()
        } else LinearQuizFragment()

    }


}