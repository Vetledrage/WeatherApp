//[app](../../../index.md)/[no.uio.ifi.in2000.smsolsae.in2000_prosjektoppgave.ui.components](../index.md)/[TabBarItem](index.md)

# TabBarItem

[androidJvm]\
data class [TabBarItem](index.md)(val title: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), val selectedIcon: [ImageVector](https://developer.android.com/reference/kotlin/androidx/compose/ui/graphics/vector/ImageVector.html), val unselectedIcon: [ImageVector](https://developer.android.com/reference/kotlin/androidx/compose/ui/graphics/vector/ImageVector.html), val badgeAmount: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)? = null, val route: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html))

A general class for a tab item. Currently used on the bottom of the screen.

## Constructors

| | |
|---|---|
| [TabBarItem](-tab-bar-item.md) | [androidJvm]<br>constructor(title: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), selectedIcon: [ImageVector](https://developer.android.com/reference/kotlin/androidx/compose/ui/graphics/vector/ImageVector.html), unselectedIcon: [ImageVector](https://developer.android.com/reference/kotlin/androidx/compose/ui/graphics/vector/ImageVector.html), badgeAmount: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)? = null, route: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)) |

## Properties

| Name | Summary |
|---|---|
| [badgeAmount](badge-amount.md) | [androidJvm]<br>val [badgeAmount](badge-amount.md): [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)? = null<br>Amount of badges |
| [route](route.md) | [androidJvm]<br>val [route](route.md): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)<br>Route to the screen we come to by clicking on this TabBarItem |
| [selectedIcon](selected-icon.md) | [androidJvm]<br>val [selectedIcon](selected-icon.md): [ImageVector](https://developer.android.com/reference/kotlin/androidx/compose/ui/graphics/vector/ImageVector.html)<br>Icon when selected |
| [title](title.md) | [androidJvm]<br>val [title](title.md): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)<br>the title of the tab |
| [unselectedIcon](unselected-icon.md) | [androidJvm]<br>val [unselectedIcon](unselected-icon.md): [ImageVector](https://developer.android.com/reference/kotlin/androidx/compose/ui/graphics/vector/ImageVector.html)<br>Icon when unselected |
