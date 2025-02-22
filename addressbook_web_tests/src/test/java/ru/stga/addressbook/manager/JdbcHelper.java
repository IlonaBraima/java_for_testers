package ru.stga.addressbook.manager;

import ru.stga.addressbook.model.GroupData;
import ru.stga.addressbook.model.UserData;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class JdbcHelper extends HelperBase {
    public JdbcHelper(ApplicationManager manager) {
        super(manager);
    }

    public List<GroupData> getGroupList() {
        var groups = new ArrayList<GroupData>();
        try (var conn = DriverManager.getConnection("jdbc:mysql://localhost/addressbook", "root", "");
            var statement = conn.createStatement();
            var result = statement.executeQuery("SELECT group_id, group_name, group_header, group_footer FROM group_list"))
        {
            while (result.next()) {
                groups.add(new GroupData()
                        .withId(result.getString("group_id"))
                        .withName(result.getString("group_name"))
                        .withHeader(result.getString("group_header"))
                        .withFooter(result.getString("group_footer")));

            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return groups;
    }

    public List<UserData> getUserList() {
        var users = new ArrayList<UserData>();
        try (var conn = DriverManager.getConnection("jdbc:mysql://localhost/addressbook", "root", "");
             var statement = conn.createStatement();
             var result = statement.executeQuery("SELECT id, firstname FROM addressbook"))
        {
            while (result.next()) {
                users.add(new UserData()
                        .withId(result.getString("id"))
                        .withFirstName(result.getString("firstname"))
                       // .withLastName(result.getString("lastname"))
                        );
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return users;
    }
}
