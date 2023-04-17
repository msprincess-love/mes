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
 * @date 2023/4/10 16:35
 * @description mes
 */
@Data
public class WmStorageArea {

    @TableId
    private String areaId;

    @NotBlank(message = "code不能为空")
    private String areaCode;

    @NotBlank(message = "name不能为空")
    private String areaName;

    private String locationId;

    @Min(0)
    private BigDecimal area;

    @Min(0)
    private BigDecimal maxLoa;

    @Min(0)
    private Integer positionX;

    @Min(0)
    private Integer positionY;

    @Min(0)
    private Integer positionZ;

    @NotBlank(message = "是否有值不能为空")
    private String enableFlag;

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
