use SpringBootMyBasic;
truncate table TbConfig;
truncate table TbUser;
truncate table TbToken;
truncate table TbTokenInfo;
/*系统配置数据*/
/*token过期时间配置 值是分钟数*/
insert into TbConfig(configKey,configValue,lastupdate)
values('token.timeout','10',now());
/*默认测试用户*/
insert into TbUser(username,password,nickname)
values('Touma','touma123','冬馬和纱');
/*查询*/
select configKey,configValue,lastupdate from TbConfig;
select username,password,nickname,isEnable,reDate from TbUser;
select token,uid,lastupdate from TbToken;
select token,infoKey,info,lastupdate from TbTokenInfo;