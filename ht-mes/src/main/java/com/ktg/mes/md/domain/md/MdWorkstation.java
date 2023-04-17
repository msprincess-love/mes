package com.ktg.mes.md.domain.md;

import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.time.LocalDateTime;

/**
 * @author zhstart_bytedance
 * @version 1.0
 * @date 2023/4/9 18:55
 * @description mes
 */
@Data
public class MdWorkstation {

    @TableId
    private String workstationId;

    @NotBlank(message = "工作站编号不能为空")
    private String workstationCode;

    @NotBlank(message = "工作站名称不能为空")
    private String workstationName;

    private String workstationAddress;

    private String workshopId;

    private String workshopCode;

    private String workshopName;

    private String processId;

    private String processCode;

    private String processName;

    private String warehouseId;

    private String warehouseCode;

    private String warehouseName;

    private String locationId;

    private String locationCode;

    private String locationName;

    private String areaId;

    private String areaCode;

    private String areaName;

    @NotBlank(message = "是否启用必须有值")
    private String enableFlag;

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
