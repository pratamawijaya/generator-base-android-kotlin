package <%= appPackage %>.presentation.base

import android.os.Bundle
import <%= appPackage %>.BaseApp
import <%= appPackage %>.di.component.ActivityComponent
import <%= appPackage %>.di.module.ActivityModule

/**
 * Created by pratama on 8/4/17.
 */
abstract class BaseInjectedFragment : BaseFragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val activityComponent = BaseApp.get(activity)
                .appComponent
                .activityComponent()
                .activityModule(ActivityModule(activity))
                .build()

        injectModule(activityComponent)
    }

    abstract fun injectModule(activityComponent: ActivityComponent)
}