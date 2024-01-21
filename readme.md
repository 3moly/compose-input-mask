[![Latest release](https://img.shields.io/github/v/release/3moly/compose-input-mask?color=brightgreen&label=latest%20release)](https://github.com/3moly/compose-input-mask/releases/latest)
[![Latest build](https://img.shields.io/github/v/release/3moly/compose-input-mask?color=orange&include_prereleases&label=latest%20build)](https://github.com/3moly/compose-input-mask/releases)


# input-mask library for compose multiplatform 
This is a small project to bring a few functions that solve an input-mask problem in compose. 
There is already added one implementation for demo in compose: **PasswordVisualTransformation**, but this is **not enough**. If you already knew what it costs to bring your own mask for your compose-project, **this project can help you**.

support targets: android, ios, desktop and js.

#### before you go, read the cons to not use this:

* under v1.x.x there is no regex support

#### future plans

- [ ] v2: add regex support

#### features

* placeholder
* styling text

# install

``` kotlin
allprojects {
  repositories {
    mavenCentral()
  }
}

dependencies {
    implementation("io.github.3moly:compose-input-mask:1.0.0")
}
```

# how to use

Here is example of using TextFields in Jetpack Compose. And the one missing part is visualTransformation parameter.

``` kotlin
val textFieldState = remember { mutableStateOf(TextFieldValue("")) }
OutlinedTextField(
    value = textFieldState.value,
    onValueChange = { newValue ->
        textFieldState.value = newValue
    },
    visualTransformation = visualTransformation,
    singleLine = true
)
```

Let's write a mask for date like this "dd/mm/yyyy".

``` kotlin
val visualTransformation = universalTransformation(
    mask = "dd/mm/yyyy",
    maskCharToKeep = '/'
)
```

| input       | display result | raw value in return (newValue ->) |
|-------------|----------------|-----------------------------------|
| 11          | 11/mm/yyyy     | 11                                |
| 11012001    | 11/01/2001     | 11012001                          |
| 112233334   | 11/22/3333     | 112233334                         |
| my_birthday | my/_b/irth     | my_birthday                       |

<details>

<summary>tools</summary>

###### commands to run samples 

desktop: `./gradlew :sample:run`

wasmJs: `./gradlew :sample:wasmJsRun`

###### other commands 

get new versions: `./gradlew :refreshVersions`

</details>