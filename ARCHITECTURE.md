Beskriver arkitekturen som er benyttet i appen.

Beskrivelse av hvordan viktige objektorienterte prinsipper som
lav kobling og høy kohesjon samt design patterns som MVVM
og UDF er ivaretatt i løsningen burde også være med.

Beskriv løsningen beregnet på lesere som skal jobbe med drift,
vedlikehold og videreutvikling av løsningen. Beskriv hvilke
teknologier og arkitektur som brukes i løsningen. Beskriv hvilket
API-nivå (Android versjon) dere har valgt, og hvorfor.


# ARCHITECTURE.MD PAWCAST
### ARCHITECTURE.md is a file where information about the architecture, build and methods in the project/code. There will also be information about the object-oriantated principples, API-level chosen and how other developers can further develop and use the code.

## ARCHITECTURE: 
### Datasource and Respositories:
We are using API calls from a JSON source from MetAlerts and MapBox. Theese are collected in DataSources. Later the data is collected by the DataRespositories where using Interfaces we develop functions that collect the data and later sort them into  the Data Classes. Theese respositories is where the data is called and used by the viewmodel. 

### ViewModel
In our App we are using a viewmodel to handle data. A ViewModel is a livedata class that calls on the respositories and and save them in a UI-state. Then we can handle and use the data as we want, while the UI-state handles where and what is done so the Data will update live. This means that instead of loading in the page every time, the page is saved/remembered. An example is when you set your location in the App, if you then change screen and then back the location will NOT reset, it is saved.

### Object-Orientated

### API-level

### Further development

