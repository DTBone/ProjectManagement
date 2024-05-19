<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Quản lý đề tài nghiên cứu khoa học</title>
    <link rel="stylesheet"
          href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css">

    <style>
        body {
            margin: 0;
            font-family: Arial, sans-serif !important;
            display: flex;
            min-height: 100vh;
        }

        .containerP {
            display: flex;
            height: 100vh;
            margin: 0;
        }

        .sidebar {
            background-color: #f4f4f4;
            box-shadow: 2px 0 5px rgba(0, 0, 0, 0.1);
            display: flex;
            flex-direction: column;
            align-items: flex-start;
            width: 100%;
        }

        .sidebar-btn {
            padding: 10px;
            margin-bottom: 10px;
            text-decoration: none !important;
            color: #333;
            cursor: pointer;
            border-radius: 5px;
            transition: background-color 0.3s;
            display: flex; /* Sử dụng flexbox để căn giữa theo chiều ngang */
            align-items: center; /* Căn giữa theo chiều dọc */
            width: 100%;
        }

        .sidebar-btn i {
            margin-right: 10px; /* Khoảng cách giữa biểu tượng và nội dung */
        }

        .sidebar-btn span {
            margin-left: 10px; /* Khoảng cách giữa nội dung và biểu tượng */
        }

        .sidebar-btn:hover {
            background-color: #ddd;
        }
    </style>
</head>
<body>
<div class="containerP">
    <%--    <input type="hidden" id="csrf_token" name="csrf_token"--%>
    <%--    <c:if test="${csrf_token !=null }"> value="${csrf_token}" </c:if>  >--%>
    <%--    <aside class="sidebar">--%>
    <%--        <a href="AD_TrangChu.jsp" id="home-link" class="sidebar-btn"><i class="fa fa-home"></i>Trang chủ</a>--%>
    <%--        <a href="AD_ThongBao.jsp" id="notification-link" class="sidebar-btn"><i class="fa fa-bell"></i>Thông báo</a>--%>
    <%--        <a href="<%=request.getContextPath()%>/AD/list_account" id="account-management-link" class="sidebar-btn"><i--%>
    <%--                class="fa fa-tasks"></i>Quản lý tài khoản</a>--%>
    <%--        <a href="<%=request.getContextPath()%>/AD/list_giangvien" id="manage-lecturers-link" class="sidebar-btn"><i--%>
    <%--                class="fa fa-check-circle"></i>Quản lý giảng viên</a>--%>
    <%--        <a href="<%=request.getContextPath()%>/AD/show_acadmin" id="personal-page-link" class="sidebar-btn"><i--%>
    <%--                class="fas fa-user"></i>Trang Cá Nhân</a>--%>
    <%--    </aside>--%>
    <aside class="sidebar">
        <a href="<%=request.getContextPath()%>/AD_TrangChu.jsp" class="sidebar-btn"><i
                class="fa fa-home"></i>Trang chủ</a> <a href="<%=request.getContextPath()%>/zAD_ThongBao.jsp"
                                                        class="sidebar-btn"><i class="fa fa-bell"></i>Thông báo</a> <a
            href="<%=request.getContextPath()%>/AD/list_account" class="sidebar-btn"><i class="fa fa-tasks"></i>Quản
        lý tài khoản</a> <a href="<%=request.getContextPath()%>/AD/list_giangvien" class="sidebar-btn"><i
            class="fa fa-check-circle"></i>Quản lý giảng viên</a> <a
            href="<%=request.getContextPath()%>/AD/show_acadmin" class="sidebar-btn"><i
            class="fas fa-user"></i>Trang Cá Nhân</a>


    </aside>
