1. 切换当前分支
2. 添加 maven 阿里镜像仓库
```
allprojects {
    repositories {
        maven { url 'https://maven.aliyun.com/repository/public/' }
        maven { url 'https://maven.aliyun.com/repository/spring/'}
        mavenLocal()
        mavenCentral()
    }
}

```
3. 修改 gradle wapper 下载地址  
    distributionUrl=https\://services.gradle.org/distributions/gradle-4.4.1-bin.zip 修改为
    distributionUrl=https\://downloads.gradle-dn.com/distributions/gradle-4.4.1-bin.zip

4. Follow import-into-idea.md 或者 import-into-eclipse




参考链接
https://developer.aliyun.com/mirror/maven