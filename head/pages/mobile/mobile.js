import * as echarts from '../../ec-canvas/echarts';
// 载入工具
//const util = require('../../utils/util.js')

// 全局变量
let chart = null;
let gameList = null;
let seriesList = null;
let platform = "Gamesamba Mobile";
let period = "month";
let periodType = "按日"
let dateList = null;
//let mailUrl = "https://stanley1.xiaomy.net/bireport"
let mailUrl = "https://stanley1.xiaomy.net/biMiniProgram"
let url = mailUrl + "/gamedata";
//let url = "http://10.10.21.52:8080/bireport/PrintServlet";
let buttonCondition = "button1";
let tmpButtonCondition = "button1";
let activeCondition = "condition1";
let notetext = "注：每日北京时间18点左右更新前一天数据，图表时间为美国中部时间"
let tooltip = {
  show: true,
  trigger: "axis",
  formatter: function (param) {
    console.log(param);
    // 利用循环更改显示的内容
    let list = param.length;
    let Oparam = param;
    let txt = param[0].name + "\n";
    let total = 0;
    for (var i = 0; i < list; i++) {
      txt += param[i].seriesName + ":" + param[i].data + '\n';
      total += parseFloat(param[i].data);
    }
    txt = txt + "total:" + total.toFixed(2);
    return txt;
  },
  position: [30, 30]
};
function initChart(canvas, width, height) {
  chart = echarts.init(canvas, null, {
    width: width,
    height: height
  });
  canvas.setChart(chart);
  return chart;
};

