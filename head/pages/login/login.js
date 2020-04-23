

Page({
  data: {
    //判断小程序的API，回调，参数，组件等是否在当前版本可用。
    canIUse: wx.canIUse('button.open-type.getUserInfo')
  },
 
  onLoad: function () {
    var that = this;  
    wx.login({
      success(res){
        console.log(res.code)

      }
    })  
    // 查看是否授权   
    wx.getSetting({
      success: function (res) {        
        if (res.authSetting['scope.userInfo']) {          
          wx.navigateTo({
            url: '../header/header',
          })
        }
      }
    })
    
  },
  bindGetUserInfo: function (e) {
    if (e.detail.userInfo) {
      console.log(e.detail.userInfo.nickName)
      //用户按了允许授权按钮
      var that = this;
      //插入登录的用户的相关信息到数据库
      
        wx.navigateTo({
          url: '../header/header',
        })
      
      //授权成功后，跳转进入小程序首页
      
    } 
  },
  //获取用户信息接口
  

})