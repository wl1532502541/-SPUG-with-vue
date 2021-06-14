<template>
  <a-layout-content style="padding:24px 24px 0;">
    <a-card>
    <a-tabs
        default-active-key="1"
        tab-position="left"
        @prevClick="callback"
        @nextClick="callback"
    >
      <a-tab-pane v-for="(setting,index) in settings" :key="index" :tab="setting.name"> Content of  {{ index }} </a-tab-pane>
    </a-tabs>
    </a-card>
  </a-layout-content>
</template>

<script>
export default {
  name: "Setting",
  data(){
    return{
      settings:[
        {
          name:"基本设置"
        },
        {
          name: '安全设置'
        },
        {
          name: 'LDAP设置'
        },
        {
          name: '密钥设置'
        },
        {
          name: '报警服务设置'
        },
        {
          name: '开放服务设置'
        },
        {
          name: '关于'
        },
      ]
    }
  },
  methods:{
    callback(val) {
      console.log(val);
    },
  }
}
</script>

<style scoped>

</style>