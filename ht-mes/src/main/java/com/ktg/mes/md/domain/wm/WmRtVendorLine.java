package com.ktg.mes.md.domain.wm;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.ktg.common.annotation.Excel;
import lombok.Data;
import org.checkerframework.checker.units.qual.A;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Date;

/**
 * @author zhstart_bytedance
 * @version 1.0
 * @date 2023/4/14 9:38
 * @description mes
 */
@Data
public class WmRtVendorLine {

    @TableId(type = IdType.AUTO)
    private Long lineId;

    private String rtId;

    private String materialStockId;

    private String itemId;

    private String itemCode;

    private String itemName;

    private String specification;

    private String unitOfMeasure;

    @Min(0)
    private BigDecimal quantityRted;

    private String batchCode;

    private String warehouseId;

    private String warehouseCode;

    private String warehouseName;

    private String locationId;

    private String locationCode;

    private String lcoationName;

    private String areaId;

    private String areaCode;

    private String areaName;

    private String status;

    private String remark;

    @Excel(name = "预留字段1")
    private String attr1;

    @Excel(name = "预留字段2")
    private String attr2;

    @Excel(name = "预留字段3")
    private Long attr3;

    @Excel(name = "预留字段4")
    private Long attr4;

    private String createBy;

    private Date createTime;

    private String updateBy;

    private Date updateTime;
}
