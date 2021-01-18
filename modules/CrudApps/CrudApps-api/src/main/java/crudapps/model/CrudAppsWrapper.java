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

import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.wrapper.BaseModelWrapper;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link CrudApps}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see CrudApps
 * @generated
 */
public class CrudAppsWrapper
	extends BaseModelWrapper<CrudApps>
	implements CrudApps, ModelWrapper<CrudApps> {

	public CrudAppsWrapper(CrudApps crudApps) {
		super(crudApps);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("appId", getAppId());
		attributes.put("title", getTitle());
		attributes.put("description", getDescription());
		attributes.put("url", getUrl());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long appId = (Long)attributes.get("appId");

		if (appId != null) {
			setAppId(appId);
		}

		String title = (String)attributes.get("title");

		if (title != null) {
			setTitle(title);
		}

		String description = (String)attributes.get("description");

		if (description != null) {
			setDescription(description);
		}

		String url = (String)attributes.get("url");

		if (url != null) {
			setUrl(url);
		}
	}

	/**
	 * Returns the app ID of this crud apps.
	 *
	 * @return the app ID of this crud apps
	 */
	@Override
	public long getAppId() {
		return model.getAppId();
	}

	/**
	 * Returns the description of this crud apps.
	 *
	 * @return the description of this crud apps
	 */
	@Override
	public String getDescription() {
		return model.getDescription();
	}

	/**
	 * Returns the primary key of this crud apps.
	 *
	 * @return the primary key of this crud apps
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the title of this crud apps.
	 *
	 * @return the title of this crud apps
	 */
	@Override
	public String getTitle() {
		return model.getTitle();
	}

	/**
	 * Returns the url of this crud apps.
	 *
	 * @return the url of this crud apps
	 */
	@Override
	public String getUrl() {
		return model.getUrl();
	}

	/**
	 * Returns the uuid of this crud apps.
	 *
	 * @return the uuid of this crud apps
	 */
	@Override
	public String getUuid() {
		return model.getUuid();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets the app ID of this crud apps.
	 *
	 * @param appId the app ID of this crud apps
	 */
	@Override
	public void setAppId(long appId) {
		model.setAppId(appId);
	}

	/**
	 * Sets the description of this crud apps.
	 *
	 * @param description the description of this crud apps
	 */
	@Override
	public void setDescription(String description) {
		model.setDescription(description);
	}

	/**
	 * Sets the primary key of this crud apps.
	 *
	 * @param primaryKey the primary key of this crud apps
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the title of this crud apps.
	 *
	 * @param title the title of this crud apps
	 */
	@Override
	public void setTitle(String title) {
		model.setTitle(title);
	}

	/**
	 * Sets the url of this crud apps.
	 *
	 * @param url the url of this crud apps
	 */
	@Override
	public void setUrl(String url) {
		model.setUrl(url);
	}

	/**
	 * Sets the uuid of this crud apps.
	 *
	 * @param uuid the uuid of this crud apps
	 */
	@Override
	public void setUuid(String uuid) {
		model.setUuid(uuid);
	}

	@Override
	protected CrudAppsWrapper wrap(CrudApps crudApps) {
		return new CrudAppsWrapper(crudApps);
	}

}