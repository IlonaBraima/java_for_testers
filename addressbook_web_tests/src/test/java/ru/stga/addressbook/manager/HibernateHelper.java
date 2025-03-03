package ru.stga.addressbook.manager;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.AvailableSettings;
import org.hibernate.cfg.Configuration;
import ru.stga.addressbook.manager.hdm.GroupRecord;
import ru.stga.addressbook.manager.hdm.UserRecord;
import ru.stga.addressbook.model.GroupData;
import ru.stga.addressbook.model.UserData;

import java.util.List;
import java.util.stream.Collectors;

public class HibernateHelper extends HelperBase {

    private SessionFactory sessionFactory;

    public HibernateHelper(ApplicationManager manager) {
        super(manager);

        sessionFactory = new Configuration()
                .addAnnotatedClass(GroupRecord.class)
                .addAnnotatedClass(UserRecord.class)
                .setProperty(AvailableSettings.JAKARTA_JDBC_URL, "jdbc:mysql://localhost/addressbook") //?zeroDateTimeBehavior=convertToNull
                .setProperty(AvailableSettings.JAKARTA_JDBC_USER, "root")
                .setProperty(AvailableSettings.JAKARTA_JDBC_PASSWORD, "")
                .buildSessionFactory();

    }

    static List<GroupData> convertList(List<GroupRecord> records) {
        return records.stream().map(HibernateHelper::convert).collect(Collectors.toList());
    }

    private static GroupData convert(GroupRecord record) {
        return new GroupData("" + record.id, record.name, record.header, record.footer);
    }

    private static GroupRecord convert(GroupData data) {
        var id = data.id();
        if("".equals(id)) {
            id = "0";
        }
        return new GroupRecord(Integer.parseInt(id), data.name(), data.header(), data.footer());
    }

    static List<UserData> convertUsList(List<UserRecord> records) {
        return records.stream().map(HibernateHelper::convert).collect(Collectors.toList());
    }

    private static UserData convert(UserRecord record) {
        return new UserData().withId("" + record.id)
                .withFirstName(record.firstname)
                .withMiddleName(record.middlename)
                .withLastName(record.lastname)
                .withNickName(record.nickname)
                .withTitle(record.title)
                .withEmail(record.email)
                .withPhoto(record.photo)
                .withEmail2(record.email2)
                .withEmail3(record.email3)
                .withHome(record.home)
                .withMobile(record.mobile)
                .withWork(record.work)
                .withFax(record.fax)
                .withAddress(record.address);
    }

    private static UserRecord convert(UserData data) {
        var id = data.id();
        if("".equals(id)) {
            id = "0";
        }
        return new UserRecord(Integer.parseInt(id), data.firstname(), data.middlename(), data.lastname(), data.nickname(), data.title(), data.email(), data.photo());
    }

    public List<GroupData> getGroupList() {
        return convertList(sessionFactory.fromSession(session -> {
            return session.createQuery("from GroupRecord", GroupRecord.class).list();
        }));
    }

    public List<UserData> getUserList() {
        return convertUsList(sessionFactory.fromSession(session -> {
            return session.createQuery("from UserRecord", UserRecord.class).list();
        }));
    }


    public long getGroupCount() {
        return sessionFactory.fromSession(session -> {
            return session.createQuery("select count (*) from GroupRecord", Long.class).getSingleResult();
        });
    }

    public long getUserCount() {
        return sessionFactory.fromSession(session -> {
            return session.createQuery("select count (*) from UserRecord", Long.class).getSingleResult();
        });
    }

    public void createGroup(GroupData groupData) {
        sessionFactory.inSession(session -> {
            session.getTransaction().begin();
            session.persist(convert(groupData));
            session.getTransaction().commit();
        });

    }

    public void createUser(UserData userData) {
        sessionFactory.inSession(session -> {
            session.getTransaction().begin();
            session.persist(convert(userData));
            session.getTransaction().commit();
        });
    }

    public List<UserData> getUsersInGroup(GroupData group) {
        return sessionFactory.fromSession(session -> {
            return convertUsList(session.get(GroupRecord.class, group.id()).users);
        });
    }
}