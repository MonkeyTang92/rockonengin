<#macro layout>
<html>
	<head>
        <link rel="stylesheet" href="/css/style.css">
	</head>
	<body>
		<#include "header.ftl">
		<div style="text-align:center; font-size:30px;">

			<#include "banner.ftl">
			<#--<#include "menu.ftl">-->

			<#-- 在这里嵌入main contentt -->
			<#nested>


		</div>
		<#include "footer.ftl">
	</body>
</html>
</#macro>