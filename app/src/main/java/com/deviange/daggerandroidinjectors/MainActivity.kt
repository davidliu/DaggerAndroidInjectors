package com.deviange.daggerandroidinjectors

import android.os.Bundle
import com.deviange.daggerandroidinjectors.ui.generic.GenericFragment
import dagger.Provides
import dagger.android.support.DaggerAppCompatActivity

class MainActivity : DaggerAppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.container, GenericFragment.newInstance())
                .commitNow()
        }
    }

    @dagger.Module
    abstract class Module {
        @dagger.Module
        companion object {
            @Provides
            @JvmStatic
            fun actualString() = "actual"
        }
    }
}
