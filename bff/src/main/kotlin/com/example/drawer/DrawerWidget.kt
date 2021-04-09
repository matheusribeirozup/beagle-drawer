package com.example.drawer

import br.com.zup.beagle.annotation.RegisterWidget
import br.com.zup.beagle.widget.Widget

data class Destination(
    val id: Int,
    val image: String,
    val title: String,
    val path: String,
)

@RegisterWidget
data class DrawerWidget(
    val photo: String,
    val name: String,
    val email: String,
    val destinations: List<Destination>
) : Widget()
