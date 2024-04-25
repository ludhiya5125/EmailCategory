import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        String emails="ludhiyagurugari@gmail.com,199x1a0523@gpcet.ac.in,ludhiya0211@yahoo.com,yash@outlook.com,ludhiyayash@gmail.com,yashmahajan@yahoo.com,ravindar@outlook.com,grace@outlook.com,raj@yahoo.com";
        String[] emailArray = emails.split(",");

        // Categorize emails based on their domain using TreeMap
        Map<String, List<String>> emailsCategory = new TreeMap<>();
        emailsCategory.put("Gmail", new ArrayList<>());
        emailsCategory.put("Yahoo", new ArrayList<>());
        emailsCategory.put("Outlook", new ArrayList<>());
        emailsCategory.put("Others", new ArrayList<>());

        for (String email : emailArray) {
            String domain = getEmailDomain(email);
            emailsCategory.computeIfAbsent(domain, k -> new ArrayList<>()).add(email);
        }

        // Display the categorized emails
        for (Map.Entry<String, List<String>> entry : emailsCategory.entrySet()) {
            String category = entry.getKey();
            List<String> emailsInCategory = entry.getValue();
            System.out.println(category + ": " + emailsInCategory);
        }
    }

    // method to extract domain from email address
    private static String getEmailDomain(String email) {
        int atIndex = email.indexOf('@');
        return email.substring(atIndex + 1);
    }
}

