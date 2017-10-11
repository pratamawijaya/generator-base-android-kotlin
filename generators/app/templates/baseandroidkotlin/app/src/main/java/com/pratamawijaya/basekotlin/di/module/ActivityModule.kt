package <%= appPackage %>.di.module

import android.app.Activity
import android.content.Context
import <%= appPackage %>.di.ActivityContext
import <%= appPackage %>.di.PerActivity
import dagger.Module
import dagger.Provides

/**
 * Created by pratama on 8/4/17.
 */
@Module
class ActivityModule(val activity: Activity) {

    @Provides
    @PerActivity
    fun provideActivity(): Activity = activity

    @Provides
    @ActivityContext
    fun provideActivityContext(): Context = activity
}