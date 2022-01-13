package com.example.elon.activities.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.elon.R
import com.example.elon.activities.DashBoard
import kotlinx.android.synthetic.main.activity_dash_board.*

class AccountFragment : Fragment() {
    lateinit var mainController: DashBoard


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_account, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        mainController = context as DashBoard


        mainController.btnBack.visibility = View.VISIBLE
        mainController.tab.visibility = View.GONE



        mainController.txtToolbar.text = "My Profile"

        mainController.searchCardView.visibility = View.GONE

        mainController.txtToolbarQuiz.visibility = View.GONE
        mainController.totalQuiz.visibility = View.GONE
        mainController.completedQuiz.visibility = View.GONE


    }


}