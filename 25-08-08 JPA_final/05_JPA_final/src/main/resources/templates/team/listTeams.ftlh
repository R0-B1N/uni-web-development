<#include "../base/layout.ftlh">
<#include "../util/icons.ftlh">

<#macro list_team team>
    <div class="list-group-item list-group-item-action d-flex gap-3 py-3">
        <@icon "bi-people-fill"/>
        <div class="d-flex gap-2 w-100 justify-content-between">
            <div>
                <h6 class="mb-0">${team.name}</h6>
                <p class="mb-0 opacity-75">
                    Team-Code: ${team.code}
                </p>
            </div>
            <a href="/team/create/${team.id?string.computer}">
                <@icon "bi-pencil-square"/>
            </a>
        </div>
    </div>
</#macro>

<#macro content>
    <h1>Team Verwaltung</h1>
    <div class="list-group index_list_group">
        <#if teamList?size == 0>
            <p>
                Die Teamliste ist zur Zeit noch leer.
            </p>
        </#if>
        <#list teamList as team>
            <@list_team team/>
        </#list>
    </div>
</#macro>

<@html/>
