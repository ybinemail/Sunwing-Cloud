package com.sunwing.cloud.system.controller;

import com.sunwing.cloud.system.service.ISystemService;
import com.sunwing.platform.boot.common.base.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "system")
@AllArgsConstructor
@Api(tags = "SunWing-System")
public class SystemController {
    private final ISystemService systemService;
    @GetMapping(value = "list")
    @ApiOperation("获取list")
    public Object list(){
        return systemService.list();
    }

    @GetMapping(value = "page")
    @ApiOperation("获取list")
    public Object page(){
        return systemService.page();
    }

    @GetMapping(value = "mockException")
    @ApiOperation("自定义异常")
    public Result<String> mockException(){
        return Result.data(systemService.mockException());
    }

}
