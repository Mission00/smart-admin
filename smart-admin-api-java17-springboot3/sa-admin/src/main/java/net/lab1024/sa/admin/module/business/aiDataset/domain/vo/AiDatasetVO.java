package net.lab1024.sa.admin.module.business.aiDataset.domain.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import java.time.LocalDateTime;
import lombok.Data;

/**
 * 知识库 列表VO
 *
 * @Author Mission
 * @Date 2025-12-03 21:33:59
 * @Copyright Mission
 */

@Data
public class AiDatasetVO {


    @Schema(description = "id")
    private String datasetId;

    @Schema(description = "知识库名称")
    private String name;

    @Schema(description = "知识库描述")
    private String description;

    @Schema(description = "知识库权限")
    private String permission;

    @Schema(description = "知识库类型")
    private String type;

    @Schema(description = "外部知识库id")
    private String extKnowledgeId;

    @Schema(description = "外部知识库密钥")
    private String extKnowledgeKey;

    @Schema(description = "创建人名称")
    private String createByName;

    @Schema(description = "创建时间")
    private LocalDateTime createTime;

    @Schema(description = "更新时间")
    private LocalDateTime updateTime;

    @Schema(description = "更新人名称")
    private String updateByName;

}
