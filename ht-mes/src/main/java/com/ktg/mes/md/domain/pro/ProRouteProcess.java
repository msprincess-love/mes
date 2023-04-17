package com.ktg.mes.md.domain.pro;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

/**
 * @author zhstart_bytedance
 * @version 1.0
 * @date 2023/4/9 19:49
 * @description mes
 */
@Data
public class ProRouteProcess {

    @TableId(type = IdType.AUTO)
    private Long recordId;

    private String routeId;

    private String processId;

    private String processCode;

    private String processName;

    @NotNull
    @Min(0)
    private Integer orderNum;

    private String nextProcessId;

    private String nextProcessCode;

    private String nextProcessName;

    private String linkType;

    private Integer defaultPreTime;

    private Integer defaultSufTime;

    private String colorCode;

    private String keyFlag;

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
