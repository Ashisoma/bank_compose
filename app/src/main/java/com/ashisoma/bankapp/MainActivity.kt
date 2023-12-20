package com.ashisoma.bankapp

import com.ashisoma.bankapp.ui.theme.PurpleStart
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material.icons.rounded.Home
import androidx.compose.material.icons.rounded.Search
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.ashisoma.bankapp.ui.theme.BankAppTheme
import com.ashisoma.bankapp.ui.theme.PurpleEnd
import com.google.accompanist.systemuicontroller.rememberSystemUiController

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BankAppTheme {
                // A surface container using the 'background' color from the theme
                SetBarColor(color = MaterialTheme.colorScheme.background)
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    HomeScreen()
                }
            }
        }
    }


}

@Composable
private fun SetBarColor(color: Color){
    val systemUiController = rememberSystemUiController()
    SideEffect {
         systemUiController.setNavigationBarColor(
             color = color
         )
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun HomeScreen() {
    Scaffold(
        
        bottomBar = {
            BottomNavigationBar()
        }
    ) {
        padding->
        Column(
            modifier= Modifier
                .fillMaxSize()
                .padding(padding)
        ) {
             WalletSection()
            Spacer(modifier = Modifier.height(16.dp))
             CardsSection()
            // FincanceSection
            // Currencies Section
        }

    }
}

@Composable
fun WalletSection() {
    
    Row(

        modifier = Modifier
            .background(color = Color.White)
            .padding(vertical = 8.dp, horizontal = 8.dp)
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
         Alignment.CenterVertically

    ) {

        Column(
            modifier = Modifier
                .padding(horizontal = 8.dp),
        ) {
            // Text
            Text(
                text = "Wallet",
                style = MaterialTheme.typography.titleSmall,
                color = Color.Gray
            )
            Spacer(modifier = Modifier.height(10.dp))
            Text(
                text = "$ 490.00",
                style = MaterialTheme.typography.titleLarge
            )
        }
        Icon(
            modifier = Modifier
                .width(40.dp)
                .height(40.dp)
                .background(color = Color.Blue, shape = RoundedCornerShape(size = 12.dp))
                .padding(2.dp)


            ,
            imageVector = Icons.Rounded.Search,
            contentDescription ="Search",
            )
    }



}

//@Preview
@Composable
fun CardsSection() {
    TODO("Not yet implemented")
}

@Preview
@Composable
fun CardItem() {
    val gradientColors = listOf(PurpleStart, PurpleEnd)
    val gradientBrush = Brush.linearGradient(
        colors = gradientColors
    )
    Box(
        modifier = Modifier
            .height(150.dp)
            .width(250.dp)
            .clip(MaterialTheme.shapes.medium)
            .background(
                brush = gradientBrush,
            )
    ) {

        Image(
            painter =  painterResource(id = R.drawable.ic_visa), // Replace with your image resource
            contentDescription = null, // Provide content description as needed
            modifier = Modifier
                .align(Alignment.TopStart)
                .padding(5.dp)
                .height(50.dp) // Adjust the height as needed
                .width(100.dp) // Adjust the height as needed
                .background(color = Color.Transparent), // Optional: Add a background to the image
            contentScale = ContentScale.Crop // Adjust content scale as needed
        )    }

}



