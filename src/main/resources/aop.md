# 在学习aop的时候配置execution语句时出现了一个问题

> execution 语句格式:
execution(modifiers-pattern? ret-type-pattern declaring-type-pattern? name-pattern(param-pattern) throws-pattern?)

## 其中: 
- 第一个是修饰符(modifiers-pattern) 
- 第二个是返回值(ret-type-pattern) 
- 第三个方法的包名(declaring-type-pattern) 
- 第四个是方法名(name-pattern) 
- 第五个方法参数(param-pattern) 
- 第六个抛出的异常类型(throws-pattern)


> 注:带？表示可有可无

下面表示一个使用 public的方法 
```
execution(public * *(..)) 因为返回类型和方法名必须有 所以是两个**
```


以set开始的方法名（注* 和set之间有个空格，这就是我后面出现的问题) 
```
execution(* set*(..))
```

# the execution of any method defined in the service package or a sub-package: 
```
//使用service 包下及子包的方法 
execution(* com.xyz.service..*.*(..)) 
```

