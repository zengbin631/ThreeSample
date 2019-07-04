package org.student.util;

import java.sql.*;

public class DBUtil {
    private static  final  String URL="jdbc:mysql://localhost:3306/testdata";
    private static final  String NAME="root";
    private static final  String PASSWORD="123456";
    public static Connection connection=null;
    public static PreparedStatement preparedStatement=null;
    public static ResultSet resultSet=null;
    //增删改
    public static boolean executeUpdate(String sql,Object[] params){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(URL, NAME, PASSWORD);
            preparedStatement = connection.prepareStatement(sql);
            for(int i=0;i<params.length;i++){
                preparedStatement.setObject(i+1,params[i]);
            }
            int count = preparedStatement.executeUpdate();

            if(count>0){
                return true;
            }else{
                return false;
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            return false;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        } catch (Exception e){
            e.printStackTrace();
            return false;
        }finally {
            try {
                if(preparedStatement!=null){preparedStatement.close();}
                if(connection!=null){connection.close();}
            }catch (SQLException e){
                e.printStackTrace();
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }
    //查
    public static ResultSet executeQuery(String sql,Object[] params) throws ClassNotFoundException, SQLException {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(URL, NAME, PASSWORD);
            preparedStatement = connection.prepareStatement(sql);
            if(params!=null){
                for(int i=0;i<params.length;i++){
                    preparedStatement.setObject(i+1,params[i]);
                }
            }
            resultSet = preparedStatement.executeQuery();
            return resultSet;
    }

    public static int getTotalCount(String sql){
        int count=-1;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(URL, NAME, PASSWORD);
            preparedStatement = connection.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();
            if(resultSet.next()){
                count=resultSet.getInt(1);
            }
            return count;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            return count;
        } catch (SQLException e) {
            e.printStackTrace();
            return count;
        } catch (Exception e){
            e.printStackTrace();
            return count;
        }finally {
            try {
                if(resultSet!=null){resultSet.close();}
                if(preparedStatement!=null){preparedStatement.close();}
                if(connection!=null){connection.close();}
            }catch (SQLException e){
                e.printStackTrace();
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }

}
