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
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults.topAppBarColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.stu74538.moviebookingapp.ui.theme.Black
import com.stu74538.moviebookingapp.ui.theme.DarkGray
import com.stu74538.moviebookingapp.ui.theme.Green
import com.stu74538.moviebookingapp.ui.theme.LightGray
import com.stu74538.moviebookingapp.ui.theme.Turquoise

var modifier = Modifier

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomePage(navController: NavController) {
    Scaffold(
        topBar = {
            TopAppBar(
                colors = topAppBarColors(
                    containerColor = Black,
                    titleContentColor = Turquoise,
                ),
                title = {
                    Text("Movie Booking")
                }
            )
        },

        ){ innerPadding ->
        Column(
            modifier = Modifier
                .background(DarkGray)
                .padding(innerPadding)
                .fillMaxSize()
                .padding(start = 20.dp, end = 20.dp),
            verticalArrangement = Arrangement.SpaceEvenly,
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            movieArray.forEachIndexed { index, movie ->
                MovieBox(
                    onClick = { navController.navigate(Routes.MoviePage.route + "/$index") },
                    movie,
                    modifier
                )
            }
        }
    }
}

@Composable
fun MovieBox(onClick: () -> Unit, movie: Movie, modifier: Modifier = Modifier) {
    Row (
        modifier = modifier
            .fillMaxWidth()
            .clickable(onClick = onClick),
        horizontalArrangement = Arrangement.SpaceBetween,
    ){
        Image(painterResource(id =  movie.image.toInt()), modifier = modifier
            .width(100.dp)
            .height(150.dp), contentDescription = null)

        Column (
            modifier = modifier
                .width(250.dp)
                .height(140.dp)
                .padding(top = 2.dp, bottom = 5.dp),
            verticalArrangement = Arrangement.SpaceBetween,
        ){
            Column {
                Text(text = movie.name, color = Turquoise, fontSize = 20.sp)
                Spacer(modifier.height(5.dp))
                Text(text = movie.description, maxLines = 2, overflow = TextOverflow.Ellipsis, color = LightGray)
            }

            if (movie.seatsSelected == 0){
                Row {
                    Image(modifier = modifier.size(20.dp), painter = painterResource(R.drawable.chair_white), contentDescription = null)
                    Spacer(modifier.width(10.dp))
                    Text(text = "${movie.seatsRemaining}  Seats Remaining", color = LightGray)
                }
            }
            else {
                Row {
                    Image(modifier = modifier.size(20.dp), painter = painterResource(R.drawable.chair_green), contentDescription = null)
                    Spacer(modifier.width(10.dp))
                    Text(text = "${movie.seatsSelected}  Seats Selected", color = Green)
                }
            }
        }
    }
}