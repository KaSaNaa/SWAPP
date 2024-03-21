package com.retardeddev.swapp

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.*
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.ViewModelProvider
import com.retardeddev.swapp.dataModel.CME
import com.retardeddev.swapp.pages.DashboardViewModel
import kotlinx.coroutines.ExperimentalCoroutinesApi

@ExperimentalCoroutinesApi
class MainActivity : ComponentActivity() {
    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val viewModel: DashboardViewModel = ViewModelProvider(this)[DashboardViewModel::class.java]

            App(viewModel)
        }
    }
}

@Composable
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
fun App(viewModel: DashboardViewModel) {
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
            ContentBox(viewModel)
        }
    )
}

@Composable
fun ContentBox(viewModel: DashboardViewModel) {
    val cmeList by viewModel.cmeList.observeAsState(initial = emptyList())

    LazyColumn(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
    ) {
        items(cmeList) { cme ->
            Text(
                text = cme.toString(),
                color = Color.Black,
                textAlign = TextAlign.Center,
                modifier = Modifier.fillMaxWidth()
            )
        }
    }
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
fun ContentBoxPreview() {
    val dummyCMEList = listOf(
        CME(
            "1",
            "2024-03-14T12:00:00",
            "Source Location",
            "Active Region Num",
            listOf("Instrument 1", "Instrument 2"),
            emptyList(),
            emptyList(),
            "Note",
            "Catalog"
        )
    )
    LazyColumn(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
    ) {
        items(dummyCMEList) { cme ->
            Text(
                text = cme.activityID,
                color = Color.Black,
                textAlign = TextAlign.Center,
                modifier = Modifier.fillMaxWidth()
            )
        }
    }
}
