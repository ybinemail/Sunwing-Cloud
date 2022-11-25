package com.sunwing.cloud.system.controller;

import com.sunwing.cloud.system.service.ISystemService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "system")
@AllArgsConstructor

public class SystemController {
    private final ISystemService iSystemService;

    @GetMapping(value = "list")
    public Object list(){
        return iSystemService.list();
    }

    @GetMapping(value = "page")
    public Object page(){
        return iSystemService.page();
    }

}
