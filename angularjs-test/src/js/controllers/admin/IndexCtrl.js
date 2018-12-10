(function() {
  var ctrls = angular.module('controllers');
  ctrls.controller('AdminIndexCtrl', [
    '$scope',
    '$log',
    '$timeout',
    'DialogService',
    AdminIndexCtrl
  ]);

  function AdminIndexCtrl($scope, $log, $timeout, DialogService) {
    $log.debug('AdminIndexCtrl init...');

    // 处理scope销毁
    $scope.$on('$destroy', function() {
      $log.debug('AdminIndexCtrl destroy...');
    });

    $scope.dialog01 = function() {
      //确定(alert)对话框
      //第一个参数是必填 对话框显示的信息
      //第二个参数是可选 对话框关闭后的回调方法
      DialogService.showAlert('确定对话框', function() {
        $log.debug('关闭对话框');
      });
    };

    $scope.dialog02 = function() {
      //设置临时的标题和对话框按钮文本 只会生效一次
      //标题是对所有对话框有效
      DialogService.setTempDialogTitle('自定义对话框');
      DialogService.setAlertBtnOk('自定义按钮');
      DialogService.showAlert('自定义信息');
    };

    $scope.dialog03 = function() {
      //确定对话框
      //第二个参数(可选) 用户点击确定后的回调
      //第三个参数(可选 如果填写 就必须指定第二个参数)
      //用户点击取消后的回调
      DialogService.showConfirm(
        '是否继续',
        function() {
          $log.debug('选择了继续');
        },
        function() {
          $log.debug('选择了取消');
        }
      );
    };

    $scope.dialog04 = function() {
      DialogService.setConfirmBtnYes('继续');
      DialogService.setConfirmBtnNo('要不起');
      DialogService.showConfirm(
        '是否继续自定义',
        function() {
          $log.debug('管上');
        },
        function() {
          $log.debug('要不起');
        }
      );
    };

    $scope.dialog05 = function() {
      DialogService.showWait('后台数据处理中 请稍候..', function() {
        $log.debug('等待对话框关闭');
      });
      //模拟延时关闭等待对话框
      $timeout(function() {
        DialogService.hideWait();
      }, 3000);
    };

    //传递数据
    $scope.cdata = {};

    //更改cdata的方法
    $scope.changeCdata = function(cdata) {
      $scope.cdata = cdata;
    };

    $scope.dialog06 = function() {
      //自定义对话框
      //第一个参数 是定制对话框的页面
      //第二个参数(可选) 传递给页面的数据
      //第三个参数(可选) 关闭对话框的回调函数(一般不会用)
      DialogService.showCustom(
        'templates/admin/Index-dialog.html',
        { username: '测试用户', pscope: $scope },
        function() {
          $log.debug('关闭定制对话框');
        }
      );
    };
  }
})();