Page({
  data: {
    ec: {
      onInit: initChart,
    },
    condition1: "noactive",
    condition2: "noactive",
    condition3: "noactive",
    condition4: "noactive",
    condition5: "noactive",
    notetext: notetext,
    buttonCondition1: "buttonNoactive",
    buttonCondition2: "buttonNoactive",
    buttonCondition3: "buttonNoactive",
    buttonCondition4: "buttonNoactive",
  },
  onReady() {
    //var url = url;
    var type = "loginNum";
    //var platform = "Gamesamba";
    var cnType = "登陆人数";
    periodType = "按日"
    this.getData(url, type, platform, cnType, period, tooltip, periodType);
  },
  tapButton: function (e) {
    buttonCondition = e.target.id;
    activeCondition = "condition1";
    this.tapTab();
  },
  tapTab: function (e) {
    if (e.target.id == "button1" || e.target.id == "button2" || e.target.id == "button3" || e.target.id == "button4") {
      if (e.target.id != "button4") {
        tmpButtonCondition = e.target.id;
      }
      buttonCondition = e.target.id;
    } else {
      activeCondition = e.target.id;
    }
    this.setData({
      condition1: "noactive",
      condition2: "noactive",
      condition3: "noactive",
      condition4: "noactive",
      condition5: "noactive",
      [activeCondition]: "active"
    });
    if (buttonCondition == "button1") {
      periodType = "按日"
      this.setData({
        buttonCondition2: "buttonNoactive",
        buttonCondition1: "buttonActive",
        buttonCondition3: "buttonNoactive",
      })
      tooltip = {
        show: true,
        trigger: "axis",
        formatter: function (param) {
          console.log(param);
          // 利用循环更改显示的内容
          let list = param.length;
          let Oparam = param;
          let txt = param[0].name + "\n";
          let total = 0;
          for (var i = 0; i < list; i++) {
            txt += param[i].seriesName + ":" + param[i].data + '\n';
            total += parseFloat(param[i].data);
          }
          txt = txt + "total:" + total.toFixed(2);
          return txt;
        },
        position: [30, 30]
      };
      notetext = "注：每日北京时间18点左右更新前一天数据，图表时间为美国中部时间";
      period = "month";
      //url = "http://10.10.21.52:8080/bireport/PrintServlet";
      //url = mailUrl + "/bireport/PrintServlet";
      switch (activeCondition) {
        case ("condition1"):
          var type = "loginNum";
          var cnType = "登陆人数";
          this.getData(url, type, platform, cnType, period, tooltip, periodType);
          break;
        case ("condition2"):
          console.log(22)
          var type = "regNum";
          var cnType = "注册人数";
          this.getData(url, type, platform, cnType, period, tooltip, periodType);
          break;
        case ("condition3"):
          console.log(3)
          var type = "topupAmount";
          var cnType = "划拨金额";
          this.getData(url, type, platform, cnType, period, tooltip, periodType);
          break;
        case ("condition4"):
          console.log(5)
          var type = "topupNum";
          var cnType = "划拨次数";
          this.getData(url, type, platform, cnType, period, tooltip, periodType);
          break;
        case ("condition5"):
          console.log(5)
          var type = "topupPer";
          var cnType = "划拨人数";
          this.getData(url, type, platform, cnType, period, tooltip, periodType);
          break;
        default:
      }
    } else if (buttonCondition == "button2") {
      periodType = "按时"
      this.setData({
        buttonCondition1: "buttonNoactive",
        buttonCondition2: "buttonActive",
        buttonCondition3: "buttonNoactive",
      })
      tooltip = {
        show: true,
        trigger: "axis",
        formatter: function (param) {
          console.log(param);
          // 利用循环更改显示的内容
          let list = param.length;
          let Oparam = param;
          var date = new Date(param[0].name);
          var dateStr = date.getFullYear;
          date.setDate(date.getDate() + 1);
          let txt = param[0].name + "\n";
          let total = 0;
          let total1 = 0;
          var index = 0;
          for (var i = 0; i < list / 2; i++) {
            if (param[i].seriesType == 'bar') {
              txt += param[i].seriesName + ":" + param[i].data + '\n';
              total += parseFloat(param[i].data);
              index++;
            } else {
              break;
            }
          }
          txt = txt + "total:" + total.toFixed(2) + '\nyesterday\n';
          for (var i = index; i < list; i++) {
            txt += param[i].seriesName + ":" + param[i].data + '\n';
            total1 += parseFloat(param[i].data);
          }
          txt = txt + "total:" + total1.toFixed(2);
          return txt;
        },
        position: [30, 30]
      };
      notetext = "注：每个整点更新前一小时数据，折线为前一天的数据，图表时间为美国中部时间";
      //url = "http://10.10.21.52:8080/bireport/PrintCurrentServlet";
      //url = mailUrl + "/bireport/PrintCurrentServlet";
      period = "today";
      switch (activeCondition) {
        case ("condition1"):
          console.log(1)
          var type = "loginNum";
          var cnType = "登陆人数";
          this.getData(url, type, platform, cnType, period, tooltip, periodType);

          break;
        case ("condition2"):
          console.log(22)
          var type = "regNum";
          var cnType = "注册人数";
          this.getData(url, type, platform, cnType, period, tooltip, periodType);

          break;
        case ("condition3"):
          console.log(3)
          var type = "topupAmount";
          var cnType = "划拨金额";
          this.getData(url, type, platform, cnType, period, tooltip, periodType);
          break;
        case ("condition4"):
          console.log(4)
          var type = "topupNum";
          var cnType = "划拨次数";
          this.getData(url, type, platform, cnType, period, tooltip, periodType);
          break;
        case ("condition5"):
          console.log(5)
          var type = "topupPer";
          var cnType = "划拨人数";
          this.getData(url, type, platform, cnType, period, tooltip, periodType);
          break;
        default:
      }
    } else if (buttonCondition == "button3") {
      periodType = "按月"
      this.setData({
        buttonCondition1: "buttonNoactive",
        buttonCondition2: "buttonNoactive",
        buttonCondition3: "buttonActive",
      })
      tooltip = {
        show: true,
        trigger: "axis",
        formatter: function (param) {
          console.log(param);
          // 利用循环更改显示的内容
          let list = param.length;
          let Oparam = param;
          //console.log(param);
          var date = new Date(param[0].name);
          var dateStr = date.getFullYear;
          date.setDate(date.getDate() + 1);
          let txt = param[0].name + "\n";
          let total = 0;
          let total1 = 0;
          var index = 0;
          for (var i = 0; i < list / 2; i++) {
            console.log(param[i] + "~~~")
            if (param[i].seriesType == 'bar') {
              txt += param[i].seriesName + ":" + param[i].data + '\n';
              total += parseFloat(param[i].data);
              index++;
            } else {
              break;
            }
          }
          txt = txt + "total:" + total.toFixed(2) + '\nyesterday\n';
          for (var i = index; i < list; i++) {
            txt += param[i].seriesName + ":" + param[i].data + '\n';
            total1 += parseFloat(param[i].data);
          }
          txt = txt + "total:" + total1.toFixed(2);
          return txt;
        },
        position: [30, 30]
      };
      notetext = "注：每个整点更新前一小时数据，折线为前一天的数据，图表时间为美国中部时间";
      //url = "http://10.10.21.52:8080/bireport/PrintCurrentServlet";
      //url = mailUrl + "/bireport/PrintCurrentServlet";
      period = "year";
      switch (activeCondition) {
        case ("condition1"):
          console.log(1)
          var type = "loginNum";
          var cnType = "登陆人数";
          this.getData(url, type, platform, cnType, period, tooltip, periodType);
          break;
        case ("condition2"):
          console.log(22)
          var type = "regNum";
          var cnType = "注册人数";
          this.getData(url, type, platform, cnType, period, tooltip, periodType);

          break;
        case ("condition3"):
          console.log(3)
          var type = "topupAmount";
          var cnType = "划拨金额";
          this.getData(url, type, platform, cnType, period, tooltip, periodType);
          break;
        case ("condition4"):
          console.log(4)
          var type = "topupNum";
          var cnType = "划拨次数";
          this.getData(url, type, platform, cnType, period, tooltip, periodType);
          break;
        case ("condition5"):
          console.log(5)
          var type = "topupPer";
          var cnType = "划拨人数";
          this.getData(url, type, platform, cnType, period, tooltip, periodType);
          break;
        default:
      }
    } else if (buttonCondition == "button4") {
      console.log('aaa')

      wx.navigateTo({
        url: '../index/index',
      })
      buttonCondition = tmpButtonCondition;
    }
    this.setData({
      notetext: notetext
    });
  },
  getData(url, type, platform, cnType, period, tooltip, periodType) { //请求后台数据
    var that = this;
    wx.showLoading({
      title: '加载中',
    });
    wx.request({
      url: url,
      data: {
        type: type,
        platform: platform,
        period: period
      },
      success: function (res) {
        dateList = res.data.date;
        gameList = res.data.gamename;
        seriesList = res.data.series;
        console.log(typeof seriesList)
        platform = res.data.platform;
        var lengend = {
          icon: "circle",
          itemGap: 15,
          itemWidth: 10,
          orient: 'horizontal',
          textStyle: {
            color: "#436EEE",
            fontSize: 8,
          },
          type: "plain",
          top: "30rpx",
          left: "center",
          data: gameList,
          itemWidth: 5,
          itemHeight: 5
        };
        console.log(gameList);
        chart.clear();
        chart.setOption({
          title: {
            text: platform + cnType + periodType + '统计',
            right: 'center',
            textStyle: {
              color: "#436EEE",
              fontSize: 15,
            }
          },
          tooltip: tooltip,
          legend: lengend,
          grid: {
            top: '22%',
            left: '1%',
            right: '3%',
            bottom: '20%',
            containLabel: true
          },
          xAxis: {
            data: dateList,
            splitLine: {
              show: false,
            },
            axisLabel: {
              rotate: 65,
              interval: 4,
              formatter: function (val) {
                var strs = val.split(''); //字符串数组
                var str = ''
                for (var i = 0, s; s = strs[i++];) { //遍历字符串数组
                  str += s;
                  if (!(i % 11)) str += '\n'; //按需要求余
                }
                return str;
              }
            },
          },
          yAxis: {
            splitLine: {
              show: true,
            },
          },
          series: seriesList,
          minInterval: 50,
          type: "value"
        });
        wx.hideLoading();
      },
      fail: function (res) { },
      complete: function (res) { },
    });
  }
});