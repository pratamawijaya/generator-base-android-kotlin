package <%= appPackage %>.di.component

import <%= appPackage %>.di.PerActivity
import <%= appPackage %>.di.module.ActivityModule
import <%= appPackage %>.presentation.home.HomeFragment
import <%= appPackage %>.presentation.home.MainActivity
import dagger.Subcomponent

/**
 * Created by pratama on 8/4/17.
 */
@PerActivity
@Subcomponent(modules = arrayOf(ActivityModule::class))
interface ActivityComponent {

    @Subcomponent.Builder
    interface Builder {
        fun activityModule(activityModule: ActivityModule): Builder

        fun build(): ActivityComponent
    }

    fun inject(activity: MainActivity)
    fun inject(fragment: HomeFragment)

}