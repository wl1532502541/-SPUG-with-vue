import Vue from "vue";
import Vuex from "vuex";
import host from "./modules/host"

Vue.use(Vuex);

export default new Vuex.Store({
    state: {isLogin: true,token:undefined},
    getters:{},
    mutations: {
        // updateToken(){
        //     localStorage.getItem('token')
        // }
    },
    actions: {},
    modules: {
        host
    }
});
