# MyShopPlus

## 概述

- [**项目学习视频**](https://www.bilibili.com/video/av62628434/)
- [**项目学习文档**](http://www.qfdmy.com/%E8%AF%BE%E7%A8%8B/%e5%be%ae%e6%9c%8d%e5%8a%a1%e6%9e%b6%e6%9e%84-2-0/?tab=tab-curriculum)

**MyShopPlus** 项目致力于推广并普及 **微服务架构** 思想，采用全新 **服务网格** 系统打造电商生态级产品。

## 开发工具

工具 | 地址 
----|----
Intellij IDEA | https://www.jetbrains.com/idea/download 
SwitchHosts | https://oldj.github.io/SwitchHosts/
FinalShell | http://www.hostbuf.com/ 
Postman | https://www.getpostman.com/downloads/ 
SQLyog | https://sqlyog.en.softonic.com/ 
PicPick | https://picpick.app/zh/download 
亿图图示 | https://www.edrawsoft.cn/edrawmax/ 
亿图导图 | https://www.edrawsoft.cn/mindmaster/ 

## 商业组件

服务 | 说明 | 地址
----|----|----
Aliyun SDK OSS | 阿里云对象存储服务 | [官网](https://help.aliyun.com/product/31815.html?spm=a2c4g.750001.list.19.3cce7b13L4uLgg)

## 后端技术

技术 | 说明 | 地址
----|----|----
Spring Boot | 新一代 JavaEE 开发标准 | [GitHub](https://github.com/spring-projects/spring-boot)
Spring Cloud Alibaba | 阿里巴巴基于 Spring Cloud 编程模型的微服务生态 | [GitHub](https://github.com/alibaba/spring-cloud-alibaba)
Spring Cloud Alibaba Dubbo | 与 Spring Cloud Alibaba 生态相结合的高性能 Java RPC 框架 | [GitHub](https://github.com/apache/dubbo)
Spring Cloud Alibaba RocketMQ | 分布式消息系统 | [GitHub](https://github.com/alibaba/spring-cloud-alibaba/blob/master/spring-cloud-alibaba-examples/rocketmq-example/readme.md)
Spring Security oAuth2 | 安全认证和授权框架 | [GitHub](https://github.com/spring-projects/spring-security-oauth)
Spring Social | 第三方登录接入框架 | [GitHub](https://github.com/spring-projects/spring-social)
TkMyBatis | 基于 MyBatis 二次开发的轻量级框架，用于简化 MyBatis 操作 | [GitHub](https://github.com/abel533/Mapper)
MyBatisGenerator | Maven 插件，用于 MyBatis 相关代码生成 | [官网](http://www.mybatis.org/generator/)
MybatisCodeHelper | Intellij IDEA 插件，用于 MyBatis 相关代码生成 | [官网](https://plugins.jetbrains.com/plugin/9837-mybatiscodehelperpro)
PageHelper | MyBatis 分页插件 | [GitHub](https://github.com/pagehelper/Mybatis-PageHelper)
Swagger | API 文档生成工具 | [GitHub](https://github.com/swagger-api/swagger-ui)
HikariCP | 数据库连接池 | [GitHub](https://github.com/brettwooldridge/HikariCP)
Docker | 容器化引擎 | [官网](https://www.docker.com/)
Docker Compose | 容器编排工具 | [官网](https://docs.docker.com/compose/)
Kubernetes | 容器编排系统 | [官网](https://kubernetes.io/)
TiDB | 分布式数据库 | [官网](https://pingcap.com/)
OKHttp3 | 轻量级网络框架 | [GitHub](https://github.com/square/okhttp)
OpenFeign | 声明式 HTTP 客户端 | [GitHub](https://github.com/OpenFeign/feign)
UserAgentUtils | 用户代理检查工具 | [GitHub](https://github.com/HaraldWalker/user-agent-utils)

## 前端技术

技术 | 说明 | 地址
----|----|----
Vue | 前端框架，MVVM 模式的实现者 | [GitHub](https://github.com/vuejs/vue)
Vue CLI | Vue 脚手架，基于 NodeJS | [GitHub](https://github.com/vuejs/vue-cli)
Vue Router | Vue 路由框架 | [GitHub](https://github.com/vuejs/vue-router)
Vuex | Vue 全局状态管理框架 | [GitHub](https://github.com/vuejs/vuex)
Axios | 前端 HTTP 框架 | [GitHub](https://github.com/axios/axios)
Element UI | 饿了么 UI 框架 | [官网](https://element.eleme.cn)
Vue Element Admin | 基于 Element UI 的前端后台解决方案 | [GitHub](https://github.com/PanJiaChen/vue-element-admin)
Vue Image Crop Upload | Vue 图片剪裁上传组件 | [GitHub](https://github.com/dai-siki/vue-image-crop-upload)

## 框架集成

集成 | 完成 
----|----
Spring Boot | ✔
Spring Cloud Alibaba | ✔ 
Spring Cloud Alibaba Dubbo | ✔ 
Spring Cloud Alibaba Sentinel | ✔ 
Spring Security oAuth2 | ✔ 
TkMyBatis | ✔ 
HikariCP | ✔ 
OKHttp3 | ✔ 
Feign 传递 Token | ✔ 

## 后台功能清单

### 后台登录

功能 | 完成 
----|----
用户注册 | ✔ 
用户登录 | ✔ 
获取 Token | ✔ 
刷新 Token | 

### 个人信息

功能 | 完成 
----|----
查看信息 | ✔ 
更新信息 | ✔ 
更新密码 | ✔ 
更新头像 | ✔ 

### 权限管理

角色 | 菜单 
----|----
超级管理员 | 所有菜单权限 
运营人员 | 首页、用户、促销、运营、内容 

功能 | 说明 | 完成 
----|----|----
权限管理 | 添加权限、删除权限、修改权限、以树形结构返回权限 | 
角色管理 | 添加角色、删除角色、更新角色、角色列表、获取角色权限、修改角色权限 | 
成员管理 | CRUD、为成员分配角色、获取成员角色、权限分配、获取权限列表 | 

## 前台功能清单

功能 | 完成 
----|----
用户注册 |  
用户登录 | ✔ 
获取 Token | ✔ 
刷新 Token | 
头像上传 | ✔

## 后台服务规划

### 数据访问

服务名 | 端口 | 说明 
----|----|----
ums-admin-provider | 随机 | 用户服务提供者

### 业务逻辑

服务名 | 端口 | 说明 
----|----|----
business-reg | 9000 | 注册服务
business-oauth2 | 9001 | 认证服务
business-profile | 9002 | 个人信息管理服务

### 云服务

服务名 | 端口 | 说明 
----|----|----
cloud-upload | 10001 | 文件上传服务

### 网关

服务名 | 端口 | 说明 
----|----|----
gateway | 8888 | Spring Cloud Gateway

## 基础设施规划

### Docker

服务 | 主机名 | IP/端口 | CPU/MEM | 说明 
----|----|----|----|----
GitLab | docker-gitlab | 192.168.141.200:80 | 2 核 2G | 代码管理 
Nexus | docker-nexus | 192.168.141.201:80 | 2 核 2G | 依赖管理 
Harbor | docker-harbor | 192.168.141.202:80 | 2 核 2G | 镜像管理 
ZenTao | docker-zentao | 192.168.141.203:80 | 2 核 2G | 项目管理 

### Kubernetes

| 主机名               | IP                 | 角色   | CPU/MEM | 磁盘     |
| -------------------- | ------------------ | ------ | ------- | -------- |
| kubernetes\-master   | 192\.168\.141\.110 | Master | 2 核 2G | 20G      |
| kubernetes\-node\-01 | 192\.168\.141\.120 | Node   | 2 核 4G | 20G + 40G      |
| kubernetes\-node\-02 | 192\.168\.141\.121 | Node   | 2 核 4G | 20G + 40G      |
| kubernetes\-node\-03 | 192\.168\.141\.122 | Node   | 2 核 4G | 20G + 40G      |
| kubernetes\-node\-04 | 192\.168\.141\.123 | Node   | 2 核 8G | 20G + 40G      |
| kubernetes-volumes   | 192.168.141.130    | NFS    | 2 核 2G | 按需扩容 |

## 容器部署配置

### GItLab

```yaml
version: '3'
services:
    web:
      image: 'twang2218/gitlab-ce-zh'
      restart: always
      hostname: '192.168.141.200'
      environment:
        TZ: 'Asia/Shanghai'
        GITLAB_OMNIBUS_CONFIG: |
          external_url 'http://192.168.141.200'
          gitlab_rails['gitlab_shell_ssh_port'] = 2222
          unicorn['port'] = 8888
          nginx['listen_port'] = 80
      ports:
        - '80:80'
        - '443:443'
        - '2222:22'
      volumes:
        - ./config:/etc/gitlab
        - ./data:/var/opt/gitlab
        - ./logs:/var/log/gitlab
```

### Nexus

- **账号：** admin
- **密码：** `cat /var/lib/docker/volumes/nexus_data/_data/admin.password`

```yaml
version: '3.1'
services:
  nexus:
    restart: always
    image: sonatype/nexus3
    container_name: nexus
    ports:
      - 80:8081
    volumes:
      - data:/nexus-data

volumes:
  data:
```

### Harbor

[官方 GitHub](https://github.com/goharbor/harbor) 上下载最新离线安装版（我已经下载并放置在群分享的 **Linux** 目录下）并上传至服务器

- **账号：** admin
- **密码：** Harbor12345

```bash
# 解压
tar -zxvf harbor-offline-installer-v1.8.0.tgz

# 修改
cd harbor
vi harbor.yml
hostname: 192.168.141.202

# 安装
./install.sh
```

### 禅道

- 禅道开源版：http://dl.cnezsoft.com/zentao/docker/docker_zentao.zip
- 下载并解压后将目录名修改为 `build`，再通过 Compose 构建

```yaml
version: '3.1'
services:
  zendao:
    build: build
    restart: always
    container_name: zendao
    environment:
      MYSQL_ROOT_PASSWORD: 123456
    ports:
      - 80:80
    volumes:
      - ./app:/app/zentaopms
      - ./data:/var/lib/mysql
```