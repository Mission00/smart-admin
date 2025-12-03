package net.lab1024.sa.admin.module.business.aiDataset.dao;

import java.util.List;
import net.lab1024.sa.admin.module.business.aiDataset.domain.entity.AiDatasetEntity;
import net.lab1024.sa.admin.module.business.aiDataset.domain.form.AiDatasetQueryForm;
import net.lab1024.sa.admin.module.business.aiDataset.domain.vo.AiDatasetVO;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

/**
 * 知识库 Dao
 *
 * @Author Mission
 * @Date 2025-12-03 21:33:59
 * @Copyright Mission
 */

@Mapper
public interface AiDatasetDao extends BaseMapper<AiDatasetEntity> {

    /**
     * 分页 查询
     *
     * @param page
     * @param queryForm
     * @return
     */
    List<AiDatasetVO> queryPage(Page page, @Param("queryForm") AiDatasetQueryForm queryForm);

    /**
     * 更新删除状态
     */
    long updateDeleted(@Param("datasetId")String datasetId,@Param("deletedFlag")boolean deletedFlag);

    /**
     * 批量更新删除状态
     */
    void batchUpdateDeleted(@Param("idList")List<String> idList,@Param("deletedFlag")boolean deletedFlag);

}
