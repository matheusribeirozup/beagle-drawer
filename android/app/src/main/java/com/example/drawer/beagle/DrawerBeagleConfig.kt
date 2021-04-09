package com.example.drawer.beagle

import br.com.zup.beagle.android.annotation.BeagleComponent
import br.com.zup.beagle.android.setup.BeagleConfig
import br.com.zup.beagle.android.setup.Cache
import br.com.zup.beagle.android.setup.Environment

@BeagleComponent
class DrawerBeagleConfig : BeagleConfig {
    override val baseUrl: String
        get() = "http://10.0.2.2:8080" //todo check last / in docs
    override val cache: Cache
        get() = Cache(enabled = true, maxAge = 500, size = 3)
    override val environment: Environment
        get() = Environment.DEBUG
    override val isLoggingEnabled: Boolean
        get() = true
}
