<template>
  <a-layout-content style="padding:24px;minHeight:280px ">
    <a-card>
      <a-form
        layout="horizontal"
        :label-col="{ flex: '75px' }"
        :wrapper-col="{ flex: 'auto' }"
      >
        <a-row :gutter="12">
          <a-col :sm="24" :md="6">
            <a-form-item label="主机类别：" style="display: flex">
              <a-select placeholder="请选择">
                <a-select-option value="1">
                  1
                </a-select-option>
                <a-select-option value="2">
                  Web服务
                </a-select-option>
              </a-select>
            </a-form-item>
          </a-col>
          <a-col :sm="24" :md="6">
            <a-form-item label="主机别名：" style="display: flex">
              <a-input placeholder="请输入"> </a-input>
            </a-form-item>
          </a-col>
          <a-col :sm="24" :md="6">
            <a-form-item label="连接地址：" style="display: flex">
              <a-input placeholder="请输入"> </a-input>
            </a-form-item>
          </a-col>
          <a-col :sm="24" :md="6">
            <a-form-item>
              <a-button type="primary" @click="clickRefresh">
                <a-icon type="sync"></a-icon>
                刷新
              </a-button>
            </a-form-item>
          </a-col>
        </a-row>
      </a-form>
      <div style="margin: 0 0 16px">
        <a-button type="primary" @click="setVisible(newHost, true)">
          <a-icon type="plus"></a-icon>
          新建
        </a-button>
        <a-modal
          title="新建主机"
          :visible="newHost.visible"
          :confirm-loading="newHost.confirmLoading"
          ok-text="确定"
          cancel-text="取消"
          @ok="handleOk(newHost)"
          @cancel="setVisible(newHost, false)"
          width="800px"
          :maskClosable="false"
        >
          <a-form
            layout="horizontal"
            :label-col="{ span: 4 }"
            :wrapper-col="{ span: 14 }"
            :form="newHostForm"
          >
            <a-form-item label="主机类别">
              <a-col :span="14">
                <a-select placeholder="请选择主机类别/区域/分组"
                          v-decorator="['type',{rules:[{required:true}]}]">
                  <a-select-option value="Web服务">
                    Web服务
                  </a-select-option>
                </a-select>
              </a-col>
              <a-col :span="4" offset="1">
                <a>添加类别</a>
              </a-col>
              <a-col :span="4" offset="1">
                <a>编辑类别</a>
              </a-col>
            </a-form-item>
            <a-form-item label="主机名称">
                <a-input placeholder="请输入主机名称" v-decorator="['hostName',{rules:[{required:true}]}]">
                </a-input>
            </a-form-item>
            <a-form-item required label="连接地址" style="margin-bottom: 0">
              <a-form-item  style="display: inline-block;width: 30%">
                <a-input v-decorator="['userName',{rules:[{required:true}]}]" addon-before="ssh" placeholder="用户名">

                </a-input>
              </a-form-item>
              <a-form-item style="display: inline-block;width: 40%">
                <a-input v-decorator="['hostIp',{rules:[{required:true}]}]" addon-before="@" placeholder="主机名/IP">

                </a-input>
              </a-form-item>
              <a-form-item style="display: inline-block;width: 30%">
                <a-input v-decorator="['port',{rules:[{required:true}]}]" addon-before="-p" placeholder="端口">

                </a-input>
              </a-form-item>
            </a-form-item>
            <a-form-item label="独立密钥" extra="默认使用全局密钥，如果上传了独立密钥则优先使用该密钥。">
              <a-upload
                name="file"
                :multiple="true"
                action="https://www.mocky.io/v2/5cc8019d300000980a055e76"
                :headers="headers"
                @change="handleChange"
              >
                <a-button> <a-icon type="upload" /> 点击上传 </a-button>
              </a-upload>
            </a-form-item>
            <a-form-item label="备注信息">
              <a-textarea v-decorator="['remarks']" :rows="2" placeholder="请输入主机备注信息">

              </a-textarea>
            </a-form-item>
            <a-form-item :wrapper-col="{offset:4}">
              <span>
                ⚠️ 首次验证时需要输入登录用户名对应的密码，但不会存储该密码。
              </span>
            </a-form-item>
          </a-form>
        </a-modal>
        <a-button
          type="primary"
          @click="setVisible(importHost, true)"
          style="margin-left:20px "
        >
          <a-icon type="import"></a-icon>
          批量导入
        </a-button>
        <a-modal
          title="批量导入"
          :visible="importHost.visible"
          :confirm-loading="importHost.confirmLoading"
          ok-text="确定"
          cancel-text="取消"
          @ok="handleOk(importHost)"
          @cancel="setVisible(importHost, false)"
          width="800px"
        >
          <a-alert
            v-show="importHost.information.visible"
            description="导入或输入的密码仅作首次验证使用，并不会存储密码。"
            type="info"
            closable
            show-icon
            style="width:600px;margin: 0 auto 20px"
          />
          <a-form layout="horizontal"
          :label-col="{span:6}"
          :wrapper-col="{span:14}">
            <a-form-item label="模板下载" extra="请下载使用该模板填充数据后导入">
              <a href="../123.xlsx" download="主机导入模板.xlsx">主机导入模板.xlsx</a>
            </a-form-item>
            <a-form-item label="默认密码" extra="如果excel中密码为空则使用该密码">
              <a-input placeholder="请输入默认主机密码">
              </a-input>
            </a-form-item>
            <a-form-item label="导入数据">
              <a-upload
                name="file"
                :multiple="true"
                action="https://www.mocky.io/v2/5cc8019d300000980a055e76"
                :headers="headers"
                @change="handleChange"
              >
                <a-button> <a-icon type="upload" /> 点击上传 </a-button>
              </a-upload>
            </a-form-item>
          </a-form>
        </a-modal>
      </div>
      <a-spin :spinning="spinning">
        <a-table :columns="columns" :data-source="data">
          <a slot="name" slot-scope="text">{{ text }}</a>
          <span slot="customTitle"> 类别</span>
          <span slot="action" slot-scope="record">
            <a @click="setVisible(setHost,true,record.ip)">编辑{{record.ip}}</a>
            <a-modal :visible="setHost.visible&&record.ip==editIndex"
                     title="编辑主机"
                     :confirm-loading="setHost.confirmLoading"
                     ok-text="确定"
                     cancel-text="取消"
                     @ok="handleOk(setHost)"
                     @cancel="setVisible(setHost, false)"
                     width="800px">
              <a-form
                layout="horizontal"
                :label-col="{ span: 4 }"
                :wrapper-col="{ span: 14 }"
              >
            <a-form-item label="主机类别">
              <a-col :span="14">
                <a-select placeholder="请选择主机类别/区域/分组">
                  <a-select-option value="Web服务">
                    Web服务
                  </a-select-option>
                </a-select>
              </a-col>
              <a-col :span="4" offset="1">
                <a>添加类别</a>
              </a-col>
              <a-col :span="4" offset="1">
                <a>编辑类别</a>
              </a-col>
            </a-form-item>
            <a-form-item label="主机名称">
                <a-input placeholder="请输入主机名称">
                </a-input>
            </a-form-item>
            <a-form-item label="连接地址" style="margin-bottom: 0">
              <a-form-item style="display: inline-block;width: 30%">
                <a-input addon-before="ssh" placeholder="用户名">

                </a-input>
              </a-form-item>
              <a-form-item style="display: inline-block;width: 40%">
                <a-input addon-before="@" placeholder="主机名/IP">

                </a-input>
              </a-form-item>
              <a-form-item style="display: inline-block;width: 30%">
                <a-input addon-before="-p" placeholder="端口">

                </a-input>
              </a-form-item>
            </a-form-item>
            <a-form-item label="独立密钥" extra="默认使用全局密钥，如果上传了独立密钥则优先使用该密钥。">
              <a-upload
                name="file"
                :multiple="true"
                action="https://www.mocky.io/v2/5cc8019d300000980a055e76"
                :headers="headers"
                @change="handleChange"
              >
                <a-button> <a-icon type="upload" /> 点击上传 </a-button>
              </a-upload>
            </a-form-item>
            <a-form-item label="备注信息">
              <a-textarea :rows="2" placeholder="请输入主机备注信息">

              </a-textarea>
            </a-form-item>
            <a-form-item :wrapper-col="{offset:4}">
              <span>
                ⚠️ 首次验证时需要输入登录用户名对应的密码，但不会存储该密码。
              </span>
            </a-form-item>
          </a-form>
            </a-modal>
            <a-divider type="vertical" />
            <a type="dashed" @click="showPropsConfirm">删除</a>
            <a-divider type="vertical" />
            <a>Console</a>
            <a-divider type="vertical" />
          </span>
        </a-table>
      </a-spin>
    </a-card>
  </a-layout-content>
