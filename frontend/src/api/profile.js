import request from '@/utils/request'

/**
 * 获取个人信息
 * @param username 用户名
 */
export function info(username) {
  return request({
    url: '/profile/info/' + username,
    method: 'get'
  })
}

/**
 * 更新个人信息
 * @param data
 */
export function update(data) {
  return request({
    url: '/profile/update',
    method: 'post',
    data
  })
}
