package ru.sapteh.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.NativeQuery;
import org.hibernate.query.Query;
import ru.sapteh.model.Mark;

import java.util.List;

public class MarkServ implements DAO<Mark, Integer> {
    private SessionFactory factory;
    public MarkServ (SessionFactory factory) {
        this.factory = factory;
    }

    @Override
    public void create(Mark mark) {
        try (Session session = factory.openSession()) {
            String sql = "insert into Mark (mark, concern) values (:mark, :concern)";
            Query<Mark> Query = session.createNativeQuery(sql, Mark.class);
            Query.setParameter("mark", mark.getMark()).setParameter("concern", mark.getConcern());
            session.getTransaction().commit();
        }
    }

    @Override
    public void update(Mark mark) {
        try (Session session = factory.openSession()) {
            String sqlMark = "update Mark set mark = :mark where id = :id";
            Query<Mark> Query = session.createNativeQuery(sqlMark, Mark.class);
            String sqlConcern = "update Mark set concern = :concern where id = :id";
            Query<Mark> Query1 = session.createNativeQuery(sqlConcern, Mark.class);
            Query.setParameter("mark", mark.getMark()).setParameter("concern", mark.getConcern());
            session.getTransaction().commit();
        }
    }
    @Override
    public void delete(Mark mark) {
        try (Session session = factory.openSession()) {
            String sqlMark = "delete from Mark where mark = :mark";
            Query<Mark> Query = session.createNativeQuery(sqlMark, Mark.class);
        }
    }

    @Override
    public Mark read(Integer integer) {
        return null;
    }

    @Override
    public List<Mark> findByAll() {
        return null;
    }
}
