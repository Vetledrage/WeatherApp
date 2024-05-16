//[app](../../../index.md)/[no.uio.ifi.in2000.smsolsae.in2000_prosjektoppgave.data](../index.md)/[MapFeatures](index.md)

# MapFeatures

[androidJvm]\
data class [MapFeatures](index.md)(var id: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)?, var type: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)?, var placeType: [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)&lt;[String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)&gt;, var relevance: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)?, var text: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)?, var placeName: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)?, var geometry: [MapGeometry](../-map-geometry/index.md)?, var address: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)?)

Represents the features of the map.

## Constructors

| | |
|---|---|
| [MapFeatures](-map-features.md) | [androidJvm]<br>constructor(id: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)?, type: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)?, placeType: [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)&lt;[String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)&gt;, relevance: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)?, text: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)?, placeName: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)?, geometry: [MapGeometry](../-map-geometry/index.md)?, address: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)?) |

## Properties

| Name | Summary |
|---|---|
| [address](address.md) | [androidJvm]<br>var [address](address.md): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)?<br>The address of the feature. |
| [geometry](geometry.md) | [androidJvm]<br>var [geometry](geometry.md): [MapGeometry](../-map-geometry/index.md)?<br>The geometry of the feature. |
| [id](id.md) | [androidJvm]<br>var [id](id.md): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)?<br>The ID of the feature. |
| [placeName](place-name.md) | [androidJvm]<br>var [placeName](place-name.md): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)?<br>The name of the place. |
| [placeType](place-type.md) | [androidJvm]<br>var [placeType](place-type.md): [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)&lt;[String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)&gt;<br>The list of place types. |
| [relevance](relevance.md) | [androidJvm]<br>var [relevance](relevance.md): [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)?<br>The relevance score of the feature. |
| [text](text.md) | [androidJvm]<br>var [text](text.md): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)?<br>The text description of the feature. |
| [type](type.md) | [androidJvm]<br>var [type](type.md): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)?<br>The type of the feature. |
