package no.uio.ifi.in2000.smsolsae.in2000_prosjektoppgave.ui.components

import androidx.compose.material.icons.Icons

import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Info
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

/**
 * A general class for a tab item. Currently used on the bottom of the screen.
 * @property title the title of the tab
 * @property selectedIcon Icon when selected
 * @property unselectedIcon Icon when unselected
 * @property badgeAmount Amount of badges (More information to be added)
 * @property route Route to the screen we come to by clicking on this TabBarItem
 */
data class TabBarItem(
    val title: String,
    val selectedIcon: ImageVector,
    val unselectedIcon: ImageVector,
    val badgeAmount: Int? = null,
    val route: String
)


/**
 * Component that will be used throughout the whole app. Displays the bottombar
 * @param navController navcontroller for standard navigation
 */
@Composable
fun BottomBar(navController: NavController){
    val homeTab = TabBarItem(
        title = "Home",
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
    val infoTab = TabBarItem(
        title = "Info",
        selectedIcon = Icons.Filled.Info,
        unselectedIcon = Icons.Outlined.Info,
        route = Screen.Info.route
    )
    val settingsTab = TabBarItem(
        title = "Settings",
        selectedIcon = Icons.Filled.Settings,
        unselectedIcon = Icons.Outlined.Settings,
        route = Screen.Settings.route
    )

    val tabBarItems = listOf(homeTab, alertsTab, infoTab, settingsTab)


    TabView(barItems = tabBarItems, navController = navController)
}

/**
 * Helper method for BottomBar. (More information to be added)
 * @param barItems a list of tab bar items
 * @param navController navcontroller for standard navigation
 */
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