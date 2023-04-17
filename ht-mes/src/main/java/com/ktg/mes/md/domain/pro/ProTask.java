package com.ktg.mes.md.domain.pro;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * @author zhstart_bytedance
 * @version 1.0
 * @date 2023/4/13 15:42
 * @description mes
 */
@Data
public class ProTask {

    @TableId(type = IdType.AUTO)
    private Long taskId;

    @NotBlank(message = "code不能为空")
    private String taskCode;

    @NotBlank(message = "name不能为空")
    private String taskName;

    private String workorderId;

    private String workorderCode;

    private String workorderName;

    private String workstationId;

    private String workstationCode;

    private String workstationName;

    private String processId;

    private String processCode;

    private String processName;

    private String itemId;

    private String itemCode;

    private String itemName;

    private String specification;

    private String unitOfMeasure;

    @Min(0)
    private BigDecimal quantity;

    @Min(0)
    private BigDecimal quantityQuanlify;

    @Min(0)
    private BigDecimal quantityUnquanlify;

    @Min(0)
    private BigDecimal quantityChanged;

    private String clientId;

    private String clientCode;

    private String clientName;

    private String clientNick;

    private LocalDate startTime;

    @Min(0)
    private Integer duration;

    private LocalDate endTime;

    private String colorCode;

    private LocalDate requestDate;

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
