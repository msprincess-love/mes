package com.ktg.mes.md.domain.wm;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
public class WmItemRecptLine {

    @TableId(type = IdType.AUTO)
    private Long lineId;

    private Long recptId;

    private String itemId;

    private String itemCode;

    private String itemName;

    private String specification;

    private String unitOfMeasure;

    @Min(0)
    private BigDecimal quantityRecived;

    private String batchCode;

    private String warehouseId;

    private String warehouseCode;

    private String warehouseName;

    private String locationId;

    private String locationCode;

    private String locationName;

    private String areaId;

    private String areaCode;

    private String areaName;

    private LocalDate expireDate;

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
               
