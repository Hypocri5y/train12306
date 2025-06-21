import { createRouter, createWebHistory } from 'vue-router'
import Login from "@/views/login";

const routes = [
  {
    path: '/login',
    name: 'login',
    component: Login},
  {
    path: '/',
    component: () => import('../views/ConsoleView.vue')
  }
]


const router = createRouter({
  history: createWebHistory(process.env.BASE_URL),
  routes
})

export default router
