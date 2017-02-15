/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bascula.controller;

import bascula.controller.exceptions.NonexistentEntityException;
import bascula.controller.exceptions.PreexistingEntityException;
import bascula.entity.Conductor;
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
public class ConductorJpaController implements Serializable {

    public ConductorJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Conductor conductor) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(conductor);
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findConductor(conductor.getIdConductor()) != null) {
                throw new PreexistingEntityException("Conductor " + conductor + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Conductor conductor) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            conductor = em.merge(conductor);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Long id = conductor.getIdConductor();
                if (findConductor(id) == null) {
                    throw new NonexistentEntityException("The conductor with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(Long id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Conductor conductor;
            try {
                conductor = em.getReference(Conductor.class, id);
                conductor.getIdConductor();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The conductor with id " + id + " no longer exists.", enfe);
            }
            em.remove(conductor);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Conductor> findConductorEntities() {
        return findConductorEntities(true, -1, -1);
    }

    public List<Conductor> findConductorEntities(int maxResults, int firstResult) {
        return findConductorEntities(false, maxResults, firstResult);
    }

    private List<Conductor> findConductorEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Conductor.class));
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

    public Conductor findConductor(Long id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Conductor.class, id);
        } finally {
            em.close();
        }
    }

    public int getConductorCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Conductor> rt = cq.from(Conductor.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    public List<Conductor> ObtenerConductores(String busqueda){
        try{
        EntityManager em = getEntityManager();
        em.getTransaction().begin();
        String jpql="select a from bascula.entity.Conductor a ";
              jpql+="where(";
               jpql+=" concat('',a.idConductor) like :busqueda or ";
               jpql+=" ( a.nombres     like :busqueda2 or ";
               jpql+="   a.apellidos   like :busqueda2 or ";   
               jpql+="   concat(concat(a.nombres,' '),a.apellidos)   like :busqueda2  ";   
               jpql+=" ) ";
               jpql+=")";
                    
        Query query=em.createQuery(jpql);
        query.setParameter("busqueda",busqueda+"%");
        query.setParameter("busqueda2","%"+busqueda+"%");
        
        List<Conductor> list=query.getResultList();
        em.getTransaction().commit();
        return list;
        }catch(Exception e){
            return new ArrayList<Conductor>();
        }
    }
}
