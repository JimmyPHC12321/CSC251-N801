/**
 * The Policy class models an insurance policy for one person.
 */
public class Policy {
    // Attributes

    /**
     * The policy number of the insurance policy.
     */
    private String policyNumber;

    /**
     * The name of the insurance policy provider.
     */
    private String providerName;

    /**
     * The first name of the policyholder.
     */
    private String firstName;

    /**
     * The last name of the policyholder.
     */
    private String lastName;

    /**
     * The age of the policyholder.
     */
    private int age;

    /**
     * The smoking status of the policyholder (smoker or non-smoker).
     */
    private String smokingStatus;

    /**
     * The height of the policyholder in inches.
     */
    private double height;

    /**
     * The weight of the policyholder in pounds.
     */
    private double weight;

    // Constants

    /**
     * The base fee for the insurance policy.
     */
    private static final double BASE_FEE = 600.0;

    /**
     * The additional fee for policyholders over 50 years old.
     */
    private static final double AGE_FEE = 75.0;

    /**
     * The additional fee for smoker policyholders.
     */
    private static final double SMOKER_FEE = 100.0;

    /**
     * The BMI threshold for calculating additional fee.
     */
    private static final double BMI_THRESHOLD = 35.0;

    /**
     * The fee per unit BMI above the threshold.
     */
    private static final double BMI_FEE_PER_UNIT = 20.0;

    // Constructors

    /**
     * Default constructor that initializes all attributes with default values.
     */
    public Policy() {
        policyNumber = "";
        providerName = "";
        firstName = "";
        lastName = "";
        age = 0;
        smokingStatus = "non-smoker"; // Default to non-smoker
        height = 0.0;
        weight = 0.0;
    }

    /**
     * Constructor that accepts arguments to initialize all fields.
     *
     * @param policyNumber   The policy number of the insurance policy.
     * @param providerName   The name of the insurance policy provider.
     * @param firstName      The first name of the policyholder.
     * @param lastName       The last name of the policyholder.
     * @param age            The age of the policyholder.
     * @param smokingStatus  The smoking status of the policyholder (smoker or non-smoker).
     * @param height         The height of the policyholder in inches.
     * @param weight         The weight of the policyholder in pounds.
     */
    public Policy(String policyNumber, String providerName, String firstName, String lastName,
                  int age, String smokingStatus, double height, double weight) {
        this.policyNumber = policyNumber;
        this.providerName = providerName;
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.smokingStatus = smokingStatus;
        this.height = height;
        this.weight = weight;
    }

    // Getters and Setters for attributes

    // Getter and Setter methods here...

    // Methods

    /**
     * Calculate the Body Mass Index (BMI) of the policyholder.
     *
     * @return The calculated BMI value.
     */
    public double calculateBMI() {
        return (weight * 703) / (height * height);
    }

    /**
     * Calculate the price of the insurance policy based on policyholder attributes.
     *
     * @return The calculated price of the insurance policy.
     */
    public double calculatePolicyPrice() {
        double policyPrice = BASE_FEE;

        if (age > 50) {
            policyPrice += AGE_FEE;
        }

        if (smokingStatus.equalsIgnoreCase("smoker")) {
            policyPrice += SMOKER_FEE;
        }

        double bmi = calculateBMI();
        if (bmi > BMI_THRESHOLD) {
            policyPrice += (bmi - BMI_THRESHOLD) * BMI_FEE_PER_UNIT;
        }

        return policyPrice;
    }
}