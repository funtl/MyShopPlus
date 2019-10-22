package com.funtl.myshop.plus.commons.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import java.util.Collections;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * HttpServletRequest 子类
 * <p>
 * Description: 扩展 HttpServletRequest ，增加设置请求头方法
 * </p>
 *
 * @author Lusifer
 * @version v1.0.0
 * @date 2019-10-22 09:07:39
 * @see com.funtl.myshop.plus.commons.web
 */
public class MutableHttpServletRequest extends HttpServletRequestWrapper {

    private final Map<String, String> customHeaders;

    public MutableHttpServletRequest(HttpServletRequest request) {
        super(request);
        this.customHeaders = new HashMap<String, String>();
    }

    public void putHeader(String name, String value) {
        this.customHeaders.put(name, value);
    }

    @Override
    public String getHeader(String name) {
        String headerValue = customHeaders.get(name);

        if (headerValue != null) {
            return headerValue;
        }

        return ((HttpServletRequest) getRequest()).getHeader(name);
    }

    @Override
    public Enumeration<String> getHeaderNames() {
        Set<String> set = new HashSet<String>(customHeaders.keySet());

        Enumeration<String> e = ((HttpServletRequest) getRequest()).getHeaderNames();
        while (e.hasMoreElements()) {
            String n = e.nextElement();
            set.add(n);
        }

        return Collections.enumeration(set);
    }

}
