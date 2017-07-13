### dependencies

project build.gradle
```
apply from : "dependencies.gradle"
allprojects {
    repositories {
        //...
        maven { url rootProject.ext.maven.localMaven}
        maven { url rootProject.ext.maven.localMavenSnapshots}
        //...
    }
}
```

module build.gradle

```
dependencies {
    //...
    compile "cn.wittyneko:base:1.0.0"
    //...
}

```