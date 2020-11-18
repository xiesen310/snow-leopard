package com.github.leopard.web.controller;

import com.github.leopard.dao.model.User;
import com.github.leopard.service.UserService;
import com.github.leopard.web.reponse.ResponseHelper;
import com.github.leopard.web.reponse.ResponseModel;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author 谢森
 * @Description UserController
 * @Email xiesen310@163.com
 * @Date 2020/11/18 18:58
 */
@RestController
@RequestMapping("/user")
@Api(value = "用户控制器", protocols = "http")
public class UserController {

    @Autowired
    private UserService userService;

    @ApiOperation(
            value = "获取所有用户",
            produces = "application/json, application/xml",
            consumes = "application/json, application/xml",
            response = ResponseModel.class
    )
    @GetMapping
    public ResponseModel<List<User>> list() {
        return ResponseHelper.buildResponseModel(this.userService.findAll());
    }

    @ApiOperation(
            value = "创建用户",
            produces = "application/json, application/xml",
            consumes = "application/json, application/xml",
            response = ResponseModel.class
    )
    @PostMapping
    public ResponseModel create(@ApiParam(value = "用户对象", required = true) @Validated @RequestBody User user) {
        boolean b = this.userService.saveUser(user);
        return b ? ResponseHelper.buildResponseModel(user) : ResponseHelper.internalServerError("用户保存失败");
    }

    @ApiOperation(
            value = "修改用户",
            produces = "application/json, application/xml",
            consumes = "application/json, application/xml",
            response = ResponseModel.class
    )
    @PutMapping
    public ResponseModel modify(@ApiParam(value = "用户对象", required = true) @Validated @RequestBody User user) {
        boolean b = this.userService.updateUser(user);
        return b ? ResponseHelper.buildResponseModel(user) : ResponseHelper.internalServerError("更新用户失败");
    }

    @ApiOperation(
            value = "根据 ID 查询业务",
            produces = "application/json, application/xml",
            consumes = "application/json, application/xml",
            response = ResponseModel.class
    )
    @GetMapping("/{id}")
    public ResponseModel get(@ApiParam(value = "用户 ID", required = true) @PathVariable("id") Long id) {
        User user = this.userService.findUser(id);
        return ResponseHelper.buildResponseModel(user);
    }

    @ApiOperation(
            value = "删除用户",
            produces = "application/json, application/xml",
            consumes = "application/json, application/xml",
            response = ResponseModel.class
    )
    @DeleteMapping("/{id}")
    public ResponseModel delete(@ApiParam(value = "用户 ID", required = true) @PathVariable("id") Long id) {
        boolean b = this.userService.deleteUser(id);
        return b ? ResponseHelper.buildResponseModel(id) : ResponseHelper.internalServerError("删除用户失败");
    }
}
