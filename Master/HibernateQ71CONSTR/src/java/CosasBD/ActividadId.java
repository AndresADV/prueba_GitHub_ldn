package CosasBD;
// Generated 6/06/2017 02:30:11 PM by Hibernate Tools 3.2.1.GA



/**
 * ActividadId generated by hbm2java
 */
public class ActividadId  implements java.io.Serializable {


     private byte actividadTipo;
     private byte actividadCodigo;
     private boolean selected;


    public ActividadId() {
    }

    public ActividadId(byte actividadTipo, byte actividadCodigo) {
       this.actividadTipo = actividadTipo;
       this.actividadCodigo = actividadCodigo;
    }
   
    public byte getActividadTipo() {
        return this.actividadTipo;
    }
    
    public void setActividadTipo(byte actividadTipo) {
        this.actividadTipo = actividadTipo;
    }
    public byte getActividadCodigo() {
        return this.actividadCodigo;
    }
    
    public void setActividadCodigo(byte actividadCodigo) {
        this.actividadCodigo = actividadCodigo;
    }
    public boolean isSelected() {
        return selected;
    }

    public void setSelected(boolean selected) {
        this.selected = selected;
    }
 
}


