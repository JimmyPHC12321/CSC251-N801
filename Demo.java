import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Demo {
    public static void main(String[] args) {
        ArrayList<Policy> policies = new ArrayList<Policy>();

        try {
            BufferedReader reader = new BufferedReader(new FileReader("PolicyInformation.txt"));
            String line;
            while ((line = reader.readLine()) != null) {
                int policyNumber = Integer.parseInt(line);
                String providerName = reader.readLine();
                String firstName = reader.readLine();
                String lastName = reader.readLine();
                int age = Integer.parseInt(reader.readLine());
                String smokingStatus = reader.readLine();
                double height = Double.parseDouble(reader.readLine());
                double weight = Double.parseDouble(reader.readLine());

                PolicyHolder policyHolder = new PolicyHolder(firstName, lastName, age, smokingStatus, height, weight);
                Policy policy = new Policy(policyNumber, providerName, policyHolder, 700.00); // You can set the price accordingly.
                policies.add(policy);
            }
            reader.close();
        } catch (IOException e) {
            System.out.println("An error occurred while reading the file.");
            e.printStackTrace();
        }

        for (Policy policy : policies) {
            System.out.println(policy.toString());
        }

        int smokers = 0;
        int nonSmokers = 0;
        for (Policy policy : policies) {
            if (policy.getPolicyHolder().toString().contains("smoker")) {
                smokers++;
            } else {
                nonSmokers++;
            }
        }

        System.out.println("\nThere were " + Policy.getPolicyCount() + " Policy objects created.");
        System.out.println("The number of policies with a smoker is: " + smokers);
        System.out.println("The number of policies with a non-smoker is: " + nonSmokers);
    }
}
