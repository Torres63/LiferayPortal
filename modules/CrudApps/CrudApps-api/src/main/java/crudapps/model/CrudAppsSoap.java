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

package crudapps.model;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link crudapps.service.http.CrudAppsServiceSoap}.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class CrudAppsSoap implements Serializable {

	public static CrudAppsSoap toSoapModel(CrudApps model) {
		CrudAppsSoap soapModel = new CrudAppsSoap();

		soapModel.setUuid(model.getUuid());
		soapModel.setAppId(model.getAppId());
		soapModel.setTitle(model.getTitle());
		soapModel.setDescription(model.getDescription());
		soapModel.setUrl(model.getUrl());

		return soapModel;
	}

	public static CrudAppsSoap[] toSoapModels(CrudApps[] models) {
		CrudAppsSoap[] soapModels = new CrudAppsSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static CrudAppsSoap[][] toSoapModels(CrudApps[][] models) {
		CrudAppsSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new CrudAppsSoap[models.length][models[0].length];
		}
		else {
			soapModels = new CrudAppsSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static CrudAppsSoap[] toSoapModels(List<CrudApps> models) {
		List<CrudAppsSoap> soapModels = new ArrayList<CrudAppsSoap>(
			models.size());

		for (CrudApps model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new CrudAppsSoap[soapModels.size()]);
	}

	public CrudAppsSoap() {
	}

	public long getPrimaryKey() {
		return _appId;
	}

	public void setPrimaryKey(long pk) {
		setAppId(pk);
	}

	public String getUuid() {
		return _uuid;
	}

	public void setUuid(String uuid) {
		_uuid = uuid;
	}

	public long getAppId() {
		return _appId;
	}

	public void setAppId(long appId) {
		_appId = appId;
	}

	public String getTitle() {
		return _title;
	}

	public void setTitle(String title) {
		_title = title;
	}

	public String getDescription() {
		return _description;
	}

	public void setDescription(String description) {
		_description = description;
	}

	public String getUrl() {
		return _url;
	}

	public void setUrl(String url) {
		_url = url;
	}

	private String _uuid;
	private long _appId;
	private String _title;
	private String _description;
	private String _url;

}