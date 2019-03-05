# 一个 Spring Boot 服务的测试示例

## 需求

一个供客户找书并下单购买的服务

找书：[./features/query.feature]()  
下单：[./features/order.feature]()  
...

## 项目依赖

JDK 8 + SpringBootTestStarter 2

pom：[pom.xml]()

## 运行测试

```./mvnw clean test```

## 测试工具

1. JUnit5
    * ParameterizedTest
    * ExtendWith
    * Tag
    * DisplayName
    * ...(*未完待续*)
2. AssertJ
    * assertThat().
    * JsonPath
    * ...(*未完待续*)
3. SpringBootTest
    * SpringExtension
    * WebMvcTest
    * MockBean
    * ...(*未完待续*)
4. Mockito
    * given(...).willReturn(...)
    * verify(...).
    * ...(*未完待续*)
5. JsonPath
6. ...(*未完待续*)

## 知识点

1. 测试金字塔
    * 端到端测试、组件测试、集成测试、单元测试优劣
2. 测试替身
    * Stub、Spy、Mock区别
3. 断言
    * 断言“精确”的程度
    * 断言的可读性
4. 单元测试原则（FIRST）
5. 测试执行
    * -Dgroups=... -DexcludedGroups=...
6. 单元测试规范
    * 测试类与被测类对应
    * API测试命名
    * 测试方法命名
7. 测试案例设计
    * “三角法”

## 相关实践

1. 测试驱动开发
2. 重构  
3. ..(*未完待续*)


## *未完待续*