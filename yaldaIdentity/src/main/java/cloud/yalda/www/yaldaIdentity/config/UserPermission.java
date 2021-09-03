package cloud.yalda.www.yaldaIdentity.config;

public enum UserPermission {
    PERSON_BLOCK("person:block"),
    PERSON_LIST("person:list");

    public String getPermissions() {
        return permissions;
    }

    private final String permissions;

    UserPermission(String permissions) {
        this.permissions = permissions;
    }

}
