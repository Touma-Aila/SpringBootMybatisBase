(function() {
  //控制命名规则：首字母大写的双驼峰表达式
  //目录名称页面名称Ctrl
  //也就是和html同步，但是要匹配驼峰
  //例如demo.html==>DemoCtrl，/test/demo.html==>TestDemoCtrl
  var ctrls = angular.module('controllers');
  ctrls.controller('DemoCtrl', ['$scope', '$log', DemoCtrl]);

  function DemoCtrl($scope, $log) {
    $log.debug('DemoCtrl init...');

    // 处理scope销毁
    $scope.$on('$destroy', function() {
      $log.debug('DemoCtrl destroy...');
    });
    
  }
})();