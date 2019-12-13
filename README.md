数据库lung
内含两张表
1、user用户表 
name        varchar(255) not null primary key
password    varchar(255) not null

2、pathlogy 病理表
pathology    varchar(50) not null primaty key  病理号
(上面这个主键，中间多了个o，打错了，后面懒得改了)
image       varchar(50) not null              图片号
hospitalID  varchar(50) not null              住院号
name        int not null                      姓名
age         int not null                      年龄
sex         int not null                      性别
（数据库忘干净了，不知道枚举怎么用了，所以干脆用的int，反正0和1一个男一个女就完事了）
diagnosis   varchar(255) not null             病理诊断
big         varchar(255) not null             癌症大小
describe    varchar(255) not null             病情描述
(这里按照给的excel是只有一个描述，但是按照要求里面的图片分成了三个，你们看着塞)
department  varchar(50) not null            送检科室
adate       varchar(50) not null             接受日期
bdate       varchar(50) not null             报告日期
(不要问为什么不用date用的字符串，我不会用)
beg         varchar(255) not null           床号
picture     mediumblob                      图片
(这里没用非空，因为是后面加上的)
