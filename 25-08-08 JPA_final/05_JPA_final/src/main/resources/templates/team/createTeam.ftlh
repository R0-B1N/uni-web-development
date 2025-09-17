<#include "../base/layout.ftlh">
<#include "../util/icons.ftlh">
<#include "../util/messages.ftlh">

<#assign page_title="Team Bearbeitung">

<#macro team_message>
    <#if error??>
        <@error_message error />
    <#elseif success??>
        <@success_message success />
    </#if>
</#macro>

<#macro team_create_form>
    <form action="/team/create" method="post" class="row col-sm-8 mt-5 create_employee_form">
        <#if teamObj?? && teamObj.id??>
            <input type="hidden" name="id" value="${teamObj.id?string.computer}">
        </#if>
        <div class="mb-3 row">
            <label class="form-label" for="name">Team-Name</label>
            <div class="">
                <input type="text" class="form-control" id="name" name="name"
                       value="${(teamObj.name)!}">
            </div>
        </div>
        <div class="mb-3 row">
            <label class="form-label" for="code">Code</label>
            <div class="">
                <input type="text" class="form-control" id="code" name="code"
                       value="${(teamObj.code)!}">
            </div>
        </div>
        <div>
            <div class="submit_wrapper">
                <input type="submit" class="btn btn-primary" value="Speichern">
            </div>
        </div>
    </form>
</#macro>

<#macro content>
    <@team_message/>
    <@team_create_form />
</#macro>

<@html/>
