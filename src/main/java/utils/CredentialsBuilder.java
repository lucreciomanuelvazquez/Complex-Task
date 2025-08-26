package utils;

public class CredentialsBuilder {
    private String username;
    private String password;
    //temporary fields the builder that will be used to build the final object

    public CredentialsBuilder setUsername(String username) {
        this.username = username;
        return this;
        //stores the username and returns the builder itself to allow method chaining
    }

    public CredentialsBuilder setPassword(String password) {
        this.password = password;
        return this;
    }

    public Credentials build() {
        return new Credentials(username, password);
        //creates and returns a new Credentials object using the stored values
    }

    public static class Credentials {
        //the actual object that will be used in tests
        private final String username;
        private final String password;

        public Credentials(String username, String password) {
            this.username = username;
            this.password = password;
        }
        public String getUsername() { return username; }
        public String getPassword() { return password; }
    }
    //builder Pattern: allows flexible, fluent, and readable creation of objects.
    //Instead of hardcoding username/password in different places, you can build credentials dynamically (e.g., valid, invalid, empty, etc.) in your tests.
    //the inner Credentials class is immutable, which makes it safe to use across your test cases.
}
