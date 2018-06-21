# ideal-umbrella

## 快速构建子工程

clone 项目 先**install**  **maven-archetype-springboot**

然后即可再命令行执行以下命令：

```bash
mvn archetype:generate \
-DgroupId=com.github.ideal \
-DartifactId=ideal-umbrella \
-Dpackage=com.github.ideal \
-DarchetypeArtifactId=maven-archetype-springboot \
-DinteractiveMode=false \
 -DarchetypeCatalog=local \
 -DarchetypeGroupId=com.github.ideal \
 -DarchetypeVersion=1.0.1
```

