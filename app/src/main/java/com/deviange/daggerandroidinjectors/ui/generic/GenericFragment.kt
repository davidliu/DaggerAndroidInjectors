package com.deviange.daggerandroidinjectors.ui.generic

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.deviange.daggerandroidinjectors.R
import dagger.android.support.DaggerFragment
import java.util.*
import javax.inject.Inject

class GenericFragment : DaggerFragment() {

    @Inject
    lateinit var foo: Optional<String>

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.main_fragment, container, false)
    }

    @dagger.Module
    abstract class Module

    companion object {
        fun newInstance() = GenericFragment()
    }
}
