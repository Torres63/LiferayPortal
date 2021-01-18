/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package crudapps.model.impl;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import crudapps.model.CrudApps;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing CrudApps in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class CrudAppsCacheModel
	implements CacheModel<CrudApps>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof CrudAppsCacheModel)) {
			return false;
		}

		CrudAppsCacheModel crudAppsCacheModel = (CrudAppsCacheModel)object;

		if (appId == crudAppsCacheModel.appId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, appId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(11);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", appId=");
		sb.append(appId);
		sb.append(", title=");
		sb.append(title);
		sb.append(", description=");
		sb.append(description);
		sb.append(", url=");
		sb.append(url);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public CrudApps toEntityModel() {
		CrudAppsImpl crudAppsImpl = new CrudAppsImpl();

		if (uuid == null) {
			crudAppsImpl.setUuid("");
		}
		else {
			crudAppsImpl.setUuid(uuid);
		}

		crudAppsImpl.setAppId(appId);

		if (title == null) {
			crudAppsImpl.setTitle("");
		}
		else {
			crudAppsImpl.setTitle(title);
		}

		if (description == null) {
			crudAppsImpl.setDescription("");
		}
		else {
			crudAppsImpl.setDescription(description);
		}

		if (url == null) {
			crudAppsImpl.setUrl("");
		}
		else {
			crudAppsImpl.setUrl(url);
		}

		crudAppsImpl.resetOriginalValues();

		return crudAppsImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();

		appId = objectInput.readLong();
		title = objectInput.readUTF();
		description = objectInput.readUTF();
		url = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		if (uuid == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(uuid);
		}

		objectOutput.writeLong(appId);

		if (title == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(title);
		}

		if (description == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(description);
		}

		if (url == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(url);
		}
	}

	public String uuid;
	public long appId;
	public String title;
	public String description;
	public String url;

}