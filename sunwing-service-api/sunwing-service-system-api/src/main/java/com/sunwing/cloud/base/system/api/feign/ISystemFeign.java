package com.sunwing.cloud.base.system.api.feign;
import com.sunwing.cloud.base.system.api.dto.ApiSystemDTO;
import com.sunwing.platform.boot.common.base.Result;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;


@FeignClient(value = "sunwing-service-system")
public interface ISystemFeign {

    @GetMapping(value = "/system/api/by/id")
    Result<String> querySystemById(@RequestParam("id") Long id);


    @PostMapping(value = "system/api/by/dto")
    Result<ApiSystemDTO> querySystemDto(@RequestBody ApiSystemDTO apiSystemDTO);

}
