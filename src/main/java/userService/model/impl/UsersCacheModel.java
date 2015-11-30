package userService.model.impl;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import userService.model.Users;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing Users in entity cache.
 *
 * @author Yevgen Kogut
 * @see Users
 * @generated
 */
public class UsersCacheModel implements CacheModel<Users>, Externalizable {
    public long userId;
    public String userName;
    public String email;
    public String text;

    @Override
    public String toString() {
        StringBundler sb = new StringBundler(9);

        sb.append("{userId=");
        sb.append(userId);
        sb.append(", userName=");
        sb.append(userName);
        sb.append(", email=");
        sb.append(email);
        sb.append(", text=");
        sb.append(text);
        sb.append("}");

        return sb.toString();
    }

    @Override
    public Users toEntityModel() {
        UsersImpl usersImpl = new UsersImpl();

        usersImpl.setUserId(userId);

        if (userName == null) {
            usersImpl.setUserName(StringPool.BLANK);
        } else {
            usersImpl.setUserName(userName);
        }

        if (email == null) {
            usersImpl.setEmail(StringPool.BLANK);
        } else {
            usersImpl.setEmail(email);
        }

        if (text == null) {
            usersImpl.setText(StringPool.BLANK);
        } else {
            usersImpl.setText(text);
        }

        usersImpl.resetOriginalValues();

        return usersImpl;
    }

    @Override
    public void readExternal(ObjectInput objectInput) throws IOException {
        userId = objectInput.readLong();
        userName = objectInput.readUTF();
        email = objectInput.readUTF();
        text = objectInput.readUTF();
    }

    @Override
    public void writeExternal(ObjectOutput objectOutput)
        throws IOException {
        objectOutput.writeLong(userId);

        if (userName == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(userName);
        }

        if (email == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(email);
        }

        if (text == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(text);
        }
    }
}
