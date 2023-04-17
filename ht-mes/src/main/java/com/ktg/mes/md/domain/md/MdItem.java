package com.ktg.mes.md.domain.md;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.ktg.common.annotation.Excel;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @author zhstart_bytedance
 * @version 1.0
 * @date 2023/4/8 13:30
 * @description mes
 */
@Data
@TableName("md_item")
public class MdItem {

    @TableId(type = IdType.AUTO)
    private Long itemId;

    @NotBlank(message = "code不能为空")
    private String itemCode;

    @NotBlank(message = "name不能为空")
    private String itemName;

    private String specification;

    @NotBlank(message = "单位必须有值")
    private String unitOfMeasure;

    @NotBlank(message = "物料产品标识必须勾选")
    private String itemOrProduct;

    private Long itemTypeId;

    private String itemTypeCode;

    private String itemTypeName;

    @NotBlank(message = "是否启用必须有值")
    private String enableFlag;

    @NotBlank(message = "是否设置安全库存必须有值")
    private String safeStockFlag;

    private BigDecimal minStock;

    private BigDecimal maxStock;

    private String remark;

    @Excel(name = "预留字段1")
    private String attr1;

    @Excel(name = "预留字段2")
    private String attr2;

    @Excel(name = "预留字段3")
    private Long attr3;

    @Excel(name = "预留字段4")
    private Long attr4;

    private String createBy;

    private Date createTime;

    private String updateBy;

    private Date updateTime;

}
