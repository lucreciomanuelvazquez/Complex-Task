package utils;

public class CredentialsBuilder {
    private String username;
    private String password;

    public CredentialsBuilder setUsername(String username) {
        this.username = username;
        return this;
    }

    public CredentialsBuilder setPassword(String password) {
        this.password = password;
        return this;
    }

    public Credentials build() {
        return new Credentials(username, password);
    }

    public static class Credentials {
        private final String username;
        private final String password;

        public Credentials(String username, String password) {
            this.username = username;
            this.password = password;
        }
        public String getUsername() { return username; }
        public String getPassword() { return password; }
    }
}
