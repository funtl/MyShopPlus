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
