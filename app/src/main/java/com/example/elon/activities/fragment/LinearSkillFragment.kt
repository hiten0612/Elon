package com.example.elon.activities.fragment

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.elon.R
import com.example.elon.activities.SkillVideo
import com.example.elon.activities.adapter.LinearSkillAdapter
import com.example.elon.activities.interfaces.Listener
import com.example.elon.activities.models.NewSkillModel
import kotlinx.android.synthetic.main.fragment_complete_quiz.*
import kotlinx.android.synthetic.main.fragment_linear_skill.*

class LinearSkillFragment : Fragment(), Listener {

    var linearSkillAdapter: LinearSkillAdapter? = null


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_linear_skill, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        linearSkill()


    }

    private fun linearSkill() {
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
        sList.add(
            NewSkillModel(
                3,
                R.drawable.sweatshirt,
                "Google Ceo",

                )
        )
        sList.add(
            NewSkillModel(
                4,
                R.drawable.sweater,
                "Mobile App Code",

                )
        )
        sList.add(
            NewSkillModel(
                5,
                R.drawable.polo,
                "Marketing Document",

                )
        )
        tabSkillRecyclerView.layoutManager = LinearLayoutManager(requireContext())
        linearSkillAdapter = LinearSkillAdapter(sList, requireContext(), this)
        tabSkillRecyclerView.adapter = linearSkillAdapter

    }

    override fun onItemClick(position: Int) {
        val intent = Intent(requireContext(), SkillVideo::class.java)
        startActivity(intent)
    }


}