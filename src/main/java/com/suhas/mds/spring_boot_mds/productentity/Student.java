package com.suhas.mds.spring_boot_mds.productentity;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
@ConfigurationProperties("student.map")
public class Student {

     Map<String,String> studentMap;

    public Map<String, String> getStudentMap() {
        return studentMap;
    }

    public void setStudentMap(Map<String, String> studentMap) {
        this.studentMap = studentMap;
    }
}
