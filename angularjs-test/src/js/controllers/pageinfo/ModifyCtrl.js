(function() {
  //控制命名规则：首字母大写的双驼峰表达式
  //目录名称页面名称Ctrl
  //也就是和html同步，但是要匹配驼峰
  //例如demo.html==>ModifyCtrl，/test/demo.html==>TestModifyCtrl
  var ctrls = angular.module('controllers');
  ctrls.controller('ModifyCtrl', [
    '$scope',
    '$log',
    'DataService',
    'DialogService',
    ModifyCtrl
  ]);

  function ModifyCtrl($scope, $log, DataService, DialogService) {
    $log.debug('ModifyCtrl init...');

    // 处理scope销毁
    $scope.$on('$destroy', function() {
      $log.debug('ModifyCtrl destroy...');
    });

    var info = DialogService.getCustomData();
    $log.debug(info);

    DataService.send('/pageinfo/queryByKey', { tbPageInfo: info }, function(
      data
    ) {
      if (data.success && data.datas && data.datas.info) {
        $scope.tbPageInfo = data.datas.info;
        return;
      }
      DialogService.showAlert(data.message, function() {
        DialogService.hideCustom();
      });
    });

    $scope.close = function() {
      DialogService.hideCustom();
    };

    $scope.modify = function() {
      DialogService.showWait('数据修改中...');
      DataService.send(
        '/pageinfo/modify',
        { tbPageInfo: $scope.tbPageInfo },
        function(data) {
          DialogService.hideWait();
          DialogService.showAlert(data.message, function() {
            DialogService.hideCustom();
          });
        }
      );
    };
  }
})();
