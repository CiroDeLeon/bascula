/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bascula.controller;

import bascula.controller.exceptions.NonexistentEntityException;
import bascula.controller.exceptions.PreexistingEntityException;
import bascula.entity.Camion;
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
public class CamionJpaController implements Serializable {

    public CamionJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Camion camion) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(camion);
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findCamion(camion.getIdCamion()) != null) {
                throw new PreexistingEntityException("Camion " + camion + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Camion camion) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            camion = em.merge(camion);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                String id = camion.getIdCamion();
                if (findCamion(id) == null) {
                    throw new NonexistentEntityException("The camion with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(String id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Camion camion;
            try {
                camion = em.getReference(Camion.class, id);
                camion.getIdCamion();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The camion with id " + id + " no longer exists.", enfe);
            }
            em.remove(camion);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Camion> findCamionEntities() {
        return findCamionEntities(true, -1, -1);
    }

    public List<Camion> findCamionEntities(int maxResults, int firstResult) {
        return findCamionEntities(false, maxResults, firstResult);
    }

    private List<Camion> findCamionEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Camion.class));
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

    public Camion findCamion(String id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Camion.class, id);
        } finally {
            em.close();
        }
    }

    public int getCamionCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Camion> rt = cq.from(Camion.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
     public List<Camion> ObtenerCamiones(String busqueda){
        try{
        EntityManager em = getEntityManager();
        em.getTransaction().begin();
        String jpql="select a from bascula.entity.Camion a ";
              jpql+="where(";
               jpql+=" concat('',a.idCamion) like :busqueda or ";
               jpql+=" ( a.conductor.nombres     like :busqueda2 or ";
               jpql+="   a.conductor.apellidos   like :busqueda2 or ";   
               jpql+="   concat(concat(a.conductor.nombres,' '),a.conductor.apellidos)   like :busqueda2  ";   
               jpql+=" ) ";
               jpql+=")";
                    
        Query query=em.createQuery(jpql);
        query.setParameter("busqueda",busqueda+"%");
        query.setParameter("busqueda2","%"+busqueda+"%");
        
        List<Camion> list=query.getResultList();
        em.getTransaction().commit();
        return list;
        }catch(Exception e){
            return new ArrayList<Camion>();
        }
    }
}
