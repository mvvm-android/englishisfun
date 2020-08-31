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

package com.jpaya.base.extensions

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.os.Bundle

/**
 * Functions for simpler, easier and funny way of launching of Activities.
 * Source: https://android.jlelse.eu/launching-activities-in-easier-way-using-kotlin-extensions-121a8175220c
 *
 * Simple Activities
 * launchActivity<UserDetailActivity>()
 *
 * Add Intent extras
 * launchActivity<UserDetailActivity> {
 *      putExtra(INTENT_USER_ID, user.id)
 * }
 *
 * Add custom flags
 * launchActivity<UserDetailActivity> {
 *      putExtra(INTENT_USER_ID, user.id)
 *      addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
 * }
 *
 * Add Shared Transitions
 * val options = ActivityOptionsCompat.makeSceneTransitionAnimation(this, avatar, "avatar")
 * launchActivity<UserDetailActivity>(options = options) {
 *      putExtra(INTENT_USER_ID, user.id)
 * }
 *
 * Add requestCode for startActivityForResult() call
 * launchActivity<UserDetailActivity>(requestCode = 1234) {
 *      putExtra(INTENT_USER_ID, user.id)
 * }
 */
inline fun <reified T : Any> Activity.launchActivity(
    requestCode: Int = -1,
    options: Bundle? = null,
    noinline init: Intent.() -> Unit = {}
) {
    val intent = newIntent<T>(this)
    intent.init()
    startActivityForResult(intent, requestCode, options)
}

inline fun <reified T : Any> Context.launchActivity(options: Bundle? = null, noinline init: Intent.() -> Unit = {}) {
    val intent = newIntent<T>(this)
    intent.init()
    startActivity(intent, options)
}

inline fun <reified T : Any> newIntent(context: Context): Intent = Intent(context, T::class.java)
