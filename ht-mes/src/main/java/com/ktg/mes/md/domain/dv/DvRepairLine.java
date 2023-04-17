package com.ktg.mes.md.domain.dv;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * @author zhstart_bytedance
 * @version 1.0
 * @date 2023/4/16 13:50
 * @description mes
 */
@Data
public class DvRepairLine {

    @TableId(type = IdType.AUTO)
    private Long lineId;

    private Long repairId;

    private String subjectId;

    private String subjectCode;

    private String subjectName;

    private String subjectType;

    private String subjectContent;

    private String subjectStandard;

    private String malfunctionUrl;

    private String repairDes;

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
