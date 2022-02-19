package com.example.mykmmapp.android

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.mykmmapp.Greeting
import android.widget.TextView
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.lifecycle.ViewModel
import com.example.mykmmapp.BooksInfo
import com.example.mykmmapp.repo.BooksRepo
import kotlinx.coroutines.runBlocking



class MainActivity : AppCompatActivity() {
    private val viewModel: MyViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    setContent {
        MaterialTheme {
            val state = viewModel.book.observeAsState(emptyList())
            LazyColumn {
                items(state.value) { item ->
                    rowItem(item)
                }
            }
        }
    }
//        /@OptIn(ExperimentalCallAPI::class)
        @Composable
                fun rowItem(item:BooksInfo){
Column(
Modifier.background(Color.White).fillMaxWidth().wrapContentHeight().padding(bottom = 8.dp)

){
    Row(Modifier.fillMaxWidth().padding(horizontal = 8.dp), horizontalArrangement = Arrangement.SpaceBetween){

        Text(item.display_name, Modifier.padding(top=20.dp))
        Text(item.published_date_description, Modifier.padding(top=20.dp))

    }
}
                }
      }


    }

