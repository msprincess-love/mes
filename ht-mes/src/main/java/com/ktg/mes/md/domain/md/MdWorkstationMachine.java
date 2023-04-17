package com.ktg.mes.md.domain.md;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import javax.validation.constraints.Min;
import java.time.LocalDateTime;

/**
 * @author zhstart_bytedance
 * @version 1.0
 * @date 2023/4/15 13:31
 * @description mes
 */
@Data
public class MdWorkstationMachine {

    @TableId(type = IdType.AUTO)
    private Long recordId;

    private String workstationId;

    private String machineryId;

    private String machineryCode;

    private String machineryName;

    @Min(0)
    private Integer quantity;

    private String remark;

    private String attr1;

    private String attr2;

    private Integer attr3;

    private Integer attr4;

    private String createBy;

    private LocalDateTime createTime;

    private String updateBy;

    private LocalDateTime updateTime;

    public void add(MdWorkstationMachine mdWorkstationMachine) {



    }
}
