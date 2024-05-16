//[app](../../../index.md)/[no.uio.ifi.in2000.smsolsae.in2000_prosjektoppgave.ui.utils](../index.md)/[DailyFactManager](index.md)

# DailyFactManager

class [DailyFactManager](index.md)(context: [Context](https://developer.android.com/reference/kotlin/android/content/Context.html))

Class to manage the daily facts. Will ensure that a new fact is generated each day.

#### Parameters

androidJvm

| | |
|---|---|
| context | The context used to access application assets and preferences. |

## Constructors

| | |
|---|---|
| [DailyFactManager](-daily-fact-manager.md) | [androidJvm]<br>constructor(context: [Context](https://developer.android.com/reference/kotlin/android/content/Context.html)) |

## Functions

| Name | Summary |
|---|---|
| [getDailyFact](get-daily-fact.md) | [androidJvm]<br>fun [getDailyFact](get-daily-fact.md)(): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)<br>Gets the daily fact. If the stored date does not match the current date, a new fact is generated and stored. |
