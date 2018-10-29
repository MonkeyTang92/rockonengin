<@override name="head">
<title>404错误</title>
</@override>

<@override name="body" >
<div class="error-container">
    <div class="well">
        <h1 class="grey lighter smaller">
            <span class="blue bigger-125">
                <i class="ace-icon fa fa-sitemap"></i>
                404
            </span>
            资源没有被发现
        </h1>

        <hr/>
        <h3 class="lighter smaller">当前系统不存在该资源:<a href="${path!""}" target="_self" >${path!""}</a>!</h3>
        <div>
            <div class="space"></div>
            <h4 class="smaller">可以尝试以下几种方式:</h4>
            <ul class="list-unstyled spaced inline bigger-110 margin-15">
                <li>
                    <i class="ace-icon fa fa-hand-o-right blue"></i>
                    再次点击URL
                </li>
                <li>
                    <i class="ace-icon fa fa-hand-o-right blue"></i>
                    阅读faq
                </li>
                <li>
                    <i class="ace-icon fa fa-hand-o-right blue"></i>
                    联系后台开发同事
                </li>
            </ul>
        </div>
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