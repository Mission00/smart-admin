package net.lab1024.sa.admin.module.business.aiDataset.domain.form;

import net.lab1024.sa.base.common.domain.PageParam;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 知识库 分页查询表单
 *
 * @Author Mission
 * @Date 2025-12-03 21:33:59
 * @Copyright Mission
 */

@Data
@EqualsAndHashCode(callSuper = false)
public class AiDatasetQueryForm extends PageParam {

    @Schema(description = "关键字查询")
    private String keyword;

    @Schema(description = "知识库类型")
    private String type;

    @Schema(description = "知识库权限")
    private String permission;

}
