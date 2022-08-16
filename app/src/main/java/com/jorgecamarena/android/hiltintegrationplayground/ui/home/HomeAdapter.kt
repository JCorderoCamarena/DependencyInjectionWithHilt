package com.jorgecamarena.android.hiltintegrationplayground.ui.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.jorgecamarena.android.hiltintegrationplayground.R

/**
 * Created by jorgecordero on Aug, 15, 2022
 **/
class HomeAdapter(
    private val items: List<HomeItem>,
    private val onOptionSelected: (homeItem: HomeItem) -> Unit
): RecyclerView.Adapter<HomeViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.view_holder_home, parent, false)
        return HomeViewHolder(view)
    }

    override fun onBindViewHolder(holder: HomeViewHolder, position: Int) {
        val item = items[position]
        holder.bind(item.label) {
            onOptionSelected(item)
        }
    }

    override fun getItemCount(): Int = items.count()

}