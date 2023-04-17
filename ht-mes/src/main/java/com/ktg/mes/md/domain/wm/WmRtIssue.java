package com.ktg.mes.md.domain.wm;

import com.baomidou.mybatisplus.annotation.TableId;
import com.ktg.common.annotation.Excel;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.time.LocalDate;
import java.util.Date;

/**
 * @author zhstart_bytedance
 * @version 1.0
 * @date 2023/4/14 10:26
 * @description mes
 */
@Data
public class WmRtIssue {

    @TableId
    private Long rtId;

    @NotBlank(message = "code不能为空")
    private String rtCode;

    @NotBlank(message = "name不能为空")
    private String rtName;

    private String workorderId;

    private String workorderCode;

    private String warehouseId;

    private String warehouseCode;

    private String warehouseName;

    private String locationId;

    private String locationCode;

    private String locationName;

    private String areaId;

    private String areaCode;

    private String areaName;

    private LocalDate rtDate;

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
