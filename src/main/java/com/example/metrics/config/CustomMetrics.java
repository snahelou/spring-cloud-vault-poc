package com.example.metrics.config;

import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.Gauge;
import io.micrometer.core.instrument.MeterRegistry;
import io.micrometer.core.instrument.config.NamingConvention;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnResource;
import org.springframework.boot.info.BuildProperties;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
@ConditionalOnResource(resources =
        "${spring.info.build.location:classpath:META-INF/build-info.properties}")
public class CustomMetrics {

    @Autowired
    public MeterRegistry registry ;

    @Autowired
    BuildProperties buildProperties;

    @PostConstruct
    public void initMetrics(){

        Gauge appInfo = Gauge
                .builder("app_build_info", 1.0, n -> n)
                .strongReference(true)
                .description("A metric with a constant '1' value labeled by version, app_name, runtime version, and build time from which application was built.")
                .tags(  "app_version", buildProperties.getVersion(),
                        "app_name", buildProperties.getName(),
                        "runtime_version",System.getProperty("java.version"),
                        "build_time",buildProperties.getTime().toString())
                .register(registry);

    }
}
