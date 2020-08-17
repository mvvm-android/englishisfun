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

import android.app.Activity
import androidx.hilt.lifecycle.ViewModelInject
import androidx.navigation.NavController
import co.zsmb.rainbowcake.base.RainbowCakeViewModel
import com.google.firebase.auth.FirebaseAuth
import com.jpaya.englishisfun.R

class HomeViewModel @ViewModelInject constructor(
    private val firebaseAuth: FirebaseAuth
) :
    RainbowCakeViewModel<HomeViewState>(HomeViewState.NavigationScreen) {

    private val navFragmentsIds = setOf(
        R.id.abbreviations_list_fragment,
        R.id.irregulars_list_fragment,
        R.id.settings_fragment,
        R.id.about_fragment
    )

    /**
     * Navigation controller add destination changed listener.
     *
     * @param navController Navigation manager.
     */
    fun navigationControllerChanged(navController: NavController) {
        navController.addOnDestinationChangedListener { _, destination, _ ->
            viewState = if (navFragmentsIds.contains(destination.id)) {
                HomeViewState.NavigationScreen
            } else {
                HomeViewState.FullScreen
            }
        }
    }

    fun authenticate(activity: Activity) {
        firebaseAuth.signInAnonymously().addOnCompleteListener(activity) {
            if (it.isSuccessful) {
                viewState = HomeViewState.NavigationScreen
            }
        }
    }
}
