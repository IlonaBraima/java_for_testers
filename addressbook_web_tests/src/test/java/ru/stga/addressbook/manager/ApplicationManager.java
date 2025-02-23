package ru.stga.addressbook.manager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Properties;


public class ApplicationManager {

    protected WebDriver driver;

    private LoginHelper session;

    private GroupHelper groups;

    private UserHelper users;

    private JdbcHelper jdbc;

    private HibernateHelper hbm;

    private Properties properties;


    public void init(String browser, Properties properties) {
        this.properties = properties;
        if (driver == null) {
            if ("chrome".equals(browser)){
                driver = new ChromeDriver();
            } else if ("firefox".equals(browser)) {
                    driver = new ChromeDriver();
            } else {
                throw new IllegalArgumentException(String.format("Unknown browser %s", browser));
            }
            Runtime.getRuntime().addShutdownHook(new Thread(driver::quit));
            driver.get(properties.getProperty("web.baseUrl"));
            driver.manage().window().setSize(new Dimension(970, 668));
            session().login(properties.getProperty("web.username"), properties.getProperty("web.password"));
        }
    }

    public LoginHelper session() {
        if (session == null) {
            session = new LoginHelper(this);
        }
        return session;
    }

    public GroupHelper groups() {
        if (groups == null) {
            groups = new GroupHelper (this);
        }
        return groups;
    }

    public UserHelper users() {
        if (users == null) {
            users = new UserHelper (this);
        }
        return users;
    }

    public JdbcHelper jdbc() {
        if (jdbc == null) {
            jdbc = new JdbcHelper (this);
        }
        return jdbc;
    }

    public HibernateHelper hbm() {
        if (hbm == null) {
            hbm = new HibernateHelper (this);
        }
        return hbm;
    }

    protected boolean isElementPresent(By locator) {
        try {
            driver.findElement(locator);
            return true;
        } catch (NoSuchElementException exception) {
            return false;
        }
    }
}
