<%-- 
    Document   : updateJadwal
    Created on : Mar 22, 2020, 9:26:56 PM
    Author     : fahmi.ali
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
        <form:form id="jadwalUpdate" action="updateJadwal.htm" modelAttribute="jadwalDto" method="POST">
            <form:hidden path="id_jadwal" value="${jadwalDto.id_jadwal}" />
        <center><table>      
                <tr>
                    <td>Nama Jadwal :</td>
                    <td><form:input path="nama_jadwal" id="nm" value="${jadwalDto.nama_jadwal}"/></td>
                </tr>
                <tr>
                    <td>Id Paket :</td>
                    <td><form:input path="id_paket" id="idp" value="${jadwalDto.id_paket}"/></td>
                </tr>
                <tr>
                    <td>Tanggal Berangkat :</td>
                    <td><form:input path="tanggal_berangkat" id="tgb" value="${jadwalDto.tanggal_berangkat}"/></td>
                </tr>
                <tr>
                    <td>Tanggal Kembali :</td>
                    <td><form:input path="tanggal_kembali" id="tgk" value="${jadwalDto.tanggal_kembali}"/></td>
                </tr>
                <tr>
                    <td colspan="2">
                        <form:button type="submit" id="update">Save</form:button>
                        </td>
                    </tr>
                </table>
            </center>
    </form:form>
    </body>
</html>
