(function() {
  var ctrls = angular.module('controllers');
  ctrls.controller('AdminDataCtrl', [
    '$scope',
    '$log',
    'DataService',
    'MyUtilService',
    'DialogService',
    AdminDataCtrl
  ]);

  function AdminDataCtrl(
    $scope,
    $log,
    DataService,
    MyUtilService,
    DialogService
  ) {
    $log.debug('AdminDataCtrl init...');

    // 处理scope销毁
    $scope.$on('$destroy', function() {
      $log.debug('AdminDataCtrl destroy...');
    });

    $scope.echo = '';
    $scope.getWelcome = function() {
      DataService.send('/', { echo: $scope.echo }, function(data) {
        $scope.result = JSON.stringify(data);
        $scope.jsonResult = MyUtilService.trustAsHtml(
          MyUtilService.jsonSyntaxHighlight(
            MyUtilService.formatJson(JSON.stringify(data))
          )
        );
      });
    };

    $scope.user = {};
    $scope.login = function() {
      DialogService.showWait('登录处理中');
      DataService.send('/user/login', { user: $scope.user }, function(data) {
        DialogService.hideWait();
        $scope.result = JSON.stringify(data);
        $scope.jsonResult = MyUtilService.trustAsHtml(
          MyUtilService.jsonSyntaxHighlight(
            MyUtilService.formatJson(JSON.stringify(data))
          )
        );
      });
    };
  }
})();
