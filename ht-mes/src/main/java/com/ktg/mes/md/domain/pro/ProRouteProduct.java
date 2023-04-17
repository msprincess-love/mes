package com.ktg.mes.md.domain.pro;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * @author zhstart_bytedance
 * @version 1.0
 * @date 2023/4/9 19:49
 * @description mes
 */
@Data
public class ProRouteProduct {

    @TableId(type = IdType.AUTO)
    private Long recordId;

    private String routeId;

    private String itemId;

    private String itemCode;

    private String itemName;

    private String specification;

    private String unitOfMeasure;

    @NotNull
    @Min(0)
    private Integer quantity;

    @NotNull
    @Min(0)
    private BigDecimal productionTime;

    private String timeUnitType;

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
