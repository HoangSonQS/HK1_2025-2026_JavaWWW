<%-- [Tệp: DienThoaiForm.jsp] --%>
<%@ include file="Header.jsp" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<div class="form-container">
    <h2 style="text-align: center;" id="formTitle">
        Thêm Điện Thoại Mới
    </h2>

    <p id="uploadError" style="color: red; text-align: center;"></p>

    <%-- Đây là một form HTML thuần, không dùng <form:form> --%>
    <form id="dienThoaiForm" enctype="multipart/form-data">

        <%-- ID 0 được dùng cho việc thêm mới --%>
        <input type="hidden" id="maDT" name="maDT" value="0"/>

        <div class="form-row">
            <label for="tenDT">Tên Điện Thoại (*)</label>
            <div>
                <input type="text" id="tenDT" name="tenDT" required class="form-control"/>
            </div>
        </div>
        <div class="form-row">
            <label for="namSanXuat">Năm Sản Xuất (YYYY) (*)</label>
            <div>
                <input type="number" id="namSanXuat" name="namSanXuat" required pattern="\\d{4}"
                       title="Năm sản xuất là 4 chữ số" class="form-control"/>
            </div>
        </div>
        <div class="form-row">
            <label for="cauHinh">Cấu hình (*)</label>
            <div>
                <textarea id="cauHinh" name="cauHinh" required maxlength="255" class="form-control"></textarea>
            </div>
        </div>
        <div class="form-row">
            <label for="nhaCungCap">Nhà Cung Cấp (*)</label>
            <div>
                <%-- Dữ liệu NCC sẽ được tải bằng JS --%>
                <select id="nhaCungCap" name="nhaCungCap" required class="form-control">
                    <option value="">-- Chọn NCC --</option>
                </select>
            </div>
        </div>
        <div class="form-row">
            <label for="imageFile">Hình ảnh (png, jpg, jpeg)</label>
            <div>
                <input type="file" name="imageFile" id="imageFile" accept=".png,.jpg,.jpeg" class="form-control"/>
                <%-- Ảnh hiện tại (nếu có) sẽ được JS thêm vào đây --%>
                <div id="currentImageContainer" style="margin-top: 10px;"></div>
            </div>
        </div>

        <div class="button-group">
            <button type="submit" class="btn btn-success">Lưu</button>
            <a href="${pageContext.request.contextPath}/views/dienthoai" class="btn btn-secondary">Quay Lại</a>
        </div>

    </form>
</div>

<script>
    // Định nghĩa API Backend (giống trang danh sách)
    const API_URL = "http://localhost:8082";

    document.addEventListener("DOMContentLoaded", async function () {
        const form = document.getElementById("dienThoaiForm");
        const formTitle = document.getElementById("formTitle");
        const nccSelect = document.getElementById("nhaCungCap");
        const currentImageContainer = document.getElementById("currentImageContainer");
        const errorP = document.getElementById("uploadError");

        // Lấy ID từ URL (nếu có)
        const urlParams = new URLSearchParams(window.location.search);
        const dienThoaiId = urlParams.get('id');

        // Hàm gọi API
        async function fetchAPI(url) {
            const response = await fetch(url);
            if (!response.ok) throw new Error("Lỗi API: " + response.statusText);
            return await response.json();
        }

        // 1. Tải danh sách Nhà Cung Cấp
        async function loadNhaCungCap() {
            try {
                const dsNhaCungCap = await fetchAPI(`http://localhost:8082/api/nhacungcap`);
                dsNhaCungCap.forEach(ncc => {
                    const option = new Option(ncc.tenNhaCC, ncc.maNCC);
                    nccSelect.add(option);
                });
            } catch (error) {
                console.error("Lỗi tải NCC: ", error);
                nccSelect.disabled = true;
            }
        }

        // 2. Tải thông tin điện thoại (nếu là trang Cập nhật)
        async function loadDienThoaiInfo(id) {
            formTitle.textContent = "Cập Nhật Điện Thoại";
            try {
                const dt = await fetchAPI(`http://localhost:8082/api/dienthoai/${id}`);

                document.getElementById("maDT").value = dt.maDT;
                document.getElementById("tenDT").value = dt.tenDT;
                document.getElementById("namSanXuat").value = dt.namSanXuat;
                document.getElementById("cauHinh").value = dt.cauHinh;

                // Cần đợi NCC tải xong
                await loadNhaCungCap();

                if (dt.nhaCungCap) {
                    nccSelect.value = dt.nhaCungCap.maNCC;
                }

                if (dt.hinhAnh) {
                    // Hiển thị ảnh từ Backend
                    currentImageContainer.innerHTML =
                        `<img src="http://localhost:8082/uploaded-images/${dt.hinhAnh}" alt="Ảnh hiện tại" style="max-width: 100px;"/>`;
                }
            } catch (error) {
                console.error("Lỗi tải thông tin điện thoại: ", error);
                errorP.textContent = "Không thể tải thông tin sản phẩm.";
            }
        }

        // 3. Xử lý Submit Form
        form.addEventListener("submit", async function (e) {
            e.preventDefault();
            errorP.textContent = "";

            // Xây dựng đối tượng dienThoai (dạng JSON)
            const dienThoaiData = {
                maDT: document.getElementById("maDT").value,
                tenDT: document.getElementById("tenDT").value,
                namSanXuat: document.getElementById("namSanXuat").value,
                cauHinh: document.getElementById("cauHinh").value,
                nhaCungCap: {
                    maNCC: nccSelect.value // Gửi đối tượng lồng nhau
                }
                // hinhAnh sẽ được xử lý riêng
            };

            // Tạo FormData để gửi tệp và JSON
            const formData = new FormData();

            // 1. Thêm tệp JSON (phải là "Blob" với đúng kiểu)
            formData.append('dienThoai', new Blob([JSON.stringify(dienThoaiData)], {
                type: 'application/json'
            }));

            // 2. Thêm tệp ảnh (nếu có)
            const imageFile = document.getElementById("imageFile").files[0];
            if (imageFile) {
                formData.append('imageFile', imageFile);
            }

            try {
                const response = await fetch(`http://localhost:8082/api/dienthoai`, {
                    method: 'POST',
                    body: formData
                    // Không cần 'Content-Type', FormData tự quản lý
                });

                if (response.ok) {
                    alert("Lưu thành công!");
                    window.location.href = "${pageContext.request.contextPath}/views/dienthoai";
                } else {
                    const errorText = await response.text();
                    errorP.textContent = "Lỗi khi lưu: " + errorText;
                }
            } catch (error) {
                console.error("Lỗi submit: ", error);
                errorP.textContent = "Lỗi mạng, không thể gửi form.";
            }
        });

        // Chạy logic chính
        if (dienThoaiId) {
            // Chế độ Cập nhật
            loadDienThoaiInfo(dienThoaiId);
        } else {
            // Chế độ Thêm Mới - chỉ cần tải NCC
            loadNhaCungCap();
        }
    });
</script>

<%@ include file="Footer.jsp" %>