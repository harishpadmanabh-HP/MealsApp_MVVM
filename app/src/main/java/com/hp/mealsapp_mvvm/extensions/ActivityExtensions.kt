/*
 * Designed and developed by 2020 skydoves (Jaewoong Eum)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.hp.mealsapp_mvvm.extensions

import android.graphics.Color
import android.os.Build
import android.view.View
import android.view.WindowManager
import androidx.appcompat.app.AppCompatActivity
import com.skydoves.transformationlayout.onTransformationEndContainer

fun AppCompatActivity.onTransformationEndContainerApplyParams() {
  onTransformationEndContainer(intent.getParcelableExtra("com.skydoves.transformationlayout"))
}
fun AppCompatActivity.makeStatusBarTransparent() {
  if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
    window.apply {
      clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS)
      addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
      if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
        decorView.systemUiVisibility =
          View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN or
                   View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR
      } else {
        decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
      }
      statusBarColor = Color.TRANSPARENT
    }
  }
}
