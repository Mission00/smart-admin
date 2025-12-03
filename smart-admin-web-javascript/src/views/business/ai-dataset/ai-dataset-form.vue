<!--
  * 知识库
  *
  * @Author:    Mission
  * @Date:      2025-12-03 21:33:59
  * @Copyright  Mission
-->
<template>
  <a-drawer
      :title="form.datasetId ? '编辑' : '添加'"
      :width="400"
      :open="visibleFlag"
      @close="onClose"
      :maskClosable="false"
      :destroyOnClose="true"
  >
    <a-form ref="formRef" :model="form" :rules="rules" :label-col="{ span: 5 }" >
        <a-form-item label="知识库名称"  name="name">
          <a-input style="width: 100%" v-model:value="form.name" placeholder="知识库名称" />
        </a-form-item>
        <a-form-item label="知识库描述"  name="description">
          <a-textarea style="width: 100%" v-model:value="form.description" placeholder="知识库描述" />
        </a-form-item>
        <a-form-item label="知识库权限"  name="permission">
          <DictSelect width="100%" v-model:value="form.permission" :dict-code="DICT_CODE_ENUM.DATASET_PERMISSION || 'DATASET_PERMISSION'" placeholder="知识库权限"/>
        </a-form-item>
        <a-form-item label="知识库类型"  name="type">
          <DictSelect width="100%" v-model:value="form.type" :dict-code="DICT_CODE_ENUM.DATASET_TYPE || 'DATASET_TYPE'" placeholder="知识库类型"/>
        </a-form-item>
        <a-form-item label="外部知识库id"  name="extKnowledgeId">
          <a-input style="width: 100%" v-model:value="form.extKnowledgeId" placeholder="外部知识库id" />
        </a-form-item>
        <a-form-item label="外部知识库密钥"  name="extKnowledgeKey">
          <a-input style="width: 100%" v-model:value="form.extKnowledgeKey" placeholder="外部知识库密钥" />
        </a-form-item>
    </a-form>

    <template #footer>
      <a-space>
        <a-button @click="onClose">取消</a-button>
        <a-button type="primary" @click="onSubmit">保存</a-button>
      </a-space>
    </template>
  </a-drawer>
</template>
<script setup>
  import { reactive, ref, nextTick } from 'vue';
  import _ from 'lodash';
  import { message } from 'ant-design-vue';
  import { SmartLoading } from '/@/components/framework/smart-loading';
  import { aiDatasetApi } from '/@/api/business/ai-dataset/ai-dataset-api';
  import { smartSentry } from '/@/lib/smart-sentry';
  import DictSelect from '/@/components/support/dict-select/index.vue';
  import { DICT_CODE_ENUM } from '/@/constants/support/dict-const.js';

  // ------------------------ 事件 ------------------------

  const emits = defineEmits(['reloadList']);

  // ------------------------ 显示与隐藏 ------------------------
  // 是否显示
  const visibleFlag = ref(false);

  function show(rowData) {
    Object.assign(form, formDefault);
    if (rowData && !_.isEmpty(rowData)) {
      Object.assign(form, rowData);
    }
    // 使用字典时把下面这注释修改成自己的字典字段 有多个字典字段就复制多份同理修改 不然打开表单时不显示字典初始值
    // if (form.status && form.status.length > 0) {
    //   form.status = form.status.map((e) => e.valueCode);
    // }
    visibleFlag.value = true;
    nextTick(() => {
      formRef.value.clearValidate();
    });
  }

  function onClose() {
    Object.assign(form, formDefault);
    visibleFlag.value = false;
  }

  // ------------------------ 表单 ------------------------

  // 组件ref
  const formRef = ref();

  const formDefault = {
      name: undefined, //知识库名称
      description: undefined, //知识库描述
      permission: undefined, //知识库权限
      type: undefined, //知识库类型
      extKnowledgeId: undefined, //外部知识库id
      extKnowledgeKey: undefined, //外部知识库密钥
  };

  let form = reactive({ ...formDefault });

  const rules = {
      name: [{ required: true, message: '知识库名称 必填' }],
      description: [{ required: true, message: '知识库描述 必填' }],
      permission: [{ required: true, message: '知识库权限 必填' }],
      type: [{ required: true, message: '知识库类型 必填' }],
  };

  // 点击确定，验证表单
  async function onSubmit() {
    try {
      await formRef.value.validateFields();
      save();
    } catch (err) {
      message.error('参数验证错误，请仔细填写表单数据!');
    }
  }

  // 新建、编辑API
  async function save() {
    SmartLoading.show();
    try {
      if (form.datasetId) {
        await aiDatasetApi.update(form);
      } else {
        await aiDatasetApi.add(form);
      }
      message.success('操作成功');
      emits('reloadList');
      onClose();
    } catch (err) {
      smartSentry.captureError(err);
    } finally {
      SmartLoading.hide();
    }
  }

  defineExpose({
    show,
  });
</script>
