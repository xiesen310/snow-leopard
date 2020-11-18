package com.github.leopard.dao.annotation;

import org.apache.commons.lang3.StringUtils;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.regex.Pattern;

/**
 * @author 谢森
 * @Description 手机号码校验
 * @Email xiesen310@163.com
 * @Date 2020/11/18 18:38
 */
public class PhoneValidator implements ConstraintValidator<Phone, String> {

    private boolean required = false;
    /**
     * 定义的手机号验证正则表达式
     * 号段主要有(不包括上网卡)：130~139、150~153、155~159、180~189、170~171、176~178。14号段为上网卡专属号段
     */
    private Pattern pattern = Pattern.compile("^((13[0-9])|(14[5|7|9])|(15([0-9])|(17[0-9])|(18[0-9])|(19[8|9]))\\d{8})$");

    @Override
    public void initialize(Phone constraintAnnotation) {
        required = constraintAnnotation.required();
    }

    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        if (required) {
            return pattern.matcher(s).matches();
        } else {
            if (StringUtils.isEmpty(s)) {
                return false;
            } else {
                return pattern.matcher(s).matches();
            }
        }
    }
}

