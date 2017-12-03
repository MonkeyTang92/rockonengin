<!DOCTYPE html>
<html lang="zh-cn">
    <head>
        <#include "header.ftl">
        <@block name="head">
            <!--head-->
        </@block>
    </head>
    <body class="body-iframe">
        <div class="wrapper">
            <div class="content-wrapper-iframe">
                <@block name="body">
                    <!--body-->
                </@block>
            </div>
        </div><!-- ./wrapper -->
        <div class="control-sidebar-bg"></div>
        <#include "baseScript.ftl">
        <@block name="bodyTail">
            <!--bodyTail-->
        </@block>
    </body>
</html>
<@block name="tail">
    <!--extends title-->
</@block>
