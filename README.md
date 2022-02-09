# spring-learn
记录学习23种设计模式的项目

## 创建型creational
### 单例模式-singleton
介绍：只需要一个实例  
饿汉式-普通写法  
饿汉式-静态语句块  
懒汉式-线程不安全  
懒汉式-线程安全-直接synchronized  
懒汉式-线程安全-优化性能-双检synchronized

## 行为型behavior
### 责任链-chain
介绍：行为设计模式，允许你将请求沿着处理者链进行发送。收到请求后，每个处理者均可对请求进行处理，或将其传递给链上的下个处理者

### 桥接模式-bridge
介绍：将抽象部分和实现部分分离，对象结构型模式，很抽象吧，就是controller里面autowired service接口，但是具体对象可以切换