</template>

<script>
import throttle from "@/util";

export default {
  name: "Host",
  components: {},
  created() {
    /*this.data=[{
      key: "2",
      hostType: "Web22服务",
      hostName: "web-22201123",
      hostLocation: "10.22227.117.181",
      hostPort: "2222201",
      hostRemarks: ""
    }]*/
    /*this.data=*/
    let that=this;
    this.axios.get("/host/filter?filter=&page=0_10&sort=-createTime")
        .then((response)=>{/*that.data=response.data.items;*/that.data=[...response.data.items]
          for(let i=0;i<that.data.length;i++){
            that.data[i]['key']=response.data.items[i]['id'];
          }
          console.log(that.data)
        console.log(response.data);})
  },
  data() {
    return {
      editIndex:-1,
      newHostForm:this.$form.createForm(this,{name:'newHost'}),
      data:[],
      columns,
      //按钮 新建主机
      newHost: {
        name: 'newHost',
        visible: false,
        confirmLoading: false,
        type:'',
        hostName:''
      },
      //按钮 批量导入
      importHost: {
        name: 'importHost',
        visible: false,
        confirmLoading: false,
        information: { visible: true }
      },
      //按钮 编辑主机
      setHost: {
        name: 'setHost',
        visible: false,
        confirmLoading: false
      },
      //按钮 刷新
      spinning: false,
      //上传
      headers: {
        authorization: 'authorization-text',
      },
    };
  },
  methods: {
    setVisible(obj, boolean,editIndex=-1) {
      if(obj==this.newHost){
        obj.visible = boolean;
        this.newHostForm.resetFields();
        let _this=this;
        /*console.log(this.newHostForm.getFieldsValue())*/
        this.newHostForm.setFieldsValue({userName:"we"})
        this.$forceUpdate();
        /*this.nextTick(_this.newHostForm.setFieldsValue({userName:"we"}))
        this.$nextTick(function(){_this.newHostForm.setFieldsValue({userName:"we"})})
        console.log(this.newHostForm.getFieldsValue())*/
        /*this.newHostForm.values.name='1';*/
      }
      if(obj==this.setHost){
        this.editIndex=editIndex
      }
      let that = this;
      if (obj.name == 'importHost' && boolean == true) {
        obj.information.visible = true;
        console.log(that.importHost.information.visible)
      }
      obj.visible = boolean;
    },
    handleOk(obj) {
      if(obj==this.newHost){
        this.newHostForm.validateFields((err, values) => {
          if (!err) {
            console.log('Received values of form: ', values);
            obj.confirmLoading = true;
            this.axios.post("/host/add",JSON.stringify(
                {type:values.type,
                        hostName:values.hostName,
                        userName:values.userName,
                        ip:values.hostIp,
                        port:values.port,
                        remarks:values.remarks,
                        }),
                {headers:{'Content-Type':"application/json"}})
                .then((response)=>{console.log(response.data);
                })
            let that=this;
            this.axios.get("/host/filter?filter=&page=0_10&sort=-createTime")
                .then((response)=>{

                  that.data=response.data.items;
                  console.log(response.data);;obj.visible = false;
                  obj.confirmLoading = false;})
            this.$forceUpdate();

            /*setTimeout(() => {
              obj.visible = false;
              obj.confirmLoading = false;
            }, 100);*/
          }
        });
      }

      /*axios({
        method:"post",
        url:"xxxxxxx",
        headers: {
          "Content-Type": "multipart/form-data"
        },
        withCredentials:true,
        data:formData
      }).then((res)=>{
        console.log(res);
      });*/
    }
    ,
    //刷新按钮
    clickRefresh: function() {
      console.log("2");
      this.spinning = !this.spinning;
      let that = this;
      let fn = setTimeout(function() {
        that.spinning = !that.spinning;
      }, 500);
      console.log("pre");
      throttle(fn, 5000)();
      console.log("after");
    },
    //上传确定按钮
    handleChange(info) {
      if (info.file.status !== 'uploading') {
        console.log(info.file, info.fileList);
      }
      if (info.file.status === 'done') {
        this.$message.success(`${info.file.name} file uploaded successfully`);
      } else if (info.file.status === 'error') {
        this.$message.error(`${info.file.name} file upload failed.`);
      }
    },
    showPropsConfirm() {
      this.$confirm({
        title: 'Are you sure delete this task?',
        content: '确定要删除？',
        okText: '确定',
        okType: '取消',/*
        okButtonProps: {
          props: {type:'primary',
            disabled: false },
        },*/
        cancelText: 'No',
        onOk() {
          console.log('OK');
        },
        onCancel() {
          console.log('Cancel');
        },
      });
    }
  }
};
/*let data = [
  {
    key: "1",
    hostType: "Web服务",
    hostName: "web-01123",
    hostLocation: "10.7.117.181",
    hostPort: "2201",
    hostRemarks: ""
  }
];*/
const columns = [
  {
    dataIndex: "type",
    key: "type",
    slots: { title: "customTitle" },
    scopedSlots: { customRender: "type" }
  },
  {
    title: "主机名称",
    dataIndex: "hostName",
    key: "hostName",
    sorter: (a, b) => a.hostName - b.hostName
  },
  {
    title: "连接地址",
    key: "ip",
    dataIndex: "ip",
    /*defaultSortOrder: 'descend',*/
    sorter: (a, b) => a.ip - b.ip,
    scopedSlots: { customRender: "ip" }
  },
  {
    title: "端口",
    key: "port",
    dataIndex: "port"
  },
  {
    title: "备注信息",
    key: "remarks",
    dataIndex: "remarks"
  },
  {
    title: "操作",
    key: "hostAction",
    scopedSlots: { customRender: "action" }
  }
];
</script>

<style scoped>
.ant-advanced-search-form {
  padding: 24px;
  background: #fbfbfb;
  border: 1px solid #d9d9d9;
  border-radius: 6px;
}
.ant-advanced-search-form .ant-form-item {
  display: flex;
}
.ant-advanced-search-form .ant-form-item-control-wrapper {
  flex: 1;
}
</style>
