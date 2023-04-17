package com.ktg.mes.md.vo;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.util.List;

/**
 * @author zhstart_bytedance
 * @version 1.0
 * @date 2023/4/8 18:40
 * @description mes
 */
@Data
public class MdItemTypeVo {

    private Long id;

    @TableField("itemTypeName")
    private String label;

    @TableField(exist = false)
    private List<MdItemTypeVo> children;
}
