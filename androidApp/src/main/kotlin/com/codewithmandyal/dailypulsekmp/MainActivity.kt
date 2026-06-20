package com.codewithmandyal.dailypulsekmp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import com.codewithmandyal.dailypulsekmp.articles.ArticlesViewModel
import com.codewithmandyal.dailypulsekmp.screens.AboutScreen
import com.codewithmandyal.dailypulsekmp.screens.ArticlesScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        enableEdgeToEdge()
        super.onCreate(savedInstanceState)

        //Platform().logSystemInfo()


        setContent {
            //App()
            //AboutScreen()
            //ArticlesScreen()
            AppScaffold()
        }
    }
}

@Preview
@Composable
fun AppAndroidPreview() {
    App()
}