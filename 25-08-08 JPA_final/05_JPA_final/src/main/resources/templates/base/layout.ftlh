<#macro head>
    <head>
        <base href="http://localhost:8080/">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>
            <#if page_title??>
                ${page_title}
            <#else>
                05_JPA
            </#if>
        </title>
        <link rel="stylesheet" href="webjars/bootstrap/5.3.3/css/bootstrap.min.css">
<#--        <link rel="stylesheet" href="css/custom.css">-->
        <script rel="script" src="webjars/bootstrap/5.3.3/js/bootstrap.bundle.min.js"></script>
    </head>
</#macro>

<#macro content>
    <div/>
</#macro>

<#macro body>
    <body>
    <#include "nav.ftlh">
    <div class="container">
        <@content/>
    </div>
    <div class="container">
        <#include "footer.ftlh">
    </div>
    </body>
</#macro>

<#macro html>
    <!DOCTYPE html>
    <html lang="de">
    <@head/>
    <@body/>
    </html>
</#macro>
