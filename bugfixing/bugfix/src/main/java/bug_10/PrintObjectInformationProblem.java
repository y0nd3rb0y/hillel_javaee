package bug_10;

public class PrintObjectInformationProblem {

    public static void main(String[] args) {
        System.out.println(new User());
    }
}

//lets add few constructors here

class User {


    private static Company company = new Company();
    private static User manager = new User(null, company, "manager_firstname", "manager_lastname", 15);

    private String name;
    private String surName;
    private int age;

    public User(){
        this(manager, company, "user_firstname", "user_lastname", 12);
    }

    public User(User manager){
            this(manager, company, "user_firstname", "user_lastname", 12);
    }

    public User(User manager, Company company){
        this(manager, company, "user_firstname", "user_lastname", 12);
    }

    public User(User manager, Company company, String firstname){
        this(manager, company, firstname, "user_lastname", 12);
    }

    public User(User manager, Company company, String firstname, String lastname){
        this(manager, company, firstname, lastname, 12);
    }

    public User(User manager, Company company, String firstname, String lastname, int age){
        this.setManager(manager);
        this.setCompany(company);
        this.name = firstname;
        this.surName = lastname;
        this.age = age;
    }



    public User getManager() {
        return manager;
    }

    public void setManager(User manager) {
        this.manager = manager;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurName() {
        return surName;
    }

    public void setSurName(String surName) {
        this.surName = surName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "User{" +
                "manager=" + manager.getName() +
                ", company=" + company.getAddress()+
                ", name='" + name + '\'' +
                ", surName='" + surName + '\'' +
                ", age=" + age +
                '}';
    }
}

class Company {
    private String companyName;
    private String address;
    private String commonDescription;

    public Company(){
        this("Company Name", "Company Address", "Common Description");
    }

    public Company(String companyName){
        this(companyName, "Company Address", "Common Description");
    }
    public Company(String companyName, String companyAddress){
        this(companyName, companyAddress, "Common Description");
    }

    public Company(String companyName, String companyAddress, String commonDescription){
        this.companyName = companyName;
        this.address = companyAddress;
        this.commonDescription = commonDescription;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCommonDescription() {
        return commonDescription;
    }

    public void setCommonDescription(String commonDescription) {
        this.commonDescription = commonDescription;
    }

    @Override
    public String toString() {
        return "Company{" +
                "companyName='" + companyName + '\'' +
                ", address='" + address + '\'' +
                ", commonDescription='" + commonDescription + '\'' +
                '}';
    }
}