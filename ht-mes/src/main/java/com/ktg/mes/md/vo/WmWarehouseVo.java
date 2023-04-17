package com.ktg.mes.md.vo;

import com.baomidou.mybatisplus.annotation.TableField;
import com.ktg.mes.md.domain.wm.WmStorageLocation;
import lombok.Data;

import java.util.List;

/**
 * @author zhstart_bytedance
 * @version 1.0
 * @date 2023/4/14 9:31
 * @description mes
 */
@Data
public class WmWarehouseVo {

    private String warehouseId;

    private String warehouseName;

    @TableField(exist = false)
    private List<WmStorageLocationVo> wmStorageLocations;
}
