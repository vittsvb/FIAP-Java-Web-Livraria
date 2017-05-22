package br.com.fiap.si.util;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sun.net.httpserver.Filter.Chain;

import br.com.fiap.si.managedbean.UsuarioMB;
import br.com.fiap.si.modelo.Usuario;

public class FilterApp implements Filter{

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
	        FilterChain chain)
	        throws IOException, ServletException {
	    System.out.println("Entered intop Login Filter");
	    HttpServletRequest req = (HttpServletRequest) request;
	    Usuario login = (Usuario) req.getSession().getAttribute("usuario");
	    String path = req.getRequestURI().substring(req.getContextPath().length());
	    System.out.println("path:" + path);
	    
	    if(login != null){
	    
	        if (login.isAdm()) {
	        	chain.doFilter(request, response);
	        } else {
	            HttpServletResponse res = (HttpServletResponse) response;
	            res.sendRedirect("../loginUsuario.jsf");
	        }
	    }
	    else {
	    	HttpServletResponse res = (HttpServletResponse) response;
            res.sendRedirect("../loginUsuario.jsf");
	    }

	    
	}

}
