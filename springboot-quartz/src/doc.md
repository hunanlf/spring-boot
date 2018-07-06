## 动态的定时器
代码在com.yf.quartz.dynamic中<br/>

测试代码在TestDynamic类中，随着项目启动自启动的

测试效果，是给一个数组，数组的长度是双数 <br/>
奇数开启一个定时器，偶数开启一个定时器，一个数字对应一个定时器
LZ这里的cron表达式，是每天10点的这个分钟数调用方法<br/>

注意：数组里面的数据可以从数据库来

## 单独定一个定时器
配置文件在 com.yf.quartz.config.QuartzConfigration 类中<br/>

## 手动配置多个定时器
代码在 com.yf.quartz.web.QuartzController 类中 <br/>

scheduleJob 第一个任务 <br/>
scheduleJob1 第二个任务 <br/>

执行的方法在 com.yf.quartz.task 包下的 Task1 ,Task2 <br/>
c测试方法是访问 /two 方法，就开启2个定时器 <br/>

scheduleUpdateCronTrigger 方法是查询数据库，改变定时器





