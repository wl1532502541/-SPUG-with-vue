import http from "../../libs/http"
export default{
    namespaced:true,
    state:{
        records:[],
        types:[],
        record:{},
        isFetching : false,
        formVisible: false,

        f_type:"",
        f_hostName:"",
        f_ip:""
    },
    mutations:{
        //显示表格
        showForm(state,info={}){
            state.record=info
            state.formVisible=true
            console.log("info",info)
            console.log("record",state.record)
        },
        closeForm(state,callback){
          state.formVisible=false
          if(callback)callback()
        },
        //获取表格数据
        fetchRecords(state) {
            state.isFetching = true;
            http
              .get("/host/filter?filter=&page=0_10&sort=-createTime")
              .then((response) => {
                state.records = [
                  ...response.items
                ];
                console.log("获取表格数据:",state.records)
                let temp=state.records.map((item)=>item.type)
                temp = new Set(temp)
                state.types=Array.from(temp)
                console.log("获取分类：",state.types)
              })
              .finally(() => (state.isFetching = false));
          },
    }
}
