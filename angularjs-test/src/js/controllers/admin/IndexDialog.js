(function() {
  var ctrls = angular.module('controllers');
  ctrls.controller('AdminIndexDialogCtrl', [
    '$scope',
    '$log',
    'DialogService',
    AdminIndexDialogCtrl
  ]);

  function AdminIndexDialogCtrl($scope, $log, DialogService) {
    $log.debug('AdminIndexDialogCtrl init...');

    // 处理scope销毁
    $scope.$on('$destroy', function() {
      $log.debug('AdminIndexDialogCtrl destroy...');
    });

    //获取定制对话框传递的数据
    $scope.cdata = DialogService.getCustomData();

    $scope.close = function() {
      //关闭定制对话框
      DialogService.hideCustom();
    };

    //测试按钮 处理数据并回转
    $scope.process = function() {
      //调用传递的scope对象中定义的方法
      $scope.cdata.pscope.changeCdata({ data: $scope.cdata.username });
      DialogService.hideCustom();
    };

    $scope.close = function() {
      DialogService.hideCustom();
    };
  }
})();
