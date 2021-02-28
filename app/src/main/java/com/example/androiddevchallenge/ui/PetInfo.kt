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

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.IconToggleButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.androiddevchallenge.R
import com.example.androiddevchallenge.bean.Pet
import com.example.androiddevchallenge.bean.myLovelyPets
import com.example.androiddevchallenge.ui.theme.infoButtonColor
import com.example.androiddevchallenge.ui.theme.infoCardColor
import com.example.androiddevchallenge.ui.theme.infoColor
import com.example.androiddevchallenge.ui.theme.likeColor
import com.example.androiddevchallenge.ui.theme.likedColor
import com.example.androiddevchallenge.ui.theme.nameColor
import com.example.androiddevchallenge.ui.theme.shapes

@Preview(showBackground = true)
@Composable
fun PetInfoPreview() {
    PetInfo(pet = myLovelyPets.last())
}

@Composable
fun PetInfo(pet: Pet) {
    Box(
        modifier = Modifier.fillMaxHeight().padding(12.dp),
        contentAlignment = Alignment.Center
    ) {
        Card(
            shape = shapes.medium,
            // elevation = 8.dp,
            backgroundColor = infoCardColor
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .verticalScroll(rememberScrollState()),
                verticalArrangement = Arrangement.Center
            ) {
                val image: Painter = painterResource(id = pet.icon)
                Image(
                    painter = image,
                    contentDescription = stringResource(id = pet.name),
                    contentScale = ContentScale.Crop,
                    modifier = Modifier.aspectRatio(1.3f)
                )
                Column(modifier = Modifier.padding(16.dp)) {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(
                            modifier = Modifier.weight(1f).align(Alignment.CenterVertically),
                            text = stringResource(id = pet.name),
                            style = MaterialTheme.typography.h6,
                            color = nameColor,
                        )

                        val checkedState = remember { mutableStateOf(false) }
                        IconToggleButton(
                            modifier = Modifier.align(Alignment.CenterVertically).size(18.dp),
                            checked = checkedState.value,
                            onCheckedChange = {
                                checkedState.value = it
                            }
                        ) {
                            Icon(
                                painterResource(id = R.drawable.ic_like),
                                contentDescription = "like",
                                modifier = Modifier.size(18.dp),
                                tint = if (checkedState.value) likedColor else likeColor
                            )
                        }
                    }
                    Text(
                        text = stringResource(id = pet.age),
                        fontStyle = FontStyle.Italic,
                        style = MaterialTheme.typography.caption,
                        color = infoColor,
                    )
                    Text(
                        text = stringResource(id = pet.type),
                        fontStyle = FontStyle.Italic,
                        style = MaterialTheme.typography.caption,
                        color = infoColor,
                    )
                    Spacer(modifier = Modifier.height(16.dp))
                    Text(
                        text = stringResource(id = pet.info),
                        // fontStyle = FontStyle.Italic,
                        style = MaterialTheme.typography.body1,
                        color = infoColor,
                    )
                    Spacer(modifier = Modifier.height(16.dp))
                    Button(
                        modifier = Modifier.fillMaxWidth(),
                        onClick = {},
                        shape = shapes.large,
                        colors = ButtonDefaults.buttonColors(backgroundColor = infoButtonColor)
                    ) {
                        Text(
                            text = stringResource(id = R.string.activity_info_btn),
                            // color = infoColor,
                        )
                    }
                }
            }
        }
    }
}
