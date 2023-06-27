package com.example.testproject.presentation.main

import android.os.Bundle
import android.util.Log
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.common.utils.Utils
import com.example.testproject.data.model.Article
import com.example.testproject.presentation.main.viewmodel.MainViewModel
import com.example.testproject.ui.theme.TestProjectTheme
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {

    private val mainViewModel: MainViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        fetchData()
        setContent {
            TestProjectTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Greeting("Android")
                }
            }
        }
    }

    private fun fetchData() {

        mainViewModel.news.observe(this) {
            Log.d("hailpt ", " ${it.size}")
//            showArticles(it)
        }

        mainViewModel.getArticles()
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    TestProjectTheme {
        Greeting("Android")
    }
}

@Composable
fun showArticles(articles: List<Article>) {
    LazyColumn {
        items(articles) { article->
            makeItem(title = articles[0].title)
        }
    }
}

@Composable
private fun makeItem(title: String?) {
    Card(
        modifier = Modifier
            .padding(2.dp)
            .border(width = 1.dp, color = Color.Cyan)
    ) {
        Text(
            text = title ?: "Error"
        )
    }
}