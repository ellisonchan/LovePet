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

import androidx.compose.foundation.layout.Column
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Scaffold
import androidx.compose.material.ScaffoldState
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.ArrowBack
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navArgument
import androidx.navigation.compose.navigate
import androidx.navigation.compose.rememberNavController
import com.example.androiddevchallenge.R
import com.example.androiddevchallenge.bean.Pet
import com.example.androiddevchallenge.model.PetViewModel

@Composable
fun PetListFragment(
    navController: NavController,
    setTitle: (String) -> Unit,
    petViewModel: PetViewModel = viewModel()
) {
    setTitle(stringResource(id = R.string.activity_list_name))
    val pets: State<List<Pet>> = petViewModel.pets.observeAsState(emptyList())
    PetList(
        pets = pets.value,
        onClick = { pet ->
            setTitle("")
            navController.navigate("info/${pet.id}")
        }
    )
}

@Composable
fun PetInfoFragment(
    petId: Int,
    setTitle: (String) -> Unit,
    petViewModel: PetViewModel = viewModel()
) {
    val pets: State<List<Pet>> = petViewModel.pets.observeAsState(emptyList())
    pets.value.firstOrNull { it.id == petId }?.let {
        setTitle(stringResource(id = it.name))
        PetInfo(it)
    }
}

@Preview
@Composable
fun MainNavigation() {
    val navController = rememberNavController()
    val baseTitle = stringResource(id = com.example.androiddevchallenge.R.string.activity_list_name)

    val (title, setTitle) = remember { mutableStateOf(baseTitle) }
    val (canPop, setCanPop) = remember { mutableStateOf(false) }
    val scaffoldState: ScaffoldState = rememberScaffoldState()

    navController.addOnDestinationChangedListener { controller, _, _ ->
        setCanPop(controller.previousBackStackEntry != null)
    }

    Column {
        Scaffold(
            topBar = {
                TopAppBar(
                    title = { Text(text = title) },
                    navigationIcon = if (canPop) {
                        {
                            IconButton(
                                onClick = {
                                    navController.popBackStack()
                                }
                            ) {
                                Icon(Icons.Outlined.ArrowBack, "back")
                            }
                        }
                    } else {
                        {
                            IconButton(
                                onClick = {}
                            ) {
                                Icon(painterResource(id = R.drawable.ic_launcher_foreground), "back")
                            }
                        }
                    },
                )
            },
            scaffoldState = scaffoldState
        ) {
            NavHost(
                navController = navController,
                startDestination = "main"
            ) {
                composable("main") {
                    PetListFragment(navController, setTitle)
                }
                composable(
                    route = "info/{petId}",
                    arguments = listOf(navArgument("petId") { type = NavType.IntType })
                ) { backStackEntry ->
                    PetInfoFragment(backStackEntry.arguments?.getInt("petId")!!, setTitle)
                }
            }
        }
    }
}
