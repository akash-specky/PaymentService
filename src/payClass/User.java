package payClass;

public class User {
    private  String userId;
    private  String name;
    private  String email;
    private String address;

    private User(UserBuilder builder) {
        this.userId = builder.userId;
        this.name = builder.name;
        this.email = builder.email;
        this.address = builder.address;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId='" + userId + '\'' +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", address='" + address + '\'' +
                '}';
    }

    static public class UserBuilder{
        private String userId;
        private String name;
        private String email;
        private String address;

        public UserBuilder(){

        }
        public UserBuilder setUserId(String userId) {
            this.userId = userId;
            return this;
        }

        public UserBuilder setName(String name) {
            this.name = name;
            return this;
        }

        public UserBuilder setEmail(String email) {
            if (!email.contains("@")) {
                throw new IllegalArgumentException("Invalid email");
            }
            this.email = email;
            return this;
        }

        public UserBuilder setAddress(String address) {
            this.address = address;
            return this;
        }

        public User build() {
            return new User(this);
        }
    }
}

