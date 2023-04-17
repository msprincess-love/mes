package com.ktg.mes.md.domain.pro;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
public class ProFeedback {

    @TableId(type = IdType.AUTO)
    private Long recordId;
    private String feedbackType;
    private String workstationId;
    private String workstationCode;
    private String workstationName;
    private Long workorderId;
    private String workorderCode;
    private String workorderName;
    private String processId;
    private String processCode;
    private String processName;
    private String taskId;
    private String taskCode;
    private String itemId;
    private String itemCode;
    private String itemName;
    private String unitOfMeasure;
    private String specification;
    private BigDecimal quantity;
    private BigDecimal quantityFeedback;
    private BigDecimal quantityQualified;
    private BigDecimal quantityUnqualified;
    private String userName;
    private String nickName;
    private String feedbackChannel;
    private LocalDate feedbackTime;
    private String recordUser;
    private String recordNick;
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
