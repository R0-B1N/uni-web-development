<#macro addTeam>

<#-- Erfolgs- und Fehlermeldungen anzeigen -->
    <#if successMessage?has_content>
      <div class="alert alert-success">${successMessage}</div>
    </#if>
    <#if errorMessage?has_content>
      <div class="alert alert-danger">${errorMessage}</div>
    </#if>

<#-- Eingabe Form -->
  <form action="/team/add" method="post">
    <div>
      <input type="hidden" name="id" value="${team.id}">
    </div>
    <div>
      <label for="name">Team-Name</label>
      <input type="text" id="name" name="name" value="${(team.name)!}" required>
    </div>
    <div>
      <label for="code">Team-Code</label>
      <input type="text" id="code" name="code" value="${(team.code)!}" required>
    </div>
    <div>
      <input type="submit" value="Team erstellen">
    </div>
  </form>

</#macro>
