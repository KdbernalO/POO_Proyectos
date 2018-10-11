/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package agenda.Datos;

import agenda.logica.Cita;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Estudiantes
 */
public class DBCitas {

    DBConexion cn2;

    public DBCitas() {
        cn2 = new DBConexion();
    }

    public Cita[] getCitas() {
        int registros = 0;
        try {
            PreparedStatement pstm = cn2.getConexion().prepareStatement("SELECT count(1) as cont"
                    + " FROM citas ");
            ResultSet res = pstm.executeQuery();
            res.next();
            registros = res.getInt("cont");
            res.close();
        } catch (SQLException e) {
            System.out.println(e);
        }
        Cita[] data = new Cita[registros];
        try {
            PreparedStatement pstm = cn2.getConexion().prepareStatement("SELECT con_persona, "
                    + " con_lugar, "
                    + " con_hora, "
                    + " con_descripcion "
                    + " FROM citas"
                    + " ORDER BY con_persona ");
            ResultSet res = pstm.executeQuery();
            int i = 0;
            while (res.next()) {
                data[i] = new Cita();

                data[i].setPersona(res.getString("con_persona"));
                data[i].setLugar(res.getString("con_lugar"));
                data[i].setHora(res.getString("con_hora"));
                data[i].setDescripcion(res.getString("con_descripcion"));
                i++;
            }
            res.close();
        } catch (SQLException e) {
            System.out.println(e);
        }
        return data;
    }

    public int insertarCita(Cita c2) {
        int cont_usuario = -1;
        int resultado = 0;//no hubo errores de validacion
        try {
            PreparedStatement pstm = cn2.getConexion().prepareStatement("select count(1) as cont "
                    + " from citas ");
            ResultSet res = pstm.executeQuery();
            res.next();
            cont_usuario = res.getInt("cont");
            res.close();

            if (cont_usuario == 0) {
                pstm = cn2.getConexion().prepareStatement("insert into contactos (con_persona, "
                        + " con_lugar,"
                        + " con_hora,"
                        + " con_descripcion,"
                        + " values(?,?,?,?)");
                pstm.setString(1, c2.getPersona());
                pstm.setString(2, c2.getLugar());
                pstm.setString(3, c2.getHora());
                pstm.setString(4, c2.getDescripcion());

                pstm.executeUpdate();
            } else {
                resultado = -2;//el login ya existe
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return resultado;
    }

    public int actualizarCita(Cita c2) {
        int resultado = 0;
        try {
            PreparedStatement pstm = cn2.getConexion().prepareStatement("update citas " + " set con_persona = ?, "
                    + " con_lugar = ?,"
                    + " con_hora = ?,"
                    + " con_descripcion = ?,");
            pstm.setString(1, c2.getPersona());
            pstm.setString(2, c2.getLugar());
            pstm.setString(3, c2.getHora());
            pstm.setString(4, c2.getDescripcion());
            resultado = pstm.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }
        return resultado;
    }

    public int borrarCita(Cita c2) {
        int resultado = 0;
        try {
            PreparedStatement pstm = cn2.getConexion().prepareStatement("delete from citas "
                    + " where con_persona = ?");
            pstm.setString(1, c2.getPersona());
            resultado = pstm.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }
        return resultado;
    }
}
