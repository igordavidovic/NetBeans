/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vjezbanje.controller;

import java.util.List;
import org.hibernate.Session;
import vjezbanje.util.EdunovaException;
import vjezbanje.util.HibernateUtil;

/**
 *
 * @author Igor
 */
public abstract class Obrada<T> {
    protected Session session;
    protected T entitet;
    
    public abstract List<T> read();
    protected abstract void kontrolaCreate() throws EdunovaException;
    protected abstract void kontrolaUpdate() throws EdunovaException;
    protected abstract void kontrolaDelete() throws EdunovaException;
    
    public Obrada(){
        session = HibernateUtil.getSession();
    }
    
    public T create() throws EdunovaException{
        kontrolaCreate();
        save();
        return entitet;
    }
    
    public T update() throws EdunovaException{
        kontrolaUpdate();
        save();
        return entitet;
    }
    
    public void delete() throws EdunovaException{
        kontrolaDelete();
        session.beginTransaction();
        session.delete(entitet);
        session.getTransaction().commit();
    }
    
    private void save(){
        session.beginTransaction();
        session.save(entitet);
        session.getTransaction().commit();
    }

    public T getEntitet() {
        return entitet;
    }

    public void setEntitet(T entitet) {
        this.entitet = entitet;
    }
    
    
}
