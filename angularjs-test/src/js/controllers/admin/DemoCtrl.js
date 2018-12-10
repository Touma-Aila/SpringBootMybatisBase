(function() {
  //控制命名规则：首字母大写的双驼峰表达式
  //目录名称页面名称Ctrl
  //也就是和html同步，但是要匹配驼峰
  //例如demo.html==>AdminIndexCtrl，/test/demo.html==>TestAdminIndexCtrl
  var ctrls = angular.module('controllers');
  ctrls.controller('AdminIndexCtrl', [
    '$scope',
    '$log',
    'DialogService',
    AdminIndexCtrl
  ]);

  function AdminIndexCtrl($scope, $log, DialogService) {
    $log.debug('AdminIndexCtrl init...');

    // 处理scope销毁
    $scope.$on('$destroy', function() {
      $log.debug('AdminIndexCtrl destroy...');
    });

    $scope.dialog01 = function() {
      DialogService.showAlert('确定对话框');
    };
  }
})();
