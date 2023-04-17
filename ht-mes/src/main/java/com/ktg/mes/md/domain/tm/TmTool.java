package com.ktg.mes.md.domain.tm;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import org.checkerframework.checker.units.qual.min;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * @author zhstart_bytedance
 * @version 1.0
 * @date 2023/4/11 15:32
 * @description mes
 */
@Data
public class TmTool {

    @TableId(type = IdType.AUTO)
    private Long toolId;

    @NotBlank(message = "code不能为空")
    private String toolCode;

    @NotBlank(message = "name不能为空")
    private String toolName;

    private String brand;

    private String spec;

    private Long toolTypeId;

    private String toolTypeCode;

    private String toolTypeName;

    private String codeFlag;

    @NotNull
    @Min(0)
    private Integer quantity;

    @Min(0)
    private Integer quantityAvail;

    private String maintenType;

    private Integer nextMaintenPeriod;

    private LocalDate nextMaintenDate;

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
