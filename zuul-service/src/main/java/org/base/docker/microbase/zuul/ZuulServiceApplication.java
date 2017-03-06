package org.base.docker.microbase.zuul;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.ComponentScan;

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

@EnableZuulProxy
@SpringBootApplication(exclude = {org.springframework.boot.autoconfigure.security.SecurityAutoConfiguration.class,
        org.springframework.boot.actuate.autoconfigure.ManagementWebSecurityAutoConfiguration.class})
@ComponentScan(useDefaultFilters = true, basePackages = {"org.base.docker.microbase.zuul.security", "org.base.docker.microbase.zuul.filters"})

public class ZuulServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(ZuulServiceApplication.class, args);
    }
}
