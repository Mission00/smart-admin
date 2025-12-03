package net.lab1024.sa.admin.module.business.aiDataset.service;

import java.util.List;
import net.lab1024.sa.admin.module.business.aiDataset.dao.AiDatasetDao;
import net.lab1024.sa.admin.module.business.aiDataset.domain.entity.AiDatasetEntity;
import net.lab1024.sa.admin.module.business.aiDataset.domain.form.AiDatasetAddForm;
import net.lab1024.sa.admin.module.business.aiDataset.domain.form.AiDatasetQueryForm;
import net.lab1024.sa.admin.module.business.aiDataset.domain.form.AiDatasetUpdateForm;
import net.lab1024.sa.admin.module.business.aiDataset.domain.vo.AiDatasetVO;
import net.lab1024.sa.base.common.util.SmartBeanUtil;
import net.lab1024.sa.base.common.util.SmartPageUtil;
import net.lab1024.sa.base.common.domain.ResponseDTO;
import net.lab1024.sa.base.common.domain.PageResult;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.stereotype.Service;

import jakarta.annotation.Resource;

/**
 * 知识库 Service
 *
 * @Author Mission
 * @Date 2025-12-03 21:33:59
 * @Copyright Mission
 */

@Service
public class AiDatasetService {

    @Resource
    private AiDatasetDao aiDatasetDao;

    /**
     * 分页查询
     */
    public PageResult<AiDatasetVO> queryPage(AiDatasetQueryForm queryForm) {
        Page<?> page = SmartPageUtil.convert2PageQuery(queryForm);
        List<AiDatasetVO> list = aiDatasetDao.queryPage(page, queryForm);
        return SmartPageUtil.convert2PageResult(page, list);
    }

    /**
     * 添加
     */
    public ResponseDTO<String> add(AiDatasetAddForm addForm) {
        AiDatasetEntity aiDatasetEntity = SmartBeanUtil.copy(addForm, AiDatasetEntity.class);
        aiDatasetDao.insert(aiDatasetEntity);
        return ResponseDTO.ok();
    }

    /**
     * 更新
     *
     */
    public ResponseDTO<String> update(AiDatasetUpdateForm updateForm) {
        AiDatasetEntity aiDatasetEntity = SmartBeanUtil.copy(updateForm, AiDatasetEntity.class);
        aiDatasetDao.updateById(aiDatasetEntity);
        return ResponseDTO.ok();
    }

    /**
     * 批量删除
     */
    public ResponseDTO<String> batchDelete(List<String> idList) {
        if (CollectionUtils.isEmpty(idList)){
            return ResponseDTO.ok();
        }

        aiDatasetDao.batchUpdateDeleted(idList, true);
        return ResponseDTO.ok();
    }

    /**
     * 单个删除
     */
    public ResponseDTO<String> delete(String datasetId) {
        if (null == datasetId){
            return ResponseDTO.ok();
        }

        aiDatasetDao.updateDeleted(datasetId, true);
        return ResponseDTO.ok();
    }
}
