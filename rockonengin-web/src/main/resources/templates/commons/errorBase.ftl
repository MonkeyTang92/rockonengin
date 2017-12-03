<!DOCTYPE html>
<html lang="zh-cn">
    <head>
        <#include "header.ftl">
        <@block name="head">
            <!--head-->
        </@block>
    </head>
    <body>
        <div class="main-container ace-save-state">
            <div class="main-content">
                <div class="main-content-inner">
                    <div class="page-content" >
                        <div class="row"  >
                            <div class="col-xs-12" >
                                <@block name="body">
                                    <!--body-->
                                </@block>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <@block name="bodyTail">
        <!--bodyTail-->
        </@block>
    </body>
</html>
<@block name="tail">
    <!--extends title-->
</@block>