</div>
<%--<script>--%>
<%--    // JavaScript function để thêm CSRF token và chuyển hướng người dùng đến URL--%>
<%--    function goToHomePageWithCSRFToken() {--%>
<%--        // Lấy CSRF token từ trường ẩn--%>
<%--        var csrfToken = document.getElementById('csrf_token').value;--%>
<%--        console.log(csrfToken);--%>
<%--        // URL đích--%>
<%--        var destinationUrl = 'AD_TrangChu.jsp';--%>

<%--        // Thêm CSRF token vào URL--%>
<%--        if (destinationUrl.indexOf('?') === -1) {--%>
<%--            destinationUrl += '?csrf_token=' + encodeURIComponent(csrfToken);--%>
<%--        } else {--%>
<%--            destinationUrl += '&csrf_token=' + encodeURIComponent(csrfToken);--%>
<%--        }--%>

<%--        // Chuyển hướng người dùng đến URL đã được xử lý--%>
<%--        window.location.href = destinationUrl;--%>
<%--    }--%>

<%--    // Gắn sự kiện click vào thẻ <a>--%>
<%--    document.getElementById('home-link').addEventListener('click', function (event) {--%>
<%--        // Ngăn chặn hành vi mặc định của thẻ <a>--%>
<%--        event.preventDefault();--%>

<%--        // Gọi hàm goToHomePageWithCSRFToken()--%>
<%--        goToHomePageWithCSRFToken();--%>
<%--    });--%>
<%--</script>--%>
<%--<script>--%>
<%--    // JavaScript function để thêm CSRF token và chuyển hướng người dùng đến URL--%>
<%--    function goToNotificationPageWithCSRFToken() {--%>
<%--        // Lấy CSRF token từ trường ẩn--%>
<%--        var csrfToken = document.getElementById('csrf_token').value;--%>
<%--        console.log(csrfToken);--%>
<%--        // URL đích--%>
<%--        var destinationUrl = 'AD_ThongBao.jsp';--%>

<%--        // Thêm CSRF token vào URL--%>
<%--        if (destinationUrl.indexOf('?') === -1) {--%>
<%--            destinationUrl += '?csrf_token=' + encodeURIComponent(csrfToken);--%>
<%--        } else {--%>
<%--            destinationUrl += '&csrf_token=' + encodeURIComponent(csrfToken);--%>
<%--        }--%>

<%--        // Chuyển hướng người dùng đến URL đã được xử lý--%>
<%--        window.location.href = destinationUrl;--%>
<%--    }--%>

<%--    // Gắn sự kiện click vào thẻ <a>--%>
<%--    document.getElementById('notification-link').addEventListener('click', function (event) {--%>
<%--        // Ngăn chặn hành vi mặc định của thẻ <a>--%>
<%--        event.preventDefault();--%>

<%--        // Gọi hàm goToNotificationPageWithCSRFToken()--%>
<%--        goToNotificationPageWithCSRFToken();--%>
<%--    });--%>
<%--</script>--%>
<%--<script>--%>
<%--    // JavaScript function để thêm CSRF token và chuyển hướng người dùng đến URL--%>
<%--    function goToManageLecturersPageWithCSRFToken() {--%>
<%--        // Lấy CSRF token từ trường ẩn--%>
<%--        var csrfToken = document.getElementById('csrf_token').value;--%>
<%--        console.log(csrfToken);--%>
<%--        // Lấy đường dẫn từ <%=request.getContextPath()%>--%>
<%--        var contextPath = '<%=request.getContextPath()%>';--%>

<%--        // URL đích--%>
<%--        var destinationUrl = contextPath + '/AD/list_giangvien';--%>

<%--        // Thêm CSRF token vào URL--%>
<%--        if (destinationUrl.indexOf('?') === -1) {--%>
<%--            destinationUrl += '?csrf_token=' + encodeURIComponent(csrfToken);--%>
<%--        } else {--%>
<%--            destinationUrl += '&csrf_token=' + encodeURIComponent(csrfToken);--%>
<%--        }--%>

<%--        // Chuyển hướng người dùng đến URL đã được xử lý--%>
<%--        window.location.href = destinationUrl;--%>
<%--    }--%>

