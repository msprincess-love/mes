package com.ktg.mes.md.domain.qc;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@TableName("qc_iqc")
public class QcIqc {
    @TableId(value = "iqc_id", type = IdType.AUTO)
    private Long iqcId;

    @NotBlank(message = "code不能为空")
    private String iqcCode;

    @NotBlank(message = "name不能为空")
    private String iqcName;

    private Long templateId;

    private String vendorId;

    private String vendorCode;

    private String vendorName;

    private String vendorNick;

    private String vendorBatch;

    private String itemId;

    private String itemCode;

    private String itemName;

    private String specification;

    private String unitOfMeasure;

    private Integer quantityMinCheck;

    private Integer quantityMaxUnqualified;

    private BigDecimal quantityRecived;

    private Integer quantityCheck;

    private Integer quantityUnqualified;

    private BigDecimal crRate;

    private BigDecimal majRate;

    private BigDecimal minRate;

    private Integer crQuantity;

    private Integer majQuantity;

    private Integer minQuantity;

    private String checkResult;

    private LocalDate reciveDate;

    private LocalDate inspectDate;

    private String inspector;

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
