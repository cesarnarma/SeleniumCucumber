package utils;

import objetos.Usuarios;

import java.sql.*;
import java.util.ArrayList;

public class SqlUtils
{
    private static Connection conexion = null;
    private static Statement statement = null;

    public static void crearConexion()
    {
        String url = Utilidades.getProperties("Schema_Automatizacion");
        String usuario = Utilidades.getProperties("userBD");
        String contrasena = Utilidades.getProperties("passBD");
        try {
            conexion = DriverManager.getConnection(url, usuario, contrasena);
            statement = conexion.createStatement();
        }catch(Exception e)
        {
            e.printStackTrace();
        }
    }

    /*
    * Metodo generico todo terreno
    * */
    public static ArrayList<ArrayList<String>> obtenerResultadosQuery(String query, String[] columnas)
    {
        crearConexion();
        ArrayList<ArrayList<String>> resultados = new ArrayList<>();
        try {
            ResultSet resultSet = statement.executeQuery(query);
            while(resultSet.next())
            {
                ArrayList<String> fila = new ArrayList<>();
                for(int i=0; i<columnas.length; i++)
                {
                    fila.add(resultSet.getObject(columnas[i]).toString());
                }
                resultados.add(fila);
            }
            // Cerrar recursos
            resultSet.close();
            statement.close();
            conexion.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return resultados;
    }

    public static ArrayList<Usuarios> obtenerResultadosQueryPorObjeto(String query, String[] columnas) throws SQLException {
        crearConexion();
        ArrayList<Usuarios> resultados = new ArrayList<>();
        try {
            ResultSet resultSet = statement.executeQuery(query);
            while(resultSet.next())
            {
                Usuarios user = new Usuarios();
                user.setIdUsuario(resultSet.getInt(columnas[0]));
                user.setNombre(resultSet.getString(columnas[1]));
                user.setApellido_paterno(resultSet.getString(columnas[2]));
                user.setApellido_materno(resultSet.getString(columnas[3]));
                user.setTipo(resultSet.getString(columnas[4]));
                resultados.add(user);
            }
            // Cerrar recursos
            resultSet.close();
            statement.close();
            conexion.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return resultados;
    }

    public static void main(String ar[]) throws SQLException {
        String query = "select * from usuarios "; // aqui se contruye la consulta deseada
        String[] columnas = {"idusuarios", "nombre", "apellido_paterno", "apellido_materno", "tipo"}; // aqui se poene las columnas de esa consulta en orden
        /*ArrayList<ArrayList<String>> resultados = obtenerResultadosQuery(query, columnas);
        int filas = resultados.size();
        if(filas > 0)
        {
            for(int i=0; i<filas; i++)
            {
                ArrayList<String> fila = resultados.get(i);
                System.out.println(fila.get(0)+" - "+fila.get(1)+" - "+fila.get(2)+" - "+fila.get(3)+" - "+fila.get(4));
            }
        }*/
        ArrayList<Usuarios> resultados = obtenerResultadosQueryPorObjeto(query, columnas);
        for(Usuarios user : resultados)
        {
            System.out.println(user.getIdUsuario() +" - "+user.getNombre()+" - "
                    +user.getApellido_paterno()+" - "+user.getApellido_materno()+" - "+user.getTipo());
        }
    }
}
