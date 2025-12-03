package net.lab1024.sa.admin.module.business.aiDataset.domain.form;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import net.lab1024.sa.base.common.json.deserializer.DictDataDeserializer;

/**
 * 知识库 更新表单
 *
 * @Author Mission
 * @Date 2025-12-03 21:33:59
 * @Copyright Mission
 */

@Data
public class AiDatasetUpdateForm {

    @Schema(description = "id", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotBlank(message = "id 不能为空")
    private String datasetId;

    @Schema(description = "知识库名称", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotBlank(message = "知识库名称 不能为空")
    private String name;

    @Schema(description = "知识库描述", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotBlank(message = "知识库描述 不能为空")
    private String description;

    @Schema(description = "知识库权限", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotBlank(message = "知识库权限 不能为空")
    @JsonDeserialize(using = DictDataDeserializer.class)
    private String permission;

    @Schema(description = "知识库类型", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotBlank(message = "知识库类型 不能为空")
    @JsonDeserialize(using = DictDataDeserializer.class)
    private String type;

    @Schema(description = "外部知识库id")
    private String extKnowledgeId;

    @Schema(description = "外部知识库密钥")
    private String extKnowledgeKey;

}