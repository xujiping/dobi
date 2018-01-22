# dobi:根项目
数据库：

    ancient.sql:数据库文件，导入navicat。
  
## commonservice:通用服务
    
1. eureka：服务发现中心
    1. 端口：8761
    2. 配置系统hosts，windows系统hosts文件路径是C:\Windows\System32\drivers\etc\hosts；Linux及Mac OS等系统的文件路径是/etc/hosts。
	127.0.0.1 peer1 peer2
    3. 启动：
	java -jar eureka-0.0.1-SNAPSHOT.jar
	4. 登录：admin 123456

2. oauth-server：认证服务器

3. configServer：配置中心

4. gateway-server：网关服务

## component:通用组件

## demo:学习demo

需要安装配置jre，双击jar文件执行
1、eureka:服务注册中心（首先启动）
	http://localhost:1000
2、configServer:配置中心
	http://localhost:1001/[属性名]/[dev/test]
	示例：http://localhost:1001/mysqldb.datasource.url/dev
3、cms-admin:后台管理系统,网关中心,提供路由、权限控制等功能。所有的请求都经过该系统，实现统一认证。
	http://localhost:8000
4、cms-book:书籍前端系统
	http://localhost:8001
5、gateway：网关中心
	http://localhost:1002