package Java;

import CosasBD.Actividad;
import CosasBD.ActividadId;
import HibernateUtil.HibernateUtil;
import java.util.ArrayList;
import java.util.List;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

@Named(value = "act")
@RequestScoped
public class ActividadJava {

    private Actividad actividad;
    private ActividadId actividadId;
    private List<Actividad> actividades;

    public ActividadJava() {
        actividad = new Actividad();
        actividades = new ArrayList();
        actividadId = new ActividadId();
        cargarDatos();
    }

    public void cargarDatos() {
        SessionFactory sf = HibernateUtil.getSessionFactory();
        Session ses = sf.openSession();
        actividades = ses.createQuery("from Actividad").list();
    }

    public String Guardar() {
        SessionFactory sf = HibernateUtil.getSessionFactory();
        Session ses = sf.openSession();
        Transaction tx = ses.beginTransaction();
        Actividad act = new Actividad(new ActividadId(actividadId.getActividadCodigo(), actividadId.getActividadTipo()), actividad.getActividadNombre(), null);
        ses.saveOrUpdate(act);
        tx.commit();
        cargarDatos();
        return "index";
    }

    public String Eliminar() {
        for (Actividad c : actividades) {
            if (c.isSelected()) {
                SessionFactory sf = HibernateUtil.getSessionFactory();
                Session se = sf.openSession();
                //Se hace la busqueda del objeto categoria esto es igual a 
                //Realizar la operacion select * from categoria where codigo = ?
                Actividad act = (Actividad) se.get(Actividad.class, c.getId());
                //Borramos el objeto
                se.delete(act);
                //Hacemos commit
                se.beginTransaction().commit();                
            }
        }
        cargarDatos();//Cargarmos la lista de categorias para actualizar la tabla
        return "index";
    }

   

    public void setActividadId(ActividadId actividadId) {
        this.actividadId = actividadId;
    }

    public ActividadId getActividadId() {
        return actividadId;
    }

    public Actividad getActividad() {
        return actividad;
    }

    public List<Actividad> getActividades() {
        return actividades;
    }

    public void setActividades(List<Actividad> actividades) {
        this.actividades = actividades;
    }

    public void setActividad(Actividad actividad) {
        this.actividad = actividad;
    }
}
