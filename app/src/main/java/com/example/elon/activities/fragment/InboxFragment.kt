package com.example.elon.activities.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.elon.R
import com.example.elon.activities.DashBoard
import com.example.elon.activities.adapter.InboxAdapter
import com.example.elon.activities.models.InboxDataModel
import kotlinx.android.synthetic.main.activity_dash_board.*
import kotlinx.android.synthetic.main.fragment_inbox.*


class InboxFragment : Fragment() {

    lateinit var mainController: DashBoard
    var inboxAdapter: InboxAdapter? = null
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_inbox, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        mainController = context as DashBoard


        mainController.btnBack.visibility = View.GONE

        // mainController.rootTab.visibility = View.GONE

        mainController.txtToolbar.text = "Inbox"

        mainController.txtToolbarQuiz.visibility = View.GONE
        mainController.totalQuiz.visibility = View.GONE
        mainController.completedQuiz.visibility = View.GONE
        mainController.tab.visibility = View.GONE

        val arrayList = ArrayList<InboxDataModel>()

        arrayList.add(InboxDataModel(1, R.drawable.causal, "Elon musk", "Hello how are you"))
        arrayList.add(InboxDataModel(2, R.drawable.hoody, "Adam york", "Hello how are you"))
        arrayList.add(InboxDataModel(3, R.drawable.jacket, "Elinda oopas", "Hello how are you"))
        arrayList.add(InboxDataModel(4, R.drawable.polo, "Tom Larek", "Hello how are you"))
        arrayList.add(InboxDataModel(5, R.drawable.sweatshirt, "Ross Taylor", "Hello how are you"))


        recyclerView.layoutManager = LinearLayoutManager(requireContext())
        inboxAdapter = InboxAdapter(arrayList, requireContext())
        recyclerView.adapter = inboxAdapter


    }


}