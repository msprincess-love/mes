package com.ktg.mes.md.vo;

import com.baomidou.mybatisplus.annotation.TableField;
import com.ktg.mes.md.domain.wm.WmStorageArea;
import lombok.Data;

import java.util.List;

/**
 * @author zhstart_bytedance
 * @version 1.0
 * @date 2023/4/14 9:34
 * @description mes
 */
@Data
public class WmStorageLocationVo {

    private String locationId;

    private String locationName;

    @TableField(exist = false)
    private List<WmStorageAreaVo> wmStorageAreas;
}
