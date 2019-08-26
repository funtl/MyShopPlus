<template>
  <div class="components-container">
    <pan-thumb :image="image" />

    <el-button type="primary" icon="upload" style="position: absolute;bottom: 15px;margin-left: 40px;" @click="toggleShow">
      上传头像
    </el-button>

    <image-cropper
      v-model="show"
      field="multipartFile"
      :width="300"
      :height="300"
      :url="url"
      :params="params"
      :headers="headers"
      img-format="png"
      @crop-success="cropSuccess"
      @crop-upload-success="cropUploadSuccess"
      @crop-upload-fail="cropUploadFail"
    />
  </div>
</template>

<script>
import ImageCropper from 'vue-image-crop-upload'
import PanThumb from '@/components/PanThumb'
import { getToken } from '../../utils/auth'
import { modifyIcon } from '@/api/profile'

export default {
  name: 'ProfileIcon',
  components: { ImageCropper, PanThumb },
  data() {
    return {
      url: process.env.VUE_APP_BASE_API + '/upload',
      show: false,
      params: {
        access_token: getToken()
      },
      headers: {
        smail: '*_~'
      },
      image: this.$store.getters.avatar
    }
  },
  methods: {
    toggleShow() {
      this.show = !this.show
    },

    /**
     *
     * @param image
     * @param field
     */
    cropSuccess(image, field) {
      console.log('-------- crop success --------')
      this.image = image
    },

    /**
     * 上传成功
     * @param jsonData 服务器返回数据，已进行 JSON 转码
     * @param field
     */
    cropUploadSuccess(jsonData, field) {
      console.log('-------- upload success --------')
      console.log(jsonData)
      console.log('path: ', jsonData.data.path)
      console.log('field: ' + field)

      // 更新头像
      modifyIcon({
        username: this.$store.getters.name,
        path: jsonData.data.path
      }).then(response => {
        this.$message({
          message: response.message,
          type: 'success'
        })

        // 更新 vuex 中的头像
        this.$store.dispatch('user/setAvatar', jsonData.data.path)
      }).catch(() => {
      })
    },

    /**
     * 上传失败
     * @param status 服务器返回的失败状态码
     * @param field
     */
    cropUploadFail(status, field) {
      console.log('-------- upload fail --------')
      console.log(status)
      console.log('field: ' + field)
    }
  }
}
</script>

<style scoped>
  .avatar{
    width: 200px;
    height: 200px;
    border-radius: 50%;
  }
</style>
