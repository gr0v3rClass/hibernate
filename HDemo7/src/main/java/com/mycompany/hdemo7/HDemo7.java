/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.hdemo7;

import com.mycompany.hdemo7.dao.PadreDao;
import com.mycompany.hdemo7.entity.Hijo;
import com.mycompany.hdemo7.entity.Padre;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author gr0v3r
 */
public class HDemo7 {

    public static void main(String[] args) {
        Padre padre = new Padre("Fermin");
        
        Hijo hijo1 = new Hijo("Roberto");
        Hijo hijo2 = new Hijo("Carlos");        
        
        hijo1.setPadre(padre);
        hijo2.setPadre(padre);
        List<Hijo> listHijos = new ArrayList<>();
        listHijos.add(hijo1);
        listHijos.add(hijo2);
        
        padre.setHijos(listHijos);
        
        PadreDao padreDao = new PadreDao();
        
        padreDao.savePadre(padre);
        
    }
}
