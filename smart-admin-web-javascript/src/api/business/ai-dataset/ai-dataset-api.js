/**
 * 知识库 api 封装
 *
 * @Author:    Mission
 * @Date:      2025-12-03 21:33:59
 * @Copyright  Mission
 */
import { postRequest, getRequest } from '/@/lib/axios';

export const aiDatasetApi = {

  /**
   * 分页查询  @author  Mission
   */
  queryPage : (param) => {
    return postRequest('/aiDataset/queryPage', param);
  },

  /**
   * 增加  @author  Mission
   */
  add: (param) => {
      return postRequest('/aiDataset/add', param);
  },

  /**
   * 修改  @author  Mission
   */
  update: (param) => {
      return postRequest('/aiDataset/update', param);
  },


  /**
   * 删除  @author  Mission
   */
  delete: (id) => {
      return getRequest(`/aiDataset/delete/${id}`);
  },

  /**
   * 批量删除  @author  Mission
   */
  batchDelete: (idList) => {
      return postRequest('/aiDataset/batchDelete', idList);
  },

};
