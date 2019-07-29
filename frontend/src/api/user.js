import request from '@/utils/request'

export function login(data) {
  return request({
    url: '/user/login',
    method: 'post',
    data
  })
}

/**
 * 此处将 params: { token } -> params: { access_token: token }
 * 用以适配我们后台
 * @param token
 */
export function getInfo(token) {
  return request({
    url: '/user/info',
    method: 'get',
    params: { access_token: token }
  })
}

export function logout(token) {
  return request({
    url: '/user/logout',
    method: 'post',
    params: { access_token: token }
  })
}
