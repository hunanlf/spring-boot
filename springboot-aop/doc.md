# java 自带注解说明
## 内置注解
```
   @Override 	表示当前的方法定义将覆盖超类中的方法，如果方法名或者参数有误，那么编译器就会报错提示。
   @Deprecated 	用于注解已经过时的代码（方法或者某属性），使用了该注解的方法或者属性编译器会发出警告
   @SuppressWarnings 	关闭不当的编译器警告信息。如果一个方法调用的方法已过时，
     或使一个不安全的类型转换，编译器可能会产生一个警告。您可以通过包含使用@SuppressWarnings注解代码的方法标注抑制这些警告。
```
## 元注解
```
@Target 	指定注解的作用域
@Retention 	指定在那个级别保存该注解信息。
@Documented 	指定这个注解的元素可以被javadoc此类的工具文档化
@Inherite 	指定该注解类型被自动继承。如果用户在当前类中查询这个元注解类型并且当前类的声明中不包含这个元注解类型，那么也将自动查询当前类的父类是否存在Inherited元注解，
这个动作将被重复执行知道这个标注类型被找到，或者是查询到顶层的父类
```
###  @Target
 指定注解的作用域，由ElementType枚举指定定义 
 源码如下
 ```java
 public enum ElementType { 
    TYPE, //接口、类、枚举、注解 
    FIELD, //字段、枚举的常量
    METHOD, //方法 
    PARAMETER, //方法参数 
    CONSTRUCTOR,//构造函数
    LOCAL_VARIABLE,//局部变量 
    ANNOTATION_TYPE,//注解
    PACKAGE,//包
    TYPE_PARAMETER, // java8声明 
    TYPE_USE// java8声明 
}

 ```
 ### @Retention
 指定在那个级别保存该注解信息，由RetentionPolicy枚举定义。该注解的源码如下
 ```java
 public enum RetentionPolicy { 
    SOURCE,//仅仅在源代码中可以使用,可以被编译器识别 
    CLASS,//在源代码、class文件中可用，不能再runtime中使用，默认就是这个策略 
    RUNTIME //在源代码、class、runtime中都可以使用
}

 ```