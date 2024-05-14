package org.test.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.Environment;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.test.bootstrap.PropsLoader;
import org.test.service.CommonService;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

@Slf4j
@RestController
@RequestMapping(value = "/common")
public class CommonController {

    @Autowired
    private CommonService commonService;
    @Autowired
    private PropsLoader propsLoader;
    @Autowired
    private Environment environment;

    private final String CLASS_NAME = this.getClass().getName();

    @PostMapping(value = "/callAPI", produces = MediaType.APPLICATION_JSON_VALUE)
    public String callAPI(@RequestBody String jsonRequestBody) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {

        StringBuilder sb = new StringBuilder(jsonRequestBody);
        sb.setCharAt(jsonRequestBody.lastIndexOf('}'), ' ');

        String routingMethodName = sb.substring(jsonRequestBody.indexOf('"') + 1, jsonRequestBody.indexOf(':') - 1).trim();
        log.info("requestKey : {}", routingMethodName);

        routingMethodName = (routingMethodName.contains("\"")) ? routingMethodName.replace("\"", "") : routingMethodName;

        String methodName = environment.getProperty(routingMethodName.trim());
        log.info("Routing Method : {}", methodName);
        assert methodName != null;
        Method method = commonService.getClass().getDeclaredMethod(methodName, String.class);

        log.info("incoming requestString: {}", sb);
        return (String) method.invoke(commonService, sb.toString().trim());
    }

}
