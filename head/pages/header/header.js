const app = getApp();
let nickName = null;
let flag=false;
Page({
  data: {
    userInfo: {},
    hasUserInfo: false,
    canIUse: wx.canIUse('button.open-type.getUserInfo')
  },
  //事件处理函数 查看日志
  bindViewTap: function () {
    //console.log(nickName)
   
    if (flag) {
      wx.navigateTo({
        url: '../index/index'
      })
    } else {
      wx.showModal({
        title: '警告',
        content: '没有权限，请于管理员联系',
      })
    }

  },  
  onShow: function () {    
  },
  onLoad: function () {
    this.login() 
    
    
    
  },
  getUserInfo: function (e) {
    if (e.detail.userInfo) {
      app.globalData.userInfo = e.detail.userInfo
      nickName = e.detail.userInfo.nickName
      console.log(nickName)
      this.setData({
        userInfo: e.detail.userInfo,
        hasUserInfo: true
      })
    } else {
      this.openSetting();
    }
  },
  login: function () {
    var that = this;
    wx.login({
      success: function (res) {
        var code = res.code;
        console.log(code);
        wx.getUserInfo({
          success: function (res) {
            app.globalData.userInfo = res.userInfo
            nickName = res.userInfo.nickName
            console.log(nickName+666)
            wx.request({
              url: "https://stanley1.xiaomy.net/biMiniProgram/user",
              data: { nickName: nickName },
              //url: 'https://stanley1.xiaomy.net/bireport/user_execute',
              //url: 'http://localhost:8080/miniProgarm/user_execute',
              success(res) {
                flag = res.data

              }
            })
            that.setData({
              userInfo: res.userInfo,
              hasUserInfo: true
            })
          }
        })
        
      }
    })
  },
  //跳转设置页面授权
  openSetting: function () {
    var that = this
    if (wx.openSetting) {
      wx.openSetting({
        success: function (res) {
          console.log(9);
          //尝试再次登录
          that.login()
        }
      })
    } else {
      wx.showModal({
        title: '授权提示',
        content: '小程序需要您的微信授权才能使用哦~ 错过授权页面的处理方法：删除小程序->重新搜索进入->点击授权按钮'
      })
    }
  }
})