package servlet;

import Dao.AllDao;
import Dao.download;
import Dao.isPtInPoly;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static Dao.AllDao.*;
import static Dao.download.downloadtxt;
import static java.lang.System.out;

@WebServlet(name = "Servletone" )
public class Servletone extends HttpServlet {

    public Servletone(){

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        up0();
        for (int y = 0; y < 1; y++) {
            List<AllDao> listyuan = AllDao.getb(y);
            List<AllDao> listpipei = AllDao.geta();
            boolean isInpoly;
            for (int j = 0; j < listyuan.size(); j++) {
                for (int k = 0; k < listpipei.size(); k++) {
                    String city = listyuan.get(j).getCitys().toString();
                    if (city.equals(listpipei.get(k).getCitys().toString())) {
                        isInpoly = isPtInPoly.isPtInPoly(Double.parseDouble(listyuan.get(j).getLongitude()), Double.parseDouble(listyuan.get(j).getLatitude().toString()), (listpipei.get(k)).getlPoint1());
                        if (isInpoly == true) {
                            up1(isInpoly,y, j);
                            break;
                        }
                    }
                }
            }
        }
        up2();

        try {
            download.downloadall();
        } catch (Exception e) {
            e.printStackTrace();
        }

        List<AllDao> listjudge = AllDao.judge();
        for (int k = 0; k < listjudge.size(); k++) {
            String city = listjudge.get(k).getCitys().toString();
            try {
                downloadtxt(city);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        out.print("处理中");
        request.getRequestDispatcher("../result0.jsp").forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
