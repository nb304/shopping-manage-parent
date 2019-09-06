package com.king2.login.server.exception;

import com.king2.commons.result.SystemResult;
import org.springframework.validation.BindException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import java.util.Set;

/*================================================================
˵����ȫ���쳣����

����          ʱ��             ע��
����        2018.7.26	      ����
==================================================================*/
@ControllerAdvice
public class GlobalExceptionHandler {

    /**
     * ----------------------------------------------------------------- ���ܣ�����ȫ���쳣
     * <p>
     * ���أ�SystemResult �쳣�����Ϣ
     * -------------------------------------------------------------------
     */
    @ExceptionHandler(Exception.class)
    @ResponseBody
    public SystemResult errorHandler(Exception e) {
        // ��ӡջ����Ϣ
        e.printStackTrace();
        return SystemResult.build(500, "�����ڲ��쳣,���Ժ�����");
    }

    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
    @ResponseBody
    public SystemResult requestMethodNotSupportedException(HttpRequestMethodNotSupportedException ex) {
        return SystemResult.build(100, "����ʽ����", ex.getMessage());
    }

    /**
     * ----------------------------------------------------------------- ���ܣ���������У���쳣
     * <p>
     * ���أ�SystemResult �쳣�����Ϣ
     * -------------------------------------------------------------------
     */
    @ExceptionHandler(BindException.class)
    @ResponseBody
    public SystemResult dataException(BindException bind) {
        // ���ش�����Ϣ
        return SystemResult.build(100, bind.getFieldError().getDefaultMessage());
    }

    /**
     * -----------------------------------------------------------------
     * ���ܣ��������@RequestBody����У���쳣
     * <p>
     * ���أ�SystemResult �쳣�����Ϣ
     * -------------------------------------------------------------------
     */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseBody
    public SystemResult MethodArgumentNotValidException(MethodArgumentNotValidException dataValid) {
        // ���ش�����Ϣ
        return SystemResult.build(100, dataValid.getBindingResult().getFieldError().getDefaultMessage());
    }

    /**
     * �������󵥸�����������У�������쳣��Ϣ
     */
    @ExceptionHandler(value = ConstraintViolationException.class)
    @ResponseBody
    public SystemResult constraintViolationExceptionHandler(HttpServletRequest request,
                                                            ConstraintViolationException exception) {
        // ִ��У�飬���У����
        Set<ConstraintViolation<?>> validResult = exception.getConstraintViolations();
        // ���ش�����Ϣ
        return SystemResult.build(100, validResult.iterator().next().getMessage());
    }
}
