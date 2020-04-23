import * as echarts from '../../ec-canvas/echarts';
import '../../ec-canvas/world.js'
//let url = "http://localhost:8080/userMap";
let url = "https://stanley1.xiaomy.net/biMiniProgram/userMap";
let chart = null;
let dataList = null;
function initChart(canvas, width, height) {
  chart = echarts.init(canvas, null, {
    width: width,
    height: height
  });
  canvas.setChart(chart);
  return chart;
};
Page({

  /**
   * 页面的初始数据
   */
  data: {
    ec: {
      onInit: initChart
    }
  },

  /**
   * 生命周期函数--监听页面加载
   */  
  onReady() {
    //var url = "http://10.10.21.52:8080/userMap_execute";    
    this.getData(url);
  },
  getData(url) { //请求后台数据
    var that = this;
    wx.showLoading({
      title: '加载中',
    });
    wx.request({
      url: url,      
      success: function (res) {        
        dataList =  res.data.result;        
        chart.clear();
        chart.setOption( {
          backgroundColor: '#404a59',
          title: {
            text: "玩家分布",
            subtext: "",
            left: 'center',
            textStyle: {
              color: '#fff'
            }
          },
          visualMap: {
            type: 'piecewise',
            show: true,
            symbolSize:50,
            pieces: [
              { min: 1000000 }, // 不指定 max，表示 max 为无限大（Infinity）。
              { min: 10000, max: 1000000 },
              { min: 10000, max: 100000 },
              { min: 1000, max: 10000 },
              { min: 100, max: 1000 },
              { min: 1, max: 100 },
              { value: 0,  color: 'grey' }, // 表示 value 等于 0 的情况。           
              
            ],            
            realtime: true,
            calculable: true,
            color: ["#d94e5d","#eac736","#50a3ba"],
            hoverLink: true,
            textStyle: {
              color: '#fff'
            }
          },
          tooltip: {
            trigger: "item",
            formatter: function (param) {
              //console.log(param)
              // 利用循环更改显示的内容
              let list = param.length
              console.log(param.data.name)              
              return param.data.name + ":" + param.data.value
              },
            orient: 'vertical',
            top: 'bottom',
            left: 'right',            
            textStyle: {
              color: '#fff'
            }
          },
          geo: {
            map: "world",
            label: {
              emphasis: {
                show: false
              }
            },
            itemStyle: {
              normal: {
                areaColor: '#323c48',
                borderColor: '#111'
              },
              emphasis: {
                areaColor: '#2a333d'
              }
            },        
          },
          //配置属性
          series: [
            {
              name: "数据",
              type: "map",
              mapType: "world",
              roam: false,
              label: {
                normal: {
                  show: false //省份名称
                },
                emphasis: {
                  show: false
                }
              },
              data: dataList

            }
          ]
        })
        wx.hideLoading();
      },
    });
  }
})
