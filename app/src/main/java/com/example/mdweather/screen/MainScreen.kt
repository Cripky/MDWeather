package com.example.mdweather.screen

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.example.mdweather.R
import com.example.mdweather.data.WeatherModel
import com.example.mdweather.ui.theme.BlueLight

@Composable
fun MainCard(
    currentDay: MutableState<WeatherModel>,
    onClickSearch: () -> Unit
) {
    Column(
        modifier = Modifier.padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Card(
            modifier = Modifier,
            backgroundColor = BlueLight,
            elevation = 0.dp,
            shape = RoundedCornerShape(16.dp)
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.SpaceEvenly
            ) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Row(
                        modifier = Modifier.padding(8.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Icon(
                            painter = painterResource(id = R.drawable.ic_location),
                            contentDescription = "Location"
                        )
                        Text(
                            text = currentDay.value.city,
                            style = TextStyle(fontSize = 24.sp),
                            color = Color.Black
                        )
                    }
                    IconButton(
                        onClick = {
                            onClickSearch.invoke()
                        }
                    ) {
                        Icon(
                            painter = painterResource(id = R.drawable.ic_search),
                            contentDescription = "im3",
                            tint = Color.Black
                        )
                    }
                }
                AsyncImage(
                    model = "https://" + currentDay.value.icon,
                    contentDescription = "im2",
                    modifier = Modifier
                        .size(260.dp)
                        .padding(top = 3.dp, end = 8.dp)
                )
                Text(
                    text = "${currentDay.value.currentTemp.toFloat().toInt()}ºC",
                    style = TextStyle(fontSize = 65.sp),
                    color = Color.Black,
                    fontWeight = FontWeight.Bold
                )
                Text(
                    text = currentDay.value.condition,
                    style = TextStyle(fontSize = 30.sp),
                    color = Color.Black
                )
                Row(
                    modifier = Modifier.fillMaxWidth().padding(horizontal = 16.dp, vertical = 24.dp),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Row(
                        modifier = Modifier,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Icon(
                            painter = painterResource(id = R.drawable.ic_water),
                            contentDescription = "Humidity",
                            tint = Color.Black
                        )
                        Column(modifier = Modifier.padding(horizontal = 8.dp)) {
                            Text(
                                text = currentDay.value.humidity,
                                style = TextStyle(fontSize = 16.sp),
                                color = Color.Black
                            )
                            Text(text = "Humidity")
                        }
                    }
                    Row(
                        modifier = Modifier,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Icon(
                            painter = painterResource(id = R.drawable.ic_wind),
                            contentDescription = "Wind Speed",
                            tint = Color.Black
                        )
                        Column(modifier = Modifier.padding(horizontal = 8.dp)) {
                            Text(
                                text = currentDay.value.windSpeed + " kph",
                                style = TextStyle(fontSize = 16.sp),
                                color = Color.Black
                            )
                            Text(text = "Wind Speed")
                        }
                    }
                }
            }
        }
    }
}