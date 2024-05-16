//[app](../../../index.md)/[no.uio.ifi.in2000.smsolsae.in2000_prosjektoppgave.data](../index.md)/[Features](index.md)

# Features

[androidJvm]\
data class [Features](index.md)(val geometry: [GeometryAlert](../-geometry-alert/index.md), val properties: [PropertiesAlert](../-properties-alert/index.md)?, val type: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)?, val time: [WhenMet](../-when-met/index.md)?)

Represents the features of the build.

## Constructors

| | |
|---|---|
| [Features](-features.md) | [androidJvm]<br>constructor(geometry: [GeometryAlert](../-geometry-alert/index.md), properties: [PropertiesAlert](../-properties-alert/index.md)?, type: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)?, time: [WhenMet](../-when-met/index.md)?) |

## Properties

| Name | Summary |
|---|---|
| [geometry](geometry.md) | [androidJvm]<br>val [geometry](geometry.md): [GeometryAlert](../-geometry-alert/index.md)<br>The geometry of the feature. |
| [properties](properties.md) | [androidJvm]<br>val [properties](properties.md): [PropertiesAlert](../-properties-alert/index.md)?<br>The properties of the feature. |
| [time](time.md) | [androidJvm]<br>@SerializedName(value = &quot;when&quot;)<br>val [time](time.md): [WhenMet](../-when-met/index.md)?<br>The time information of the feature. |
| [type](type.md) | [androidJvm]<br>val [type](type.md): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)?<br>The type of the feature. |
