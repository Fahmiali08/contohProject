<%-- 
    Document   : DataJadwal
    Created on : Nov 8, 2019, 6:44:29 PM
    Author     : user
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Travel Umroh | Mihrab Qolbi</title>
    </head>
    <body>
        <h1 align="center">Data Jadwal</h1>
        <c:url var="tambahDataJadwal" value="/doTambahDataJadwal.htm">        
        </c:url>
        <button><a href="${tambahDataJadwal}">Tambah Jadwal</a></button><br>
        <table border="1" align="center">
            <tr>
                <th>No</th> 
                <th>Id Jadwal</th>            
                <th>Nama Jadwal</th>
                <th>Id Paket</th>            
                <th>tanggal Berangkat</th>
                <th>Tanggal Kembali</th>
                <th colspan="2">Aksi</th>
            </tr> 
            <c:set var="index" value="1"/>
            <c:forEach var="dataJadwal" items="${DataJadwalDTO}">
                <tr>  
                    <td>${index}</td>
                    <td>${dataJadwal.id_jadwal}</td>
                    <td>${dataJadwal.nama_jadwal}</td>
                    <td>${dataJadwal.id_paket}</td>
                    <td>${dataJadwal.tanggal_berangkat}</td>
                    <td>${dataJadwal.tanggal_kembali}</td>
                    <c:url var="deleteJadwal" value="/deleteDataJadwal.htm">
                        <c:param name="id_jadwal" value="${dataJadwal.id_jadwal}"/>
                    </c:url>
                    <c:url var="updateJadwal" value="/getDataUpdateJadwal.htm">
                        <c:param name="id_jadwal" value="${dataJadwal.id_jadwal}"/>
                    </c:url>
                    <td><a href="${updateJadwal}">Update</a></td>
                    <td><a href="${deleteJadwal}">Delete</a></td>
                </tr>            
                <c:set var="index" value="${index+1}"/>
            </c:forEach>
        </table>
    </body>
</html>
