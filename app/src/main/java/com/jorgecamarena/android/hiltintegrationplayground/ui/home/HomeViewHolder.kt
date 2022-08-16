package com.jorgecamarena.android.hiltintegrationplayground.ui.home

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.jorgecamarena.android.hiltintegrationplayground.R


/**
 * Created by jorgecordero on Aug, 15, 2022
 **/
class HomeViewHolder(view: View): RecyclerView.ViewHolder(view) {

    fun bind(label: String, onItemSelected: () -> Unit) {
        with(itemView) {
            val itemLabel = findViewById<TextView>(R.id.itemLabel)
            itemLabel.text = label
            setOnClickListener { onItemSelected() }
        }
    }

}