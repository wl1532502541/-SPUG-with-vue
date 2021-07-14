import Vue from "vue";
import VueRouter from "vue-router";
import routes from "@/router/routes";
import NProgress from "nprogress"
import 'nprogress/nprogress.css' // progress bar style


Vue.use(VueRouter);

const router = new VueRouter({
    mode: 'history',
    routes: routes
});
router.beforeEach((to, from, next) => {
    NProgress.start()
    next()
})

router.afterEach(() => {
    NProgress.done() // finish progress bar
})
export default router;
