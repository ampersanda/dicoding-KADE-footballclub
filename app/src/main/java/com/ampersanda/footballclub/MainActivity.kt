package com.ampersanda.footballclub

import android.os.Bundle
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import org.jetbrains.anko.*
import org.jetbrains.anko.recyclerview.v7.recyclerView

class MainActivity : AppCompatActivity() {

    private var listOfFootballClub : MutableList<FootballClub> = mutableListOf()

    companion object {
        const val clubKey : String = "club"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initData()
        MainActivityView(listOfFootballClub).setContentView(this)
    }

    private fun initData() {
        val logos = resources.obtainTypedArray(R.array.clubs_logo)
        val names = resources.getStringArray(R.array.clubs_name)
        val descriptions = resources.getStringArray(R.array.clubs_description)

        listOfFootballClub.clear()

        for (index in names.indices) listOfFootballClub.add(FootballClub(names[index], logos.getResourceId(index, 0), descriptions[index]))

        logos.recycle()
    }

    class MainActivityView(private var listOfFootballClub: MutableList<FootballClub>) : AnkoComponent<MainActivity>{

        override fun createView(ui: AnkoContext<MainActivity>) = with(ui) {
            verticalLayout{
                lparams(matchParent, matchParent)

                recyclerView {
                    lparams(matchParent, matchParent)
                    layoutManager = LinearLayoutManager(context)
                    adapter = FootballRecyclerAdapter(listOfFootballClub) {
                        footballClub -> startActivity<DetailActivity>(clubKey to footballClub)
                    }
                }
            }
        }

    }
}
