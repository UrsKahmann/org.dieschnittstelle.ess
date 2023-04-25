package org.dieschnittstelle.ess.ser;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.apache.logging.log4j.Logger;

import java.io.IOException;

import static org.dieschnittstelle.ess.utils.Utils.show;

public class TouchpointServiceServletFilter implements Filter {

    protected static Logger logger = org.apache.logging.log4j.LogManager
            .getLogger(TouchpointServiceServletFilter.class);


    @Override
    public void destroy() {
        // TODO Auto-generated method stub

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response,
                         FilterChain chain) throws IOException, ServletException {
        show("TouchpointServiceServletFilter: doFilter() invoked\n");

        String userAgentHeader = ((HttpServletRequest) request)
                .getHeader("user-agent");
        logger.info("got user-agent header: " + userAgentHeader);

        if (userAgentHeader != null) {
            ((HttpServletResponse) response)
                    .setStatus(HttpServletResponse.SC_FORBIDDEN);
            return;
        }

        chain.doFilter(request, response);
    }

    @Override
    public void init(FilterConfig arg0) throws ServletException {
        // TODO Auto-generated method stub

    }

}
