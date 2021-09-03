package cloud.yalda.www.yaldaIdentity.config;

import com.google.common.collect.Sets;

import java.util.Set;

public enum UserRole {
    FREE(Sets.newHashSet()),PREMIUM(Sets.newHashSet())
    ,ADMIN(Sets.newHashSet(UserPermission.PERSON_BLOCK,UserPermission.PERSON_LIST))
    ,SUPPORT(Sets.newHashSet(UserPermission.PERSON_BLOCK,UserPermission.PERSON_LIST));

    public Set<UserPermission> getUserPermissions() {
        return userPermissions;
    }

    private final Set<UserPermission> userPermissions;

    UserRole(Set<UserPermission> userPermissions) {
        this.userPermissions = userPermissions;
    }
}
