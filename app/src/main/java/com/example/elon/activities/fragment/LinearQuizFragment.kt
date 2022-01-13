package com.example.elon.activities.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.elon.R
import com.example.elon.activities.adapter.LinearQuizAdapter
import com.example.elon.activities.models.NewQuizModel
import kotlinx.android.synthetic.main.fragment_linear_quiz.*

class LinearQuizFragment : Fragment() {

    var linearQuizAdapter: LinearQuizAdapter? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_linear_quiz, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        linearQuiz()
    }

    fun linearQuiz() {
        val lList = ArrayList<NewQuizModel>()

        lList.add(
            NewQuizModel(
                1,
                R.drawable.discussion,
                "Social Media Quiz",

            )
        )
        lList.add(
            NewQuizModel(
                2,
                R.drawable.discussion,
                "Finance Quiz",

            )
        )
        lList.add(
            NewQuizModel(
                3,
                R.drawable.discussion,
                "Web Site",

            )
        )
        lList.add(
            NewQuizModel(
                4,
                R.drawable.discussion,
                "Google SEO Quiz",

            )
        )
        lList.add(
            NewQuizModel(
                5,
                R.drawable.discussion,
                "Techenical Quiz",

            )
        )
        lList.add(
            NewQuizModel(
                6,
                R.drawable.discussion,
                "Mathematical Quiz",

            )
        )



        tabQuizRecyclerView.layoutManager = LinearLayoutManager(requireContext())
        linearQuizAdapter = LinearQuizAdapter(lList, requireContext())
        tabQuizRecyclerView.adapter = linearQuizAdapter

    }


}