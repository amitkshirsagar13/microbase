package org.base.docker.microbase.zuul.filters;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.netflix.config.DynamicBooleanProperty;
import com.netflix.config.DynamicPropertyFactory;
import com.netflix.config.DynamicStringProperty;
import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.constants.ZuulConstants;
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
public class BaseBaseFilter extends ZuulFilter {

    private static Logger log = LoggerFactory.getLogger(BaseBaseFilter.class);

    private static final DynamicBooleanProperty ROUTING_DEBUG = DynamicPropertyFactory.getInstance()
            .getBooleanProperty(ZuulConstants.ZUUL_DEBUG_REQUEST, false);

    private static final DynamicStringProperty DEBUG_PARAMETER = DynamicPropertyFactory.getInstance()
            .getStringProperty(ZuulConstants.ZUUL_DEBUG_PARAMETER, "debug");

    @Override
    public String filterType() {
        return "pre";
    }

    @Override
    public boolean shouldFilter() {
        HttpServletRequest request = RequestContext.getCurrentContext().getRequest();
        if (!"true".equals(request.getParameter(DEBUG_PARAMETER.get()))) {
            return true;
        }
        return ROUTING_DEBUG.get();
    }

    @Override
    public Object run() {
        RequestContext ctx = RequestContext.getCurrentContext();
        HttpServletRequest request = ctx.getRequest();
        log.info(String.format("%s request to %s", request.getMethod(), request.getRequestURL().toString()));
        ctx.setDebugRouting(true);
        ctx.setDebugRequest(true);
        return null;
    }

    /*
     * (non-Javadoc)
     *
     * @see com.netflix.zuul.ZuulFilter#filterOrder()
     */
    @Override
    public int filterOrder() {
        return 0;
    }

}