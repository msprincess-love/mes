package com.ktg.mes.md.domain.dv;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.time.LocalDateTime;

/**
 * @author zhstart_bytedance
 * @version 1.0
 * @date 2023/4/10 20:05
 * @description mes
 */
@Data
public class DvMachineryType {

    @TableId(type = IdType.AUTO)
    private String machineryTypeId;

    private String machineryTypeCode;

    @NotBlank(message = "name不能为空")
    private String machineryTypeName;

    private String parentTypeId;

    private String ancestors;

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
