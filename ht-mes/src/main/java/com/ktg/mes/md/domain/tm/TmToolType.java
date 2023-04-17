package com.ktg.mes.md.domain.tm;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.time.LocalDateTime;

/**
 * @author zhstart_bytedance
 * @version 1.0
 * @date 2023/4/11 15:32
 * @description mes
 */
@Data
public class TmToolType {

    @TableId(type = IdType.AUTO)
    private Long toolTypeId;

    @NotBlank(message = "code不能为空")
    private String toolTypeCode;

    @NotBlank(message = "name不能为空")
    private String toolTypeName;

    private String codeFlag;

    private String maintenType;

    private Integer maintenPeriod;

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
