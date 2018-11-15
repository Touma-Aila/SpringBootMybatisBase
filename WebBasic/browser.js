/* browser.js通过nodejs启动外部浏览器 */
/* 替换浏览器执行文件 所有的\都要换成\\ */
/* 由于浏览器可能在带空格的路径中 而空格在程序执行中执行命令行参数 */
/* 所以要将执行文件路径放置在引导中 空格后面是传递给浏览器要打开的网站 */
const browser =
  '"D:\\GOSICK\\UCBrowser\\Application\\UCBrowser.exe" http://127.0.0.1';
/* nodejs调用外部程序 */
const exec = require('child_process').exec;
exec(browser, function(error) {
  console.log(error);
});
