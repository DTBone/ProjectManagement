package Admin_Controller;

import java.awt.*;
import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import DAO.P_ThongBaoDAO;
import Model.P_ThongBaoModel;
import Util.CSRFTokenUtil;
import Util.EmailUtility;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Admin_Dao.AD_GiangVienDao;
import Admin_Dao.AD_ThongBaoDao;
import Admin_Model.AD_GiangVien;
import Admin_Model.AD_ThongBao;
import Admin_Model.AD_Admin;

import Admin_Dao.AD_AccountDao;
import Admin_Dao.AD_AdminDao;
import Admin_Model.AD_Account;
import Util.InputValidator;

import static Util.CSRFTokenUtil.validateCSRFToken;


@MultipartConfig
@WebServlet("/AD/*")
public class Controller_Admin extends HttpServlet {
    private static final long serialVersionUID = 1L;

    private AD_GiangVienDao GVDAO;
    private AD_AccountDao ACDAO;
    private AD_AdminDao ADDAO;
    private String host;
    private String port;
    private String user;
    private String pass;

    public void init() {
        GVDAO = new AD_GiangVienDao();
        ACDAO = new AD_AccountDao();
        ADDAO = new AD_AdminDao();
        ServletContext context = getServletContext();
        host = context.getInitParameter("host");
        port = context.getInitParameter("port");
        user = context.getInitParameter("user");
        pass = context.getInitParameter("pass");
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
        String csrfToken = request.getParameter("csrf_token");
        String tieuDe = request.getParameter("tbTieuDe");
        String noiDung = request.getParameter("tbNoiDung");
        String mtkstatus = request.getParameter("mtkstatus");
        String mtkvisible = request.getParameter("mtkvisible");
        String mtk = request.getParameter("mtk");
        String matkupdate = request.getParameter("matkupdate");
        String id = request.getParameter("id");
        String MaTK = request.getParameter("MaTK");
        String password = request.getParameter("password");
        String role = request.getParameter("role");
        String username = request.getParameter("username");
        String GioiTinh = request.getParameter("GioiTinh");
        String HoTen = request.getParameter("HoTen");
        String Image = request.getParameter("Image");
        String MaGV = request.getParameter("MaGV");
        String MaKhoa = request.getParameter("MaKhoa");
        String TrinhDo = request.getParameter("TrinhDo");


//        if (!InputValidator.isValid(csrfToken) || !InputValidator.isValid(tieuDe) || !InputValidator.isValid(noiDung) || !InputValidator.isValid(id) || !InputValidator.isValid(matkupdate) || !InputValidator.isValid(mtk) || !InputValidator.isValid(mtkvisible) || !InputValidator.isValid(mtkstatus) || !InputValidator.isValid(GioiTinh) || !InputValidator.isValid(username) || !InputValidator.isValid(role) || !InputValidator.isValid(password) || !InputValidator.isValid(MaTK) || !InputValidator.isValid(TrinhDo) || !InputValidator.isValid(MaKhoa) || !InputValidator.isValid(MaGV) || !InputValidator.isValid(Image) || !InputValidator.isValid(HoTen)) {
//            response.sendError(HttpServletResponse.SC_FORBIDDEN, "parameter very long.");
//        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
//        if (!CSRFTokenUtil.validateCSRFToken(request)) {
//            response.sendError(HttpServletResponse.SC_FORBIDDEN, "CSRF TOKEN is null.");
//        }
        String csrfToken = request.getParameter("csrf_token");
        String tieuDe = request.getParameter("tbTieuDe");
        String noiDung = request.getParameter("tbNoiDung");
        String mtkstatus = request.getParameter("mtkstatus");
        String mtkvisible = request.getParameter("mtkvisible");
        String mtk = request.getParameter("mtk");
        String matkupdate = request.getParameter("matkupdate");
        String id = request.getParameter("id");
        String MaTK = request.getParameter("MaTK");
        String password = request.getParameter("password");
        String role = request.getParameter("role");
        String username = request.getParameter("username");
        String GioiTinh = request.getParameter("GioiTinh");
        String HoTen = request.getParameter("HoTen");
        String Image = request.getParameter("Image");
        String MaGV = request.getParameter("MaGV");
        String MaKhoa = request.getParameter("MaKhoa");
        String TrinhDo = request.getParameter("TrinhDo");


        // Kiểm tra kích thước của dữ liệu


//        if (!InputValidator.isValid(csrfToken) || !InputValidator.isValid(tieuDe) || !InputValidator.isValid(noiDung) || !InputValidator.isValid(id) || !InputValidator.isValid(matkupdate) || !InputValidator.isValid(mtk) || !InputValidator.isValid(mtkvisible) || !InputValidator.isValid(mtkstatus) || !InputValidator.isValid(GioiTinh) || !InputValidator.isValid(username) || !InputValidator.isValid(role) || !InputValidator.isValid(password) || !InputValidator.isValid(MaTK) || !InputValidator.isValid(TrinhDo) || !InputValidator.isValid(MaKhoa) || !InputValidator.isValid(MaGV) || !InputValidator.isValid(Image) || !InputValidator.isValid(HoTen)) {
//            response.sendError(HttpServletResponse.SC_FORBIDDEN, "parameter very long.");
//        }

        String action = request.getPathInfo();

        try {
            switch (action) {
                // GiangVien

                case "/list_giangvien":
                    listTeachers(request, response);
                    break;

                case "/delete_giangvien":
                    updatevisible(request, response);
                    break;
                case "/show_giangvien":
                    getGiangVienByMaTK(request, response);
                    break;
                case "/update_giangvien":
                    updategv(request, response);
                    break;
                case "/show_updategv":
                    showEditForm(request, response);
                    break;
                case "/new_giangvien":
                    insertGiangVien(request, response);
                    break;

                // Account
                case "/list_account":
                    listAccount(request, response);
                    break;
                case "/new_account":
                    insertTaiKhoan(request, response);
                    break;
                case "/update_taikhoan":
                    updateTaiKhoan(request, response);
                    break;
                case "/show_updatetaikhoan":
                    showEditTaiKhoan(request, response);
                    break;
                case "/delete_account":
                    updatestatus(request, response);
                    break;

                // Admin
                case "/show_acadmin":
                    showADMIN(request, response);
                    break;
                case "/show_updateadmintaikhoan":
                    showEditFormAdmin(request, response);
                    break;
                case "/update_Admin":
                    updatetkadmin(request, response);
                    break;

                // Thông Báo
                case "/XemThongBao":
                    XemThongBao(request, response);
                    break;
                case "/list":
                    XemThongBao(request, response);
                    break;
                case "/ThongBao":
                    XemGV(request, response);
                    break;
                case "/GuiThongBaoGet":
                    GuiThongBaoGet(request, response);
                    response.sendRedirect("/AD_ThongBao.jsp");
                    break;
                case "/GuiEmailThongBao11":
                    GuiEmailThongBao(request, response);
                    break;
                default:
                    RequestDispatcher dispatcher = request.getRequestDispatcher("/Login.jsp");
                    dispatcher.forward(request, response);
                    break;
            }
        } catch (SQLException ex) {
            throw new ServletException(ex);
        }
    }

