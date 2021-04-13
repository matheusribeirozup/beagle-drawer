package com.example.drawer

import br.com.zup.beagle.ext.applyFlex
import br.com.zup.beagle.widget.core.Flex
import br.com.zup.beagle.widget.core.JustifyContent
import br.com.zup.beagle.widget.core.TextAlignment
import br.com.zup.beagle.widget.layout.Container
import br.com.zup.beagle.widget.ui.Button
import br.com.zup.beagle.widget.ui.Text

object DrawerBuilder {
    fun buildDrawer() = DrawerWidget(
        photo = "ic_photo",
        name = "Android Studio",
        email = "android.studio@android.com",
        destinations = buildDestinations()
    )

    private fun buildDestinations() = listOf(
        Destination(
            id = 0,
            image = "ic_menu_camera",
            title = "Home",
            path = "/home",
        ),
        Destination(
            id = 1,
            image = "ic_menu_gallery",
            title = "Gallery",
            path = "/gallery",
        ),
        Destination(
            id = 2,
            image = "ic_menu_slideshow",
            title = "Slideshow",
            path = "/slideshow",
        )
    )

    fun buildHome() = buildPage("This is home")

    fun buildGallery() = buildPage("This is gallery")

    fun buildSlideshow() = buildPage("This is slideshow")

    private fun buildPage(message: String) =
        Container(
            children = listOf(
                Text(message, alignment = TextAlignment.CENTER)
            )
        ).applyFlex(
            Flex(
                justifyContent = JustifyContent.CENTER,
                grow = 1.0
            )
        )
}
