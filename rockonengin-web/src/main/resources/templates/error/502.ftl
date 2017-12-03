<@override name="head">
<title>500错误</title>
</@override>

<@override name="body" >
<div class="error-container">
    <div class="well">
        <h1 class="grey lighter smaller">
            <span class="blue bigger-125">
                <i class="ace-icon fa fa-sitemap"></i>
                500
            </span>
            服务器内部错误！
        </h1>
        <hr/>
        <div class="space"></div>
    </div>
</div>

</@override>

<@override name="bodyTail">
</@override>

<@override name="tail">
<script>
    (function ($) {


    })(jQuery);
</script>
</@override>

<@extends name="/commons/errorBase.ftl"/>