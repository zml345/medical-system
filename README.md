# Medical System

Java Web 开发 · 实验 1：医疗系统开发环境搭建与 Hello World

## 技术栈

| 组件 | 版本 |
|---|---|
| JDK | 17.0.2 |
| Maven | 3.9.16 |
| Spring Boot | 3.2.5 |
| MySQL | 8.0.45 |
| Git | 2.45.1 |
| IDEA | 2026.1.4 |

## 项目结构

```
medical-system
├── pom.xml
├── src
│   ├── main
│   │   ├── java/com/medical
│   │   │   ├── MedicalSystemApplication.java   启动类
│   │   │   └── controller
│   │   │       └── HelloController.java        基础接口
│   │   └── resources
│   │       └── application.yml                 配置文件
│   └── test/java/com/medical                   单元测试
└── .gitignore
```

## 接口清单

| 方法 | 路径 | 说明 |
|---|---|---|
| GET | `/api/hello` | Hello World，支持 `?name=xxx` |
| GET | `/api/health` | 健康检查，返回 JVM 与系统信息 |
| GET | `/api/departments` | 科室列表（演示用静态数据） |

## 本地运行

```bash
# 编译
mvn clean package -DskipTests

# 启动
mvn spring-boot:run

# 验证
curl http://localhost:8080/api/hello
curl http://localhost:8080/api/health
curl http://localhost:8080/api/departments
```

浏览器直接访问 <http://localhost:8080/api/hello>

## 分支规范

| 分支 | 用途 |
|---|---|
| `main` | 主干，可运行版本 |
| `develop` | 日常开发集成分支 |
| `feature/*` | 功能分支，如 `feature/patient-module` |
| `hotfix/*` | 紧急修复分支 |

提交信息格式：`<type>(<scope>): <subject>`

- `feat` 新功能
- `fix` 修复缺陷
- `docs` 文档
- `refactor` 重构
- `test` 测试
- `chore` 构建/工具
