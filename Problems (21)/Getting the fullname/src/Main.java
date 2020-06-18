
class User {
    private String firstName;
    private String lastName;

    public User() {
        this.firstName = "";
        this.lastName = "";
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName == null ? "" : firstName.trim();
    }

    public void setLastName(String lastName) {
        this.lastName = lastName == null ? "" : lastName.trim();
    }

    public String getFullName() {
        String fullName = new String(this.firstName + " " + this.lastName).trim();
        return fullName.isEmpty() ? "Unknown" : fullName;
    }
}