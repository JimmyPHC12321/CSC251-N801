import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Demo {
    public static void main(String[] args) {
        List<Policy> policies = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader("PolicyInformation.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                String policyNumber = line;
                String providerName = br.readLine();
                String firstName = br.readLine();
                String lastName = br.readLine();
                int age = Integer.parseInt(br.readLine());
                String smokingStatus = br.readLine();
                double height = Double.parseDouble(br.readLine());
                double weight = Double.parseDouble(br.readLine());

                Policy policy = new Policy(policyNumber, providerName, firstName, lastName, age, smokingStatus, height, weight);
                policies.add(policy);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Display policy information
        for (Policy policy : policies) {
            System.out.println("Policy Number: " + policy.getPolicyNumber());
            System.out.println("Provider Name: " + policy.getProviderName());
            System.out.println("Policyholder's First Name: " + policy.getFirstName());
            System.out.println("Policyholder's Last Name: " + policy.getLastName());
            System.out.println("Policyholder's Age: " + policy.getAge());
            System.out.println("Policyholder's Smoking Status: " + policy.getSmokingStatus());
            System.out.println("Policyholder's Height: " + policy.getHeight() + " inches");
            System.out.println("Policyholder's Weight: " + policy.getWeight() + " pounds");
            System.out.printf("Policyholder's BMI: %.2f%n", policy.calculateBMI());
            System.out.printf("Policy Price: $%.2f%n%n", policy.calculatePolicyPrice());
        }

        // Count smokers and non-smokers
        int smokerCount = 0;
        int nonSmokerCount = 0;

        for (Policy policy : policies) {
            if (policy.getSmokingStatus().equalsIgnoreCase("smoker")) {
                smokerCount++;
            } else {
                nonSmokerCount++;
            }
        }

        System.out.println("The number of policies with a smoker is: " + smokerCount);
        System.out.println("The number of policies with a non-smoker is: " + nonSmokerCount);
    }
}