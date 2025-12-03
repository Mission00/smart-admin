package net.lab1024.sa.admin.module.business.aiDataset.domain.entity;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.time.LocalDateTime;
import lombok.Data;

/**
 * 知识库 实体类
 *
 * @Author Mission
 * @Date 2025-12-03 21:33:59
 * @Copyright Mission
 */

@Data
@TableName("t_ai_dataset")
public class AiDatasetEntity {

    /**
     * id
     */
    @TableId
    private String datasetId;

    /**
     * 知识库名称
     */
    private String name;

    /**
     * 知识库描述
     */
    private String description;

    /**
     * 知识库权限（private，public）
     */
    private String permission;

    /**
     * 知识库类型 dify
     */
    private String type;

    /**
     * 外部知识库id
     */
    private String extKnowledgeId;

    /**
     * 外部知识库密钥
     */
    private String extKnowledgeKey;

    /**
     * 创建人
     */
    private String createBy;

    /**
     * 创建人名称
     */
    private String createByName;

    /**
     * 创建时间
     */
    @TableField(fill = FieldFill.INSERT)
    private LocalDateTime createTime;

    /**
     * 更新人
     */
    private String updateBy;

    /**
     * 更新时间
     */
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private LocalDateTime updateTime;

    /**
     * 更新人名称
     */
    private String updateByName;

    /**
     * 逻辑删除标志
     */
    private Integer deletedFlag;

}
