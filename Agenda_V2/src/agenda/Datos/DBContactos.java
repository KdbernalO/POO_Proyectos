/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package agenda.Datos;
import java.sql.*;
import agenda.logica.Contacto;
/**
 *
 * @author Estudiantes
 */
public class DBContactos {

    DBConexion cn;

    public DBContactos() {
        cn = new DBConexion();
    }

    public Contacto[] getContactos() {
        int registros = 0;
        try {
            PreparedStatement pstm = cn.getConexion().prepareStatement("SELECT count(1) as cont"
                    + " FROM contactos ");
            ResultSet res = pstm.executeQuery();
            res.next();
            registros = res.getInt("cont");
            res.close();
        } catch (SQLException e) {
            System.out.println(e);
        }
        Contacto[] data = new Contacto[registros];
        try {
            PreparedStatement pstm = cn.getConexion().prepareStatement("SELECT con_id, "
                    + " con_nombre, "
                    + " con_apellido, "
                    + " con_telefono_domicilio, "
                    + " con_telefono_oficina,"
                    + " con_celular, "
                    + " con_correo, "
                    + " con_direccion_residencia,"
                    + " con_direccion_trabajo "
                    + " FROM contactos "
                    + " ORDER BY con_nombre, con_apellido ");
            ResultSet res = pstm.executeQuery();
            int i = 0;
            while (res.next()) {
                data[i] = new Contacto();
                data[i].setId(res.getInt("con_id"));
                data[i].setNombre(res.getString("con_nombre"));
                data[i].setApellido(res.getString("con_apellido"));
                data[i].setTelefonoDomicilio(res.getString("con_telefono_domicilio"));
                data[i].setTelefonoOficina(res.getString("con_telefono_oficina"));
                data[i].setCelular(res.getString("con_celular"));
                data[i].setCorreo(res.getString("con_correo"));
                data[i].setDireccionResidencia(res.getString("con_direccion_residencia"));
                data[i].setDireccionTrabajo(res.getString("con_direccion_trabajo"));
                i++;
            }
            res.close();
        } catch (SQLException e) {
            System.out.println(e);
        }
        return data;
    }

    public int insertarContacto(Contacto c) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public int borrarContacto(Contacto c) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public int actualizarContacto(Contacto c) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
