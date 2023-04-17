package com.ktg.mes.md.domain.md;

import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * @author zhstart_bytedance
 * @version 1.0
 * @date 2023/4/9 15:49
 * @description mes
 */
@Data
public class MdWorkshop {

    @TableId
    private String workshopId;

    @NotBlank(message = "车间编码不能为空")
    private String workshopCode;

    @NotBlank(message = "车间名称不能为空")
    private String workshopName;

    private BigDecimal area;

    private String charge;

    @NotBlank(message = "是否启用必须有值")
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
