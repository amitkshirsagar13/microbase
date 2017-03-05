package org.base.docker.microbase.hytrix;

import com.netflix.turbine.discovery.InstanceDiscovery;
import com.netflix.turbine.streaming.servlet.TurbineStreamServlet;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.cloud.client.actuator.HasFeatures;
import org.springframework.cloud.netflix.turbine.TurbineHttpConfiguration;
import org.springframework.cloud.netflix.turbine.TurbineLifecycle;
import org.springframework.cloud.netflix.turbine.TurbineProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * <p>
 * <b>Overview:</b>
 * </p>
 * <pre>
 * @projectName microbase
 * @class EurekaApplication
 * Creation date: 3/5/2017
 * @author amit.kshirsagar.13@gmail.com
 * @version 1.0
 * @since
 *
 * <p><b>Modification History:</b></p>
 *
 *
 * </pre>
 */
@Configuration
@EnableConfigurationProperties
public class TurbineConfiguration {

    @Bean
    public HasFeatures Feature() {
        return HasFeatures.namedFeature("Turbine (HTTP)", TurbineHttpConfiguration.class);
    }

    @Bean
    public ServletRegistrationBean turbineStreamServlet() {
        return new ServletRegistrationBean(new TurbineStreamServlet(), "/turbine.stream");
    }

    @Bean
    public TurbineProperties turbineProperties() {
        return new TurbineProperties();
    }

    @Bean
    public TurbineLifecycle turbineLifecycle(InstanceDiscovery instanceDiscovery) {
        return new TurbineLifecycle(instanceDiscovery);
    }

}
