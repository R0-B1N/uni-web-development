<#include "icons.ftlh">

<#macro message alert_message alert_type icon_type>
    <div class="alert ${alert_type} d-flex align-items-center alert-dismissible" role="alert">
        <@icon icon_type/>
        <div>${(alert_message)!}</div>
        <button type="button" class="btn-close" data-bs-dismiss="alert"></button>
    </div>
</#macro>

<#macro success_message alert_message>
    <@message alert_message=alert_message alert_type="alert-success" icon_type="check-circle-fill"/>
</#macro>

<#macro error_message alert_message>
    <@message alert_message=alert_message alert_type="alert-danger" icon_type="exclamation-triangle-fill"/>
</#macro>
