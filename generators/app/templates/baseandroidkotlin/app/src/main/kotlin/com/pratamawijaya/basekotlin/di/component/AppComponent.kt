package <%= appPackage %>.di.component

import <%= appPackage %>.di.module.AppModule
import <%= appPackage %>.di.module.DataModule
import dagger.Component
import javax.inject.Singleton

/**
 * Created by pratama on 8/4/17.
 */
@Singleton
@Component(modules = arrayOf(
        AppModule::class,
        DataModule::class
))
interface AppComponent {
    fun activityComponent(): ActivityComponent.Builder
}