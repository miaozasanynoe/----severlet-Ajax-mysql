package util;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;




import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * util������
 * @author yangchaoyi
 *
 */
public class DButil {
	
	 //����Connection����
    Connection con;
    //����������
    static String driver = "com.mysql.jdbc.Driver";
    //URLָ��Ҫ���ʵ����ݿ���mydata
    String url = "jdbc:mysql://119.27.167.223:3306/shixun";
    //MySQL����ʱ���û���
    String user = "root";
    //MySQL����ʱ������
    String password = "wuruofeng920205";
    //1��ִ�о�̬����,�������ݿ�����
    static {
        try {
            System.out.println("���ڼ������ݿ�����...");
            Class.forName(driver);
            System.out.println("�Ѽ������ݿ�����������\n");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    //2���������ݿ����ӵķ���
    public Connection getConnection() {
        try {
            System.out.println("�������ӵ����ݿ�...");
            con = DriverManager.getConnection(url,user,password);
            System.out.println("�����ӵ�MySQL���ݿ⣡����\n");
            return con;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    //3���ر����ݿ����ӣ��ͷ�JDBC��Դ�ķ���
    public void closeConnection(Connection connection) {
        if (connection != null) {
            try {
                System.out.println("׼���ͷ�jdbc��Դ���Ͽ����ݿ�����...");
                System.out.println("connection.close();");

                connection.close();//�����ͷ�jdbc��Դ�������ǵ��Զ��ͷ�

                System.out.println("�ѶϿ����ݿ����Ӳ����ͷ���jdbc��Դ\n");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    }
}


