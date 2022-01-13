package com.example.elon.activities.fragment

import android.app.AlertDialog
import android.content.DialogInterface
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.elon.R
import com.example.elon.activities.DashBoard
import kotlinx.android.synthetic.main.activity_dash_board.*
import kotlinx.android.synthetic.main.fragment_start_quiz.*


class StartQuizFragment : Fragment() {

    lateinit var mainController: DashBoard
    private val nextQuestionFragment = NextQuestionFragment()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_start_quiz, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        mainController = context as DashBoard

        mainController.searchCardView.visibility = View.GONE
        mainController.txtToolbar.visibility = View.GONE
        mainController.cardMenu.visibility = View.GONE
        mainController.totalQuiz.visibility = View.VISIBLE
        mainController.completedQuiz.visibility = View.VISIBLE
        mainController.completed_quiz_number.text = "1"
        mainController.txtToolbarQuiz.visibility = View.VISIBLE
        mainController.btnBack.visibility = View.GONE

        mainController.tab.visibility = View.GONE



        btnNext.setOnClickListener(View.OnClickListener {

            val builder = AlertDialog.Builder(requireContext())
            builder.setTitle("Alert")
            if (radioGroup.checkedRadioButtonId == -1) {

                builder.setMessage("Please select answer")

                builder.setPositiveButton("Ok", fun(dialog: DialogInterface, id: Int) {

                    dialog.cancel()
                })
                val alert = builder.create()
                alert.show()
                return@OnClickListener
            } else {
                requireActivity().supportFragmentManager.popBackStack()
                requireActivity().supportFragmentManager.beginTransaction()
                    .replace(R.id.fLayout, nextQuestionFragment, null).addToBackStack(tag).commit()
            }


        })



        exitQuiz.setOnClickListener(View.OnClickListener {

            val homeFragment = HomeFragment()
            (requireActivity() as DashBoard).supportFragmentManager.beginTransaction()
                .replace(R.id.fLayout, homeFragment).addToBackStack(tag).commit()

        })


    }


}