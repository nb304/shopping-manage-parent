package com.king2.login.server.service;

import com.king2.commons.result.SystemResult;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

public interface LoginManageService {

    SystemResult login(String username, String password, HttpServletRequest request , String code)  throws IOException;
}
