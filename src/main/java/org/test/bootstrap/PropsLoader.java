package org.test.bootstrap;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.test.repository.AppParamRepo;

import java.util.HashMap;
import java.util.Map;

@Slf4j
@Component("propsLoader")
public class PropsLoader implements CommandLineRunner {
    @Autowired
    private AppParamRepo appParamRepo;
    private Map<String, String> dataMap;

    PropsLoader() {
        dataMap = new HashMap<>();
    }

    public String getCron() {
        log.info("Loaded the props in dataMap");
        appParamRepo.findAll().forEach(x -> dataMap.put(x.getName(), x.getValue()));
        log.info("Values in dataMap : {} ", dataMap);
        return dataMap.get("CRON_EXPER");
    }

    public String getProperty(String key) {
        return dataMap.get(key);
    }

    public Map<String, String> getDataMap() {
        return dataMap;
    }

    @Override
    public void run(String... args) {
        log.info(" Command line runner executed .. ");
    }
}
