$(function() {
  console.log('in login.js...');

  reseForm();

  $('#btnCancel').click(function() {
    reseForm();
  });

  /**
   * 重置表单
   */
  function reseForm() {
    $('#txtUsername').val('');
    $('#txtPassword').val('');
    $('#divError').html('');
    $('#txtUsername').focus();
  }

  /**
   * 登录
   */
  $('#btnLogin').click(function() {
    dataService.send(
      '/user/login',
      {
        'user.username': $('#txtUsername').val(),
        'user.password': $('#txtPassword').val()
      },
      function(data) {
        $('#divError').html('');
        if (data.code == 500) {
          $('#divError').html(data.message);
        }

        if (data.message == '用户名必须填写' || data.message == '用户名不存在') {
          $('#txtUsername').focus();
          return;
        }
        if (data.message == '密码必须填写' || data.message == '密码错误') {
          $('#txtPassword').focus();
          return;
        }
        //alert(data.message);
        /**
         * 'index.html'可以输入'/' '/'表示跳到顶级目录
         */
        location.href='index.html';
      }
    );
  });
});
