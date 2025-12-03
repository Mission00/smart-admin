package net.lab1024.sa.admin.module.business.aiDataset.controller;

import net.lab1024.sa.admin.module.business.aiDataset.domain.form.AiDatasetAddForm;
import net.lab1024.sa.admin.module.business.aiDataset.domain.form.AiDatasetQueryForm;
import net.lab1024.sa.admin.module.business.aiDataset.domain.form.AiDatasetUpdateForm;
import net.lab1024.sa.admin.module.business.aiDataset.domain.vo.AiDatasetVO;
import net.lab1024.sa.admin.module.business.aiDataset.service.AiDatasetService;
import net.lab1024.sa.base.common.domain.ValidateList;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import net.lab1024.sa.base.common.domain.ResponseDTO;
import net.lab1024.sa.base.common.domain.PageResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.Operation;
import cn.dev33.satoken.annotation.SaCheckPermission;
import jakarta.annotation.Resource;
import jakarta.validation.Valid;

/**
 * 知识库 Controller
 *
 * @Author Mission
 * @Date 2025-12-03 21:33:59
 * @Copyright Mission
 */

@RestController
@Tag(name = "知识库")
public class AiDatasetController {

    @Resource
    private AiDatasetService aiDatasetService;

    @Operation(summary = "分页查询 @author Mission")
    @PostMapping("/aiDataset/queryPage")
    @SaCheckPermission("aiDataset:query")
    public ResponseDTO<PageResult<AiDatasetVO>> queryPage(@RequestBody @Valid AiDatasetQueryForm queryForm) {
        return ResponseDTO.ok(aiDatasetService.queryPage(queryForm));
    }

    @Operation(summary = "添加 @author Mission")
    @PostMapping("/aiDataset/add")
    @SaCheckPermission("aiDataset:add")
    public ResponseDTO<String> add(@RequestBody @Valid AiDatasetAddForm addForm) {
        return aiDatasetService.add(addForm);
    }

    @Operation(summary = "更新 @author Mission")
    @PostMapping("/aiDataset/update")
    @SaCheckPermission("aiDataset:update")
    public ResponseDTO<String> update(@RequestBody @Valid AiDatasetUpdateForm updateForm) {
        return aiDatasetService.update(updateForm);
    }

    @Operation(summary = "批量删除 @author Mission")
    @PostMapping("/aiDataset/batchDelete")
    @SaCheckPermission("aiDataset:delete")
    public ResponseDTO<String> batchDelete(@RequestBody ValidateList<String> idList) {
        return aiDatasetService.batchDelete(idList);
    }

    @Operation(summary = "单个删除 @author Mission")
    @GetMapping("/aiDataset/delete/{datasetId}")
    @SaCheckPermission("aiDataset:delete")
    public ResponseDTO<String> batchDelete(@PathVariable String datasetId) {
        return aiDatasetService.delete(datasetId);
    }
}
