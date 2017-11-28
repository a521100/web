import dbmanager.DbManager;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class Dao {
    public static List<Dao> getYuan(int y){
        ArrayList<Dao> listyuan = new ArrayList<Dao>();
        DbManager dbm = new DbManager();
        Connection conn= null;
        Statement st = null;
        ResultSet rs = null;
        conn = dbm.in();
        try {
            st = conn.createStatement();
            int ar=35000*y+1;
            //int br=35000*(y+1);
            String sql = "select city,longitude,latitude from yuan WHERE (yuan.id>='"+ar+"' )";
            rs = st.executeQuery(sql);
            while (rs.next()) {
                Dao sv = new Dao();
                sv.setCitys(rs.getString("city"));
                sv.setLongitude(rs.getString("longitude"));
                sv.setLatitude(rs.getString("latitude"));
                //sv.setZuobiaojihe(rs.getString("zuobiaojihe"));
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


    public static List<Dao> getPipei(){
        ArrayList<Dao> listpipei = new ArrayList<Dao>();
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
                Dao sv = new Dao();
                sv.setCitys(rs.getString("city"));
                sv.setZuobiaojihe(rs.getString("zuobiaojihe"));
                //sv.setLongitude(rs.getString("longitude"));
                //sv.setLatitude(rs.getString("latitude"));
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
        Point []ps=new Point[s.length];
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




    private String citys;
    private String longitude;
    private String latitude;
    private String zuobiaojihe;
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
}
