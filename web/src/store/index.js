import { createStore } from 'vuex'

const MEMBER = "MEMBER";
export default createStore({
  state: {
    // member创建时从sessionStorage中读取，若不存在则为空对象
    member: window.SessionStorage.get(MEMBER)||{}
  },
  getters: {
  },
  mutations: {
    setMember(state, _member) {
      // 设置store内的数据对象，同时刷新sessionStorage内的数据对象
      state.member=_member
      window.SessionStorage.set(MEMBER, _member);    }
  },
  actions: {
  },
  modules: {
  }
})
