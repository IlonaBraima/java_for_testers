package ru.stqa.mantis.manager;

import org.openqa.selenium.io.CircularOutputStream;
import org.openqa.selenium.os.CommandLine;
import ru.stqa.mantis.model.DeveloperMailUser;

public class JamesCliHelper extends HelperBase {

    public JamesCliHelper(ApplicationManager manager) {
        super(manager);
    }

//    public void addUser(String email, String password) {
//        CommandLine cmd = new CommandLine(
//                "java",
//                "-cp", "\"james-server-jpa-app.lib/*\"",
//                "org.apache.james.cli.ServerCmd",
//                "AddUser", email, password);
//        cmd.setWorkingDirectory(manager.property("james.workingDir"));
//        CircularOutputStream out = new CircularOutputStream();
//        cmd.copyOutputTo(out);
//        cmd.execute();
//        cmd.waitFor();
//        System.out.println(out);
//
//    }
//}

    public DeveloperMailUser addUser(String email, String password) {
        CommandLine cmd = new CommandLine(
                "java",
                "-cp", "\"james-server-jpa-app.lib/*\"",
                "org.apache.james.cli.ServerCmd",
                "AddUser", email, password);
        cmd.setWorkingDirectory(manager.property("james.workingDir"));

        CircularOutputStream out = new CircularOutputStream();
        cmd.copyOutputTo(out);

        cmd.execute();
        cmd.waitFor();

        String output = out.toString().trim();
        System.out.println("James CLI Output: " + output);

        if (output.toLowerCase().contains("executed sucessfully") ||
                output.toLowerCase().contains("executed successfully")) {
            return new DeveloperMailUser(email, "1cnytGOkQR39RELj2t6bcH0FcFdEmyHg");
        }

        throw new RuntimeException("Unexpected CLI output: " + output);
    }
}


