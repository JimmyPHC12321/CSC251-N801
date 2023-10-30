/**
 * The Policy class represents an insurance policy.
 */
public class Policy {
    private int policyNumber;
    private String providerName;
    private PolicyHolder policyHolder;
    private double price;

    // Constructors

    /**
     * Creates a new Policy object with the given information.
     *
     * @param policyNumber   The policy number.
     * @param providerName   The name of the insurance provider.
     * @param policyHolder   The policy holder associated with this policy.
     * @param price          The price of the policy.
     */
    public Policy(int policyNumber, String providerName, PolicyHolder policyHolder, double price) {
        this.policyNumber = policyNumber;
        this.providerName = providerName;
        this.policyHolder = policyHolder;
        this.price = price;
    }

    // Getter methods

    /**
     * Get the policy number.
     *
     * @return The policy number.
     */
    public int getPolicyNumber() {
        return policyNumber;
    }

    /**
     * Get the name of the insurance provider.
     *
     * @return The provider name.
     */
    public String getProviderName() {
        return providerName;
    }

    /**
     * Get the policy holder associated with this policy.
     *
     * @return The policy holder.
     */
    public PolicyHolder getPolicyHolder() {
        return policyHolder;
    }

    /**
     * Get the price of the policy.
     *
     * @return The policy price.
     */
    public double getPrice() {
        return price;
    }

    // Static field and method

    /**
     * Get the number of Policy objects that have been created.
     *
     * @return The count of Policy objects.
     */
    public static int getPolicyCount() {
        return policyCount;
    }

    // toString method

    /**
     * Returns a string representation of the Policy object.
     *
     * @return A string containing policy information.
     */
    @Override
    public String toString() {
        // Include the string representation of the Policy object here.
        return "Policy Number: " + policyNumber + "\n" +
               "Provider Name: " + providerName + "\n" +
               policyHolder.toString() +
               "Policy Price: $" + price + "\n";
    }
}
