package servlet;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URLEncoder;
import java.util.List;

import Dao.*;

import static Dao.download.downloadtxt;
import static java.lang.System.out;

@WebServlet(name = "ServletTwo")
public class ServletTwo extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        //获得请求文件名
        String name = request.getParameter("filename");
        String username = (String) request.getSession().getAttribute("username");
        List<AllDao> listquanxian=AllDao.find(username);
        String quanxian = listquanxian.get(0).getQuanxian().toString();

        if(name.equals(quanxian)) {

            String filename = name + ".txt";
            out.println(filename);
            //设置文件MIME类型
            response.setContentType(getServletContext().getMimeType(filename));
            //设置Content-Disposition
            response.setHeader("Content-Disposition", "attachment;filename=" + java.net.URLEncoder.encode(filename, "UTF-8"));
            //读取目标文件，通过response将目标文件写到客户端
            //获取目标文件的绝对路径
            String fullFileName = getServletContext().getRealPath("/WEB-INF/download/" + filename);
            //读取文件
            InputStream in = new FileInputStream(fullFileName);
            OutputStream out = response.getOutputStream();
            //写文件
            int b;
            while ((b = in.read()) != -1) {
                out.write(b);
            }
            in.close();
            out.close();
        }
        else {
            request.getSession().setAttribute("username", username);
            request.getRequestDispatcher("../result1.jsp").forward(request, response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
// TODO Auto-generated method stub

    }
}
