<%-- [Tệp: DanhSachDienThoaiNCC.jsp] --%>
<%@ include file="Header.jsp" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<h1>Danh Sách Điện Thoại</h1>

<div class="header-controls">
    <div class="search-bar">
        <form method="GET" action="${pageContext.request.contextPath}/views/dienthoai">
            <input type="text" name="keywordNcc" placeholder="Tìm NCC (Tên, ĐC, SĐT)" 
                   value="${param.keywordNcc != null ? param.keywordNcc : ''}">
            <button type="submit" class="btn btn-secondary">Tìm NCC</button>
            <c:if test="${param.keywordNcc != null && !param.keywordNcc.isEmpty()}">
                <a href="${pageContext.request.contextPath}/views/dienthoai" class="btn btn-secondary">Xóa tìm kiếm</a>
            </c:if>
        </form>
    </div>
    <a href="${pageContext.request.contextPath}/views/dienthoai/form" class="btn btn-primary">
        Thêm Điện Thoại
    </a>
</div>

<div class="column-container">
    <div class="supplier-column">
        <h3>Nhà Cung Cấp</h3>
        <ul class="supplier-list">
            <c:choose>
                <c:when test="${dsNhaCungCap != null && !dsNhaCungCap.isEmpty()}">
                    <c:forEach var="ncc" items="${dsNhaCungCap}">
                        <li class="supplier-item">
                            <c:url var="nccUrl" value="/views/dienthoai">
                                <c:param name="maNcc" value="${ncc.maNCC}"/>
                                <c:if test="${param.keywordNcc != null && !param.keywordNcc.isEmpty()}">
                                    <c:param name="keywordNcc" value="${param.keywordNcc}"/>
                                </c:if>
                            </c:url>
                            <c:choose>
                                <c:when test="${selectedMaNcc != null && selectedMaNcc == ncc.maNCC}">
                                    <a href="${nccUrl}" class="active">${ncc.tenNhaCC}</a>
                                </c:when>
                                <c:otherwise>
                                    <a href="${nccUrl}">${ncc.tenNhaCC}</a>
                                </c:otherwise>
                            </c:choose>
                        </li>
                    </c:forEach>
                </c:when>
                <c:otherwise>
                    <li>Không có nhà cung cấp nào</li>
                </c:otherwise>
            </c:choose>
        </ul>
    </div>

    <div class="product-column">
        <h3 style="margin-top: 0;">
            <c:choose>
                <c:when test="${selectedTenNcc != null}">
                    Điện Thoại của ${selectedTenNcc}
                </c:when>
                <c:otherwise>
                    Vui lòng chọn Nhà Cung Cấp
                </c:otherwise>
            </c:choose>
        </h3>
        
        <c:if test="${error != null}">
            <div style="color: red; padding: 10px; margin-bottom: 10px;">
                ${error}
            </div>
        </c:if>
        
        <c:choose>
            <c:when test="${selectedMaNcc != null && dsDienThoai != null}">
                <c:choose>
                    <c:when test="${!dsDienThoai.isEmpty()}">
                        <table>
                            <thead>
                                <tr>
                                    <th>Ảnh</th>
                                    <th>Tên ĐT</th>
                                    <th>Năm SX</th>
                                    <th>Cấu hình</th>
                                    <th>Thao tác</th>
                                </tr>
                            </thead>
                            <tbody>
                                <c:forEach var="dt" items="${dsDienThoai}">
                                    <tr>
                                        <td>
                                            <c:choose>
                                                <c:when test="${dt.hinhAnh != null && !dt.hinhAnh.isEmpty()}">
                                                    <img src="http://localhost:8082/uploaded-images/${dt.hinhAnh}" 
                                                         alt="Ảnh SP" class="product-img">
                                                </c:when>
                                                <c:otherwise>
                                                    Không có ảnh
                                                </c:otherwise>
                                            </c:choose>
                                        </td>
                                        <td>${dt.tenDT}</td>
                                        <td>${dt.namSanXuat}</td>
                                        <td>${dt.cauHinh}</td>
                                        <td>
                                            <a href="${pageContext.request.contextPath}/views/dienthoai/form?id=${dt.maDT}" 
                                               class="btn btn-warning btn-sm">Sửa</a>
                                            <a href="${pageContext.request.contextPath}/dienthoai/delete?id=${dt.maDT}&maNcc=${selectedMaNcc}" 
                                               class="btn btn-danger btn-sm" 
                                               onclick="return confirm('Bạn chắc chắn muốn xóa?')">Xóa</a>
                                        </td>
                                    </tr>
                                </c:forEach>
                            </tbody>
                        </table>
                    </c:when>
                    <c:otherwise>
                        <p>Không có điện thoại nào cho nhà cung cấp này.</p>
                    </c:otherwise>
                </c:choose>
            </c:when>
            <c:otherwise>
                <c:if test="${selectedMaNcc == null}">
                    <p>Vui lòng chọn một nhà cung cấp để xem danh sách điện thoại.</p>
                </c:if>
            </c:otherwise>
        </c:choose>
    </div>
</div>

<%@ include file="Footer.jsp" %>
