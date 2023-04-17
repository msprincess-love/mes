package com.ktg.mes.md.domain.wm;

import com.baomidou.mybatisplus.annotation.TableId;
import com.ktg.common.annotation.Excel;
import lombok.Data;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @author zhstart_bytedance
 * @version 1.0
 * @date 2023/4/10 10:33
 * @description mes
 */
@Data
public class WmStorageLocation {

    @TableId
    private String locationId;

    @NotBlank(message = "code不能为空")
    private String locationCode;

    @NotBlank(message = "name不能为空")
    private String locationName;

    @NotBlank(message = "仓库id不能为空")
    private String warehouseId;

    @Min(0)
    private BigDecimal area;

    private String areaFlag;

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
