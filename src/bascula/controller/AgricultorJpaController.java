/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bascula.controller;

import bascula.controller.exceptions.NonexistentEntityException;
import bascula.controller.exceptions.PreexistingEntityException;
import bascula.entity.Agricultor;
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
public class AgricultorJpaController implements Serializable {

    public AgricultorJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Agricultor agricultor) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(agricultor);
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findAgricultor(agricultor.getIdAgricultor()) != null) {
                throw new PreexistingEntityException("Agricultor " + agricultor + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Agricultor agricultor) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            agricultor = em.merge(agricultor);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Long id = agricultor.getIdAgricultor();
                if (findAgricultor(id) == null) {
                    throw new NonexistentEntityException("The agricultor with id " + id + " no longer exists.");
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
            Agricultor agricultor;
            try {
                agricultor = em.getReference(Agricultor.class, id);
                agricultor.getIdAgricultor();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The agricultor with id " + id + " no longer exists.", enfe);
            }
            em.remove(agricultor);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Agricultor> findAgricultorEntities() {
        return findAgricultorEntities(true, -1, -1);
    }

    public List<Agricultor> findAgricultorEntities(int maxResults, int firstResult) {
        return findAgricultorEntities(false, maxResults, firstResult);
    }

    private List<Agricultor> findAgricultorEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Agricultor.class));
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

    public Agricultor findAgricultor(Long id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Agricultor.class, id);
        } finally {
            em.close();
        }
    }

    public int getAgricultorCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Agricultor> rt = cq.from(Agricultor.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    public List<Agricultor> ObtenerAgricultores(String busqueda){
        try{
        EntityManager em = getEntityManager();
        em.getTransaction().begin();
        String jpql="select a from bascula.entity.Agricultor a ";
               jpql+="where(";
               jpql+=" concat('',a.idAgricultor) like :busqueda or ";
               jpql+=" ( a.nombres     like :busqueda2 or ";
               jpql+="   a.apellidos   like :busqueda2 or ";
               jpql+="   a.razonSocial like :busqueda2 or ";
               jpql+="   a.naturaleza like :busqueda2  ";
               jpql+=" ) ";
               jpql+=")";
        Query query=em.createQuery(jpql);
        query.setParameter("busqueda",busqueda+"%");
        query.setParameter("busqueda2","%"+busqueda+"%");
        
        List<Agricultor> list=query.getResultList();
        em.getTransaction().commit();
        return list;
        }catch(Exception e){
            return new ArrayList<Agricultor>();
        }
    }
}
