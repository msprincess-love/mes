package com.ktg.mes.md.domain.dv;

import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.time.LocalDateTime;

/**
 * @author zhstart_bytedance
 * @version 1.0
 * @date 2023/4/10 21:02
 * @description mes
 */
@Data
public class DvMachinery {

    @TableId
    private String machineryId;

    @NotBlank(message = "code不能为空")
    private String machineryCode;

    @NotBlank(message = "name不能为空")
    private String machineryName;

    private String machineryBrand;

    private String machinerySpec;

    private String machineryTypeId;

    private String machineryTypeCode;

    private String machineryTypeName;

    private String workshopId;

    private String workshopCode;

    private String workshopName;

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
