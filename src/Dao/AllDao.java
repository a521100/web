package Dao;

import dbmanager.DbManager;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AllDao {
    public static List<AllDao> getYuan(int y){
        ArrayList<AllDao> listyuan = new ArrayList<AllDao>();
        DbManager dbm = new DbManager();
        Connection conn= null;
        Statement st = null;
        ResultSet rs = null;
        conn = dbm.in();
        try {
            st = conn.createStatement();
            int ar=20000*y+1;
            int br=20000*(y+1);
            String sql = "select city,longitude,latitude from shuju WHERE (shuju.id>='"+ar+"'AND shuju.id<='"+br+"')";
            rs = st.executeQuery(sql);
            while (rs.next()) {
                AllDao sv = new AllDao();
                sv.setCitys(rs.getString("city"));
                sv.setLongitude(rs.getString("longitude"));
                sv.setLatitude(rs.getString("latitude"));
                listyuan.add(sv);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally
        {
            dbm.closeAll(rs, st, conn);
        }
        return listyuan;
    }

    public static List<AllDao> getPipei(){
        ArrayList<AllDao> listpipei = new ArrayList<AllDao>();
        DbManager dbm = new DbManager();
        Connection conn= null;
        Statement st = null;
        ResultSet rs = null;
        conn = dbm.in();
        try {
            st = conn.createStatement();
            String sql = "select city,zuobiaojihe from pipei ";
            rs = st.executeQuery(sql);
            while (rs.next()) {
                AllDao sv = new AllDao();
                sv.setCitys(rs.getString("city"));
                sv.setZuobiaojihe(rs.getString("zuobiaojihe"));
                listpipei.add(sv);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally
        {
            dbm.closeAll(rs, st, conn);
        }
        return listpipei;
    }

    public Point[] getlPoint1() {
        String []s= this.zuobiaojihe.split(" ");
        Point[]ps=new Point[s.length];
        int i=0;
        for(String c:s)
        {
            String []ss=c.split(",");
            Point p=new Point(Double.parseDouble(ss[0]),Double.parseDouble(ss[1]));
            ps[i]=p;
            i++;
        }
        return ps;
    }

    public static List<AllDao> getb(int y){
        ArrayList<AllDao> listyuan = new ArrayList<AllDao>();
        DbManager dbm = new DbManager();
        Connection conn= null;
        Statement st = null;
        ResultSet rs = null;
        conn = dbm.in();
        try {
            st = conn.createStatement();
            CallableStatement c=conn.prepareCall("{CALL getb(?)}");
            c.setInt(1,y);
            rs = c.executeQuery();
            while (rs.next()) {
                AllDao sv = new AllDao();
                sv.setCitys(rs.getString("city"));
                sv.setLongitude(rs.getString("longitude"));
                sv.setLatitude(rs.getString("latitude"));
                listyuan.add(sv);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally
        {
            dbm.closeAll(rs, st, conn);
        }
        return listyuan;
    }

    public static List<AllDao> geta(){
        ArrayList<AllDao> listpipei = new ArrayList<AllDao>();
        DbManager dbm = new DbManager();
        Connection conn= null;
        Statement st = null;
        ResultSet rs = null;
        conn = dbm.in();
        try {
            st = conn.createStatement();
            CallableStatement c=conn.prepareCall("{CALL geta()}");
            rs = c.executeQuery();
            while (rs.next()) {
                AllDao sv = new AllDao();
                sv.setCitys(rs.getString("city"));
                sv.setZuobiaojihe(rs.getString("zuobiaojihe"));
                listpipei.add(sv);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally
        {
            dbm.closeAll(rs, st, conn);
        }
        return listpipei;
    }

    public static void up0() {
        DbManager dbm = new DbManager();
        Connection conn = null;
        Statement st = null;
        conn = dbm.in();
        try {
            st = conn.createStatement();
            CallableStatement c=conn.prepareCall("{CALL up0()}");
            c.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally
        {
            dbm.closeSt(st, conn);
        }
    }

    public static void up1(boolean a,int y,int j) {
        DbManager dbm = new DbManager();
        Connection conn = null;
        Statement st = null;
        conn = dbm.in();
        try {
            st = conn.createStatement();
            CallableStatement c=conn.prepareCall("{CALL up1(?,?,?)}");
            c.setBoolean(1,a);
            c.setInt(2,y);
            c.setInt(3,j);
            c.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally
        {
            dbm.closeSt(st, conn);
        }
    }

    public static void up2() {
        DbManager dbm = new DbManager();
        Connection conn = null;
        Statement st = null;
        conn = dbm.in();
        try {
            st = conn.createStatement();
            CallableStatement c=conn.prepareCall("{CALL up2()}");
            c.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally
        {
            dbm.closeSt(st, conn);
        }
    }

    public static List<AllDao> judge(){
        ArrayList<AllDao> listjudge = new ArrayList<AllDao>();
        DbManager dbm = new DbManager();
        Connection conn = null;
        Statement st = null;
        conn = dbm.in();
        ResultSet rs = null;
        try {
            st = conn.createStatement();
            CallableStatement c=conn.prepareCall("{CALL judge()}");
            rs = c.executeQuery();
            while (rs.next()) {
                AllDao sv = new AllDao();
                sv.setCitys(rs.getString("city"));
                listjudge.add(sv);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally
        {
            dbm.closeAll(rs,st, conn);
        }
        return listjudge;
    }

    public static boolean  Login(String username,String password){
        DbManager dbm = new DbManager();
        Connection conn = null;
        Statement st = null;
        conn = dbm.in();
        ResultSet rs = null;
        boolean bool = false;
        try {
            st = conn.createStatement();
            String sql = "select * from userinfo where username='"+username+"' and password='"+password+"'";
            rs = st.executeQuery(sql);
            if (rs.next()) {
                bool = true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally
        {
            dbm.closeAll(rs,st, conn);
        }
        return bool;
    }

    public static List<AllDao> getcity(){
        ArrayList<AllDao> listcity = new ArrayList<AllDao>();
        DbManager dbm = new DbManager();
        Connection conn= null;
        Statement st = null;
        ResultSet rs = null;
        conn = dbm.in();
        try {
            st = conn.createStatement();
            CallableStatement c=conn.prepareCall("{CALL judge()}");
            rs = c.executeQuery();
            while (rs.next()) {
                AllDao sv = new AllDao();
                sv.setCitys(rs.getString("city"));
                listcity.add(sv);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally
        {
            dbm.closeAll(rs, st, conn);
        }
        return listcity;
    }

    public static List<AllDao> find (String username){
        ArrayList<AllDao> listfind = new ArrayList<AllDao>();
        DbManager dbm = new DbManager();
        Connection conn = null;
        Statement st = null;
        conn = dbm.in();
        ResultSet rs = null;
        try {
            st = conn.createStatement();
            String sql = "select * from userinfo where username='"+username+"'";
            rs = st.executeQuery(sql);
            while (rs.next()) {
                AllDao sv = new AllDao();
                sv.setQuanxian(rs.getString("quanxian"));
                listfind.add(sv);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally
        {
            dbm.closeAll(rs,st,conn);
        }
        return listfind;
    }


    private String citys;
    private String longitude;
    private String latitude;
    private String zuobiaojihe;
    private String username;
    private String password;
    private String quanxian;

    public void setCitys(String citys) {
        this.citys = citys;
    }
    public String getCitys() {
        return citys;
    }
    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }
    public String getLongitude() {
        return longitude;
    }
    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }
    public String getLatitude() {
        return latitude;
    };
    public String getZuobiaojihe() {
        return zuobiaojihe;
    }
    public void setZuobiaojihe(String zuobiaojihe) {
        this.zuobiaojihe = zuobiaojihe;
    }
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public String getQuanxian() {
        return quanxian;
    }
    public void setQuanxian(String quanxian) {
        this.quanxian = quanxian;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
