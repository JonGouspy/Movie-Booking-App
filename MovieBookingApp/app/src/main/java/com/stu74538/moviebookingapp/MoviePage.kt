package com.stu74538.moviebookingapp

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults.topAppBarColors
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.stu74538.moviebookingapp.R.drawable.minus
import com.stu74538.moviebookingapp.R.drawable.plus
import com.stu74538.moviebookingapp.R.drawable.chair_green
import com.stu74538.moviebookingapp.ui.theme.Black
import com.stu74538.moviebookingapp.ui.theme.DarkGray
import com.stu74538.moviebookingapp.ui.theme.Green
import com.stu74538.moviebookingapp.ui.theme.LightGray
import com.stu74538.moviebookingapp.ui.theme.Turquoise

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MoviePage(navController: NavController, movie: Movie = movieArray[0]) {
    var selectedSeats by remember { mutableIntStateOf(0) }

    Scaffold(
        topBar = {
            TopAppBar(
                modifier = modifier
                    .clickable(onClick = { navController.navigate(Routes.HomePage.route) }),
                colors = topAppBarColors(
                    containerColor = Black,
                    titleContentColor = Turquoise,
                ),
                title = {
                    Text(text = "Movie Booking")
                },
            )
        },
        bottomBar = {
            BottomAppBar(
                containerColor = DarkGray,
                contentColor = LightGray,
            ) {
                Row (
                    modifier = modifier
                        .fillMaxSize()
                        .padding(start = 10.dp, end = 10.dp),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically,
                ) {
                    if (movie.seatsSelected == 0) {
                        Row(
                            modifier = modifier
                                .width(120.dp),
                            horizontalArrangement = Arrangement.End
                        ) {
                            Text(text = "$selectedSeats", style = MaterialTheme.typography.titleMedium, color = LightGray)
                            Spacer(modifier = modifier.width(7.dp))
                            Text("Select Seats", style = MaterialTheme.typography.titleMedium, modifier = modifier
                                .clickable(onClick = { movie.seatsSelected = selectedSeats; movie.seatsRemaining -= selectedSeats; navController.navigate(Routes.HomePage.route) }))
                        }

                        Row (
                            modifier = modifier
                                .width(70.dp),
                            horizontalArrangement = Arrangement.SpaceBetween
                        ){
                            Image(
                                modifier = modifier
                                    .size(15.dp)
                                    .clickable(onClick = { if (selectedSeats > 0) selectedSeats-- }),
                                painter = painterResource(minus),
                                contentDescription = null
                            )

                            Image(
                                modifier = modifier
                                    .size(15.dp)
                                    .clickable(onClick = { if (selectedSeats < movie.seatsRemaining) selectedSeats++ }),
                                painter = painterResource(plus),
                                contentDescription = null
                            )
                        }

                        Row (
                            modifier = modifier
                                .width(137.dp),
                            horizontalArrangement = Arrangement.End
                        ){
                            Text(text = "${movie.seatsRemaining - selectedSeats}", style = MaterialTheme.typography.titleMedium, color = LightGray)
                            Spacer(modifier = modifier.width(7.dp))
                            Text(text = "Sits Remaining", style = MaterialTheme.typography.titleMedium, color = LightGray)
                        }
                    }
                    else
                    {
                        Row (
                            modifier = modifier
                                .padding(start = 10.dp)
                                .clickable(onClick = ({ navController.navigate(Routes.HomePage.route) })),
                            verticalAlignment = Alignment.CenterVertically
                        ){
                            Image(painter = painterResource(chair_green), contentDescription = null, modifier = modifier.size(30.dp))
                            Spacer(modifier = modifier.width(20.dp))
                            Text(text = "${movie.seatsSelected}", style = MaterialTheme.typography.titleMedium, color = Green)
                            Spacer(modifier = modifier.width(7.dp))
                            Text(text = "Sits Selected", style = MaterialTheme.typography.titleMedium, color = Green)
                        }
                    }
                }
            }
        },

        ) { innerPadding ->
        Column(
            modifier = modifier
                .padding(innerPadding)
                .fillMaxSize()
                .background(color = DarkGray),
            verticalArrangement = Arrangement.SpaceEvenly,
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Image(
                painterResource(id = movie.image.toInt()), modifier = modifier
                    .width(200.dp)
                    .height(300.dp), contentDescription = null
            )

            Row(
                modifier = modifier,
                verticalAlignment = Alignment.Bottom
            ) {
                Text(text = movie.name, color = Turquoise, fontSize = 20.sp)
                Spacer(modifier = modifier.width(5.dp))
                Text(text = movie.certification, color = LightGray, fontSize = 13.sp)
            }

            Row(
                modifier = modifier
                    .fillMaxWidth()
                    .padding(start = 20.dp, end = 20.dp)
            ) {
                Text(text = movie.runningTimeMins.toString(), color = LightGray)
                Spacer(modifier = modifier.width(5.dp))
                Text(text = "min", color = LightGray)

                Row(
                    modifier = modifier
                        .fillMaxWidth()
                        .padding(start = 15.dp),
                    horizontalArrangement = Arrangement.Start,

                    ) {
                    Text(text = "Starring:", color = LightGray)
                    Spacer(modifier = modifier.width(5.dp))
                    Text(text = getString(movie.starring), color = LightGray)
                }
            }

            Text(
                text = movie.description.trimIndent(),
                modifier = modifier.padding(20.dp)
                    .height(150.dp)
                    .verticalScroll(rememberScrollState()),
                color = LightGray,
                fontSize = 15.sp
            )
        }
    }
}

fun getString(array: Array<String>): String
{
    var res = ""

    array.forEachIndexed { index, str ->
        res = if (index+1 < array.size) {
            "$res$str, "
        } else {
            "$res$str"
        }
    }

    return res
}