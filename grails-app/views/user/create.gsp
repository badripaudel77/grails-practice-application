<!DOCTYPE html>
<html>
    <head>
        <meta name="layout" content="main" />
        <g:set var="entityName" value="${message(code: 'user.label', default: 'User')}" />
        <title><g:message code="default.create.label" args="[entityName]" /></title>
    </head>
    <body>
        <h3 style="text-align: center;">Register your account </h3>
        <g:if test="${flash.userNoteCreated}">
           <h4 style="text-align: center; color: red;">Error Message ::: ${flash.userNoteCreated}</h4>
        </g:if>
        <div id="create-user" class="content scaffold-create" role="main" style="margin-left: auto; text-align: center;">
            <g:form method="POST" action="save" style="margin: 30px;">
                <label for="email">Email:</label><br>
                <input type="text" id="email" name="email"><br>
                <label for="password">Password:</label><br>
                <input type="password" id="password" name="password"><br><br>
                <g:submitButton name="create" class="save btn btn-primary"
                                value="Register"/>
                </div>
            </g:form>
        </div>
    </body>
</html>