    private void listTeachers(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, ServletException {
        List<AD_GiangVien> listGV = GVDAO.selectAllGiangVien();
        String csrfToken = request.getParameter("csrf_token");
        String tieuDe = request.getParameter("tieuDe");
//        if (!validateCSRFToken(request)) {
//////            response.sendError(HttpServletResponse.SC_FORBIDDEN, "Invalid CSRF token");
//////            return;
//////        } else
        if (listGV.isEmpty() || listGV == null) {
            response.sendError(HttpServletResponse.SC_FORBIDDEN, "List is null.");
        } else {
            HttpSession session = request.getSession();
            request.setAttribute("listGiangVien", listGV);
            session.setAttribute("tengv", request);
            RequestDispatcher dispatcher = request.getRequestDispatcher("/AD_GiangVien.jsp");
            dispatcher.forward(request, response);
        }
    }

    public void updategv(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
        if (!validateCSRFToken(request)) {
            response.sendError(HttpServletResponse.SC_FORBIDDEN, "Invalid CSRF token");
            return;
        } else {
            try {
                request.setCharacterEncoding("UTF-8");
                String hoTen = request.getParameter("HoTen");
                String email = request.getParameter("Email");
                String trinhDo = request.getParameter("TrinhDo");
                String maKhoa = request.getParameter("MaKhoa");
                String maTK = request.getParameter("MaTK");
                String gioiTinh = request.getParameter("GioiTinh");
                String image = request.getParameter("Image");
                // Kiểm tra đầu vào
                if (InputValidator.isValid(hoTen) && InputValidator.isValid(email) && InputValidator.isValid(trinhDo) && InputValidator.isValid(maKhoa) && InputValidator.isValid(maTK) && InputValidator.isValid(gioiTinh) && InputValidator.isValid(image)) {
                    AD_GiangVien updategvne = new AD_GiangVien(hoTen, email, trinhDo, maKhoa, gioiTinh, image, maTK);
                    GVDAO.updategv(updategvne);
                    response.sendRedirect("list_giangvien");

                } else {
                    response.sendError(HttpServletResponse.SC_FORBIDDEN, "Buffer overflow");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void updatevisible(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
        try {
            request.setCharacterEncoding("UTF-8");
            String maTK = request.getParameter("mtkvisible");
            if (!validateCSRFToken(request)) {
                response.sendError(HttpServletResponse.SC_FORBIDDEN, "Invalid CSRF token");
                return;
            } else if (!InputValidator.isValid(maTK)) {
                response.sendError(HttpServletResponse.SC_FORBIDDEN, "parameter very long.");
            } else {
                int visible = 0;
                AD_GiangVien updatevisble = new AD_GiangVien(visible, maTK);
                GVDAO.updatevisible(updatevisble);
                response.sendRedirect("list_giangvien");
            }

        } catch (Exception e) {

            e.printStackTrace();
        }
    }

    private void showEditForm(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
        String matk = request.getParameter("matkupdate");
        if (InputValidator.isValid(matk)) {
            AD_GiangVien forgvupdate = GVDAO.getGiangVienByMaTK(matk);
            if (forgvupdate != null) {
                RequestDispatcher dispatcher = request.getRequestDispatcher("/AD_UpdateGV.jsp");
                request.setAttribute("forgvupdate", forgvupdate);
                dispatcher.forward(request, response);
            }

        } else {
            response.sendError(HttpServletResponse.SC_FORBIDDEN, "Account is null");
        }

    }

    private void getGiangVienByMaTK(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, ServletException {

        String matk = request.getParameter("mtk");
        String filteredMaTK;
        if (matk == null || matk.isEmpty() || matk.equals("show_giangvien")) {
            response.sendError(HttpServletResponse.SC_FORBIDDEN, "Invalid AccountCode");
            return;
        } else if (InputValidator.isValid(matk)) {
            if (matk != null) {

                // Lọc chuỗi để loại bỏ các ký tự không mong muốn
                filteredMaTK = matk.replaceAll("[^a-zA-Z0-9]", "");

                // Kiểm tra độ dài của chuỗi lọc
                if (filteredMaTK.length() > 10) {
                    response.sendError(HttpServletResponse.SC_FORBIDDEN, "AccountCode > 10");
                } else {
                    AD_GiangVien forgv = GVDAO.getGiangVienByMaTK(filteredMaTK);
                    HttpSession session = request.getSession();
                    session.setAttribute("tengv", request);
                    request.setAttribute("forgv", forgv);
                    RequestDispatcher dispatcher = request.getRequestDispatcher("/AD_ShowGiangVien.jsp");
                    dispatcher.forward(request, response);
                }
            } else {
                response.sendError(HttpServletResponse.SC_FORBIDDEN, "AccountCode null");
            }
        }
    }

    private void insertGiangVien(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {

        try {
            request.setCharacterEncoding("UTF-8");

            String MaGV = request.getParameter("MaGV");
            String HoTen = request.getParameter("HoTen");
            String Email = request.getParameter("Email");
            String TrinhDo = request.getParameter("TrinhDo");
            String MaKhoa = request.getParameter("MaKhoa");
            String MaTK = request.getParameter("MaTK");
            String GioiTinh = request.getParameter("GioiTinh");
            String image = request.getParameter("Image");
            String csrf_token = request.getParameter("csrf_token");
            if (InputValidator.isValid(MaGV) && InputValidator.isValid(HoTen) && InputValidator.isValid(Email) && InputValidator.isValid(TrinhDo) && InputValidator.isValid(MaKhoa) && InputValidator.isValid(MaTK) && InputValidator.isValid(GioiTinh) && InputValidator.isValid(image) && InputValidator.isValid(csrf_token)) {
                AD_GiangVien newgv = new AD_GiangVien(MaGV, HoTen, Email, TrinhDo, MaKhoa, MaTK, GioiTinh, image);
//                if (newgv == null) {
//                    response.sendError(HttpServletResponse.SC_FORBIDDEN, "Account is null.");
//                }
                GVDAO.insertGiangVien(newgv);
                response.sendRedirect("list_giangvien");
            } else {
                response.sendError(HttpServletResponse.SC_FORBIDDEN, "parameter very long.");
            }


        } catch (Exception e) {

            e.printStackTrace();
        }
    }

    // ACCOUNT
    private void listAccount(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, ServletException {
        List<AD_Account> listAC = ACDAO.selectAllAccount();
        String tieuDe = request.getParameter("tieuDe");
        String csrfToken = request.getParameter("csrf_token");
//        if (!CSRFTokenUtil.validateCSRFToken(request)) {
//            response.sendError(HttpServletResponse.SC_FORBIDDEN, "CSRF TOKEN is null.");
//        } else
        if (listAC == null) {
            response.sendError(HttpServletResponse.SC_FORBIDDEN, "List is null.");
        } else {
            request.setAttribute("listtk", listAC);
            HttpSession session = request.getSession();
            session.setAttribute("tengv", request);
            RequestDispatcher dispatcher = request.getRequestDispatcher("/AD_TaiKhoan.jsp");
            dispatcher.forward(request, response);
        }
    }

    private void insertTaiKhoan(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {

        try {
            request.setCharacterEncoding("UTF-8");

            String username = request.getParameter("username");
            String pass = request.getParameter("password");
            String role = request.getParameter("role");
            String matk = request.getParameter("MaTK");
            String tieuDe = request.getParameter("tieuDe");
            if (!CSRFTokenUtil.validateCSRFToken(request)) {
                response.sendError(HttpServletResponse.SC_FORBIDDEN, "List is null.");
            }
            if (!InputValidator.isValid(username) || !InputValidator.isValid(pass)
                    || !InputValidator.isValid(role) || !InputValidator.isValid(matk)) {
                response.sendError(HttpServletResponse.SC_FORBIDDEN, "Parameter is not validate.");
            } else {
                AD_Account newac = new AD_Account(username, pass, role, matk);
                if (newac == null) {
                    response.sendError(HttpServletResponse.SC_FORBIDDEN, "Account is null.");
                } else {
                    ACDAO.insertTaiKhoan(newac);
                    response.sendRedirect("list_account");
                }
            }


        } catch (Exception e) {

            e.printStackTrace();
        }
    }

    public void updateTaiKhoan(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
        try {
            request.setCharacterEncoding("UTF-8");

            String username = request.getParameter("username");
            String pass = request.getParameter("password");
            String role = request.getParameter("role");
            String maTK = request.getParameter("MaTK");

            AD_Account updatetk = new AD_Account(username, pass, role, maTK);

            ACDAO.updateTaiKhoan(updatetk);

            response.sendRedirect("list_account");
        } catch (Exception e) {

            e.printStackTrace();
        }
    }

    private void showEditTaiKhoan(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
        String matk = request.getParameter("matkupdate");

        if (!validateCSRFToken(request)) {
            response.sendError(HttpServletResponse.SC_FORBIDDEN, "Invalid CSRF token");
            return;
        } else if (!InputValidator.isValid(matk)) {
            response.sendError(HttpServletResponse.SC_FORBIDDEN, "accountcode is null");


        } else {
            AD_Account edittaikhoan = ACDAO.getTaiKhoanByMaTK(matk);

            RequestDispatcher dispatcher = request.getRequestDispatcher("/AD_UpdateAccount.jsp");
            request.setAttribute("edittaikhoan", edittaikhoan);
            dispatcher.forward(request, response);
        }


    }

    public void updatestatus(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
        try {
            request.setCharacterEncoding("UTF-8");
            String maTK = request.getParameter("mtkstatus");
            if (!InputValidator.isValid(maTK)) {
                response.sendError(HttpServletResponse.SC_FORBIDDEN, "parameter very long.");
            } else {
                int status = 0;
                AD_Account updatest = new AD_Account(status, maTK);
                ACDAO.updatestatus(updatest);
                response.sendRedirect("list_account");
            }

        } catch (Exception e) {

            e.printStackTrace();
        }
    }

    // ADMIN
    private void showADMIN(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {


        String username = "";
        HttpSession session = request.getSession();
        AD_Account account = (AD_Account) session.getAttribute("user_login");
        String csrfToken = request.getParameter("csrf_token");
        String tieuDe = request.getParameter("tieuDe");
//        if (!CSRFTokenUtil.validateCSRFToken(request)) {
//            response.sendError(HttpServletResponse.SC_FORBIDDEN, "CSRF TOKEN is null.");
//        }  else
        if (account == null) {
            response.sendError(HttpServletResponse.SC_FORBIDDEN, "Account is null.");
        } else {
            username = account.getUsername();
            System.out.println("Tìm Thấy" + username);
            AD_Admin tkadmin = ADDAO.getAdminByMaTK(username);
            request.setAttribute("tkadmin", tkadmin);
            RequestDispatcher dispatcher = request.getRequestDispatcher("/AD_Admin.jsp");
            dispatcher.forward(request, response);

        }


    }

    private void showEditFormAdmin(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {

        String username = "";
        HttpSession session = request.getSession();
        AD_Account account = (AD_Account) session.getAttribute("user_login");
        if (account == null) {
            response.sendError(HttpServletResponse.SC_FORBIDDEN, "Account is null.");
        } else {
            username = account.getUsername();
            //System.out.println("Tìm Thấy" + username);
            AD_Admin forad = ADDAO.getAdminByMaTK(username);

            if (forad == null) {
                response.sendError(HttpServletResponse.SC_FORBIDDEN, "Account is null.");
            }
            {
                RequestDispatcher dispatcher = request.getRequestDispatcher("/AD_UpdateAdmin.jsp");
                request.setAttribute("forad", forad);
                dispatcher.forward(request, response);
            }
        }


    }

    public void updatetkadmin(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
        try {
            request.setCharacterEncoding("UTF-8");
            String hoTen = request.getParameter("HoTen");
            String email = request.getParameter("Email");

            DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            LocalDate ngaySinh = LocalDate.parse(request.getParameter("NgaySinh"), df);

            String imagead = request.getParameter("Imagead");
            String maTK = request.getParameter("MaTK");

            AD_Admin updatead = new AD_Admin(hoTen, email, ngaySinh, imagead, maTK);

            ADDAO.updateAdminTaiKhoan(updatead);
            response.sendRedirect("show_acadmin");
        } catch (Exception e) {

            e.printStackTrace();
        }
    }

    // Thông Báo
    private void XemThongBao(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, ServletException {
        List<P_ThongBaoModel> thongBaos = P_ThongBaoDAO.getXemThongBao();

        String tieuDe = request.getParameter("tieuDe");

        String csrfToken = request.getParameter("csrf_token");
        if (!validateCSRFToken(request)) {
            response.sendError(HttpServletResponse.SC_FORBIDDEN, "CSRF TOKEN is incorrect.");
        } else if (thongBaos == null || csrfToken == null) {
            response.sendError(HttpServletResponse.SC_FORBIDDEN, "Noti is null.");
        } else {
            HttpSession session = request.getSession();
            session.setAttribute("tb", thongBaos);
            RequestDispatcher dispatcher = request.getRequestDispatcher("AD_ThongBao.jsp");
            dispatcher.forward(request, response);
        }


    }

    private void GuiThongBaoGet(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, ServletException {

    }

    private void XemGV(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, ServletException {
        List<AD_ThongBao> thongBaos = AD_ThongBaoDao.getXemGV();


        HttpSession session = request.getSession();
        session.setAttribute("tengv", thongBaos);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/AD_ThongBao.jsp");
        dispatcher.forward(request, response);
    }

    private void GuiEmailThongBao(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // reads form fields
        request.setCharacterEncoding("UTF-8");
        String TieuDeGui = request.getParameter("TieuDe");
        String NoiDung = request.getParameter("NoiDung");
        String MaGV = request.getParameter("NguoiNhan");

        String NguoiNhan = "";
        try {
            NguoiNhan = AD_ThongBaoDao.TimEmail(MaGV);
            System.out.println("OK GuiEmailThongBao tb");
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        String resultMessage = "";
        System.out.println(NguoiNhan);
        try {
            EmailUtility.sendEmail(host, port, user, pass, NguoiNhan, TieuDeGui, NoiDung);
            // resultMessage = "The e-mail was sent successfully";
        } catch (Exception ex) {
            ex.printStackTrace();
            resultMessage = "There were an error: " + ex.getMessage();
        } finally {
            request.setAttribute("errorMessage", resultMessage);
            RequestDispatcher dispatcher = request.getRequestDispatcher("/AD_ThongBao.jsp");
            dispatcher.forward(request, response);
        }
        System.out.println(resultMessage);
    }
}
