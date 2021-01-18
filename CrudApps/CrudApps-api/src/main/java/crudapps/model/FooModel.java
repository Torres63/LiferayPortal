package crudapps.model;

import com.liferay.portal.kernel.bean.AutoEscape;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.GroupedModel;
import com.liferay.portal.service.ServiceContext;

import com.liferay.portlet.expando.model.ExpandoBridge;

import java.io.Serializable;

import java.util.Date;

/**
 * The base model interface for the Foo service. Represents a row in the &quot;FOO_Foo&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation {@link crudapps.model.impl.FooModelImpl} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link crudapps.model.impl.FooImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see Foo
 * @see crudapps.model.impl.FooImpl
 * @see crudapps.model.impl.FooModelImpl
 * @generated
 */
public interface FooModel extends BaseModel<Foo>, GroupedModel {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this interface directly. All methods that expect a foo model instance should use the {@link Foo} interface instead.
     */

    /**
     * Returns the primary key of this foo.
     *
     * @return the primary key of this foo
     */
    public long getPrimaryKey();

    /**
     * Sets the primary key of this foo.
     *
     * @param primaryKey the primary key of this foo
     */
    public void setPrimaryKey(long primaryKey);

    /**
     * Returns the uuid of this foo.
     *
     * @return the uuid of this foo
     */
    @AutoEscape
    public String getUuid();

    /**
     * Sets the uuid of this foo.
     *
     * @param uuid the uuid of this foo
     */
    public void setUuid(String uuid);

    /**
     * Returns the foo ID of this foo.
     *
     * @return the foo ID of this foo
     */
    public long getFooId();

    /**
     * Sets the foo ID of this foo.
     *
     * @param fooId the foo ID of this foo
     */
    public void setFooId(long fooId);

    /**
     * Returns the group ID of this foo.
     *
     * @return the group ID of this foo
     */
    public long getGroupId();

    /**
     * Sets the group ID of this foo.
     *
     * @param groupId the group ID of this foo
     */
    public void setGroupId(long groupId);

    /**
     * Returns the company ID of this foo.
     *
     * @return the company ID of this foo
     */
    public long getCompanyId();

    /**
     * Sets the company ID of this foo.
     *
     * @param companyId the company ID of this foo
     */
    public void setCompanyId(long companyId);

    /**
     * Returns the user ID of this foo.
     *
     * @return the user ID of this foo
     */
    public long getUserId();

    /**
     * Sets the user ID of this foo.
     *
     * @param userId the user ID of this foo
     */
    public void setUserId(long userId);

    /**
     * Returns the user uuid of this foo.
     *
     * @return the user uuid of this foo
     * @throws SystemException if a system exception occurred
     */
    public String getUserUuid() throws SystemException;

    /**
     * Sets the user uuid of this foo.
     *
     * @param userUuid the user uuid of this foo
     */
    public void setUserUuid(String userUuid);

    /**
     * Returns the user name of this foo.
     *
     * @return the user name of this foo
     */
    @AutoEscape
    public String getUserName();

    /**
     * Sets the user name of this foo.
     *
     * @param userName the user name of this foo
     */
    public void setUserName(String userName);

    /**
     * Returns the create date of this foo.
     *
     * @return the create date of this foo
     */
    public Date getCreateDate();

    /**
     * Sets the create date of this foo.
     *
     * @param createDate the create date of this foo
     */
    public void setCreateDate(Date createDate);

    /**
     * Returns the modified date of this foo.
     *
     * @return the modified date of this foo
     */
    public Date getModifiedDate();

    /**
     * Sets the modified date of this foo.
     *
     * @param modifiedDate the modified date of this foo
     */
    public void setModifiedDate(Date modifiedDate);

    /**
     * Returns the field1 of this foo.
     *
     * @return the field1 of this foo
     */
    @AutoEscape
    public String getField1();

    /**
     * Sets the field1 of this foo.
     *
     * @param field1 the field1 of this foo
     */
    public void setField1(String field1);

    /**
     * Returns the field2 of this foo.
     *
     * @return the field2 of this foo
     */
    public boolean getField2();

    /**
     * Returns <code>true</code> if this foo is field2.
     *
     * @return <code>true</code> if this foo is field2; <code>false</code> otherwise
     */
    public boolean isField2();

    /**
     * Sets whether this foo is field2.
     *
     * @param field2 the field2 of this foo
     */
    public void setField2(boolean field2);

    /**
     * Returns the field3 of this foo.
     *
     * @return the field3 of this foo
     */
    public int getField3();

    /**
     * Sets the field3 of this foo.
     *
     * @param field3 the field3 of this foo
     */
    public void setField3(int field3);

    /**
     * Returns the field4 of this foo.
     *
     * @return the field4 of this foo
     */
    public Date getField4();

    /**
     * Sets the field4 of this foo.
     *
     * @param field4 the field4 of this foo
     */
    public void setField4(Date field4);

    /**
     * Returns the field5 of this foo.
     *
     * @return the field5 of this foo
     */
    @AutoEscape
    public String getField5();

    /**
     * Sets the field5 of this foo.
     *
     * @param field5 the field5 of this foo
     */
    public void setField5(String field5);

    public boolean isNew();

    public void setNew(boolean n);

    public boolean isCachedModel();

    public void setCachedModel(boolean cachedModel);

    public boolean isEscapedModel();

    public Serializable getPrimaryKeyObj();

    public void setPrimaryKeyObj(Serializable primaryKeyObj);

    public ExpandoBridge getExpandoBridge();

    public void setExpandoBridgeAttributes(ServiceContext serviceContext);

    public Object clone();

    public int compareTo(Foo foo);

    public int hashCode();

    public CacheModel<Foo> toCacheModel();

    public Foo toEscapedModel();

    public String toString();

    public String toXmlString();
}
