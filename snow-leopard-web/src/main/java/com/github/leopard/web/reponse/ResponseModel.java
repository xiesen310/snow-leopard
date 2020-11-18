package com.github.leopard.web.reponse;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletResponse;
import java.io.Serializable;

/**
 * @author 谢森
 * @Description ResponseModel
 * @Email xiesen310@163.com
 * @Date 2020/11/18 18:47
 */
@ToString
@AllArgsConstructor
@Getter
@Setter
public class ResponseModel<T> implements Serializable {

    private int status;
    private T result;
    private String message;
    private String code;

    public ResponseModel() {
        HttpServletResponse response = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes())
                .getResponse();
        response.setCharacterEncoding("UTF-8");
    }
}