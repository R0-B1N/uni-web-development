<#macro teamItem team>
  <div>
    <h6>${team.name}</h6>
    <p>${team.code}</p>
  </div>
</#macro>

<#list teamList as team>
    <@teamItem team=team />
</#list>