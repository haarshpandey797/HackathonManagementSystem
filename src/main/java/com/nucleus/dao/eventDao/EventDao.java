package com.nucleus.dao.eventDao;

import com.nucleus.dto.EventDTO;
import com.nucleus.mapper.EventMapper;
import com.nucleus.model.hmsmodels.Event;
import com.nucleus.model.hmsmodels.JudgeEventMapping;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public class EventDao {
    @Autowired
    EventMapper eventMapper;

    @Autowired
    EventDTO eventDTO;
    @Autowired
    SessionFactory sessionFactory;
    public List<Event> getEvent(){
        Session session=sessionFactory.openSession();
        session.beginTransaction();
        LocalDate currentDate = LocalDate.now();
        Query<Event> query = session.createQuery(
                "FROM Event WHERE endDate > :currentDate", Event.class);
        query.setParameter("currentDate", currentDate);
        List<Event> eventMaster = query.getResultList();

        session.getTransaction().commit();
        return eventMaster;
    }

    public List<Event> getAllEvents() {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        // Create query to fetch all events
        Query<Event> query = session.createQuery("FROM Event", Event.class);
        List<Event> eventMaster = query.getResultList();
        System.out.println(eventMaster);
        session.getTransaction().commit();
        session.close(); // Close the session after transaction
        return eventMaster;
    }
    public String saveEvent(Event event) {
        try (Session session = sessionFactory.openSession()) {
            // Validate the eventsMaster object
            if (event == null) {
                return "Failed to save event: Event object is null";
            }
            // Perform additional validations if needed

            session.beginTransaction();
            session.save(event);
            session.getTransaction().commit();
            return "Event saved successfully";
        } catch (Exception ex) {
            // Log the exception
            ex.printStackTrace(); // or use a logger to log the exception
            return "Failed";
        }
    }
    public EventDTO getEventById(long id){
        Session session = sessionFactory.openSession();
        Event event=session.get(Event.class,id);
        event.getProblemStatements();
        eventDTO= eventMapper.eventToDTO(event);
        session.close();

        return eventDTO;
    }
    public EventDTO getEventByJudgeId(long id){

        String hql = "SELECT jp " +
                "FROM Judge jm " +
                "JOIN jm.judgeEventMapping jp " +
                "WHERE jm.id = :judgeId";

        Session session = sessionFactory.openSession();
        Transaction tx = null;
        JudgeEventMapping judgeEventMapping = null;

        try {
            tx = session.beginTransaction();
            Query<JudgeEventMapping> query = session.createQuery(hql, JudgeEventMapping.class); // Specify Long.class as the return type
            query.setParameter("judgeId", (int)id);
            judgeEventMapping = query.getSingleResult();
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }

// Process eventIds as needed

        return getEventById(judgeEventMapping.getEvent().getEventId());
    }
}
