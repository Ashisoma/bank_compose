package com.ashisoma.bankapp

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.AccountBalance
import androidx.compose.material.icons.rounded.AccountCircle
import androidx.compose.material.icons.rounded.Home
import androidx.compose.material.icons.rounded.Notifications
import androidx.compose.material.icons.rounded.Wallet
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.ashisoma.bankapp.data.BottomNavigation


val items = listOf<BottomNavigation>(
    BottomNavigation(
        title = "Home",
        icon = Icons.Rounded.Home
    ),
    BottomNavigation(
        title = "Home",
        icon = Icons.Rounded.Wallet
    ),
    BottomNavigation(
        title = "Notification",
        icon = Icons.Rounded.Notifications
    ),
    BottomNavigation(
    title = "Account ",
    icon = Icons.Rounded.AccountCircle
    )
)

@Composable
fun BottomNavigationBar() {
    NavigationBar {
        Row(
            modifier = Modifier.background(MaterialTheme.colorScheme.inverseOnSurface)
        ) {
            items.forEachIndexed { index, bottomNavigationItem ->
                NavigationBarItem(
                    selected = index == 0,
                    onClick = { /*TODO*/ },
                    icon = {
                        Icon(imageVector = bottomNavigationItem.icon, contentDescription = bottomNavigationItem.title, tint = MaterialTheme.colorScheme.onBackground)
                    }
                )
            }
        }
    }
}
