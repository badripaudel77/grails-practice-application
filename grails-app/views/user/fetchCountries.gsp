<%--
  Created by IntelliJ IDEA.
  User: badripaudel
  Date: 5/28/22
  Time: 8:35 PM
--%>

<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>List of countries from the API</title>
</head>

<style>
    body {
        background-color: #5e5e5e;
        color: white;
        width: 100%;
        height: auto;
        padding: 10px;
        text-align: center;
    }
    table, th, td {
        border:1px solid black;
        text-align: center;
    }
</style>

<body>
<div>
    <g:if test="${countries}">
        <h4>Countries found.</h4>
        <hr>
        <table>
            <tr>
                <th>Country Name</th>
                <th>Country Region</th>
                <th>Country Area</th>
                <th>Country Landlocked</th>
                <th>Country Population</th>
            </tr>
        <g:each in="${countries}" var="country" status="counter">
            <tr>
                <td>${country.name}</td>
                <td>${country.region}</td>
                <td>${country.area}</td>
                <td>${country.isLandlocked}</td>
                <td>${country.population}</td>
            </tr>
        </g:each>
        </table>
        <!-- REF : http://docs.grails.org/3.1.1/ref/Tags/paginate.html -->
        <g:paginate next="Forward" prev="Back" total="${total}" />
    </g:if>

    <g:else test="!${countries}">
        <h4>No Countries found.</h4>
    </g:else>
</div>
</body>
</html>