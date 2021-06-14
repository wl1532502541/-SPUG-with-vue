export default function (router) {
    router.push({
        path: "/",
        redirect: "/login"
    });
    /*router.push({
      path: "src/resource/123.xlsx",
      redirect: ""
    });*/
    //登录
    router.push({
        path: "/login",
        name: "login",
        component: () => import("@/views/login/Login")
    });
    // 工作台
    router.push({
        path: "/home",
        name: "Home",
        component: () => import("@/views/home/Home")
    });
    // 主机管理
    router.push({
        path: "/host",
        name: "Host",
        component: () => import("@/views/home/Host")
    });
    // 批量执行
    router.push(
        {
            path: "/exec/task",
            name: "ExecTask",
            component: () => import("@/views/exec/Task")
        },
        {
            path: "/exec/template",
            name: "Template",
            component: () => import("@/views/exec/Template")
        }
    );
    // 应用发布
    router.push(
        {
            path: "/deploy/app",
            name: "App",
            component: () => import("@/views/deploy/App")
        },
        {
            path: "/deploy/request",
            name: "Request",
            component: () => import("@/views/deploy/Request")
        }
    );
    //任务计划
    router.push({
        path: "/task",
        name: "TaskPlan",
        component: () => import("@/views/task/TaskPlan")
    });
    //配置中心
    router.push(
        {
            path: "/config/app",
            name: "App",
            component: () => import("@/views/config/App")
        },
        {
            path: "/config/environment",
            name: "Environment",
            component: () => import("@/views/config/Environment")
        },
        {
            path: "/config/service",
            name: "Service",
            component: () => import("@/views/config/Service")
        }
    );
    //监控中心
    router.push({
        path: "/monitor",
        name: "Monitor",
        component: () => import("@/views/monitor/Monitor")
    })
    //报警中心
    router.push(
        {
            path: "/alarm/history",
            name: "Alarm/History",
            component: () => import("@/views/alarm/History")
        },
        {
            path: "/alarm/contact",
            name: "Alarm/Contact",
            component: () => import("@/views/alarm/Contact")
        },
        {
            path: "/alarm/group",
            name: "Alarm/Group",
            component: () => import("@/views/alarm/Group")
        }
    )
    //系统管理
    router.push(
        {
            path: "/system/account",
            name: "Account",
            component: () => import("@/views/system/Account")
        },
        {
            path: "/system/role",
            name: "Role",
            component: () => import("@/views/system/Role")
        },
        {
            path: "/system/setting",
            name: "Setting",
            component: () => import("@/views/system/Setting")
        }
    );
    router.push(
      {
          path:"/ssh",
          name:"SSH",
          component:() => import("@/views/ssh/Console")
      }
    )
}
