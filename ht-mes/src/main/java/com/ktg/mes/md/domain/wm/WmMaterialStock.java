package com.ktg.mes.md.domain.wm;

import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Date;

@Data
public class WmMaterialStock {

    @TableId
    private String materialStockId;

    private String itemTypeId;

    private String itemId;

    private String itemCode;

    private String itemName;

    private String specification;

    private String unitOfMeasure;

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

    private String vendorId;

    private String vendorCode;

    private String vendorName;

    private String vendorNick;

    private BigDecimal quantityOnhand;

    private String workorderId;

    private String workorderCode;

    private LocalDateTime recptDate;

    private LocalDateTime expireDate;

    private String attr1;

    private String attr2;

    private Integer attr3;

    private Integer attr4;

    private String createBy;

    private LocalDateTime createTime;

    private String updateBy;

    private LocalDateTime updateTime;

}
