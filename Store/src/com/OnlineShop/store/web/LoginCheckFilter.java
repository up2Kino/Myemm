package com.OnlineShop.store.web;

import com.OnlineShop.store.domain.Customer;
import com.OnlineShop.store.domain.Merchants;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter(filterName = "LoginCheckFilter", urlPatterns = {"*.jsp", "/controller"})
public class LoginCheckFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) resp;
        Customer customer = (Customer) request.getSession().getAttribute("customer");
        Merchants merchants = (Merchants)request.getSession().getAttribute("merchants");
        String action = request.getParameter("action");

        if (customer == null && merchants == null && !"login".equals(action) && !"reg_init".equals(action) && !"mer_login".equals(action)
                && !"mer_init".equals(action)&& !"mer_reg".equals(action)&& !"login_m".equals(action)) { // 没有登录
            request.getRequestDispatcher("login.jsp").forward(request, response);
        }
        chain.doFilter(req, resp);
    }

    public void init(FilterConfig config) throws ServletException {

    }

}
