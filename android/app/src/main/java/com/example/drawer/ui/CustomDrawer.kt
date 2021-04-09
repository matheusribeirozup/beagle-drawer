package com.example.drawer.ui

import android.content.Context
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import com.example.drawer.R
import com.example.drawer.beagle.Destination

class CustomDrawer(context: Context) : ConstraintLayout(context) {

    private val ivDrawer: ImageView
    private val tvNameDrawer: TextView
    private val tvEmailDrawer: TextView
    private val rvDestinations: RecyclerView
    private val drawerAdapter: DrawerAdapter

    init {
        inflate(context, R.layout.widget_drawer, this)

        ivDrawer = findViewById(R.id.iv_drawer)
        tvNameDrawer = findViewById(R.id.tv_name_drawer)
        tvEmailDrawer = findViewById(R.id.tv_email_drawer)
        rvDestinations = findViewById(R.id.rv_destinations)
        drawerAdapter = DrawerAdapter(context as OnDestinationListener)

        rvDestinations.adapter = drawerAdapter
    }

    fun setImage(photo: String) {
        val resId = context.resources.getIdentifier(photo, "drawable", context.packageName)
        ivDrawer.setImageResource(resId)
    }

    fun setName(name: String) {
        tvNameDrawer.text = name
    }

    fun setEmail(email: String) {
        tvEmailDrawer.text = email
    }

    fun setDestinations(destinations: List<Destination>) {
        drawerAdapter.setDestinations(destinations)
    }
}
