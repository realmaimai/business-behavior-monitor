package com.maimai.domain.service;

import ognl.OgnlException;

import java.util.List;

public interface ILogAnalyticalService {

    void doAnalytical(String systemName, String className, String methodName, List<String> logList) throws OgnlException;
}
