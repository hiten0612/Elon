package com.example.elon.activities.fragment

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.elon.R
import com.example.elon.activities.DashBoard
import com.example.elon.activities.SkillVideo
import com.example.elon.activities.adapter.NewSkillAdapter
import com.example.elon.activities.adapter.QuizAdapter
import com.example.elon.activities.interfaces.Listener
import com.example.elon.activities.models.NewQuizModel
import com.example.elon.activities.models.NewSkillModel
import kotlinx.android.synthetic.main.activity_dash_board.*
import kotlinx.android.synthetic.main.fragment_home.*

class HomeFragment : Fragment(), Listener {

    lateinit var mainController: DashBoard
    var newSkillAdapter: NewSkillAdapter? = null
    private val startQuizFragment = StartQuizFragment()
    var quizAdapter: QuizAdapter? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        mainController = context as DashBoard
        mainController.btnBack.visibility = View.GONE
        mainController.txtToolbar.visibility = View.VISIBLE
        mainController.txtToolbar.text = "Hi, Elon"
        mainController.txtToolbarQuiz.visibility = View.GONE
        mainController.searchCardView.visibility = View.VISIBLE
        mainController.cardMenu.visibility = View.VISIBLE
        mainController.tab.visibility = View.GONE

        mainController.totalQuiz.visibility = View.GONE
        mainController.completedQuiz.visibility = View.GONE
        //  mainController.rootTab.visibility = View.GONE

        btnStart.setOnClickListener(View.OnClickListener {
            requireActivity().supportFragmentManager.beginTransaction()
                .replace(R.id.fLayout, startQuizFragment, null).addToBackStack(tag).commit()
        })
        skill()
        quiz()


    }

    private fun skill() {

        val arrayList = ArrayList<NewSkillModel>()
        arrayList.add(NewSkillModel(1, R.drawable.causal, "Web Banner Design"))
        arrayList.add(NewSkillModel(2, R.drawable.jacket, "Social Banner Design"))
        arrayList.add(NewSkillModel(3, R.drawable.sweatshirt, "Google Ceo"))
        arrayList.add(NewSkillModel(4, R.drawable.sweater, "Mobile App Code"))
        arrayList.add(NewSkillModel(5, R.drawable.polo, "Marketing Document"))
        skillRecyclerView.layoutManager =
            LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, true)
        newSkillAdapter = NewSkillAdapter(arrayList, requireContext(), this)
        skillRecyclerView.adapter = newSkillAdapter

    }

    private fun quiz() {

        val quizList = ArrayList<NewQuizModel>()
        quizList.add(
            NewQuizModel(
                1,
                R.drawable.discussion,
                "Social Media Quiz",

                )
        )
        quizList.add(
            NewQuizModel(
                2,
                R.drawable.discussion,
                "Finance Quiz",

                )
        )
        quizList.add(
            NewQuizModel(
                3,
                R.drawable.discussion,
                "Web Site",

                )
        )
        quizList.add(
            NewQuizModel(
                4,
                R.drawable.discussion,
                "Google SEO Quiz",

                )
        )
        quizList.add(
            NewQuizModel(
                5,
                R.drawable.discussion,
                "Techenical Quiz",

                )
        )

        quizRecyclerView.layoutManager =
            LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, true)
        quizAdapter = QuizAdapter(quizList, requireContext())
        quizRecyclerView.adapter = quizAdapter


    }

    override fun onItemClick(position: Int) {
        val intent = Intent(requireContext(), SkillVideo::class.java)
        startActivity(intent)
    }


}