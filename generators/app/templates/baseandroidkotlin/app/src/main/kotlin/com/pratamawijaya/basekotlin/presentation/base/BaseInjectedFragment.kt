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

        val act = activity
        if (act != null) {
            val activityComponent = BaseApp.get(act)
                    .appComponent.activityComponent()
                    .activityModule(ActivityModule(act))
                    .build()

            injectModule(activityComponent)
        }

    }

    abstract fun injectModule(activityComponent: ActivityComponent)
}