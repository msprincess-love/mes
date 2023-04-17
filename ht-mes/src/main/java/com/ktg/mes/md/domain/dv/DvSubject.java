package com.ktg.mes.md.domain.dv;

import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.time.LocalDateTime;

/**
 * @author zhstart_bytedance
 * @version 1.0
 * @date 2023/4/11 11:29
 * @description mes
 */
@Data
public class DvSubject {

    @TableId
    private String subjectId;

    @NotBlank(message = "code不能为空")
    private String subjectCode;

    @NotBlank(message = "name不能为空")
    private String subjectName;

    private String subjectType;

    private String subjectContent;

    private String subjectStandard;

    @NotBlank(message = "是否有值不能为空")
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
