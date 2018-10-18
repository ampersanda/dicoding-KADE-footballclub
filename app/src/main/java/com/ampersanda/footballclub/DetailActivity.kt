package com.ampersanda.footballclub

import android.os.Bundle
import android.view.Gravity
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import org.jetbrains.anko.*

class DetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val club = intent.extras?.getParcelable<FootballClub?>(MainActivity.clubKey)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.title = club?.name as String
        DetailActivityView(club).setContentView(this)
    }

    class DetailActivityView(private var club: FootballClub?) : AnkoComponent<DetailActivity> {
        override fun createView(ui: AnkoContext<DetailActivity>) = with(ui) {
            verticalLayout{
                lparams(matchParent, wrapContent)
                padding = dip(16)
                gravity = Gravity.CENTER_HORIZONTAL

                imageView{
                    setImageResource(club?.image as Int)
                }.lparams(dip(112), wrapContent)

                textView{
                    text = club?.description as String
                }.lparams(matchParent, wrapContent){
                    setMargins(0, dip(32), 0, 0)
                }
            }
        }
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        val id = item?.itemId

        if (id == android.R.id.home){
            onBackPressed()
            return true
        }

        return super.onOptionsItemSelected(item)
    }
}
