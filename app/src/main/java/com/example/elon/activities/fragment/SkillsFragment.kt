package com.example.elon.activities.fragment

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.elon.R
import com.example.elon.activities.DashBoard
import kotlinx.android.synthetic.main.activity_dash_board.*


class SkillsFragment : Fragment() {


    lateinit var mainController: DashBoard

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_skills, container, false)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        mainController = context as DashBoard
        //   mainController.rootTab.visibility = View.VISIBLE

        Log.v("==========", "skill")
        mainController = context as DashBoard
        mainController.btnBack.visibility = View.GONE
        mainController.txtToolbar.visibility = View.VISIBLE
        mainController.txtToolbar.text = "Hi, Elon"
        mainController.txtToolbarQuiz.visibility = View.GONE
        mainController.searchCardView.visibility = View.VISIBLE
        mainController.cardMenu.visibility = View.VISIBLE

        mainController.totalQuiz.visibility = View.GONE
        mainController.completedQuiz.visibility = View.GONE
        mainController.tab.visibility = View.VISIBLE
        mainController.viewPager2.post {

            mainController.viewPager2.setCurrentItem(1, true)

        }


//        viewPager3.post {
//            viewPager3.setCurrentItem(1, true)
//        }


    }


}