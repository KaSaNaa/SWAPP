package com.retardeddev.swapp

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.BottomAppBarDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import com.retardeddev.swapp.R

@Preview
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun App(){
    Scaffold(
        topBar = {
            TopAppBar(
                title = {},
                navigationIcon = {
                    AppTitle()
                },
                colors = TopAppBarDefaults.mediumTopAppBarColors(
                    containerColor = Color.Blue
                ),
            )
        },
        bottomBar = {
            BottomAppBar(
                Modifier.background(Color.Blue),
                contentColor = Color.Black
            ) {
                Box(
                    modifier = Modifier.fillMaxWidth(),
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = "Bottom Bar",
                        color = Color.Black,
                        textAlign = TextAlign.Center,
                    )
                }
            }
        },
        content = {
            ContentBox()
        }
    )
}

@Preview
@Composable
fun AppTitle() {
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier.fillMaxWidth()
    ) {
        Image(painter = painterResource(id = R.drawable.ic_launcher_foreground),
            contentDescription = "SWAPP")
    }
}

@Preview(showBackground = true)
@Composable
fun ContentBox() {
    Text(color = Color.Black,
        text = "Hello, World!"
    )

}