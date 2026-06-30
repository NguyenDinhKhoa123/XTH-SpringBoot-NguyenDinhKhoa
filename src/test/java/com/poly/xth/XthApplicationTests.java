package com.poly.xth;

import org.junit.jupiter.api.Test;
import org.springframework.boot.autoconfigure.SpringBootApplication;

class XthApplicationTests {

    @Test
    void contextLoads() {
        Class<?> applicationClass = com.fpoly.lab.XthApplication.class;
        assert applicationClass.isAnnotationPresent(SpringBootApplication.class);
    }

}
