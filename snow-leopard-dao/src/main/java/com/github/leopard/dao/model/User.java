package com.github.leopard.dao.model;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.github.leopard.dao.annotation.Phone;
import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * @author 谢森
 * @Description 用户对象
 * @Email xiesen310@163.com
 * @Date 2020/11/18 18:25
 */
@Data
@TableName("tb_user")
public class User extends Model<User> implements Serializable {
    private static final long serialVersionUID = -3233039911762789874L;
    /**
     * 主键
     */
    @TableId(value = "user_id")
    private Long id;

    /**
     * 用户名
     */
    @NotNull(message = "用户名不能为空")
    @TableField("user_name")
    private String username;

    /**
     * 密码
     */
    @NotNull(message = "密码不能为空")
    @TableField("pass_word")
    private String password;

    /**
     * 手机号
     */
    @NotNull(message = "手机号不能为空")
    @Phone
    @TableField("mobile")
    private String mobile;

    /**
     * 邮箱
     */
    @NotNull(message = "邮箱不能为空")
    @Email
    @TableField("email")
    private String email;

    /**
     * 状态信息
     */
    @TableField("status")
    private int status;

    /**
     * 创建时间
     */
    @TableField(fill = FieldFill.INSERT)
    private LocalDateTime createTime;
}