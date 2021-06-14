import Vue from "vue";
import VueRouter from "vue-router";
/* import Home from "../views/home/Home.vue"; */
import homeRouter from "@/router/module/home";

Vue.use(VueRouter);

const routes = [];

/* const rootRouter = {
  path: "/",
  name: "Home",
  component: Home
}; */

homeRouter(routes);

const router = new VueRouter({
    /* routes: routes.concat(routes, rootRouter) */
    mode: 'history',
    routes: routes
});

export default router;
