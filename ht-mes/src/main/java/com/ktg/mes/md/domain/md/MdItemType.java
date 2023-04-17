package com.ktg.mes.md.domain.md;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.ktg.common.annotation.Excel;
import lombok.Data;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Date;

/**
 * @author zhstart_bytedance
 * @version 1.0
 * @date 2023/4/7 8:46
 * @description mes
 */
@Data
@TableName("md_item_type")
public class MdItemType {
    @TableId(type = IdType.AUTO)
    private Long itemTypeId;

    private String itemTypeCode;

    @NotBlank(message = "产品分类名称不允许为空")
    private String itemTypeName;

    @NotNull
    @Min(value = 1, message = "parentTypeId must be greater than zero.")
    private Long parentTypeId;

    private String ancestors;

    @NotBlank(message = "产品物料标识不能为空")
    private String itemOrProduct;

    @NotNull
    @Min(value = 1, message = "order_num must be greater than zero.")
    private Integer orderNum;

    @NotBlank(message = "是否启用不允许为空")
    private String enableFlag;

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
