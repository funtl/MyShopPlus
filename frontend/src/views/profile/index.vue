<template>
  <div class="app-container">
    <el-form ref="form" :model="form" label-width="120px">
      <el-form-item label="账号">
        <el-input v-model="form.username" />
      </el-form-item>
      <el-form-item label="邮箱">
        <el-input v-model="form.email" />
      </el-form-item>
      <el-form-item label="昵称">
        <el-input v-model="form.nickName" />
      </el-form-item>
      <el-form-item label="备注">
        <el-input v-model="form.note" />
      </el-form-item>
      <el-form-item label="创建时间">
        <el-input v-model="form.createTime" :disabled="true" />
      </el-form-item>
      <el-form-item label="最后登录">
        <el-input v-model="form.loginTime" :disabled="true" />
      </el-form-item>
      <el-form-item label="是否启用">
        <el-radio-group v-model="form.status">
          <el-radio :label="0">禁用</el-radio>
          <el-radio :label="1">启用</el-radio>
        </el-radio-group>
      </el-form-item>
      <el-form-item>
        <el-button type="primary" @click="onSubmit">保存</el-button>
      </el-form-item>
    </el-form>
  </div>
</template>

<script>
import { info } from '../../api/profile'

export default {
  name: 'Profile',
  data() {
    return {
      form: {
        username: '',
        email: '',
        nickName: '',
        note: '',
        createTime: '',
        loginTime: '',
        status: ''
      }
    }
  },
  created() {
    this.fetchData()
  },
  methods: {
    fetchData() {
      info(this.$store.getters.name).then(response => {
        this.form = response.data
      })
    },
    onSubmit() {
      this.$message('submit!')
    }
  }
}
</script>

<style scoped>

</style>
