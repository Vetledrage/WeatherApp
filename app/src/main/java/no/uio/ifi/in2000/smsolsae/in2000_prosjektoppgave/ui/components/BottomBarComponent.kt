package no.uio.ifi.in2000.smsolsae.in2000_prosjektoppgave.ui.components

import androidx.compose.material.icons.Icons

import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.List
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.List
import androidx.compose.material.icons.outlined.Notifications
import androidx.compose.material.icons.outlined.Settings
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.navigation.NavController
import no.uio.ifi.in2000.smsolsae.in2000_prosjektoppgave.Screen

data class TabBarItem(
    val title: String,
    val selectedIcon: ImageVector,
    val unselectedIcon: ImageVector,
    val badgeAmount: Int? = null,
    val route: String
)


//Komponent som skal brukes gjennom hele appen (kan brukes)
//Om flere slike komponenter lag klasse i komponent package for bedre struktur!
@Composable
fun BottomBar(navController: NavController){
    val homeTab = TabBarItem(
        title = "home",
        selectedIcon = Icons.Filled.Home,
        unselectedIcon = Icons.Outlined.Home,
        route = Screen.Home.route
    )
    val alertsTab = TabBarItem(
        title = "Alerts",
        selectedIcon = Icons.Filled.Notifications,
        unselectedIcon = Icons.Outlined.Notifications,
        badgeAmount = 7,
        route = Screen.Alerts.route
    )
    val settingsTab = TabBarItem(
        title = "Settings",
        selectedIcon = Icons.Filled.Settings,
        unselectedIcon = Icons.Outlined.Settings,
        route = Screen.Home.route
    )
    val moreTab = TabBarItem(
        title = "Weather",
        selectedIcon = Icons.Filled.List,
        unselectedIcon = Icons.Outlined.List,
        route = Screen.Home.route
    )

    val tabBarItems = listOf(homeTab, alertsTab, settingsTab, moreTab)


    TabView(barItems = tabBarItems, navController = navController)
}
@Composable
fun TabView(barItems: List<TabBarItem>, navController: NavController){
    var selectedTabIndex by remember { mutableIntStateOf(0) }

    NavigationBar {
        barItems.forEachIndexed{ index, item ->
            NavigationBarItem(
                selected = selectedTabIndex == index,
                onClick = {
                    selectedTabIndex = index
                    navController.navigate(item.route)
                },
                icon = {
                    Icon(
                        imageVector =
                        if (selectedTabIndex == index){
                            item.selectedIcon}
                        else{ item.unselectedIcon
                        },
                        contentDescription = item.title
                    )
                },
                label = { Text(text = item.title)}
            )


        }
    }
}