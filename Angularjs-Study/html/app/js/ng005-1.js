//业务逻辑
angular.element(document).ready(function() {
  var ctrls = angular.module('controllers');
  //多个控制器
  ctrls.controller('MyCtrl1', ['$scope', '$log', MyCtrl1]);

  function MyCtrl1($scope, $log) {
    $log.debug('in MyCtrl1 init...');

    //处理scope销毁
    $scope.$on('$destroy', function() {
      $log.debug('MyCtrl1 destroy...');
    });

    //业务逻辑
    $scope.welcome = '全选反选演示';

    //多选数据
    $scope.datas = [
      { id: 100, info: '电影', title: '漫威DC', selected: false },
      { id: 101, info: '音乐', title: 'Amier', selected: false },
      { id: 102, info: '游戏', title: '赛博朋克2077', selected: false },
      { id: 101, info: '动漫', title: '白色相簿2', selected: false }
    ];

    //计算属性,显示不选中的id列表
    $scope.selectedIds = function() {
      var ids = [];
      for (var i = 0; i < $scope.datas.length; i++) {
        var d = $scope.datas[i];
        if (d.selected) {
          ids.push(d.id);
        }
      }
      return ids.join(',');
    };

    //全选
    $scope.checkAll = false;

    $scope.doCheckAll = function() {
      for (var i = 0; i < $scope.datas.length; i++) {
        var d = $scope.datas[i];
        d.selected = $scope.checkAll;
      }
    };

    //反选
    $scope.doCheckRev = function() {
      for (var i = 0; i < $scope.datas.length; i++) {
        var d = $scope.datas[i];
        d.selected = !d.selected;
      }
    };
  }
});
