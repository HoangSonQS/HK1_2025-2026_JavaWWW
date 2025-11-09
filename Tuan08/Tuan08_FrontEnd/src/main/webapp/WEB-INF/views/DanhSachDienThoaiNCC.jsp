<%-- [Tệp: DanhSachDienThoaiNCC.jsp] --%>
<%@ include file="Header.jsp" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<h1>Danh Sách Điện Thoại</h1>

<div class="header-controls">
    <div class="search-bar">
        <form id="searchNccForm">
            <input type="text" name="keywordNcc" placeholder="Tìm NCC (Tên, ĐC, SĐT)">
            <button type="submit" class="btn btn-secondary">Tìm NCC</button>
        </form>
    </div>
    <a href="${pageContext.request.contextPath}/views/dienthoai/form" class="btn btn-primary">
        Thêm Điện Thoại
    </a>
</div>

<div class="column-container">
    <div class="supplier-column">
        <h3>Nhà Cung Cấp</h3>
        <ul class="supplier-list" id="supplierListContainer">
        </ul>
    </div>

    <div class="product-column">
        <h3 style="margin-top: 0;" id="productTitle">
            Vui lòng chọn Nhà Cung Cấp
        </h3>
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
            <tbody id="productListContainer">
            </tbody>
        </table>
        <p id="noProductMessage" style="display: none;">Không có điện thoại nào cho nhà cung cấp này.</p>
    </div>
</div>

<script>

    const API_URL = "http://localhost:8082";

    document.addEventListener("DOMContentLoaded", function () {
        const supplierList = document.getElementById("supplierListContainer");
        const productList = document.getElementById("productListContainer");
        const productTitle = document.getElementById("productTitle");
        const noProductMsg = document.getElementById("noProductMessage");
        const searchForm = document.getElementById("searchNccForm");
        const searchInput = searchForm.querySelector("input[name='keywordNcc']");

        let currentMaNcc = null;

        async function fetchAPI(url) {
            const response = await fetch(url);
            if (!response.ok) {
                throw new Error("Lỗi gọi API: " + response.statusText);
            }
            return await response.json();
        }

        async function loadNhaCungCap(keyword = "") {
            supplierList.innerHTML = "<li>Đang tải...</li>";
            try {
                const url = keyword
                    ? `http://localhost:8082/api/nhacungcap?keyword=${keyword}`
                    : `http://localhost:8082/api/nhacungcap`;

                const dsNhaCungCap = await fetchAPI(url);
                supplierList.innerHTML = ""; // Xóa

                dsNhaCungCap.forEach(ncc => {
                    const li = document.createElement("li");
                    li.className = "supplier-item";
                    li.innerHTML = `<a href="#" data-maNcc="${ncc.maNCC}">${ncc.tenNhaCC}</a>`;
                    console.log(ncc.maNCC)
                    console.log(ncc.tenNhaCC)
                    li.addEventListener("click", (e) => {
                        e.preventDefault();
                        loadDienThoai(ncc.maNCC, ncc.tenNhaCC);
                    });
                    supplierList.appendChild(li);
                });
            } catch (error) {
                console.error(error);
                supplierList.innerHTML = "<li>Lỗi khi tải danh sách.</li>";
            }
        }

        // 2. Tải danh sách Điện thoại khi chọn NCC
        async function loadDienThoai(maNcc, tenNcc) {
            console.log("Hàm loadDienThoai được gọi với maNcc:", maNcc, "và tenNcc:", tenNcc);
            currentMaNcc = maNcc;
            productTitle.textContent = `Điện Thoại của ${tenNcc}`;
            productList.innerHTML = "<tr><td colspan='5'>Đang tải...</td></tr>";
            noProductMsg.style.display = "none";

            // Đánh dấu mục NCC được chọn
            document.querySelectorAll(".supplier-item a").forEach(a => {
                a.classList.remove("active");
                if (a.dataset.mancc == maNcc) {
                    a.classList.add("active");
                }
            });

            try {
                const dsDienThoai = await fetchAPI(`http://localhost:8082/api/dienthoai/ncc/${maNcc}`);
                productList.innerHTML = ""; // Xóa

                if (dsDienThoai.length === 0) {
                    noProductMsg.style.display = "block";
                }

                dsDienThoai.forEach(dt => {

                    const row = document.createElement("tr");

                    const imgUrl = dt.hinhAnh
                        ? `http://localhost:8082/uploaded-images/${dt.hinhAnh}`
                        : ""; // Hình ảnh mặc định nếu cần

                    // Tạo link Sửa/Xóa
                    const updateLink = `${pageContext.request.contextPath}/views/dienthoai/form?id=${dt.maDT}`;

                    row.innerHTML = `
                        <td><img src="${imgUrl}" alt="Ảnh SP" class="product-img"></td>
                        <td>${dt.tenDT}</td>
                        <td>${dt.namSanXuat}</td>
                        <td>${dt.cauHinh}</td>
                        <td>
                            <a href="${updateLink}" class="btn btn-warning btn-sm">Sửa</a>
                            <a href="#" data-id="${dt.maDT}" class="btn btn-danger btn-sm btn-delete">Xóa</a>
                        </td>
                    `;
                    productList.appendChild(row);
                });
            } catch (error) {
                console.error(error);
                productList.innerHTML = "<tr><td colspan='5'>Lỗi khi tải điện thoại.</td></tr>";
            }
        }

        // 3. Xử lý tìm kiếm NCC
        searchForm.addEventListener("submit", (e) => {
            e.preventDefault();
            loadNhaCungCap(searchInput.value);
        });

        // 4. Xử lý xóa (Event Delegation)
        productList.addEventListener("click", async function(e) {
            if (e.target.classList.contains("btn-delete")) {
                e.preventDefault();
                const id = e.target.dataset.id;
                if (confirm("Bạn chắc chắn muốn xóa?")) {
                    try {
                        const response = await fetch(`http://localhost:8082/api/dienthoai/${id}`, {
                            method: "DELETE"
                        });

                        if (response.ok) {
                            alert("Xóa thành công!");
                            // Tải lại danh sách điện thoại của NCC hiện tại
                            if(currentMaNcc) {
                                const currentNcc = document.querySelector(".supplier-item a.active");
                                loadDienThoai(currentMaNcc, currentNcc.textContent.trim());
                            }
                        } else {
                            const errorText = await response.text();
                            alert("Xóa thất bại: " + errorText);
                        }
                    } catch (error) {
                        console.error(error);
                        alert("Lỗi khi xóa.");
                    }
                }
            }
        });

        // Tải NCC khi trang được mở
        loadNhaCungCap();
    });
</script>

<%@ include file="Footer.jsp" %>