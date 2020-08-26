/*
 * Copyright 2020 Jose Maria Payá Castillo
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.jpaya.englishisfun.home

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.ui.NavigationUI.setupActionBarWithNavController
import co.zsmb.rainbowcake.base.RainbowCakeFragment
import com.jpaya.base.ui.bindings.gone
import com.jpaya.base.ui.bindings.visible
import com.jpaya.base.ui.extensions.setupWithNavController
import com.jpaya.englishisfun.R
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.home_fragment.*

/**
 * Home principal view containing bottom navigation bar with different tabs.
 */
@AndroidEntryPoint
class HomeFragment : RainbowCakeFragment<HomeViewState, HomeViewModel>() {

    private val customViewModel: HomeViewModel by viewModels()

    override fun provideViewModel() = customViewModel
    override fun getViewResource() = R.layout.home_fragment

    private val navGraphIds = listOf(
        R.navigation.navigation_abbreviations_graph,
        R.navigation.navigation_irregulars_graph,
        R.navigation.navigation_idioms_graph,
        R.navigation.navigation_settings_graph,
        R.navigation.navigation_conditionals_graph
    )

    /**
     * Called to have the fragment instantiate its user interface view.
     *
     * @param view The view returned by onCreateView(LayoutInflater, ViewGroup, Bundle)}.
     * @param savedInstanceState If non-null, this fragment is being re-constructed
     * from a previous saved state as given here.
     * @see Fragment.onViewCreated
     */
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupToolbar()
        if (savedInstanceState == null) {
            setupBottomNavigationBar()
        }
        viewModel.authenticate(requireActivity())
    }

    /**
     * Called when all saved state has been restored into the view hierarchy of the fragment.
     *
     * @param savedInstanceState If the fragment is being re-created from a previous saved state,
     * this is the state.
     * @see Fragment.onViewStateRestored
     */
    override fun onViewStateRestored(savedInstanceState: Bundle?) {
        super.onViewStateRestored(savedInstanceState)
        setupBottomNavigationBar()
    }

    /**
     * Configure app custom support action bar.
     */
    private fun setupToolbar() = (requireActivity() as AppCompatActivity).setSupportActionBar(toolbar)

    /**
     * Configure app bottom bar via navigation graph.
     */
    private fun setupBottomNavigationBar() {
        val navController = bottom_navigation.setupWithNavController(
            navGraphIds = navGraphIds,
            fragmentManager = childFragmentManager,
            containerId = R.id.nav_host_container,
            intent = requireActivity().intent
        )

        navController.observe(
            viewLifecycleOwner,
            Observer {
                viewModel.navigationControllerChanged(it)
                setupActionBarWithNavController(requireActivity() as AppCompatActivity, it)
            }
        )
    }

    override fun render(viewState: HomeViewState) {
        when (viewState) {
            HomeViewState.NavigationScreen -> {
                app_bar_layout.visible
                bottom_navigation.visible
            }
            HomeViewState.FullScreen -> {
                app_bar_layout.gone
                bottom_navigation.gone
            }
        }
    }
}
