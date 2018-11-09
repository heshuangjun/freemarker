<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>freemarker模板</title>
</head>
<body>
<#-- freemarker插值的格式: ${...} -->
${name}
    Hello!What a mysterious world it is!
    There had the lovable micro-organism , u will like them!
    The cute little opossum has a number of tricks up its defensive sleeve
    I like many animals.
    They are tiger, monkey, dog, lion, elephant and so on… Dog is my favorite animal.
    Because it is very lovely and honest.
    The cute little opossum has a number of tricks up its defensive sleeve.
    Thank you!
    <br/>
==========================================================================================
<#-- 定义变量的赋值指定 -->
<#assign linkman="Susan">

<#-- 取值操作:获取联系人 -->
    联系人:${linkman}

<#-- 包含指令 -->
<#include "head.ftl">

<#-- 判断指令 -->
<#if (age<18)>
    恭喜您,已经成年了!可以访问该网站!
    <#else >
    很遗憾,您未成年!不可以访问该网站!
</#if>
==========================================================================================
<#-- 循环遍历 -->
<#list userList as user >
    ${user.id}---${user.name}
</#list>
==========================================================================================
<#-- 获取List长度 :共多少款式型号-->
    共计: ${userList?size}个型号
==========================================================================================
<#-- 定义变量 -->
<#assign user={"id":"1","name":"tom","age":18}>
    学号是:${user.id}
    姓名是:${user.name}
    年龄是:${user.age}
==========================================================================================
<#-- json字符串转化成对象-->
<#assign user='{"id":"2","name":"andy","age":19}'?eval>
    学号是:${user.id}
    姓名是:${user.name}
    年龄是:${user.age}
</body>
</html>