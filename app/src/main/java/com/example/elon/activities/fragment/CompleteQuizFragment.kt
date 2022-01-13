package com.example.elon.activities.fragment

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.elon.R
import com.example.elon.activities.DashBoard
import com.example.elon.activities.SkillVideo
import com.example.elon.activities.adapter.LinearSkillAdapter
import com.example.elon.activities.interfaces.Listener
import com.example.elon.activities.models.NewSkillModel
import kotlinx.android.synthetic.main.activity_dash_board.*
import kotlinx.android.synthetic.main.fragment_complete_quiz.*

class CompleteQuizFragment : Fragment(), Listener {

    var linearSkillAdapter: LinearSkillAdapter? = null


    lateinit var mainController: DashBoard


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_complete_quiz, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)




        mainController = context as DashBoard

        mainController.searchCardView.visibility = View.GONE
        mainController.txtToolbar.visibility = View.GONE
        mainController.cardMenu.visibility = View.VISIBLE
        mainController.totalQuiz.visibility = View.GONE
        mainController.completedQuiz.visibility = View.GONE
        mainController.txtToolbarQuiz.visibility = View.VISIBLE
        mainController.btnBack.visibility = View.GONE
        mainController.tab.visibility = View.GONE


        mainController.txtToolbarQuiz.setTextColor(
            ContextCompat.getColor(
                requireContext(),
                R.color.loginColor
            )
        )


        load.setOnClickListener(View.OnClickListener {

            val skillsFragment = SkillsFragment()
            requireActivity().supportFragmentManager.beginTransaction()
                .replace(R.id.fLayout, skillsFragment).addToBackStack(tag).commit()


        })


        btnDone.setOnClickListener(View.OnClickListener {

            (requireActivity() as DashBoard).supportFragmentManager.popBackStack()
            val homeFragment = HomeFragment()
            requireActivity().supportFragmentManager.beginTransaction()
                .replace(R.id.fLayout, homeFragment).addToBackStack(tag).commit()

        })


        selectSkill()


    }

    private fun selectSkill() {
        val sList = ArrayList<NewSkillModel>()
        sList.add(
            NewSkillModel(
                1,
                R.drawable.discussion,
                "Web Banner Design",

                )
        )
        sList.add(
            NewSkillModel(
                2,
                R.drawable.jacket,
                "Social Banner Design",

                )
        )

        doneRecyclerView.layoutManager = LinearLayoutManager(requireContext())
        linearSkillAdapter = LinearSkillAdapter(sList, requireContext(), this)
        doneRecyclerView.adapter = linearSkillAdapter
    }

    override fun onItemClick(position: Int) {
        val intent = Intent(requireContext(), SkillVideo::class.java)
        startActivity(intent)
    }
}