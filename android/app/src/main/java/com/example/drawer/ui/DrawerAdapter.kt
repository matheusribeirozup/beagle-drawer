package com.example.drawer.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.drawer.R
import com.example.drawer.beagle.Destination

class DrawerAdapter(private val onDestinationListener: OnDestinationListener) :
    RecyclerView.Adapter<DrawerViewHolder>() {

    private val destinations = mutableListOf<Destination>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DrawerViewHolder {
        val view: TextView = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_destination, parent, false) as TextView
        return DrawerViewHolder(view, onDestinationListener)
    }

    override fun onBindViewHolder(holder: DrawerViewHolder, position: Int) {
        holder.bind(destinations[position])
    }

    override fun getItemCount() = destinations.size

    fun setDestinations(destinationList: List<Destination>) {
        destinations.clear()
        destinations.addAll(destinationList)
        notifyDataSetChanged()
        onDestinationListener.onFirstDestinationLoaded(destinations.first())
    }
}

class DrawerViewHolder(
    private val view: TextView,
    private val onDestinationListener: OnDestinationListener,
) : RecyclerView.ViewHolder(view) {

    fun bind(destination: Destination) {
        val resId = view.context.resources.getIdentifier(
            destination.image,
            "drawable",
            view.context.packageName
        )
        view.id = destination.id
        view.text = destination.title
        view.setCompoundDrawablesWithIntrinsicBounds(
            resId,
            0,
            0,
            0
        )
        view.setOnClickListener {
            onDestinationListener.onDestinationClick(destination)
        }
    }
}

interface OnDestinationListener {
    fun onDestinationClick(destination: Destination)
    fun onFirstDestinationLoaded(destination: Destination)
}
