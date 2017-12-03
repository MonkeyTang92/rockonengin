<@override name="head">
    <title>系统异常</title>
</@override>

<@override name="body" >
<div class="error-container">
    <div class="well">
        <h1 class="grey lighter smaller">
            <span class="blue bigger-125">
                <i class="ace-icon fa fa-random"></i>
                系统繁忙
            </span>
            ，请稍后再试!
        </h1>

        <hr />
        <div class="space"></div>

        <div>
            <h4 class="lighter smaller">错误信息如下：</h4>
            <ul class="list-unstyled spaced inline bigger-110 margin-15">
                <li>
                    时间：${timestamp?string("yyyy-MM-dd HH:mm:ss")!}
                </li>
                <li>
                    异常类型：${error!}
                </li>
                <li>
                    状态码：${errorMessage.responseCode!}
                </li>
                <li>
                    异常信息：${errorMessage.responseMessage!}
                </li>
            </ul>
        </div>

        <hr />
        <div class="space"></div>
    </div>
</div>
</@override>

<@override name="bodyTail">
</@override>

<@override name="tail">
</@override>

<@extends name="/commons/errorBase.ftl"/>