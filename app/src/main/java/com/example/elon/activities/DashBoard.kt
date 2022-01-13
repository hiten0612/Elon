package com.example.elon.activities

import android.content.DialogInterface
import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import androidx.fragment.app.Fragment
import com.example.elon.R
import com.example.elon.activities.adapter.TabAdapter
import com.example.elon.activities.fragment.*
import com.google.android.material.tabs.TabLayoutMediator
import kotlinx.android.synthetic.main.activity_dash_board.*

class DashBoard : AppCompatActivity() {


    private val homeFragment = HomeFragment()
    private val quizFragment = QuizFragment()
    private val skillsFragment = SkillsFragment()
    private val inboxFragment = InboxFragment()
    private val accountFragment = AccountFragment()
    private val searchFragment = SearchFragment()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dash_board)

        Appreance.init(this)

        viewPager2.isSaveEnabled = false

        viewPager2.adapter = TabAdapter(this)

        TabLayoutMediator(tabLayout, viewPager2) { tabLayout, position ->
            when (position) {
                0 -> {
                    tabLayout.text = "Quiz"

                }
                1 -> {

                    tabLayout.text = "Skill"
                }

            }
        }.attach()


        cardMenu.setOnClickListener(View.OnClickListener {

            drawerLayout.openDrawer(GravityCompat.END)
        })

        btnBack.setOnClickListener(View.OnClickListener {


            if (supportFragmentManager.backStackEntryCount <= 1) {
                finish()
            } else {
                supportFragmentManager.popBackStack()
            }
        })


        val toggle = ActionBarDrawerToggle(
            this,
            drawerLayout,
            toolbar,
            R.string.navigationopen,
            R.string.navigationclose
        )
        drawerLayout.addDrawerListener(toggle)

        setCurrentFragment(homeFragment)

        searchCardView.setOnClickListener(View.OnClickListener {
            searchCardView.visibility = View.GONE
            setCurrentFragment(searchFragment)

        })

        homeLayout.setOnClickListener(View.OnClickListener {
            setCurrentFragment(homeFragment)
            drawerLayout.closeDrawer(GravityCompat.END)
        })
        quizLayout.setOnClickListener(View.OnClickListener {
            setCurrentFragment(quizFragment)
            drawerLayout.closeDrawer(GravityCompat.END)
        })
        skillLayout.setOnClickListener(View.OnClickListener {
            setCurrentFragment(skillsFragment)
            drawerLayout.closeDrawer(GravityCompat.END)
        })
        inboxLayout.setOnClickListener(View.OnClickListener {
            setCurrentFragment(inboxFragment)
            drawerLayout.closeDrawer(GravityCompat.END)
        })
        accLayout.setOnClickListener(View.OnClickListener {
            setCurrentFragment(accountFragment)
            drawerLayout.closeDrawer(GravityCompat.END)
        })
        logout.setOnClickListener(View.OnClickListener {
            doLogout()
        })


    }

//    fun loadSkillFragment(fragment: Fragment, tag: String, backstack: String) {
//        var currentFragment = supportFragmentManager.findFragmentById(R.id.fLayout)
//
//        fragment.apply {
//            setTargetFragment(
//                currentFragment,
//                SyncStateContract.Constants.FRAGMENT_ADD_CODE
//            )
//        }
//
//        if (currentFragment?.javaClass?.simpleName != fragment.javaClass.simpleName) {
//            supportFragmentManager.beginTransaction()
//                .replace(R.id.fLayout, fragment, tag)
//                .addToBackStack(backstack).commit()
//        } else {
//            supportFragmentManager.beginTransaction()
//                .replace(R.id.fLayout, fragment, tag)
//                .commit()
//
//        }
//
//
//    }

//    override fun onBackPressed() {
//
//
////        if (supportFragmentManager.backStackEntryCount <= 1) {
////
////            finish()
////        } else {
////            supportFragmentManager.popBackStack()
////        }
////
//
//    }


    private fun setCurrentFragment(fragment: Fragment) {

        supportFragmentManager.beginTransaction().replace(R.id.fLayout, fragment)
            .addToBackStack(null)
            .commit()

    }

    private fun doLogout() {

        val builder = AlertDialog.Builder(this)
        builder.setMessage("Are you sure want to Logout")
        builder.setPositiveButton("Yes", fun(dialog: DialogInterface, id: Int) {

            dialog.cancel()
            Appreance.clearData()
            val intent = Intent(this@DashBoard, LoginScreen::class.java)
            startActivity(intent)
            finish()


        })
        builder.setNegativeButton("No", fun(dialog: DialogInterface, id: Int) {
            dialog.cancel()
        })

        val alert = builder.create()
        alert.show()

    }


}