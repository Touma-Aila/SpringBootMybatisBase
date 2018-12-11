(function() {
  //控制命名规则：首字母大写的双驼峰表达式
  //目录名称页面名称Ctrl
  //也就是和html同步，但是要匹配驼峰
  //例如demo.html==>PageInfoIndexCtrl，/test/demo.html==>TestPageInfoIndexCtrl
  var ctrls = angular.module('controllers');
  ctrls.controller('PageInfoIndexCtrl', [
    '$scope',
    '$log',
    'DataService',
    'DialogService',
    PageInfoIndexCtrl
  ]);

  function PageInfoIndexCtrl($scope, $log, DataService, DialogService) {
    $log.debug('PageInfoIndexCtrl init...');

    // 处理scope销毁
    $scope.$on('$destroy', function() {
      $log.debug('PageInfoIndexCtrl destroy...');
    });

    $scope.tbPageInfo = {};

    $scope.add = function() {
      DialogService.showWait('数据添加中...');
      DataService.send(
        '/pageinfo/add',
        { tbPageInfo: $scope.tbPageInfo },
        function(data) {
          DialogService.hideWait();
          if (data.success) {
            $scope.tbPageInfo = {};
            $scope.query();
            return;
          }
          DialogService.showAlert(data.message);
        }
      );
    };

    $scope.page = { pageNumber: 1, pageSize: 5 };

    $scope.query = function() {
      DialogService.showWait('数据查询中');
      DataService.send('/pageinfo/queryAll', { page: $scope.page }, function(
        data
      ) {
        DialogService.hideWait();
        if (data.success) {
          $scope.page = data.datas.page;
          $scope.list = data.datas.list;
          return;
        }
        DialogService.showAlert(data.message);
      });
    };
    $scope.query();
  }
})();
