package <%= appPackage %>.presentation.base

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import <%= appPackage %>.BaseApp
import <%= appPackage %>.di.component.ActivityComponent
import <%= appPackage %>.di.module.ActivityModule

/**
 * Created by pratama on 8/4/17.
 */
abstract class BaseInjectedActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val activityComponent = BaseApp.get(this)
                .appComponent
                .activityComponent()
                .activityModule(ActivityModule(this))
                .build()

        injectModule(activityComponent)
    }

    override fun onDestroy() {
        super.onDestroy()
    }

    abstract fun injectModule(activityComponent: ActivityComponent)
}