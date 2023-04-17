package com.ktg.mes.md.domain.pro;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * @author zhstart_bytedance
 * @version 1.0
 * @date 2023/4/9 19:49
 * @description mes
 */
@Data
public class ProWorkorder {

    @TableId(type = IdType.AUTO)
    private Long workorderId;

    @NotBlank(message = "编码不能为空")
    private String workorderCode;

    @NotBlank(message = "名称不能为空")
    private String workorderName;

    private String orderSource;

    private String sourceCode;

    private Long productId;

    private String productCode;

    private String productName;

    private String productSpc;

    private String unitOfMeasure;

    @NotNull
    @Min(0)
    private BigDecimal quantity;

    @NotNull
    @Min(0)
    private BigDecimal quantityProduced;

    @NotNull
    @Min(0)
    private BigDecimal quantityScheduled;

    private String clientId;

    private String clientCode;

    private String clientName;

    private String batchCode;

    private LocalDate requestDate;

    private Long parentId;

    private String ancestors;

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
