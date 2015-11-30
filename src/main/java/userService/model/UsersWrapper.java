package userService.model;

import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.ModelWrapper;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link Users}.
 * </p>
 *
 * @author Yevgen Kogut
 * @see Users
 * @generated
 */
public class UsersWrapper implements Users, ModelWrapper<Users> {
    private Users _users;

    public UsersWrapper(Users users) {
        _users = users;
    }

    @Override
    public Class<?> getModelClass() {
        return Users.class;
    }

    @Override
    public String getModelClassName() {
        return Users.class.getName();
    }

    @Override
    public Map<String, Object> getModelAttributes() {
        Map<String, Object> attributes = new HashMap<String, Object>();

        attributes.put("userId", getUserId());
        attributes.put("userName", getUserName());
        attributes.put("email", getEmail());
        attributes.put("text", getText());

        return attributes;
    }

    @Override
    public void setModelAttributes(Map<String, Object> attributes) {
        Long userId = (Long) attributes.get("userId");

        if (userId != null) {
            setUserId(userId);
        }

        String userName = (String) attributes.get("userName");

        if (userName != null) {
            setUserName(userName);
        }

        String email = (String) attributes.get("email");

        if (email != null) {
            setEmail(email);
        }

        String text = (String) attributes.get("text");

        if (text != null) {
            setText(text);
        }
    }

    /**
    * Returns the primary key of this users.
    *
    * @return the primary key of this users
    */
    @Override
    public long getPrimaryKey() {
        return _users.getPrimaryKey();
    }

    /**
    * Sets the primary key of this users.
    *
    * @param primaryKey the primary key of this users
    */
    @Override
    public void setPrimaryKey(long primaryKey) {
        _users.setPrimaryKey(primaryKey);
    }

    /**
    * Returns the user ID of this users.
    *
    * @return the user ID of this users
    */
    @Override
    public long getUserId() {
        return _users.getUserId();
    }

    /**
    * Sets the user ID of this users.
    *
    * @param userId the user ID of this users
    */
    @Override
    public void setUserId(long userId) {
        _users.setUserId(userId);
    }

    /**
    * Returns the user uuid of this users.
    *
    * @return the user uuid of this users
    * @throws SystemException if a system exception occurred
    */
    @Override
    public java.lang.String getUserUuid()
        throws com.liferay.portal.kernel.exception.SystemException {
        return _users.getUserUuid();
    }

    /**
    * Sets the user uuid of this users.
    *
    * @param userUuid the user uuid of this users
    */
    @Override
    public void setUserUuid(java.lang.String userUuid) {
        _users.setUserUuid(userUuid);
    }

    /**
    * Returns the user name of this users.
    *
    * @return the user name of this users
    */
    @Override
    public java.lang.String getUserName() {
        return _users.getUserName();
    }

    /**
    * Sets the user name of this users.
    *
    * @param userName the user name of this users
    */
    @Override
    public void setUserName(java.lang.String userName) {
        _users.setUserName(userName);
    }

    /**
    * Returns the email of this users.
    *
    * @return the email of this users
    */
    @Override
    public java.lang.String getEmail() {
        return _users.getEmail();
    }

    /**
    * Sets the email of this users.
    *
    * @param email the email of this users
    */
    @Override
    public void setEmail(java.lang.String email) {
        _users.setEmail(email);
    }

    /**
    * Returns the text of this users.
    *
    * @return the text of this users
    */
    @Override
    public java.lang.String getText() {
        return _users.getText();
    }

    /**
    * Sets the text of this users.
    *
    * @param text the text of this users
    */
    @Override
    public void setText(java.lang.String text) {
        _users.setText(text);
    }

    @Override
    public boolean isNew() {
        return _users.isNew();
    }

    @Override
    public void setNew(boolean n) {
        _users.setNew(n);
    }

    @Override
    public boolean isCachedModel() {
        return _users.isCachedModel();
    }

    @Override
    public void setCachedModel(boolean cachedModel) {
        _users.setCachedModel(cachedModel);
    }

    @Override
    public boolean isEscapedModel() {
        return _users.isEscapedModel();
    }

    @Override
    public java.io.Serializable getPrimaryKeyObj() {
        return _users.getPrimaryKeyObj();
    }

    @Override
    public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
        _users.setPrimaryKeyObj(primaryKeyObj);
    }

    @Override
    public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
        return _users.getExpandoBridge();
    }

    @Override
    public void setExpandoBridgeAttributes(
        com.liferay.portal.model.BaseModel<?> baseModel) {
        _users.setExpandoBridgeAttributes(baseModel);
    }

    @Override
    public void setExpandoBridgeAttributes(
        com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
        _users.setExpandoBridgeAttributes(expandoBridge);
    }

    @Override
    public void setExpandoBridgeAttributes(
        com.liferay.portal.service.ServiceContext serviceContext) {
        _users.setExpandoBridgeAttributes(serviceContext);
    }

    @Override
    public java.lang.Object clone() {
        return new UsersWrapper((Users) _users.clone());
    }

    @Override
    public int compareTo(Users users) {
        return _users.compareTo(users);
    }

    @Override
    public int hashCode() {
        return _users.hashCode();
    }

    @Override
    public com.liferay.portal.model.CacheModel<Users> toCacheModel() {
        return _users.toCacheModel();
    }

    @Override
    public Users toEscapedModel() {
        return new UsersWrapper(_users.toEscapedModel());
    }

    @Override
    public Users toUnescapedModel() {
        return new UsersWrapper(_users.toUnescapedModel());
    }

    @Override
    public java.lang.String toString() {
        return _users.toString();
    }

    @Override
    public java.lang.String toXmlString() {
        return _users.toXmlString();
    }

    @Override
    public void persist()
        throws com.liferay.portal.kernel.exception.SystemException {
        _users.persist();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (!(obj instanceof UsersWrapper)) {
            return false;
        }

        UsersWrapper usersWrapper = (UsersWrapper) obj;

        if (Validator.equals(_users, usersWrapper._users)) {
            return true;
        }

        return false;
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
     */
    public Users getWrappedUsers() {
        return _users;
    }

    @Override
    public Users getWrappedModel() {
        return _users;
    }

    @Override
    public void resetOriginalValues() {
        _users.resetOriginalValues();
    }
}
