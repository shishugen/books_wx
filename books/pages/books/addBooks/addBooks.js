let app = getApp();
Page({
  data: {
    isSubmit: false,
    money: "",
    goods: "",
    date:"",
    y: "",
    m: "",
    d: ""
  },
  formSubmit: function (e) {
    console.log('form发生了submit事件，携带数据为：', e.detail.value);
    let { money, goods, date } = e.detail.value;
    if (!goods) {
      wx.showToast({
        title: '请输入商品！',
        image:"/images/icon/error.png"
      })
      return;
    }

    if (!money) {
      wx.showToast({
        title: '请输入金额',
        image: "/images/icon/error.png"
      })
      return;
    }
    console.log(money.toFixed(2)+"----")

  },
  formReset: function () {
    var timestamp = Date.parse(new Date());
    var date = new Date(timestamp);
    //年  
    var Y = date.getFullYear();
    //月  
    var M = (date.getMonth() + 1 < 10 ? '0' + (date.getMonth() + 1) : date.getMonth() + 1);
    //日  
    var D = date.getDate() < 10 ? '0' + date.getDate() : date.getDate();
    console.log("当前时间：" + Y + M + D);
    this.setData({
      date: Y + '-' + M + '-' + D
    })
  },
  bindDateChange: function (e) {
    console.log('picker发送选择改变，携带值为', e.detail.value)
    this.setData({
      date: e.detail.value
    })
  },
  onLoad:function() {
    var timestamp = Date.parse(new Date());
    var date = new Date(timestamp);
    //年  
    var Y = date.getFullYear();
    //月  
    var M = (date.getMonth() + 1 < 10 ? '0' + (date.getMonth() + 1) : date.getMonth() + 1);
    //日  
    var D = date.getDate() < 10 ? '0' + date.getDate() : date.getDate();
    console.log("当前时间：" + Y + M + D);
    this.setData({
      date:Y+'-'+M+'-'+D
    })
    this.setData({
      y:Y,
      m: M,
      d: D
    })
  }
})
