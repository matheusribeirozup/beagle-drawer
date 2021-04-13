package com.example.drawer

import org.springframework.stereotype.Service

// Each builder must be in a separate service.
// Here, everyone is grouped together just to simplify the solution.
@Service
class DrawerService {
    fun getDrawer() = DrawerBuilder.buildDrawer()
    fun getHome() = DrawerBuilder.buildHome()
    fun getGallery() = DrawerBuilder.buildGallery()
    fun getSlideshow() = DrawerBuilder.buildSlideshow()
}
