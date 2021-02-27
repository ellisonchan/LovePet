/*
 * Copyright 2021 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.androiddevchallenge.bean

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import com.example.androiddevchallenge.R

data class Pet(
    val id: Int,
    @StringRes val name: Int,
    @StringRes val age: Int,
    @DrawableRes val icon: Int,
    @StringRes val type: Int,
    @StringRes val info: Int
)

var id = 1

val myLovelyPets = listOf(
    Pet(
        id++,
        R.string.zang_ao_name,
        R.string.zang_ao_age,
        R.drawable.zang_ao_icon,
        R.string.zang_ao_type,
        R.string.zang_ao_info
    ),
    Pet(
        id++,
        R.string.hachi_name,
        R.string.hachi_age,
        R.drawable.hachi_icon,
        R.string.hachi_type,
        R.string.hachi_info
    ),
    Pet(
        id++,
        R.string.bosi_name,
        R.string.bosi_age,
        R.drawable.bosi_icon,
        R.string.bosi_type,
        R.string.bosi_info
    ),
    Pet(
        id++,
        R.string.lanmao_name,
        R.string.lanmao_age,
        R.drawable.lanmao_icon,
        R.string.lanmao_type,
        R.string.lanmao_info
    ),
    Pet(
        id++,
        R.string.bianse_name,
        R.string.bianse_age,
        R.drawable.bianse_icon,
        R.string.bianse_type,
        R.string.bianse_info
    ),
    Pet(
        id++,
        R.string.wugui_name,
        R.string.wugui_age,
        R.drawable.wugui_icon,
        R.string.wugui_type,
        R.string.wugui_info
    )
)
