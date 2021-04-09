package com.example.drawer

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class DrawerController(private val drawerService: DrawerService) {

    @GetMapping("/drawer")
    fun getDrawer() = drawerService.getDrawer()

    @GetMapping("/home")
    fun getHome() = drawerService.getHome()

    @GetMapping("/gallery")
    fun getGallery() = drawerService.getGallery()

    @GetMapping("/slideshow")
    fun getSlideshow() = drawerService.getSlideshow()
}
