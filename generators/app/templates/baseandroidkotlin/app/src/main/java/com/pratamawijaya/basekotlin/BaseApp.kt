package <%= appPackage %>

import android.app.Application
import android.content.Context
import <%= appPackage %>.di.component.AppComponent
import <%= appPackage %>.di.component.DaggerAppComponent
import <%= appPackage %>.di.module.AppModule
import <%= appPackage %>.di.module.DataModule
import timber.log.Timber

/**
 * Created by pratama on 8/4/17.
 */
class BaseApp : Application() {

    companion object {
        fun get(context: Context): BaseApp = context.applicationContext as BaseApp
    }

    val appComponent: AppComponent by lazy {
        DaggerAppComponent.builder()
                .appModule(AppModule(this))
                .dataModule(DataModule())
                .build()
    }

    override fun onCreate() {
        super.onCreate()

        if(BuildConfig.DEBUG){
            Timber.plant(Timber.DebugTree())
        }
    }
}