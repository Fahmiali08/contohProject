<%-- 
    Document   : insertJadwal
    Created on : Mar 22, 2020, 8:48:42 PM
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
        <form:form id="idJadwal" action="saveJadwal.htm" modelAttribute="jadwalDto" method="POST">
             <center><table>
                <tr>
                    <td>Id Jadwal :</td>
                    <td><form:input path="id_jadwal"/></td>
                </tr>        
                <tr>
                    <td>Nama Jadwal :</td>
                    <td><form:input path="nama_jadwal" id="nm"/></td>
                </tr>
                <tr>
                    <td>Id Paket :</td>
                    <td><form:input path="id_paket" id="id_pkt"/></td>
                </tr> 
                <tr>
                    <td>Tanggal Berangkat :</td>
                    <td><form:input path="tanggal_berangkat" id="tgl_b"/></td>
                </tr>
                <tr>
                    <td>Tanggal Kembali :</td>
                    <td><form:input path="tanggal_kembali" id="tgl_k"/></td>
                </tr>
                <tr>
                    <td colspan="2">
                        <form:button type="submit" id="save">Save</form:button>
                        </td>
                    </tr>
                </table>
            </center>
        </form:form>
    </body>
</html>
