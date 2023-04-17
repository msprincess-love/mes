package com.ktg.mes.md.domain.wm;

import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * @author zhstart_bytedance
 * @version 1.0
 * @date 2023/4/9 21:05
 * @description mes
 */
@Data
public class WmWarehouse {

    @TableId
    private String warehouseId;

    @NotBlank(message = "code必须有值")
    private String warehouseCode;

    @NotBlank(message = "name必须有值")
    private String warehouseName;

    private String location;

    private BigDecimal area;

    private String charge;

    private String enableFlag;

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
