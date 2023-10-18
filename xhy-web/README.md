# Xhy-Web

## 介绍

[B站教学视频](https://www.bilibili.com/video/BV1bw411k7QP/?spm_id_from=333.999.0.0)

深入学习了SpringMvc架构，原理，源码后写的一款web框架，主要辅助学习SpringMvc的原理，只留核心功能。

## 架构
![架构](images/%E6%9E%B6%E6%9E%84.jpg)

## 使用说明

将对应的打包后进行使用

### Tomcat

1.打包后引入依赖

```java
		 <dependency>
            <groupId>org.xhy</groupId>
            <artifactId>xhy-web</artifactId>
            <version>1.0.0</version>
        </dependency>
```

2.创建读取bean类

```java
@ComponentScan("org.xhy")
public class AppConfig {
}
```

3.继承AbstractAnnotationConfigDispatcherServletInitializer 并配置

```java
public class Quick extends AbstractAnnotationConfigDispatcherServletInitializer {
    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class[]{AppConfig.class};
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class[]{AppConfig.class};
    }

    @Override
    protected String[] getServletMappings() {
        return new String[]{"/"};
    }
}
```

4.启动

### SpringBoot

1.打包后引入依赖

```java
        <dependency>
            <groupId>org.xhy</groupId>
            <artifactId>xhy-web-starter</artifactId>
            <version>1.0.0</version>
        </dependency>
```

2.启动

### 拓展点

#### 1.WebMvcConfigurer

用于配置拦截器，全局转换器

```java
@EnableWebMvc
@Component
public class WebMvc implements WebMvcConfigurer {

    @Override
    public void addInterceptor(InterceptorRegistry registry) {
        registry.addInterceptor(new DemoInterceptor()).addIncludePatterns("/order/**");
    }
}
```

#### 2.全局异常/类型转换

类上标注@ControllerAdvice/@RestControllerAdvice

```java
@RestControllerAdvice
public class DemoControllerAdvice {
	// 注解中写捕获的异常	
    @ExceptionHandler(Exception.class)
    public String ex(Exception e){
        return e.getMessage();
    }
	// 注解中需要转换的类,方法参数必须写Object
    @ConvertType(Byte.class)
    public String byteConvert(Object value){
        return value.toString();
    }
}
```

#### 3.局部异常/类型转换

在Controller当中创建方法标注注解

```java
@ExceptionHandler(Exception.class)
    public String ex(Exception e){
        return e.getMessage();
    }
    
    @ConvertType(Integer.class)
    public Object c(Object o){
        return o;
    }
```

## 参数解析器

| 解析器                  | 说明                  |
| -------------------- | ------------------- |
| @PathVariable        | 路径获取参数              |
| @CookieValue         | 从cookie中获取参数        |
| @RequestHeader       | 从请求头中获取参数           |
| @RequestParam        | 获取参数                |
| MultipartFile        | 文件                  |
| @RequestBody         | json                |
| @HttpServletRequest  | HttpServletRequest  |
| @HttpServletResponse | HttpServletResponse |

### @PathVariable

```java
@GetMapping("/order/{id}")
    public String path(@PathVariable String id){
        
    }
    @GetMapping("/order/{id}/{name}")
    public String path(@PathVariable("id") String id,@PathVariable String name){

    }
    @GetMapping("/order/{id}/{name}")
    public String path(@PathVariable Map map){

    }
```

### @CookieValue

```java
  @GetMapping("/order/get")
    public String get(@CookieValue String name){
        
    }

    @GetMapping("/order/get")
    public String get(@CookieValue("token") String name){

    }
```

### @RequestHeader

```java
@GetMapping("/order/header")
    public String get(@RequestHeader String name){
        
    }

    @GetMapping("/order/header")
    public String get(@RequestHeader Map map){

    }
```

### @RequestParam

```java
@GetMapping("/order/par")
    public String par(@RequestParam String name,Integer age){

    }

    @GetMapping("/order/par")
    public String par(User user){

    }
```

### MultipartFile

```java
@GetMapping("/order/file")
    public String file(List<MultipartFile> file,MultipartFile[] files,Collection<MultipartFile> files,MultipartFile file){

    }
```

### @RequestBody

```java
@GetMapping("/order")
    public String file(@RequestBody User user){

    }
```

### HttpServletRequest

```java
@GetMapping("/order/request")
    public String file(HttpServletRequest request){

    }
```

### HttpServletResponse

```java
 @GetMapping("/order/request")
    public String file(HttpServletResponse response){

    }
```

>   可在映射器中支持的参数

以上所有参数



>   可在异常解析器上支持的参数

1.异常类

2.HttpServletRequest

3.HttpServletResponse

4.HandlerMethod

## 返回值处理器

@ResponseBody 方法级别

@RestController 类级别

只支持返回json **主要核心功能需要**


欢迎技术讨论，可以加我vx，拉你进群，记得备注来意呢
![输入图片说明](images/851f971db3a98f7c00b048cfdd618e4.jpg)




