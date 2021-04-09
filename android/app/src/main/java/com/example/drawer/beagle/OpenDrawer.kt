package com.example.drawer.beagle

import android.content.Intent
import android.view.View
import br.com.zup.beagle.android.action.Action
import br.com.zup.beagle.android.widget.RootView
import br.com.zup.beagle.annotation.RegisterAction
import com.example.drawer.ui.DrawerActivity

@RegisterAction
class OpenDrawer : Action {
    override fun execute(rootView: RootView, origin: View) {
        rootView.getContext()
            .startActivity(Intent(rootView.getContext(), DrawerActivity::class.java))
    }
}
