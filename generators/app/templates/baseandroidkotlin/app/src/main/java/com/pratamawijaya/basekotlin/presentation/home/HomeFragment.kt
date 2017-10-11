package <%= appPackage %>.presentation.home

import <%= appPackage %>.R
import <%= appPackage %>.di.component.ActivityComponent
import <%= appPackage %>.presentation.base.BaseInjectedFragment

/**
 * Created by pratama on 8/4/17.
 */
class HomeFragment : BaseInjectedFragment() {

    override fun injectModule(activityComponent: ActivityComponent) {
        activityComponent.inject(this)
    }

    override fun getLayout(): Int = R.layout.view_home

}