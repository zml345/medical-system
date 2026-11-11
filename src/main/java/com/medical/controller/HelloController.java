package com.medical.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * 医疗系统基础接口。
 *
 * <p>实验 1 验证点：SpringBoot 项目能启动、Controller 能被扫描到、
 * 浏览器 / curl 能访问到接口。</p>
 */
@RestController
@RequestMapping("/api")
public class HelloController {

    private static final DateTimeFormatter FMT =
            DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    /**
     * Hello World 接口。
     *
     * <p>访问：GET http://localhost:8080/api/hello</p>
     */
    @GetMapping("/hello")
    public Map<String, Object> hello(@RequestParam(defaultValue = "World") String name) {
        Map<String, Object> data = new LinkedHashMap<>();
        data.put("code", 200);
        data.put("message", "医疗系统启动成功，Hello " + name + "!");
        data.put("service", "medical-system");
        data.put("version", "1.0.0-SNAPSHOT");
        data.put("timestamp", LocalDateTime.now().format(FMT));
        return data;
    }

    /**
     * 健康检查接口。
     *
     * <p>访问：GET http://localhost:8080/api/health</p>
     */
    @GetMapping("/health")
    public Map<String, Object> health() {
        Map<String, Object> data = new LinkedHashMap<>();
        data.put("status", "UP");
        data.put("jvm", System.getProperty("java.version"));
        data.put("os", System.getProperty("os.name"));
        data.put("timestamp", LocalDateTime.now().format(FMT));
        return data;
    }

    /**
     * 科室列表（演示用静态数据，后续实验将改为数据库查询）。
     *
     * <p>访问：GET http://localhost:8080/api/departments</p>
     */
    @GetMapping("/departments")
    public Map<String, Object> departments() {
        List<Map<String, Object>> list = new ArrayList<>();

        list.add(buildDepartment(1, "内科", "呼吸、消化、心血管等常见内科疾病"));
        list.add(buildDepartment(2, "外科", "普外、骨科、神经外科等手术治疗"));
        list.add(buildDepartment(3, "儿科", "0-14 岁儿童疾病诊治与保健"));
        list.add(buildDepartment(4, "妇产科", "妇科疾病、孕期保健与分娩"));
        list.add(buildDepartment(5, "急诊科", "24 小时急危重症抢救"));

        Map<String, Object> data = new LinkedHashMap<>();
        data.put("code", 200);
        data.put("total", list.size());
        data.put("data", list);
        return data;
    }

    private Map<String, Object> buildDepartment(int id, String name, String description) {
        Map<String, Object> item = new LinkedHashMap<>();
        item.put("id", id);
        item.put("name", name);
        item.put("description", description);
        return item;
    }
}
