package com.ktg.mes.md.domain.pro;

import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.time.LocalDateTime;

/**
 * @author zhstart_bytedance
 * @version 1.0
 * @date 2023/4/9 19:49
 * @description mes
 */
@Data
public class ProProcess {

    @TableId
    private String processId;

    @NotBlank(message = "工序编码不能为空")
    private String processCode;

    @NotBlank(message = "工序名不能为空")
    private String processName;

    private String attention;

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
