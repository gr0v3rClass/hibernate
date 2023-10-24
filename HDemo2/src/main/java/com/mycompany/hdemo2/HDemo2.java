/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.hdemo2;

import com.mycompany.hdemo2.dao.UsuariosDao;
import com.mycompany.hdemo2.entity.Usuarios;
import java.util.List;

/**
 *
 * @author gr0v3r
 */
public class HDemo2 {

    public static void main(String[] args) {
        System.out.println("Hello World!");
        
        UsuariosDao usuarioDao = new UsuariosDao();
        
        Usuarios usuario = new Usuarios("carlos", "molina", "carlos@correo.com");
        
        usuarioDao.saveUsuario(usuario);
        
        
        List<Usuarios> usuarios = usuarioDao.getUsuarios();
        
        usuarios.forEach(u->System.out.println("1 "+u.getFirstName()));
    }
}
