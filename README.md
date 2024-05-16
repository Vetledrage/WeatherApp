# Team-41
* Said Magomed Aptievitsj Solsaev
* Vetle Drage
* Mohammad Younas Hameed
* Radi Halabi
* Johannes H. Sletten
* Brede Kvam

# Weather PawCast: 
## Case 3. Weather Forecast and Danger Warnings for Younger Users

#### Weather PawCast is a weather app made to inform a younger audience about weather and danger alerts. Using child friendly designs and fun features we hope to attract users in the age range 9 to 25.

#### Key features in the app showcase the newest weather information and danger alerts using a bear-inspired design. Where users can check the weather at their current location, or choose another specified location.

# Documentation
#### This project also contains the markdown files ARCHITECTURE.md and MODELING.md, and further documentation about the project is detailed in the project report. We have also included documentation for our code, which can be found under app/build/documentation. We have included documentation both in markdown and html format, generated with Dokka. To generate the documentation for the code yourself (if you for example make changes to the app and want to update the documentation), we've provided a short guide:
#### Here is a concise guide on how to generate documentation for our project in kdoc. We utilize the Dokka library for this purpose, which is already included as a dependency in our project, so there is no need for you to add it manually.

### Prequisites: 
#### Ensure that you have the JDK installed. The JDK is required to generate the documentation. If you do not have it installed, you can download it from this site: https://www.oracle.com/java/technologies/downloads/

### Steps to generate documentation:
#### 1) Open Android Studio
#### 2) Access the terminal in Android Studio
#### 3) To generate the documentation in the HTML-format: type the following command: ./gradlew dokkaHtml
#### OR: If you prefer to generate documentation in Markdown format, enter: ./gradlew dokkaGfm

#### This will initiate the process to generate the documentation. The generated documentation can be found locally in the app/build/documentation directory.
#### For more detailed information, please visit the official Dokka documentation: https://kotlinlang.org/docs/dokka-gradle.html#apply-dokka

# Installations
#### You can download the App via this GitHub project page.

# Running the App
#### We have used the Android Studio IDE to implement and run the App. When downloading the code, make sure it is ran using this program. 
#### https://developer.android.com/studio/releases
#### No other installations should be necessary. Make sure gradle sync is up to date. 

#### If the code is downloaded and gradle is synced, you can run the App in Android Studio. Make sure that you are connected to Wi-Fi. 
#### If you run the code and change internet after, running again could make the API calls fail. Therefore terminating the App then running it again on the new internet (Not rerun, but cancel then run),will fix this problem.

# Libraries used
#### Most of the code is implemented using Kotlin and Jetpack Compose. We have also used kotlinx for the livedata features. 

####
Ktor: A framework for building asynchronous servers and clients in connected systems. This project utilizes ktor-client-core, ktor-client-cio, ktor-serialization-gson, and ktor-client-content-negotiation for network requests and JSON serialization. Version: 2.3.9

Modules Used:

  • ktor-client-core: Core module for Ktor client.

  • ktor-client-cio: HTTP client engine based on CIO.
  
  • ktor-serialization-gson: Serialization support using Gson.
  
  • ktor-client-content-negotiation: Support for content negotiation.

AndroidX Core KTX: Provides Kotlin extensions for common framework APIs, making Android development more concise and idiomatic. Version: 1.13.0

AndroidX Lifecycle Runtime KTX: Kotlin extensions for Android lifecycle components, which helps in managing UI-related data in a lifecycle-conscious way. Version: 2.7.0

AndroidX Activity Compose: Integration of Jetpack Compose with Android activity lifecycle. Version: 1.9.0

AndroidX Compose: Modern toolkit for building native UI. Various modules from Compose are used, including UI, graphics, tooling preview, and Material3. Version: Compose BOM 2024.04.01

AndroidX ConstraintLayout: Layout library for creating complex and responsive UI designs. Version: 2.1.4. Compose Version: 1.0.1

AndroidX Navigation Compose: Integration of Jetpack Navigation with Compose for navigating between screens. Version: 2.7.7

Google Play Services Location: Provides APIs for location services. Version: 21.2.0

Google Accompanist Permissions: Provides utilities for handling permissions in Jetpack Compose. Version: 0.35.0-alpha

JUnit: Framework for writing and running tests. Version: 4.13.2

AndroidX Test Ext JUnit: Extensions for JUnit to run Android tests. Version: 1.1.5

AndroidX Test Espresso: Testing framework for writing concise and reliable UI tests. Version: 3.5.1

Lottie Compose: A library for parsing and rendering Lottie animations. Version: 4.0.0

Dokka: A documentation engine for Kotlin, used to generate documentation in HTML and Markdown formats. Version: 1.9.20


# Acknowledgements
#### Thanks to Meteorologisk institutt https://www.met.no for providing the APIs used to access weatherdata. 
#### Thanks to UIO https://www.uio.no for giving us the opportunity to work and experiment with these APIs, as well as providing us with help and guidance. 
#### Thanks to all developers of team41!

# Contact us!
#### We can be reached through our respective UIO emails, which should be available to the examiners. 
