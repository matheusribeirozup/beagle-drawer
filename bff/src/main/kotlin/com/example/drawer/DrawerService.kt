package com.example.drawer

import org.springframework.stereotype.Service

@Service
class DrawerService {
    fun getDrawer() = DrawerBuilder.buildDrawer()
    fun getHome() = DrawerBuilder.buildHome()
    fun getGallery() = DrawerBuilder.buildGallery()
    fun getSlideshow() = DrawerBuilder.buildSlideshow()
}
