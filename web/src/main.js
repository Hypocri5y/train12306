import { createApp } from 'vue'
import App from './App.vue'
import router from './router'
import store from './store'
import Antd, {notification} from 'ant-design-vue'
import * as Icons from '@ant-design/icons-vue';
import axios from "axios";

const app = createApp(App);
app.use(Antd).use(store).use(router).mount('#app');

//全局使用图标
const icons = Icons;
for (const i in icons) {
  app.component(i, icons[i]);
}

// Axios拦截器配置，实现前端自动打印请求和返回结果的日志
axios.interceptors.request.use(function (config) {
  console.log('请求参数：', config);
  const _token = store.state.member.token;
  if (_token) {
    config.headers.token = _token;
    console.log("请求headers添加token:", _token);
  }
  return config;
}, error => {
  return Promise.reject(error);
});
axios.interceptors.response.use(function (response) {
  console.log('返回结果：', response);
  return response;
}, error => {
  console.log('返回错误：', error);
  const response = error.response;
  const status = response.status;
  if (status === 401) {
    // HTTP状态码是401，登录失效，跳转到登录页
    console.log("未登录或登录超时，跳到登录页");
    store.commit("setMember", {});
    notification.error({ description: "登录失效，请重新登录"});
    router.push('/login');
  }
  return Promise.reject(error);
});

// 读取环境配置文件
// package.json的scripts中指定了--mode dev，则自动读取web根目录中的.env.dev配置文件
console.log('环境：', process.env.NODE_ENV);
console.log('服务端：', process.env.VUE_APP_SERVER);
// 自动设置Axios的Base URL
axios.defaults.baseURL = process.env.VUE_APP_SERVER;