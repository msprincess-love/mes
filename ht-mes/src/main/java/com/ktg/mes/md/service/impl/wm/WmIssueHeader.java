package com.ktg.mes.md.service.impl.wm;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@TableName("wm_issue_header")
public class WmIssueHeader implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "issue_id", type = IdType.AUTO)
    private Long issueId;

    @TableField("issue_code")
    @NotBlank(message = "code不能为空")
    private String issueCode;

    @TableField("issue_name")
    @NotBlank(message = "name不能为空")
    private String issueName;

    @TableField("workstation_id")
    private String workstationId;

    @TableField("workstation_code")
    private String workstationCode;

    @TableField("workstation_name")
    private String workstationName;

    @TableField("workorder_id")
    private String workorderId;

    @TableField("workorder_code")
    private String workorderCode;

    @TableField("task_id")
    private String taskId;

    @TableField("task_code")
    private String taskCode;

    @TableField("client_id")
    private String clientId;

    @TableField("client_code")
    private String clientCode;

    @TableField("client_name")
    private String clientName;

    @TableField("client_nick")
    private String clientNick;

    @TableField("warehouse_id")
    private String warehouseId;

    @TableField("warehouse_code")
    private String warehouseCode;

    @TableField("warehouse_name")
    private String warehouseName;

    @TableField("location_id")
    private String locationId;

    @TableField("location_code")
    private String locationCode;

    @TableField("location_name")
    private String locationName;

    @TableField("area_id")
    private Long areaId;

    @TableField("area_code")
    private String areaCode;

    @TableField("area_name")
    private String areaName;

    @TableField("issue_date")
    private LocalDateTime issueDate;

    @TableField("status")
    private String status;

    @TableField("remark")
    private String remark;

    @TableField("attr1")
    private String attr1;

    @TableField("attr2")
    private String attr2;

    @TableField("attr3")
    private Integer attr3;

    @TableField("attr4")
    private Integer attr4;

    @TableField("create_by")
    private String createBy;

    @TableField("create_time")
    private LocalDateTime createTime;

    @TableField("update_by")
    private String updateBy;

    @TableField("update_time")
    private LocalDateTime updateTime;
}
