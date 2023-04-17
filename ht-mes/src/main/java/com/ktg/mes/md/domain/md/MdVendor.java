package com.ktg.mes.md.domain.md;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.time.LocalDateTime;

/**
 * @author zhstart_bytedance
 * @version 1.0
 * @date 2023/4/8 19:35
 * @description mes
 */
@TableName("md_vendor")
@Data
public class MdVendor {
    @TableId
    private String vendorId;

    @NotBlank(message = "供应商编码不能为空")
    private String vendorCode;

    @NotBlank(message = "供应商名称不能为空")
    private String vendorName;

    private String vendorNick;

    private String vendorEn;

    private String vendorDes;

    private String vendorLogo;

    private String vendorLevel;

    private String vendorScore;

    private String address;

    private String website;

    private String email;

    private String tel;

    private String contact1;

    private String contact1Tel;

    private String contact1Email;

    private String contact2;

    private String contact2Tel;

    private String contact2Email;

    private String creditCode;

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
