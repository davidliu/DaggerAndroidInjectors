package com.deviange.daggerandroidinjectors

import com.deviange.daggerandroidinjectors.ui.main.MainFragment
import dagger.BindsOptionalOf
import dagger.Component
import dagger.Module
import dagger.android.AndroidInjectionModule
import dagger.android.AndroidInjector
import dagger.android.ContributesAndroidInjector
import dagger.android.DaggerApplication
import javax.inject.Singleton

class MainApplication : DaggerApplication() {
    override fun applicationInjector(): AndroidInjector<out DaggerApplication> {
        return DaggerAppComponent.create()
    }
}

@Singleton
@Component(
    modules = [
        AndroidInjectionModule::class,
        InjectionModule::class,
        OptionalModule::class
    ]
)
interface AppComponent : AndroidInjector<MainApplication>

@Module
interface InjectionModule {
    @ContributesAndroidInjector(modules = [MainActivity.Module::class])
    fun mainActivity(): MainActivity

    @ContributesAndroidInjector
    fun mainFragment(): MainFragment
}

@Module
interface OptionalModule {
    @BindsOptionalOf
    fun optionalString(): String
}