package com.example.drawer.beagle

import br.com.zup.beagle.android.widget.RootView
import br.com.zup.beagle.android.widget.WidgetView
import br.com.zup.beagle.annotation.RegisterWidget
import com.example.drawer.ui.CustomDrawer

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
) : WidgetView() {
    override fun buildView(rootView: RootView) = CustomDrawer(rootView.getContext()).apply {
        setImage(photo)
        setName(name)
        setEmail(email)
        setDestinations(destinations)
    }
}
