# mybatis-demo-with-jdk13

[![Build Status](https://travis-ci.org/kazuki43zoo/mybatis-demo-with-jdk13.svg?branch=master)](https://travis-ci.org/kazuki43zoo/mybatis-demo-with-jdk13)

This project provide demo application for developing annotation based mapper using "Text Blocks" added at JDK 13.


* src/main/java/com/example/mapper/TodoMapper.java

```java
@Mapper
public interface TodoMapper {

  @Insert("""
    INSERT INTO todo
      (title, details, finished)
    VALUES
      (#{title}, #{details}, #{finished})
  """)
  @Options(useGeneratedKeys = true, keyProperty = "id")
  void insert(Todo todo);

  @Select("""
    SELECT
      id, title, details, finished
    FROM
      todo
    WHERE
      id = #{id}
  """)
  Todo select(int id);

}
```

### Install JDK 13

* https://jdk.java.net/13/

### Set JAVA_HOME

```
$ export JAVA_HOME=/Library/Java/JavaVirtualMachines/jdk-13.jdk/Contents/Home
```

### Packaging(with Tests)

```
$ ./mvnw clean package
[INFO] Scanning for projects...
[INFO] 
[INFO] ----------------< com.example:mybatis-demo-with-jdk13 >-----------------
[INFO] Building mybatis-demo-with-jdk13 0.0.1-SNAPSHOT
[INFO] --------------------------------[ jar ]---------------------------------
[INFO] 
[INFO] --- maven-clean-plugin:3.1.0:clean (default-clean) @ mybatis-demo-with-jdk13 ---
[INFO] Deleting /Users/xxxxx/git-me/mybatis-demo-with-jdk13/target
[INFO] 
[INFO] --- maven-resources-plugin:3.1.0:resources (default-resources) @ mybatis-demo-with-jdk13 ---
[INFO] Using 'UTF-8' encoding to copy filtered resources.
[INFO] Copying 1 resource
[INFO] Copying 1 resource
[INFO] 
[INFO] --- maven-compiler-plugin:3.8.1:compile (default-compile) @ mybatis-demo-with-jdk13 ---
[INFO] Changes detected - recompiling the module!
[INFO] Compiling 3 source files to /Users/xxxxx/git-me/mybatis-demo-with-jdk13/target/classes
[WARNING] /Users/xxxxx/git-me/mybatis-demo-with-jdk13/src/main/java/com/example/mapper/TodoMapper.java:[12,11] text blocksはプレビュー機能であり、今後のリリースで削除される可能性があります。
[WARNING] /Users/xxxxx/git-me/mybatis-demo-with-jdk13/src/main/java/com/example/mapper/TodoMapper.java:[21,11] text blocksはプレビュー機能であり、今後のリリースで削除される可能性があります。
[INFO] 
[INFO] --- maven-resources-plugin:3.1.0:testResources (default-testResources) @ mybatis-demo-with-jdk13 ---
[INFO] Using 'UTF-8' encoding to copy filtered resources.
[INFO] skip non existing resourceDirectory /Users/xxxxx/git-me/mybatis-demo-with-jdk13/src/test/resources
[INFO] 
[INFO] --- maven-compiler-plugin:3.8.1:testCompile (default-testCompile) @ mybatis-demo-with-jdk13 ---
[INFO] Changes detected - recompiling the module!
[INFO] Compiling 1 source file to /Users/xxxxx/git-me/mybatis-demo-with-jdk13/target/test-classes
[INFO] 
[INFO] --- maven-surefire-plugin:2.22.2:test (default-test) @ mybatis-demo-with-jdk13 ---
[INFO] 
[INFO] -------------------------------------------------------
[INFO]  T E S T S
[INFO] -------------------------------------------------------
22:43:00.446 [main] DEBUG org.springframework.test.context.junit4.SpringJUnit4ClassRunner - SpringJUnit4ClassRunner constructor called with [class com.example.MybatisDemoApplicationTests]
22:43:00.452 [main] DEBUG org.springframework.test.context.BootstrapUtils - Instantiating CacheAwareContextLoaderDelegate from class [org.springframework.test.context.cache.DefaultCacheAwareContextLoaderDelegate]
22:43:00.460 [main] DEBUG org.springframework.test.context.BootstrapUtils - Instantiating BootstrapContext using constructor [public org.springframework.test.context.support.DefaultBootstrapContext(java.lang.Class,org.springframework.test.context.CacheAwareContextLoaderDelegate)]
22:43:00.486 [main] DEBUG org.springframework.test.context.BootstrapUtils - Instantiating TestContextBootstrapper for test class [com.example.MybatisDemoApplicationTests] from class [org.springframework.boot.test.context.SpringBootTestContextBootstrapper]
22:43:00.505 [main] INFO org.springframework.boot.test.context.SpringBootTestContextBootstrapper - Neither @ContextConfiguration nor @ContextHierarchy found for test class [com.example.MybatisDemoApplicationTests], using SpringBootContextLoader
22:43:00.510 [main] DEBUG org.springframework.test.context.support.AbstractContextLoader - Did not detect default resource location for test class [com.example.MybatisDemoApplicationTests]: class path resource [com/example/MybatisDemoApplicationTests-context.xml] does not exist
22:43:00.510 [main] DEBUG org.springframework.test.context.support.AbstractContextLoader - Did not detect default resource location for test class [com.example.MybatisDemoApplicationTests]: class path resource [com/example/MybatisDemoApplicationTestsContext.groovy] does not exist
22:43:00.511 [main] INFO org.springframework.test.context.support.AbstractContextLoader - Could not detect default resource locations for test class [com.example.MybatisDemoApplicationTests]: no resource found for suffixes {-context.xml, Context.groovy}.
22:43:00.512 [main] INFO org.springframework.test.context.support.AnnotationConfigContextLoaderUtils - Could not detect default configuration classes for test class [com.example.MybatisDemoApplicationTests]: MybatisDemoApplicationTests does not declare any static, non-private, non-final, nested classes annotated with @Configuration.
22:43:00.573 [main] DEBUG org.springframework.test.context.support.ActiveProfilesUtils - Could not find an 'annotation declaring class' for annotation type [org.springframework.test.context.ActiveProfiles] and class [com.example.MybatisDemoApplicationTests]
22:43:00.660 [main] DEBUG org.springframework.context.annotation.ClassPathScanningCandidateComponentProvider - Identified candidate component class: file [/Users/xxxxx/git-me/mybatis-demo-with-jdk13/target/classes/com/example/MybatisDemoApplication.class]
22:43:00.661 [main] INFO org.springframework.boot.test.context.SpringBootTestContextBootstrapper - Found @SpringBootConfiguration com.example.MybatisDemoApplication for test class com.example.MybatisDemoApplicationTests
22:43:00.825 [main] DEBUG org.springframework.boot.test.context.SpringBootTestContextBootstrapper - @TestExecutionListeners is not present for class [com.example.MybatisDemoApplicationTests]: using defaults.
22:43:00.825 [main] INFO org.springframework.boot.test.context.SpringBootTestContextBootstrapper - Loaded default TestExecutionListener class names from location [META-INF/spring.factories]: [org.springframework.boot.test.mock.mockito.MockitoTestExecutionListener, org.springframework.boot.test.mock.mockito.ResetMocksTestExecutionListener, org.springframework.boot.test.autoconfigure.restdocs.RestDocsTestExecutionListener, org.springframework.boot.test.autoconfigure.web.client.MockRestServiceServerResetTestExecutionListener, org.springframework.boot.test.autoconfigure.web.servlet.MockMvcPrintOnlyOnFailureTestExecutionListener, org.springframework.boot.test.autoconfigure.web.servlet.WebDriverTestExecutionListener, org.springframework.test.context.web.ServletTestExecutionListener, org.springframework.test.context.support.DirtiesContextBeforeModesTestExecutionListener, org.springframework.test.context.support.DependencyInjectionTestExecutionListener, org.springframework.test.context.support.DirtiesContextTestExecutionListener, org.springframework.test.context.transaction.TransactionalTestExecutionListener, org.springframework.test.context.jdbc.SqlScriptsTestExecutionListener, org.springframework.test.context.event.EventPublishingTestExecutionListener]
22:43:00.853 [main] DEBUG org.springframework.boot.test.context.SpringBootTestContextBootstrapper - Skipping candidate TestExecutionListener [org.springframework.test.context.web.ServletTestExecutionListener] due to a missing dependency. Specify custom listener classes or make the default listener classes and their required dependencies available. Offending class: [javax/servlet/ServletContext]
22:43:00.865 [main] INFO org.springframework.boot.test.context.SpringBootTestContextBootstrapper - Using TestExecutionListeners: [org.springframework.test.context.support.DirtiesContextBeforeModesTestExecutionListener@53f3bdbd, org.springframework.boot.test.mock.mockito.MockitoTestExecutionListener@34129c78, org.springframework.boot.test.autoconfigure.SpringBootDependencyInjectionTestExecutionListener@7d61eb55, org.springframework.test.context.support.DirtiesContextTestExecutionListener@222a59e6, org.springframework.test.context.transaction.TransactionalTestExecutionListener@6c7a164b, org.springframework.test.context.jdbc.SqlScriptsTestExecutionListener@4c2bb6e0, org.springframework.test.context.event.EventPublishingTestExecutionListener@3e62d773, org.springframework.boot.test.mock.mockito.ResetMocksTestExecutionListener@4ef74c30, org.springframework.boot.test.autoconfigure.restdocs.RestDocsTestExecutionListener@7283d3eb, org.springframework.boot.test.autoconfigure.web.client.MockRestServiceServerResetTestExecutionListener@638ef7ed, org.springframework.boot.test.autoconfigure.web.servlet.MockMvcPrintOnlyOnFailureTestExecutionListener@4bff7da0, org.springframework.boot.test.autoconfigure.web.servlet.WebDriverTestExecutionListener@3f1d2e23]
22:43:00.873 [main] DEBUG org.springframework.test.annotation.ProfileValueUtils - Retrieved @ProfileValueSourceConfiguration [null] for test class [com.example.MybatisDemoApplicationTests]
22:43:00.874 [main] DEBUG org.springframework.test.annotation.ProfileValueUtils - Retrieved ProfileValueSource type [class org.springframework.test.annotation.SystemProfileValueSource] for class [com.example.MybatisDemoApplicationTests]
22:43:00.906 [main] DEBUG org.springframework.test.context.junit4.SpringJUnit4ClassRunner - SpringJUnit4ClassRunner constructor called with [class com.example.MybatisDemoApplicationTests]
22:43:00.906 [main] DEBUG org.springframework.test.context.BootstrapUtils - Instantiating CacheAwareContextLoaderDelegate from class [org.springframework.test.context.cache.DefaultCacheAwareContextLoaderDelegate]
22:43:00.906 [main] DEBUG org.springframework.test.context.BootstrapUtils - Instantiating BootstrapContext using constructor [public org.springframework.test.context.support.DefaultBootstrapContext(java.lang.Class,org.springframework.test.context.CacheAwareContextLoaderDelegate)]
22:43:00.907 [main] DEBUG org.springframework.test.context.BootstrapUtils - Instantiating TestContextBootstrapper for test class [com.example.MybatisDemoApplicationTests] from class [org.springframework.boot.test.context.SpringBootTestContextBootstrapper]
22:43:00.908 [main] INFO org.springframework.boot.test.context.SpringBootTestContextBootstrapper - Neither @ContextConfiguration nor @ContextHierarchy found for test class [com.example.MybatisDemoApplicationTests], using SpringBootContextLoader
22:43:00.909 [main] DEBUG org.springframework.test.context.support.AbstractContextLoader - Did not detect default resource location for test class [com.example.MybatisDemoApplicationTests]: class path resource [com/example/MybatisDemoApplicationTests-context.xml] does not exist
22:43:00.909 [main] DEBUG org.springframework.test.context.support.AbstractContextLoader - Did not detect default resource location for test class [com.example.MybatisDemoApplicationTests]: class path resource [com/example/MybatisDemoApplicationTestsContext.groovy] does not exist
22:43:00.910 [main] INFO org.springframework.test.context.support.AbstractContextLoader - Could not detect default resource locations for test class [com.example.MybatisDemoApplicationTests]: no resource found for suffixes {-context.xml, Context.groovy}.
22:43:00.910 [main] INFO org.springframework.test.context.support.AnnotationConfigContextLoaderUtils - Could not detect default configuration classes for test class [com.example.MybatisDemoApplicationTests]: MybatisDemoApplicationTests does not declare any static, non-private, non-final, nested classes annotated with @Configuration.
22:43:00.914 [main] DEBUG org.springframework.test.context.support.ActiveProfilesUtils - Could not find an 'annotation declaring class' for annotation type [org.springframework.test.context.ActiveProfiles] and class [com.example.MybatisDemoApplicationTests]
22:43:00.916 [main] INFO org.springframework.boot.test.context.SpringBootTestContextBootstrapper - Found @SpringBootConfiguration com.example.MybatisDemoApplication for test class com.example.MybatisDemoApplicationTests
22:43:00.941 [main] DEBUG org.springframework.boot.test.context.SpringBootTestContextBootstrapper - @TestExecutionListeners is not present for class [com.example.MybatisDemoApplicationTests]: using defaults.
22:43:00.942 [main] INFO org.springframework.boot.test.context.SpringBootTestContextBootstrapper - Loaded default TestExecutionListener class names from location [META-INF/spring.factories]: [org.springframework.boot.test.mock.mockito.MockitoTestExecutionListener, org.springframework.boot.test.mock.mockito.ResetMocksTestExecutionListener, org.springframework.boot.test.autoconfigure.restdocs.RestDocsTestExecutionListener, org.springframework.boot.test.autoconfigure.web.client.MockRestServiceServerResetTestExecutionListener, org.springframework.boot.test.autoconfigure.web.servlet.MockMvcPrintOnlyOnFailureTestExecutionListener, org.springframework.boot.test.autoconfigure.web.servlet.WebDriverTestExecutionListener, org.springframework.test.context.web.ServletTestExecutionListener, org.springframework.test.context.support.DirtiesContextBeforeModesTestExecutionListener, org.springframework.test.context.support.DependencyInjectionTestExecutionListener, org.springframework.test.context.support.DirtiesContextTestExecutionListener, org.springframework.test.context.transaction.TransactionalTestExecutionListener, org.springframework.test.context.jdbc.SqlScriptsTestExecutionListener, org.springframework.test.context.event.EventPublishingTestExecutionListener]
22:43:00.947 [main] DEBUG org.springframework.boot.test.context.SpringBootTestContextBootstrapper - Skipping candidate TestExecutionListener [org.springframework.test.context.web.ServletTestExecutionListener] due to a missing dependency. Specify custom listener classes or make the default listener classes and their required dependencies available. Offending class: [javax/servlet/ServletContext]
22:43:00.947 [main] INFO org.springframework.boot.test.context.SpringBootTestContextBootstrapper - Using TestExecutionListeners: [org.springframework.test.context.support.DirtiesContextBeforeModesTestExecutionListener@1df8b5b8, org.springframework.boot.test.mock.mockito.MockitoTestExecutionListener@23202fce, org.springframework.boot.test.autoconfigure.SpringBootDependencyInjectionTestExecutionListener@7b993c65, org.springframework.test.context.support.DirtiesContextTestExecutionListener@37911f88, org.springframework.test.context.transaction.TransactionalTestExecutionListener@6f1c29b7, org.springframework.test.context.jdbc.SqlScriptsTestExecutionListener@4d6025c5, org.springframework.test.context.event.EventPublishingTestExecutionListener@7f284218, org.springframework.boot.test.mock.mockito.ResetMocksTestExecutionListener@407a7f2a, org.springframework.boot.test.autoconfigure.restdocs.RestDocsTestExecutionListener@4ea5b703, org.springframework.boot.test.autoconfigure.web.client.MockRestServiceServerResetTestExecutionListener@2a7ed1f, org.springframework.boot.test.autoconfigure.web.servlet.MockMvcPrintOnlyOnFailureTestExecutionListener@3fa247d1, org.springframework.boot.test.autoconfigure.web.servlet.WebDriverTestExecutionListener@2cb2fc20]
22:43:00.948 [main] DEBUG org.springframework.test.annotation.ProfileValueUtils - Retrieved @ProfileValueSourceConfiguration [null] for test class [com.example.MybatisDemoApplicationTests]
22:43:00.948 [main] DEBUG org.springframework.test.annotation.ProfileValueUtils - Retrieved ProfileValueSource type [class org.springframework.test.annotation.SystemProfileValueSource] for class [com.example.MybatisDemoApplicationTests]
22:43:01.053 [main] DEBUG org.springframework.test.annotation.ProfileValueUtils - Retrieved @ProfileValueSourceConfiguration [null] for test class [com.example.MybatisDemoApplicationTests]
22:43:01.053 [main] DEBUG org.springframework.test.annotation.ProfileValueUtils - Retrieved ProfileValueSource type [class org.springframework.test.annotation.SystemProfileValueSource] for class [com.example.MybatisDemoApplicationTests]
[INFO] Running com.example.MybatisDemoApplicationTests
22:43:01.057 [main] DEBUG org.springframework.test.annotation.ProfileValueUtils - Retrieved @ProfileValueSourceConfiguration [null] for test class [com.example.MybatisDemoApplicationTests]
22:43:01.057 [main] DEBUG org.springframework.test.annotation.ProfileValueUtils - Retrieved ProfileValueSource type [class org.springframework.test.annotation.SystemProfileValueSource] for class [com.example.MybatisDemoApplicationTests]
22:43:01.058 [main] DEBUG org.springframework.test.annotation.ProfileValueUtils - Retrieved @ProfileValueSourceConfiguration [null] for test class [com.example.MybatisDemoApplicationTests]
22:43:01.058 [main] DEBUG org.springframework.test.annotation.ProfileValueUtils - Retrieved ProfileValueSource type [class org.springframework.test.annotation.SystemProfileValueSource] for class [com.example.MybatisDemoApplicationTests]
22:43:01.060 [main] DEBUG org.springframework.test.annotation.ProfileValueUtils - Retrieved @ProfileValueSourceConfiguration [null] for test class [com.example.MybatisDemoApplicationTests]
22:43:01.061 [main] DEBUG org.springframework.test.annotation.ProfileValueUtils - Retrieved ProfileValueSource type [class org.springframework.test.annotation.SystemProfileValueSource] for class [com.example.MybatisDemoApplicationTests]
22:43:01.069 [main] DEBUG org.springframework.test.context.support.AbstractDirtiesContextTestExecutionListener - Before test class: context [DefaultTestContext@5a3bc7ed testClass = MybatisDemoApplicationTests, testInstance = [null], testMethod = [null], testException = [null], mergedContextConfiguration = [MergedContextConfiguration@181e731e testClass = MybatisDemoApplicationTests, locations = '{}', classes = '{class com.example.MybatisDemoApplication}', contextInitializerClasses = '[]', activeProfiles = '{}', propertySourceLocations = '{}', propertySourceProperties = '{org.springframework.boot.test.context.SpringBootTestContextBootstrapper=true}', contextCustomizers = set[org.springframework.boot.test.context.filter.ExcludeFilterContextCustomizer@74e52ef6, org.springframework.boot.test.json.DuplicateJsonObjectContextCustomizerFactory$DuplicateJsonObjectContextCustomizer@15de0b3c, org.springframework.boot.test.mock.mockito.MockitoContextCustomizer@0, org.springframework.boot.test.web.client.TestRestTemplateContextCustomizer@3a52dba3, org.springframework.boot.test.autoconfigure.properties.PropertyMappingContextCustomizer@0, org.springframework.boot.test.autoconfigure.web.servlet.WebDriverContextCustomizerFactory$Customizer@7dc0f706], contextLoader = 'org.springframework.boot.test.context.SpringBootContextLoader', parent = [null]], attributes = map[[empty]]], class annotated with @DirtiesContext [false] with mode [null].
22:43:01.072 [main] DEBUG org.springframework.test.annotation.ProfileValueUtils - Retrieved @ProfileValueSourceConfiguration [null] for test class [com.example.MybatisDemoApplicationTests]
22:43:01.072 [main] DEBUG org.springframework.test.annotation.ProfileValueUtils - Retrieved ProfileValueSource type [class org.springframework.test.annotation.SystemProfileValueSource] for class [com.example.MybatisDemoApplicationTests]
22:43:01.078 [main] DEBUG org.springframework.test.context.support.DependencyInjectionTestExecutionListener - Performing dependency injection for test context [[DefaultTestContext@5a3bc7ed testClass = MybatisDemoApplicationTests, testInstance = com.example.MybatisDemoApplicationTests@68df9280, testMethod = [null], testException = [null], mergedContextConfiguration = [MergedContextConfiguration@181e731e testClass = MybatisDemoApplicationTests, locations = '{}', classes = '{class com.example.MybatisDemoApplication}', contextInitializerClasses = '[]', activeProfiles = '{}', propertySourceLocations = '{}', propertySourceProperties = '{org.springframework.boot.test.context.SpringBootTestContextBootstrapper=true}', contextCustomizers = set[org.springframework.boot.test.context.filter.ExcludeFilterContextCustomizer@74e52ef6, org.springframework.boot.test.json.DuplicateJsonObjectContextCustomizerFactory$DuplicateJsonObjectContextCustomizer@15de0b3c, org.springframework.boot.test.mock.mockito.MockitoContextCustomizer@0, org.springframework.boot.test.web.client.TestRestTemplateContextCustomizer@3a52dba3, org.springframework.boot.test.autoconfigure.properties.PropertyMappingContextCustomizer@0, org.springframework.boot.test.autoconfigure.web.servlet.WebDriverContextCustomizerFactory$Customizer@7dc0f706], contextLoader = 'org.springframework.boot.test.context.SpringBootContextLoader', parent = [null]], attributes = map[[empty]]]].
22:43:01.123 [main] DEBUG org.springframework.test.context.support.TestPropertySourceUtils - Adding inlined properties to environment: {spring.jmx.enabled=false, org.springframework.boot.test.context.SpringBootTestContextBootstrapper=true, server.port=-1}

  .   ____          _            __ _ _
 /\\ / ___'_ __ _ _(_)_ __  __ _ \ \ \ \
( ( )\___ | '_ | '_| | '_ \/ _` | \ \ \ \
 \\/  ___)| |_)| | | | | || (_| |  ) ) ) )
  '  |____| .__|_| |_|_| |_\__, | / / / /
 =========|_|==============|___/=/_/_/_/
 :: Spring Boot ::             (v2.2.0.M4)

