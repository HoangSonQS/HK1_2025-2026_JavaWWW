<%@ include file="Header.jsp" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<div class="form-container">
    <h2 style="text-align: center;">
        <c:choose>
            <c:when test="${dienThoai.maDT == 0}">
                Thêm Điện Thoại Mới
            </c:when>
            <c:otherwise>
                Cập Nhật Điện Thoại
            </c:otherwise>
        </c:choose>
    </h2>

    <c:if test="${not empty uploadError}">
        <p style="color: red; text-align: center;">${uploadError}</p>
    </c:if>

    <form:form action="${pageContext.request.contextPath}/dienthoai-jsp/save"
               modelAttribute="dienThoai" method="POST" enctype="multipart/form-data">

        <form:hidden path="maDT"/>

        <div class="form-row">
            <form:label path="tenDT">Tên Điện Thoại (*)</form:label>
            <div>
                <form:input path="tenDT" id="tenDT" required="true" cssClass="form-control"/>
                <form:errors path="tenDT" cssClass="form-error"/>
            </div>
        </div>
        <div class="form-row">
            <form:label path="namSanXuat">Năm Sản Xuất (YYYY) (*)</form:label>
            <div>
                <form:input path="namSanXuat" id="namSanXuat" type="number" required="true" pattern="\d{4}"
                            title="Năm sản xuất là 4 chữ số" cssClass="form-control"/>
                <form:errors path="namSanXuat" cssClass="form-error"/>
            </div>
        </div>
        <div class="form-row">
            <form:label path="cauHinh">Cấu hình (*)</form:label>
            <div>
                <form:textarea path="cauHinh" id="cauHinh" required="true" maxlength="255" cssClass="form-control"/>
                <form:errors path="cauHinh" cssClass="form-error"/>
            </div>
        </div>
        <div class="form-row">
            <form:label path="nhaCungCap">Nhà Cung Cấp (*)</form:label>
            <div>
                <form:select path="nhaCungCap" id="nhaCungCap" required="true" cssClass="form-control">
                    <form:option value="">-- Chọn NCC --</form:option>
                    <form:options items="${dsNhaCungCap}" itemValue="maNCC" itemLabel="tenNhaCC"/>
                </form:select>
                <form:errors path="nhaCungCap" cssClass="form-error"/>
            </div>
        </div>
        <div class="form-row">
            <label for="imageFile">Hình ảnh (png, jpg, jpeg)</label>
            <div>
                <input type="file" name="imageFile" id="imageFile" accept=".png,.jpg,.jpeg" class="form-control"/>
                <c:if test="${not empty dienThoai.hinhAnh}">
                    <img src="${pageContext.request.contextPath}/uploaded-images/${dienThoai.hinhAnh}" alt="Ảnh hiện tại" style="max-width: 100px; margin-top: 10px;"/>
                </c:if>
            </div>
        </div>

        <div class="button-group">
            <button type="submit" class="btn btn-success">Lưu</button>
            <a href="${pageContext.request.contextPath}/dienthoai-jsp/list" class="btn btn-secondary">Quay Lại</a>
        </div>

    </form:form>
</div>

<%@ include file="Footer.jsp" %>