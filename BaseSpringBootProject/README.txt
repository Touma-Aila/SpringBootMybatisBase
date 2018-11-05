# springboot基础配置

## 目录说明
- src/main/java 源代码目录
- src/test/java 测试代码目录(只在IDE中可以执行 build的jar中会被排除)
- src/main/resources 资源文件目录(非java类型的文件(配置)都在这里面 build后回合编译的文件合并)

## package说明
- aop 切面编程相关类
- base 基类类型
- config 全局配置相关类
- controller 控制器类
- converter 数据转换相关类
- dao 数据访问接口
- entity 实体对象
- exception 自定义异常类
- model 数据模型类 负责控制器和服务层的数据传递
- service 服务层(接口)
- service.impl 服务层实现
- task 日程计划任务
- util 工具类

## 配置文件说明
- build.gradle gradle核心配置 更新该文件需要gradle refresh联网更新依赖
- application.yml,application.properties springboot核心配置文件
- mybatis-config.xml mybatis核心配置文件 需要在springboot核心配置文件中指定
- resources中dao包里面的xml文件 mybatis的数据映射配置文件 必须和dao接口文件在同一个目录 且必须和dao文件同名 里面的namespace和dao匹配 里面的id和dao的方法匹配 全体mapper文件包定义在mybatis核心配置文件中