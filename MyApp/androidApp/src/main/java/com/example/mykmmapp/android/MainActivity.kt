package com.example.mykmmapp.android

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.mykmmapp.Greeting
import android.widget.TextView
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.lifecycle.ViewModel
import coil.annotation.ExperimentalCoilApi
import coil.compose.rememberImagePainter

import com.example.mykmmapp.MoviesInfo
import com.example.mykmmapp.repo.BooksRepo
import kotlinx.coroutines.runBlocking



class MainActivity : AppCompatActivity() {
    private val viewModel: MainViewModel by viewModels()
    val imageBaseURL="https://static01.nyt.com/images/2019/06/05/arts/blackgodfather1/blackgodfather1-mediumThreeByTwo210.jpg"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    setContent {
        MaterialTheme {
            val state = viewModel.movie.observeAsState(initial=emptyList())
            LazyColumn {
                items(items=state.value) { item ->
                    rowItem(item)
                }
            }
        }
    }




}
@OptIn(ExperimentalCoilApi::class)
    @Composable
    fun rowItem(item: MoviesInfo) {
        Column(
            modifier=Modifier.background(Color.White).fillMaxWidth().wrapContentHeight().padding(bottom = 8.dp)

        ){

            val image=rememberImagePainter(imageBaseURL)
            Image(
                modifier=Modifier.fillMaxWidth()
                    .height(150.dp),
                painter=image,
                contentDescription="placeholder image",
                contentScale= ContentScale.Crop)



        }
      Row(modifier=Modifier.fillMaxWidth().padding(horizontal = 8.dp), horizontalArrangement = Arrangement.SpaceBetween){

                Text(item.display_title, Modifier.padding(top=20.dp))
                Text(item.mpaa_rating, Modifier.padding(top=20.dp))

            }
        }

}
