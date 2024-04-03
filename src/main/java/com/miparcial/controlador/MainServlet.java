package com.miparcial.controlador;
import java.io.IOException;
import java.util.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.*;
import com.miparcial.modelo.Calificacion;

@WebServlet(name = "MainServlet", urlPatterns = {"/MainServlet"})
public class MainServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String op = req.getParameter("op");
        Calificacion calif = new Calificacion();
        int id,pos;
        
        HttpSession ses = req.getSession();
        ArrayList<Calificacion> lista = (ArrayList<Calificacion>) ses.getAttribute("listaca");
        
        switch(op){
            case "nuevo":
                req.setAttribute("calif", calif);
                req.getRequestDispatcher("editar.jsp").forward(req, resp);
                break;
            case "editar":
                id = Integer.parseInt(req.getParameter("id"));
                pos = buscaIndice(req, id);
                calif = lista.get(pos);
                req.setAttribute("calif", calif);
                req.getRequestDispatcher("editar.jsp").forward(req, resp);
                break;
            case "eliminar":
                id = Integer.parseInt(req.getParameter("id"));
                pos = buscaIndice(req, id);
                if(pos >=0){
                    lista.remove(pos);
                }
                req.setAttribute("listaca", lista);
                resp.sendRedirect("index.jsp");
                break;
            default:
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        HttpSession ses = req.getSession();
        ArrayList<Calificacion> lista = (ArrayList<Calificacion>) ses.getAttribute("listaca");
        Calificacion calif = new Calificacion ();
        calif.setId(id);
        float p1 = Float.parseFloat(req.getParameter("primero"));
        float p2 = Float.parseFloat(req.getParameter("segundo"));
        float p3 = Float.parseFloat(req.getParameter("tercero"));
        calif.setNombres(req.getParameter("nombres"));
        calif.setPrimero(p1);
        calif.setSegundo(p2);
        calif.setTercero(p3);
        float nota = (p1+p2+p3)/3;
        calif.setNota(nota);
        if(id == 0){
            int idNuevo = obtenerId(req);
            calif.setId(idNuevo);
            lista.add(calif);
        }else{
            int pos = buscaIndice(req, id);
            lista.set(pos, calif);
        }
        req.setAttribute("listaca", lista);
        resp.sendRedirect("index.jsp");
    }
    
    public int obtenerId(HttpServletRequest req){
        HttpSession ses = req.getSession();
        ArrayList<Calificacion> lista = (ArrayList<Calificacion>) ses.getAttribute("listaca");
        int i = 0;
        for(Calificacion item : lista){
            i = item.getId();
        }
        return i+1;
    }

    public int buscaIndice(HttpServletRequest req, int id){
        HttpSession ses = req.getSession();
        ArrayList<Calificacion> lista = (ArrayList<Calificacion>) ses.getAttribute("listaca");
        int pos = 1;
        
        if(lista != null){
            for(Calificacion item:lista){
                ++pos;
                if(item.getId() == id){
                    break;
                }
            }
        }
        
        return pos;
    }

}
