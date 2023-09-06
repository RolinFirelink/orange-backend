# ⛰项目依赖

JDK8、SpringBoot2.2.1、MybatisPlus3.4.1、MySQL8.0.22、Druid1.1.20、Swagger1.5.21

# 🏃快速开始

## 数据库配置

首先在本地创建 `orange` 数据库，选择好字符集：`utf8mb4`，排序规则：`utf8mb8_general_ci`
。然后在数据库下执行项目携带的SQL文件即可（包含各个表和表结构）。

启动项目即可访问本地Swagger，若要使用完整Web服务需要在本地启动前端服务，具体请看：[orange-front](https://github.com/RolinFirelink/orange-front)

# 😀介绍

柑橘农药减施监控云服务平台后端以SpringBoot为基础框架，使用MybatisPlus框架简化开发，前端使用Vue和Element-UI框架构建可视化组件和页面，可实现对柑橘基地的实时监控和环境预测等功能，其目标是用于减轻柑橘种植人员的负担，实现减施增效的目的。

本项目为柑橘农药减施监控云服务平台的后端

## 🏭系统功能

- [x] 动态资讯

- [x] 柑橘百科
- [x] 农技学堂
- [x] 疾病预览
- [x] 图文诊断
- [x] 目检诊断

- [x] 智能诊断
- [x] 用药指导
- [x] 视频监控
- [x] 环境预测
- [x] 图表数据

## 🧱注意

超级管理员的id为admin，相比于普通管理员具有删除等权限

智能诊断推荐使用项目提供的图片进行诊断，否则容易得不到对应结果，同时智能诊断是调用另外一个项目的接口得到的结果，后续可能会因为该项目的停运而导致智能诊断无法使用

[本地Web入口](http://localhost:8805/#/login)，[本地Swagger入口](http://localhost:8804/swagger-ui.html#/)

# ❤️贡献者

RolinFirelink





