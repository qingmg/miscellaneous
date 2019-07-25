# miscellaneous
杂七杂八的案例代码(miscellaneous) -- qingmg's

#### devtools 使用:
1、加入依赖 
```
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-devtools</artifactId>
    <scope>runtime</scope>
</dependency>
```
2、google浏览器加入LiveReload插件，并开启  
3.1、不开启自动build，每次改完项目，build一下，页面自动刷新
3.2、开启自动build  
 1）File - setting - Build* - Make project automatically<勾上>  
 2）按住 ctrl+alt+shift+/，勾选 compile.automake.allow.when.app.running  
3.3、重启项目  
3.4、改完项目页面，浏览器页面自动刷新。