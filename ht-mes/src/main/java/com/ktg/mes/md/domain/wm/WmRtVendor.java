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
 * @date 2023/4/14 9:38
 * @description mes
 */
@Data
public class WmRtVendor {

    @TableId
    private String rtId;

    @NotBlank(message = "code必须有值")
    private String rtCode;

    @NotBlank(message = "name必须有值")
    private String rtName;

    private String poCode;

    private String vendorId;

    private String vendorCode;

    private String vendorName;

    private String vendorNick;

    private String batchCode;

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
