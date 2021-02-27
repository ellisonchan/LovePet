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
package com.example.androiddevchallenge.ui

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.sizeIn
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.androiddevchallenge.bean.Pet
import com.example.androiddevchallenge.bean.myLovelyPets
import com.example.androiddevchallenge.ui.theme.itemCardColor
import com.example.androiddevchallenge.ui.theme.nameColor
import com.example.androiddevchallenge.ui.theme.shapes

@Preview(showBackground = true)
@Composable
fun PetItemPreview() {
    PetItem(pet = myLovelyPets.last(), onClick = {})
}

@Composable
fun PetItem(pet: Pet, onClick: () -> Unit) {
    Log.d("Compose", "id:${pet.id}")
    Box(
        // modifier = Modifier.padding(6.dp)
        // More horizontal padding when 2 item.
        modifier = Modifier.padding(
            if (pet.id % 2 == 0) 48.dp else 12.dp,
            6.dp,
            if (pet.id % 2 == 0) 12.dp else 48.dp,
            6.dp
        )
    ) {
        Card(
            shape = shapes.small,
            elevation = 8.dp,
            backgroundColor = itemCardColor
        ) {
            Row(
                modifier = Modifier
                    .clickable(onClick = onClick)
                    .fillMaxWidth()
                    // .width(if (pet.id % 2 == 0) 200.dp else 12.dp)
                    // .width(300.dp)
                    .height(82.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                val image: Painter = painterResource(id = pet.icon)
                Image(
                    painter = image,
                    contentDescription = stringResource(id = pet.name),
                    contentScale = ContentScale.Crop,
                    modifier = Modifier.aspectRatio(1f)
                )

                Spacer(Modifier.sizeIn(16.dp))

                Column(modifier = Modifier.padding(8.dp)) {
                    // Column(verticalArrangement = Arrangement.Center) {
                    Text(
                        text = stringResource(id = pet.name),
                        style = MaterialTheme.typography.h6,
                        color = nameColor,
                    )

                    Text(
                        text = stringResource(id = pet.age),
                        style = MaterialTheme.typography.caption,
                        color = nameColor,
                    )
                }
            }
        }
    }
}
