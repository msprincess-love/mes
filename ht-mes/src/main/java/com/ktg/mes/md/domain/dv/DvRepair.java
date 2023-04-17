package com.ktg.mes.md.domain.dv;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * @author zhstart_bytedance
 * @version 1.0
 * @date 2023/4/11 15:03
 * @description mes
 */
@Data
public class DvRepair {

    @TableId(type = IdType.AUTO)
    private Long repairId;

    @NotBlank(message = "code不能为空")
    private String repairCode;

    @NotBlank(message = "name不能为空")
    private String repairName;

    private String machineryId;

    private String machineryCode;

    private String machineryName;

    private String machineryBrand;

    private String machinerySpec;

    private String machineryTypeId;

    private LocalDate requireDate;

    private LocalDate finishDate;

    private LocalDate confirmDate;

    private String repairResult;

    private String acceptedBy;

    private String confirmBy;

    private String status;

    private String remark;

    private String attr1;

    private String attr2;

    private Integer attr3;

    private Integer attr4;

    private String createBy;

    private LocalDateTime createTime;

    private String updateBy;
}
