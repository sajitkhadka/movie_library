/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sajit.movielibrarysoapwebapp.jpacontoller;

import com.sajit.movielibrarysoapwebapp.jpacontoller.exceptions.NonexistentEntityException;
import com.sajit.movielibrarysoapwebapp.jpacontoller.exceptions.PreexistingEntityException;
import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import com.sajit.movielibrarysoapwebapp.models.Genre;
import com.sajit.movielibrarysoapwebapp.models.Shows;
import java.math.BigDecimal;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

/**
 *
 * @author Sajit
 */
public class ShowsJpaController implements Serializable {

    public ShowsJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Shows shows) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Genre genreId = shows.getGenreId();
            if (genreId != null) {
                genreId = em.getReference(genreId.getClass(), genreId.getGenreId());
                shows.setGenreId(genreId);
            }
            em.persist(shows);
            if (genreId != null) {
                genreId.getShowsCollection().add(shows);
                genreId = em.merge(genreId);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findShows(shows.getShowsId()) != null) {
                throw new PreexistingEntityException("Shows " + shows + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Shows shows) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Shows persistentShows = em.find(Shows.class, shows.getShowsId());
            Genre genreIdOld = persistentShows.getGenreId();
            Genre genreIdNew = shows.getGenreId();
            if (genreIdNew != null) {
                genreIdNew = em.getReference(genreIdNew.getClass(), genreIdNew.getGenreId());
                shows.setGenreId(genreIdNew);
            }
            shows = em.merge(shows);
            if (genreIdOld != null && !genreIdOld.equals(genreIdNew)) {
                genreIdOld.getShowsCollection().remove(shows);
                genreIdOld = em.merge(genreIdOld);
            }
            if (genreIdNew != null && !genreIdNew.equals(genreIdOld)) {
                genreIdNew.getShowsCollection().add(shows);
                genreIdNew = em.merge(genreIdNew);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                BigDecimal id = shows.getShowsId();
                if (findShows(id) == null) {
                    throw new NonexistentEntityException("The shows with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(BigDecimal id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Shows shows;
            try {
                shows = em.getReference(Shows.class, id);
                shows.getShowsId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The shows with id " + id + " no longer exists.", enfe);
            }
            Genre genreId = shows.getGenreId();
            if (genreId != null) {
                genreId.getShowsCollection().remove(shows);
                genreId = em.merge(genreId);
            }
            em.remove(shows);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Shows> findShowsEntities() {
        return findShowsEntities(true, -1, -1);
    }

    public List<Shows> findShowsEntities(int maxResults, int firstResult) {
        return findShowsEntities(false, maxResults, firstResult);
    }

    private List<Shows> findShowsEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Shows.class));
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

    public Shows findShows(BigDecimal id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Shows.class, id);
        } finally {
            em.close();
        }
    }

    public int getShowsCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Shows> rt = cq.from(Shows.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
