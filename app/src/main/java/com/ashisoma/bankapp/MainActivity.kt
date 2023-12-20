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
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material.icons.rounded.Home
import androidx.compose.material.icons.rounded.InsertChart
import androidx.compose.material.icons.rounded.Save
import androidx.compose.material.icons.rounded.Search
import androidx.compose.material.icons.rounded.StarBorder
import androidx.compose.material.icons.rounded.Wallet
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
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ashisoma.bankapp.data.CardItemModel
import com.ashisoma.bankapp.data.FinanceModel
import com.ashisoma.bankapp.ui.theme.BankAppTheme
import com.ashisoma.bankapp.ui.theme.BlueEnd
import com.ashisoma.bankapp.ui.theme.BlueStart
import com.ashisoma.bankapp.ui.theme.OrangeEnd
import com.ashisoma.bankapp.ui.theme.OrangeStart
import com.ashisoma.bankapp.ui.theme.PurpleEnd
import com.ashisoma.bankapp.ui.theme.PurpleGrey80
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
@Preview
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
            Spacer(modifier = Modifier.height(16.dp))

            Text(
                text = "Wallet",
                style = MaterialTheme.typography.titleLarge.copy(fontSize = 20.sp, fontWeight = FontWeight.W600,),
                color = Color.Black,
                modifier = Modifier.padding(start = 16.dp)
            )
            Spacer(modifier = Modifier.height(8.dp))
             FinanceSection()
            // Currencies Section
        }

    }
}


@Composable
fun FinanceSection() {

    LazyRow(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.White),
        contentPadding = PaddingValues(horizontal = 16.dp, vertical = 8.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ){

        this.items(finaceList.size) { itemId ->
            val item = finaceList[itemId]
            FinanceItem(item)
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
                .background(color = PurpleGrey80, shape = RoundedCornerShape(size = 12.dp))
                .padding(2.dp)
            ,
            imageVector = Icons.Rounded.Search,
            contentDescription ="Search",
            )
    }



}

val myItemList: List<CardItemModel> = listOf(
    CardItemModel(
        id = 1,
        title = "Business",
        imageRes = R.drawable.ic_visa,
        gradientColors = listOf(PurpleStart, PurpleEnd)
    ),
    CardItemModel(
        id = 1,
        title = "School",
        imageRes = R.drawable.ic_mastercard,
        gradientColors = listOf(BlueStart, BlueEnd)
    ),
    CardItemModel(
        id = 1,
        title = "Home",
        imageRes = R.drawable.ic_visa,
        gradientColors = listOf(OrangeStart, OrangeEnd)
    ),
    // Add more items as needed
)
//@Preview
@Composable
fun CardsSection() {
    LazyRow(
        contentPadding = PaddingValues(horizontal = 16.dp, vertical = 8.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ){

        this.items(myItemList.size) { itemId ->
            val item = myItemList[itemId]
            CardItem(item)
        }
    }
}



//@Preview
@Composable
fun CardItem(item: CardItemModel) {
    val gradientColors = listOf(PurpleStart, PurpleEnd)
    val gradientBrush = Brush.linearGradient(
        colors = item.gradientColors
    )
    Column(
        modifier = Modifier
            .height(150.dp)
            .width(250.dp)
            .clip(MaterialTheme.shapes.medium)
            .background(
                brush = gradientBrush,
            )
    ) {

        Image(
            painter =  painterResource(id = item.imageRes), // Replace with your image resource
            contentDescription = null, // Provide content description as needed
            modifier = Modifier
                .padding(5.dp)
                .height(40.dp) // Adjust the height as needed
                .width(80.dp) // Adjust the height as needed
                .background(color = Color.Transparent), // Optional: Add a background to the image
            contentScale = ContentScale.Crop // Adjust content scale as needed
        )
        Text(
            text = item.title,
            style = MaterialTheme.typography.titleMedium,
            color = Color.White,
            modifier = Modifier.
            padding(start = 15.dp, top= 10.dp)
        )
        Text(
            text = "$ 14.0",
            style = MaterialTheme.typography.titleLarge,
            color = Color.White,
            modifier = Modifier.
            padding(start = 15.dp)
        )
        Text(
            text = "7483 2483 3874 3843",
            style = MaterialTheme.typography.titleMedium,
            color = Color.White,
            modifier = Modifier.
            padding(start = 15.dp, top = 10.dp)
        )
    }
}


val finaceList: List<FinanceModel> = listOf(
    FinanceModel(
        id = 1,
        title = "My\nBusiness",
        icon = Icons.Rounded.StarBorder,
        clr = OrangeStart
    ),
    FinanceModel(
        id = 1,
        title = "My\nWallet",
        icon = Icons.Rounded.Wallet,
        clr = BlueStart
    ),
    FinanceModel(
        id = 1,
        title = "Finance\nAnalysis",
        icon = Icons.Rounded.InsertChart,
        clr = BlueStart
    ),
    FinanceModel(
        id = 1,
        title = "My\nSavings",
        icon = Icons.Rounded.Save,
        clr = BlueStart
    ),
)


@Composable
fun FinanceItem(item: FinanceModel) {

    Column(
        modifier = Modifier
            .height(150.dp)
            .width(140.dp)
            .clip(MaterialTheme.shapes.medium)
            .background(
                color = PurpleGrey80,
            )
    ) {

        Icon(imageVector = item.icon, contentDescription = null,
            modifier = Modifier
                .padding(8.dp)
                .size(50.dp)
                .clip(MaterialTheme.shapes.large)
                .background(color = item.clr)

                .padding(5.dp),
            tint = Color.White
        )
        Text(
            text = item.title,
            style = MaterialTheme.typography.titleMedium,
            color = Color.Black,
            modifier = Modifier.
            padding(start = 15.dp, top= 10.dp)
        )

    }
}



