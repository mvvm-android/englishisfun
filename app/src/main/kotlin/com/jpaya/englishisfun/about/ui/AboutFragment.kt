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

package com.jpaya.englishisfun.about.ui

import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import androidx.fragment.app.viewModels
import co.zsmb.rainbowcake.base.RainbowCakeFragment
import co.zsmb.rainbowcake.extensions.exhaustive
import com.jpaya.englishisfun.R
import dagger.hilt.android.AndroidEntryPoint
import de.psdev.licensesdialog.LicensesDialog
import kotlinx.android.synthetic.main.about_fragment.*

@AndroidEntryPoint
class AboutFragment : RainbowCakeFragment<AboutViewState, AboutViewModel>() {

    private val customViewModel: AboutViewModel by viewModels()

    override fun provideViewModel() = customViewModel
    override fun getViewResource() = R.layout.about_fragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.about_fragment, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.action_libraries -> {
                showLicensesDialog()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    private fun showLicensesDialog() {
        LicensesDialog.Builder(requireContext())
            .setTitle(getString(R.string.third_party_libraries))
            .setNotices(R.raw.notices)
            .setIncludeOwnLicense(true)
            .build()
            .show()
    }

    override fun render(viewState: AboutViewState) {
        when (viewState) {
            AboutViewState.Loading -> {
            }
            is AboutViewState.Loaded -> {
                tv_version.text = viewState.version
            }
        }.exhaustive
    }
}
