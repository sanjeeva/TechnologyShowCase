package com.sample.web.controller;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.servlet.support.RequestContextUtils;

public abstract class BaseController {

    @Autowired
    //protected SomeService someService


    @Autowired(required = false)
    protected MessageSource messageSource;
    

    public HttpSession session() {
        ServletRequestAttributes attr = (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();
        return attr.getRequest().getSession(true); // true == allow create
    }

    public HttpServletRequest request() {
        ServletRequestAttributes attr = (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();
        HttpServletRequest request = attr.getRequest();

        return request; // true == allow create

    }

    public Locale currentRequestLocale() {
        Locale currentLocale = RequestContextUtils.getLocale(request());

        if (currentLocale == null) {
            currentLocale = Locale.getDefault();
        }

        return currentLocale;
    }

    public String getMessage(String key, Object... arguments) {
        return messageSource.getMessage(key, arguments, currentRequestLocale());
    }
}
