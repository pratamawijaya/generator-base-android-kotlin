package <%= appPackage %>.di.module

import android.content.Context
import <%= appPackage %>.data.OpenDotaServices
import <%= appPackage %>.data.PreferencesManager
import <%= appPackage %>.data.repository.HeroRepository
import <%= appPackage %>.data.repository.HeroRepositoryImpl
import <%= appPackage %>.di.ApplicationContext
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import javax.inject.Singleton

/**
 * Created by pratama on 8/4/17.
 */
@Module
class DataModule {

    @Provides
    @Singleton
    fun providePreferencesManager(@ApplicationContext context: Context): PreferencesManager = PreferencesManager(context)

    @Provides
    @Singleton
    fun provideOpenDotaServices(retrofit: Retrofit): OpenDotaServices = retrofit.create(OpenDotaServices::class.java)

    @Provides
    @Singleton
    fun provideHeroRepo(heroRepositoryImpl: HeroRepositoryImpl): HeroRepository = heroRepositoryImpl

}