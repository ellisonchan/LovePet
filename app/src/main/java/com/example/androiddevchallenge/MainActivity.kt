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
package com.example.androiddevchallenge

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredHeight
import androidx.compose.foundation.layout.requiredWidth
import androidx.compose.foundation.layout.sizeIn
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.androiddevchallenge.ui.MainNavigation
import com.example.androiddevchallenge.ui.theme.MyTheme

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyTheme {
                GetPetsNew()
            }
        }
    }
}

@Preview("Light Theme", widthDp = 360, heightDp = 640)
@Composable
fun GetPetsNew() {
    Spacer(Modifier.sizeIn(3.dp))
    MainNavigation()
}

@Preview("Light Theme", widthDp = 360, heightDp = 640)
@Composable
fun GetPets() {
//    Column {
//        Text("Zang ao dog")
//        Text("Bosi cat")
//        Text("Bianse dragon")
//        Text("Wu gui")
//        Text("Gold fish")
//    }

    val image = painterResource(R.drawable.zang_ao_icon)
    // val image = resources().getDrawable(R.drawable.zang_ao_icon)
    Column(
        modifier = Modifier.padding(32.dp)
    ) {

        val imageModifier = Modifier
            .requiredHeight(32.dp)
            .requiredWidth(32.dp)

        Image(
            painter = image,
            contentDescription = "zang ao",
            contentScale = ContentScale.Crop,
            // modifier = Modifier.aspectRatio(1f)
            modifier = imageModifier
        )
        Text("Zang ao")
        Text("Hachi")
        Text("Bosi cat")
        Text("Bianse dragon")
        Text("Wu gui")
        Text("Gold fish")
    }
}

// Start building your app here!
@Composable
fun MyApp() {
    Surface(color = MaterialTheme.colors.background) {
        // Text(text = "My lovely pets")
        Text(text = stringResource(id = R.string.activity_list_name))
    }
}

@Preview("Light Theme", widthDp = 360, heightDp = 640)
@Composable
fun LightPreview() {
    MyTheme {
        // MyApp()
        GetPets()
    }
}

@Preview("Dark Theme", widthDp = 360, heightDp = 640)
@Composable
fun DarkPreview() {
    MyTheme(darkTheme = true) {
        // MyApp()
        GetPets()
    }
}
