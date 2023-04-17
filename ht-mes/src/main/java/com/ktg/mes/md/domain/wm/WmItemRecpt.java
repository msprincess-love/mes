package com.ktg.mes.md.domain.wm;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
public class WmItemRecpt {

    @TableId(type = IdType.AUTO)
    private Long recptId;

    @NotBlank(message = "code不能为空")
    private String recptCode;

    @NotBlank(message = "name不能为空")
    private String recptName;


    private String iqcId;

    private String iqcCode;

    private String poCode;

    private String vendorId;

    private String vendorCode;

    private String vendorName;

    private String vendorNick;

    private String warehouseId;

    private String warehouseCode;

    private String warehouseName;

    private String locationId;

    private String locationCode;

    private String locationName;

    private String areaId;

    private String areaCode;

    private String areaName;

    private LocalDate recptDate;

    private String status;

    private String remark;

    private String attr1;

    private String attr2;

    private Integer attr3;

    private Integer attr4;

    private String createBy;

    private LocalDateTime createTime;

    private String updateBy;

    private LocalDateTime updateTime;

}
               