2019-07-16 22:43:01.440  INFO 2003 --- [           main] com.example.MybatisDemoApplicationTests  : Starting MybatisDemoApplicationTests on xxxxx.local with PID 2003 (started by xxxxx in /Users/xxxxx/git-me/mybatis-demo-with-jdk13)
2019-07-16 22:43:01.441 DEBUG 2003 --- [           main] com.example.MybatisDemoApplicationTests  : Running with Spring Boot v2.2.0.M4, Spring v5.2.0.M3
2019-07-16 22:43:01.442  INFO 2003 --- [           main] com.example.MybatisDemoApplicationTests  : No active profile set, falling back to default profiles: default
2019-07-16 22:43:02.168  INFO 2003 --- [           main] com.zaxxer.hikari.HikariDataSource       : HikariPool-1 - Starting...
2019-07-16 22:43:02.521  INFO 2003 --- [           main] com.zaxxer.hikari.HikariDataSource       : HikariPool-1 - Start completed.
2019-07-16 22:43:02.959  INFO 2003 --- [           main] com.example.MybatisDemoApplicationTests  : Started MybatisDemoApplicationTests in 1.833 seconds (JVM running for 3.03)
2019-07-16 22:43:02.993 DEBUG 2003 --- [           main] com.example.mapper.TodoMapper.insert     : ==>  Preparing: INSERT INTO todo (title, details, finished) VALUES (?, ?, ?) 
2019-07-16 22:43:03.037 DEBUG 2003 --- [           main] com.example.mapper.TodoMapper.insert     : ==> Parameters: 飲み会(String), 銀座 19:00(String), false(Boolean)
2019-07-16 22:43:03.046 DEBUG 2003 --- [           main] com.example.mapper.TodoMapper.insert     : <==    Updates: 1
2019-07-16 22:43:03.053 DEBUG 2003 --- [           main] com.example.mapper.TodoMapper.select     : ==>  Preparing: SELECT id, title, details, finished FROM todo WHERE id = ? 
2019-07-16 22:43:03.058 DEBUG 2003 --- [           main] com.example.mapper.TodoMapper.select     : ==> Parameters: 1(Integer)
2019-07-16 22:43:03.093 TRACE 2003 --- [           main] com.example.mapper.TodoMapper.select     : <==    Columns: ID, TITLE, DETAILS, FINISHED
2019-07-16 22:43:03.093 TRACE 2003 --- [           main] com.example.mapper.TodoMapper.select     : <==        Row: 1, <<BLOB>>, <<BLOB>>, FALSE
2019-07-16 22:43:03.100 DEBUG 2003 --- [           main] com.example.mapper.TodoMapper.select     : <==      Total: 1
ID       : 1
TITLE    : 飲み会
DETAILS  : 銀座 19:00
FINISHED : false
[INFO] Tests run: 1, Failures: 0, Errors: 0, Skipped: 0, Time elapsed: 3 s - in com.example.MybatisDemoApplicationTests
2019-07-16 22:43:04.105  INFO 2003 --- [       Thread-1] com.zaxxer.hikari.HikariDataSource       : HikariPool-1 - Shutdown initiated...
2019-07-16 22:43:04.111  INFO 2003 --- [       Thread-1] com.zaxxer.hikari.HikariDataSource       : HikariPool-1 - Shutdown completed.
[INFO] 
[INFO] Results:
[INFO] 
[INFO] Tests run: 1, Failures: 0, Errors: 0, Skipped: 0
[INFO] 
[INFO] 
[INFO] --- maven-jar-plugin:3.1.2:jar (default-jar) @ mybatis-demo-with-jdk13 ---
[INFO] Building jar: /Users/xxxxx/git-me/mybatis-demo-with-jdk13/target/mybatis-demo-with-jdk13-0.0.1-SNAPSHOT.jar
[INFO] 
[INFO] --- spring-boot-maven-plugin:2.2.0.M4:repackage (repackage) @ mybatis-demo-with-jdk13 ---
[INFO] Replacing main artifact with repackaged archive
[INFO] ------------------------------------------------------------------------
[INFO] BUILD SUCCESS
[INFO] ------------------------------------------------------------------------
[INFO] Total time:  8.460 s
[INFO] Finished at: 2019-07-16T22:43:05+09:00
[INFO] ------------------------------------------------------------------------
```

### Run using executable jar

```
$ $JAVA_HOME/bin/java --enable-preview -jar target/mybatis-demo-with-jdk13-0.0.1-SNAPSHOT.jar

  .   ____          _            __ _ _
 /\\ / ___'_ __ _ _(_)_ __  __ _ \ \ \ \
( ( )\___ | '_ | '_| | '_ \/ _` | \ \ \ \
 \\/  ___)| |_)| | | | | || (_| |  ) ) ) )
  '  |____| .__|_| |_|_| |_\__, | / / / /
 =========|_|==============|___/=/_/_/_/
 :: Spring Boot ::             (v2.2.0.M4)

2019-07-16 22:47:20.248  INFO 2038 --- [           main] com.example.MybatisDemoApplication       : Starting MybatisDemoApplication v0.0.1-SNAPSHOT on xxxxx.local with PID 2038 (/Users/xxxxx/git-me/mybatis-demo-with-jdk13/target/mybatis-demo-with-jdk13-0.0.1-SNAPSHOT.jar started by xxxxx in /Users/xxxxx/git-me/mybatis-demo-with-jdk13)
2019-07-16 22:47:20.251 DEBUG 2038 --- [           main] com.example.MybatisDemoApplication       : Running with Spring Boot v2.2.0.M4, Spring v5.2.0.M3
2019-07-16 22:47:20.252  INFO 2038 --- [           main] com.example.MybatisDemoApplication       : No active profile set, falling back to default profiles: default
2019-07-16 22:47:20.971  INFO 2038 --- [           main] com.zaxxer.hikari.HikariDataSource       : HikariPool-1 - Starting...
2019-07-16 22:47:21.167  INFO 2038 --- [           main] com.zaxxer.hikari.HikariDataSource       : HikariPool-1 - Start completed.
2019-07-16 22:47:21.475  INFO 2038 --- [           main] com.example.MybatisDemoApplication       : Started MybatisDemoApplication in 1.615 seconds (JVM running for 1.991)
2019-07-16 22:47:21.535 DEBUG 2038 --- [           main] com.example.mapper.TodoMapper.insert     : ==>  Preparing: INSERT INTO todo (title, details, finished) VALUES (?, ?, ?) 
2019-07-16 22:47:21.614 DEBUG 2038 --- [           main] com.example.mapper.TodoMapper.insert     : ==> Parameters: 飲み会(String), 銀座 19:00(String), false(Boolean)
2019-07-16 22:47:21.621 DEBUG 2038 --- [           main] com.example.mapper.TodoMapper.insert     : <==    Updates: 1
2019-07-16 22:47:21.631 DEBUG 2038 --- [           main] com.example.mapper.TodoMapper.select     : ==>  Preparing: SELECT id, title, details, finished FROM todo WHERE id = ? 
2019-07-16 22:47:21.641 DEBUG 2038 --- [           main] com.example.mapper.TodoMapper.select     : ==> Parameters: 1(Integer)
2019-07-16 22:47:21.677 TRACE 2038 --- [           main] com.example.mapper.TodoMapper.select     : <==    Columns: ID, TITLE, DETAILS, FINISHED
2019-07-16 22:47:21.677 TRACE 2038 --- [           main] com.example.mapper.TodoMapper.select     : <==        Row: 1, <<BLOB>>, <<BLOB>>, FALSE
2019-07-16 22:47:21.684 DEBUG 2038 --- [           main] com.example.mapper.TodoMapper.select     : <==      Total: 1
ID       : 1
TITLE    : 飲み会
DETAILS  : 銀座 19:00
FINISHED : false
2019-07-16 22:47:21.706  INFO 2038 --- [       Thread-1] com.zaxxer.hikari.HikariDataSource       : HikariPool-1 - Shutdown initiated...
2019-07-16 22:47:21.714  INFO 2038 --- [       Thread-1] com.zaxxer.hikari.HikariDataSource       : HikariPool-1 - Shutdown completed.
```