package org.base.docker.microbase.zuul.filters;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;

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
@Component
public class BasicAuthorizationHeaderFilter extends ZuulFilter {

    private static Logger log = LoggerFactory.getLogger(BasicAuthorizationHeaderFilter.class);

    @Override
    public String filterType() {
        return "pre";
    }

    @Override
    public int filterOrder() {
        return 10;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() {

        RequestContext ctx = RequestContext.getCurrentContext();
        ctx.getRequest().getRequestURL();
        // log.info("Autherization Token Passed: " +
        // ctx.getRequest().getHeader("Authorization"));
        ctx.addZuulRequestHeader("Authorization", ctx.getRequest().getHeader("Authorization"));
        return null;
    }

}