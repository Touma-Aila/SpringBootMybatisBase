(function() {
  angular.element(document).ready(function() {
    var ctrls = angular.module('controllers');
    ctrls.controller('MyCtrl', [
      '$scope',
      '$log',
      '$timeout',
      '$interval',
      '$location',
      MyCtrl
    ]);

    function MyCtrl($scope, $log, $timeout, $interval, $location) {
      $log.debug('in MyCtrl init...');

      // 处理scope销毁
      $scope.$on('$destroy', function() {
        //如果开了定时任务一定要在控制器销毁时中断
        if ($scope.timer) {
          $interval.cancel($scope.timer);
        }
        $log.debug('MyCtrl destroy...');
      });

      //延时控制div消失
      $scope.showDiv = true;
      //$timeout就是js里面setTimeout，但是$timeout更改变量会体现在页面上
      //第一个参数是延时执行的function，第二个参数是延时时间
      //返回值是用于取消延时任务的timer的id
      var timer = $timeout(function() {
        $scope.showDiv = false;
      }, 5000);

      $scope.cancelHideDiv = function() {
        //通过timer的id取消延时任务,$timeout.cancel(timer的id)
        $timeout.cancel(timer);
      };

      //获取当前时间
      function getNowTime() {
        var date = new Date();
        //年份
        var year = date.getFullYear();
        //月份
        var month = date.getMonth() + 1;
        //日期
        var day = date.getDate();
        //时
        var hour = date.getHours();
        //分
        var minute = date.getMinutes();
        //秒
        var second = date.getSeconds();

        var result = year + '年' + month + '月' + day + '日 ';
        result = result + hour + ':' + minute + ':' + second;
        return result;
      }

      $scope.nowtime = getNowTime();

      //$intervel就是js里面的setIntervel 区别一样是可以更新状态
      //第一个参数定时执行的function 第二个参数是时间间隔
      //返回值也是用户清除timer的id
      $scope.timer = $interval(function() {
        $scope.nowtime = getNowTime();
      }, 1000);

      //$location就是js中location对象封装，并且提供了路由的支持
      //http://127.0.0.1/ng008.html#!/sadf?abc=def&hh=11
      //path()是读取和设置路由地址
      //absUrl()是读写完整url地址
      //url()是带查询参数的路由地址（就是#符号后面的地址）
      //search()就是?后面的查询字符串
      $scope.locInfo = {
        path: $location.path(),
        absUrl: $location.absUrl(),
        url: $location.url(),
        qs: $location.search()
      };

      $scope.changeLocation = function() {
        $location.search({ name: 'main', password: 'pwd-123', id: [1, 2, 3] });
        $location.hash('abc123');
        $location.path('/abc/def');
      };

      //切换tab=====================
      //面板的数据(真正的项目中是来自数据库)
      $scope.tabs = [
        { id: 100, title: '首页', page: 'ng008-1.html' },
        { id: 101, title: '贴吧', page: 'ng008-2.html' },
        { id: 102, title: '微博', page: 'ng008-3.html' }
      ];

      $scope.changeTab = function(tab) {
        $log.debug(tab);
        $scope.selectedTab = tab;
      };

      var urltab = $location.search().tab;
      urltab = isNaN(urltab) ? 0 : parseInt(urltab);
      urltab = urltab < 0 ? 0 : urltab;
      urltab = urltab >= $scope.tabs.length ? $scope.tabs.length - 1 : urltab;
      $log.debug(urltab,$location.search())
      $scope.changeTab($scope.tabs[urltab]);
    }
  });
})();
