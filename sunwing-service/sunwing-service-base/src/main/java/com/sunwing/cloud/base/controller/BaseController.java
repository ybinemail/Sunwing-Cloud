package com.sunwing.cloud.base.controller;


import com.sunwing.cloud.base.system.api.dto.ApiSystemDTO;
import com.sunwing.cloud.base.system.api.feign.ISystemFeign;
import com.sunwing.platform.boot.common.base.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "base")
@Api(tags = "Sunwing-Base")
@RefreshScope
public class BaseController {

    private ISystemFeign systemFeign;

    public BaseController(ISystemFeign systemFeign) {
        this.systemFeign = systemFeign;
    }

    @GetMapping(value = "api/by/id")
    @ApiOperation(value="Fegin Get 测试")
    public Result<String> feginById(@RequestParam("id") Long id){
        return systemFeign.querySystemById(id);
    }

    @PostMapping(value = "api/by/dto")
    @ApiOperation(value = "Fegin Post 调用测试")
    public Result<ApiSystemDTO> feginByDto(@RequestBody ApiSystemDTO apiSystemDTO){
        return  systemFeign.querySystemDto(apiSystemDTO);
    }


    @PostMapping(value = "api/ribbon")
    @ApiOperation(value = "Ribbon调用测试接口")
    public Result<Object> testRibbon() {
        return Result.data(systemFeign.testRibbon());
    }

}
