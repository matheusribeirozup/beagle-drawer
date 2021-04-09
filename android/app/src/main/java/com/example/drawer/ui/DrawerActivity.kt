package com.example.drawer.ui

import android.content.res.Configuration
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.util.Log
import android.widget.FrameLayout
import android.widget.ProgressBar
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.recyclerview.widget.RecyclerView
import br.com.zup.beagle.android.utils.loadView
import br.com.zup.beagle.android.view.ScreenRequest
import br.com.zup.beagle.android.view.ServerDrivenState
import com.example.drawer.R
import com.example.drawer.beagle.Destination
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import com.google.android.material.navigation.NavigationView

class DrawerActivity : AppCompatActivity(R.layout.activity_drawer), OnDestinationListener {

    private lateinit var toolbar: Toolbar
    private lateinit var contentMain: FrameLayout
    private lateinit var toggle: ActionBarDrawerToggle
    private lateinit var drawer: DrawerLayout
    private lateinit var navView: NavigationView
    private lateinit var loading: AlertDialog
    private lateinit var firstDestination: Destination
    private var isHome = true

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setupToolbar()
        setupDrawer()
        setupLoading()
        setupNavigationView()
    }

    private fun setupToolbar() {
        toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayShowHomeEnabled(true)
    }

    private fun setupDrawer() {
        contentMain = findViewById(R.id.content_main)
        drawer = findViewById(R.id.drawer_layout)
        toggle = ActionBarDrawerToggle(
            this,
            drawer,
            toolbar,
            R.string.open_drawer,
            R.string.close_drawer
        )
        drawer.addDrawerListener(toggle)
    }

    private fun setupLoading() {
        loading = MaterialAlertDialogBuilder(this).apply {
            setView(ProgressBar(this@DrawerActivity))
            background = ColorDrawable(Color.TRANSPARENT)
            setCancelable(false)
        }.create()
    }

    private fun setupNavigationView() {
        navView = findViewById(R.id.nav_view)
        navView.loadView(this, ScreenRequest("/drawer")) { state: ServerDrivenState ->
            when (state) {
                is ServerDrivenState.Started -> loading.show()
                is ServerDrivenState.Finished -> loading.dismiss()
                is ServerDrivenState.Error -> Toast.makeText(
                    this,
                    state.throwable.message,
                    Toast.LENGTH_SHORT
                ).show()
            }
        }
    }

    override fun onPostCreate(savedInstanceState: Bundle?) {
        super.onPostCreate(savedInstanceState)
        toggle.syncState()
    }

    override fun onConfigurationChanged(newConfig: Configuration) {
        super.onConfigurationChanged(newConfig)
        toggle.onConfigurationChanged(newConfig)
    }

    override fun onBackPressed() {
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START)
        } else if (!isHome) {
            openContentByDrawer(firstDestination)
        } else {
            super.onBackPressed()
        }
    }

    override fun onDestinationClick(destination: Destination) {
        openContentByDrawer(destination)
    }

    override fun onFirstDestinationLoaded(destination: Destination) {
        firstDestination = destination
        openContentByDrawer(destination)
    }

    private fun openContentByDrawer(destination: Destination) {
        isHome = destination.id == 0
        contentMain.loadView(this, ScreenRequest(destination.path))
        drawer.closeDrawer(GravityCompat.START)
    }
}
