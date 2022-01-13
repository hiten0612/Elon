package com.example.elon.activities.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.elon.R
import com.example.elon.activities.DashBoard
import kotlinx.android.synthetic.main.activity_dash_board.*
import kotlinx.android.synthetic.main.fragment_search.*


class SearchFragment : Fragment() {
    lateinit var mainController: DashBoard
    val quizFragment = QuizFragment()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_search, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        mainController = context as DashBoard

        mainController.btnBack.visibility = View.VISIBLE
        mainController.tab.visibility = View.GONE
        //mainController.rootTab.visibility = View.GONE
        mainController.txtToolbar.text = "Hi, Elon"

        btnSearch.setOnClickListener(View.OnClickListener {

            requireActivity().supportFragmentManager.popBackStack()
            requireActivity().supportFragmentManager.beginTransaction()
                .replace(R.id.fLayout, quizFragment, null).addToBackStack(tag).commit()

        })


    }


}