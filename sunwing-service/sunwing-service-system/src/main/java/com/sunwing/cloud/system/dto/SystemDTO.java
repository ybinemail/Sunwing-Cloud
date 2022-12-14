package com.sunwing.cloud.system.dto;

import lombok.Data;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
public class SystemDTO {

    @NotNull
    @Min(value = 10, message = "id必须大于10")
    @Max(value = 100, message = "id必须小于100")
    private Long id;

    @NotNull(message = "名称不能为空")
    @Size(min = 3, max = 10, message = "名称长度必须在2-10之间")
    private String name;
}