<%--    // Gắn sự kiện click vào thẻ <a>--%>
<%--    document.getElementById('manage-lecturers-link').addEventListener('click', function (event) {--%>
<%--        // Ngăn chặn hành vi mặc định của thẻ <a>--%>
<%--        event.preventDefault();--%>

<%--        // Gọi hàm goToManageLecturersPageWithCSRFToken()--%>
<%--        goToManageLecturersPageWithCSRFToken();--%>
<%--    });--%>
<%--</script>--%>
<%--<script>--%>
<%--    // JavaScript function để thêm CSRF token và chuyển hướng người dùng đến URL--%>
<%--    function goToPersonalPageWithCSRFToken() {--%>
<%--        // Lấy CSRF token từ trường ẩn--%>
<%--        var csrfToken = document.getElementById('csrf_token').value;--%>
<%--        console.log(csrfToken);--%>
<%--        // Lấy đường dẫn từ <%=request.getContextPath()%>--%>
<%--        var contextPath = '<%=request.getContextPath()%>';--%>

<%--        // URL đích--%>
<%--        var destinationUrl = contextPath + '/AD/show_acadmin';--%>

<%--        // Thêm CSRF token vào URL--%>
<%--        if (destinationUrl.indexOf('?') === -1) {--%>
<%--            destinationUrl += '?csrf_token=' + encodeURIComponent(csrfToken);--%>
<%--        } else {--%>
<%--            destinationUrl += '&csrf_token=' + encodeURIComponent(csrfToken);--%>
<%--        }--%>

<%--        // Chuyển hướng người dùng đến URL đã được xử lý--%>
<%--        window.location.href = destinationUrl;--%>
<%--    }--%>

<%--    // Gắn sự kiện click vào thẻ <a>--%>
<%--    document.getElementById('personal-page-link').addEventListener('click', function (event) {--%>
<%--        // Ngăn chặn hành vi mặc định của thẻ <a>--%>
<%--        event.preventDefault();--%>

<%--        // Gọi hàm goToPersonalPageWithCSRFToken()--%>
<%--        goToPersonalPageWithCSRFToken();--%>
<%--    });--%>
<%--</script>--%>
<%--<script>--%>
<%--    // JavaScript function để thêm CSRF token và chuyển hướng người dùng đến URL--%>
<%--    function goToAccountManagementPageWithCSRFToken() {--%>
<%--        // Lấy CSRF token từ trường ẩn--%>
<%--        var csrfToken = document.getElementById('csrf_token').value;--%>
<%--        console.log(csrfToken);--%>
<%--        // Lấy đường dẫn từ <%=request.getContextPath()%>--%>
<%--        var contextPath = '<%=request.getContextPath()%>';--%>

<%--        // URL đích--%>
<%--        var destinationUrl = contextPath + '/AD/list_account';--%>

<%--        // Thêm CSRF token vào URL--%>
<%--        if (destinationUrl.indexOf('?') === -1) {--%>
<%--            destinationUrl += '?csrf_token=' + encodeURIComponent(csrfToken);--%>
<%--        } else {--%>
<%--            destinationUrl += '&csrf_token=' + encodeURIComponent(csrfToken);--%>
<%--        }--%>

<%--        // Chuyển hướng người dùng đến URL đã được xử lý--%>
<%--        window.location.href = destinationUrl;--%>
<%--    }--%>

<%--    // Gắn sự kiện click vào thẻ <a>--%>
<%--    document.getElementById('account-management-link').addEventListener('click', function (event) {--%>
<%--        // Ngăn chặn hành vi mặc định của thẻ <a>--%>
<%--        event.preventDefault();--%>

<%--        // Gọi hàm goToAccountManagementPageWithCSRFToken()--%>
<%--        goToAccountManagementPageWithCSRFToken();--%>
<%--    });--%>
<%--</script>--%>
</body>


</html>
