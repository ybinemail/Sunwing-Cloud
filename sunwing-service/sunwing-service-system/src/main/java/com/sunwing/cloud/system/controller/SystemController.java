package com.sunwing.cloud.system.controller;

import com.sunwing.cloud.system.dto.SystemDTO;
import com.sunwing.cloud.system.service.ISystemService;
import com.sunwing.platform.boot.common.base.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping(value = "system")
@Api(tags = "SunWing-System")
@RefreshScope
public class SystemController {

    private ISystemService systemService;

    @Value("${spring.datasource.druid.maxActive}")
    private int nacosMaxActiveType;

    @Value("${server.port}")
    private String serverPort;

    public SystemController(ISystemService systemService) {
        this.systemService = systemService;
    }


    @GetMapping(value = "list")
    @ApiOperation("获取list")
    public Object list() {
        return systemService.list();
    }

    @GetMapping(value = "page")
    @ApiOperation("获取list")
    public Object page() {
        return systemService.page();
    }

    @GetMapping(value = "mockException")
    @ApiOperation("自定义异常")
    public Result<String> mockException() {
        return Result.data(systemService.mockException());
    }


    @PostMapping(value = "valid")
    @ApiOperation("自定义参数校验")
    public Result<SystemDTO> validator(@Valid @RequestBody SystemDTO systemDTO){
        return Result.data(systemDTO);
    }

    @PostMapping(value = "nacos")
    @ApiOperation("nacos测试")
    public Result<String> nacos(){
        return Result.data(String.valueOf(nacosMaxActiveType));
    }


    @GetMapping(value = "api/by/id")
    @ApiOperation(value = "Feign Get调用接口")
    public Result<String> feignById(@RequestParam("id") Long id){
        return  Result.data(String.valueOf(id));
    }

    @PostMapping(value = "api/by/dto")
    @ApiOperation(value = "Feign Post 调用测试接口")
    public Result<SystemDTO> feginByDto(@Valid @RequestBody SystemDTO systemDTO){
        return Result.data(systemDTO);
    }

    @GetMapping("/api/ribbon")
    @ApiOperation(value = "Ribbon调用测试接口")
    public Result<String> testRibbon() {
        return Result.data("现在访问的服务端口是:" + serverPort);
    }

    @ApiOperation(value = "限流测试")
    @GetMapping(value = "sentinel/protected")
    public Result<String> sentinelProtected() {
        return Result.data("访问的是限流测试接口");
    }
}

