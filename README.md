### build

```
# 编译全部module推送到本地仓库
./gradlew uploadArchives
# 编译base推送到本地仓库
./gradlew :base:uploadArchives
```

### dependencies
复制 `config.gradle`和`dependencies.gradle`

修改 project build.gradle

```
buildscript {
    //...
    apply from : "dependencies.gradle"
    repositories {
        //...
        maven { url rootProject.ext.maven.aliyunMaven}
        jcenter()
    }
    //...
}

allprojects {
    repositories {
        //...
        maven { url rootProject.ext.maven.sdkAndroidMaven }
        maven { url rootProject.ext.maven.sdkGoogleMaven }
        maven { url rootProject.ext.maven.sdkMaven }
        maven { url rootProject.ext.maven.localMaven}
        maven { url rootProject.ext.maven.localMavenSnapshots}
        maven { url rootProject.ext.maven.aliyunMaven}
        jcenter()
        //...
    }
}
```
添加 module build.gradle 依懒

```
// eg: base module
dependencies {
    //...
    compile "cn.wittyneko:base:1.0.0"
    //...
}
```