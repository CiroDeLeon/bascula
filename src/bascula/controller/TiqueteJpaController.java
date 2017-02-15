/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bascula.controller;

import bascula.controller.exceptions.NonexistentEntityException;
import bascula.entity.Tiquete;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

/**
 *
 * @author Usuario1
 */
public class TiqueteJpaController implements Serializable {

    public TiqueteJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Tiquete tiquete) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(tiquete);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Tiquete tiquete) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            tiquete = em.merge(tiquete);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = tiquete.getIdTiquete();
                if (findTiquete(id) == null) {
                    throw new NonexistentEntityException("The tiquete with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(Integer id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Tiquete tiquete;
            try {
                tiquete = em.getReference(Tiquete.class, id);
                tiquete.getIdTiquete();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The tiquete with id " + id + " no longer exists.", enfe);
            }
            em.remove(tiquete);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Tiquete> findTiqueteEntities() {
        return findTiqueteEntities(true, -1, -1);
    }

    public List<Tiquete> findTiqueteEntities(int maxResults, int firstResult) {
        return findTiqueteEntities(false, maxResults, firstResult);
    }

    private List<Tiquete> findTiqueteEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Tiquete.class));
            Query q = em.createQuery(cq);
            if (!all) {
                q.setMaxResults(maxResults);
                q.setFirstResult(firstResult);
            }
            return q.getResultList();
        } finally {
            em.close();
        }
    }

    public Tiquete findTiquete(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Tiquete.class, id);
        } finally {
            em.close();
        }
    }

    public int getTiqueteCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Tiquete> rt = cq.from(Tiquete.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    public List<Tiquete> ObtenerTiquetes(String busqueda){
        try{
        EntityManager em = getEntityManager();
        em.getTransaction().begin();
        String jpql="select t from bascula.entity.Tiquete t ";
              jpql+="where(";
               jpql+=" concat('',t.idTiquete) like :busqueda or ";              
               jpql+=" ( ";
               jpql+="   t.conductor.nombres     like :busqueda2 or ";               
               jpql+="   t.conductor.apellidos   like :busqueda2 or ";   
               jpql+="   t.producto.descripcion   like :busqueda2 or ";                  
               jpql+="   concat('',t.camion.idCamion) like :busqueda2 or ";
               jpql+="   concat(concat(concat(t.agricultor.nombres,' '),t.agricultor.apellidos),t.agricultor.razonSocial)   like :busqueda2 or ";   
               jpql+="   concat(concat(t.conductor.nombres,' '),t.conductor.apellidos)   like :busqueda2  ";   
               jpql+=" ) ";
               jpql+=")order by t.idTiquete desc ";
                    
        Query query=em.createQuery(jpql);
        query.setParameter("busqueda",busqueda+"%");
        query.setParameter("busqueda2","%"+busqueda+"%");
        
        List<Tiquete> list=query.getResultList();
        em.getTransaction().commit();
        return list;
        }catch(Exception e){
            return new ArrayList<Tiquete>();
        }
    }
    public List<Tiquete> ObtenerTiquetesPendientes(String busqueda){
        try{
        EntityManager em = getEntityManager();
        em.getTransaction().begin();
        String jpql="select t from bascula.entity.Tiquete t ";
              jpql+="where(";
               jpql+=" t.pendiente=true and ";              
               jpql+=" (concat('',t.idTiquete) like :busqueda or ";              
               jpql+=" ( ";
               jpql+="   t.conductor.nombres     like :busqueda2 or ";               
               jpql+="   t.conductor.apellidos   like :busqueda2 or ";   
               jpql+="   t.producto.descripcion   like :busqueda2 or ";                  
               jpql+="   concat('',t.camion.idCamion) like :busqueda or ";
               jpql+="   concat('',t.agricultor.idAgricultor) like :busqueda or ";
               jpql+="   concat('',t.conductor.idConductor) like :busqueda or ";
               jpql+="   concat(concat(concat(t.agricultor.nombres,' '),t.agricultor.apellidos),t.agricultor.razonSocial)   like :busqueda2 or ";   
               jpql+="   concat(concat(t.conductor.nombres,' '),t.conductor.apellidos)   like :busqueda2  ";   
               jpql+=" )) ";
               jpql+=")order by t.idTiquete desc ";
                    
        Query query=em.createQuery(jpql);
        query.setParameter("busqueda",busqueda+"%");
        query.setParameter("busqueda2","%"+busqueda+"%");
        
        List<Tiquete> list=query.getResultList();
        em.getTransaction().commit();
        return list;
        }catch(Exception e){
            return new ArrayList<Tiquete>();
        }
    }
}
