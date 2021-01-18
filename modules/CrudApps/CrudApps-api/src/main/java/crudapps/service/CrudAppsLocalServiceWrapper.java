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

package crudapps.service;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link CrudAppsLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see CrudAppsLocalService
 * @generated
 */
public class CrudAppsLocalServiceWrapper
	implements CrudAppsLocalService, ServiceWrapper<CrudAppsLocalService> {

	public CrudAppsLocalServiceWrapper(
		CrudAppsLocalService crudAppsLocalService) {

		_crudAppsLocalService = crudAppsLocalService;
	}

	/**
	 * Adds the crud apps to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect CrudAppsLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param crudApps the crud apps
	 * @return the crud apps that was added
	 */
	@Override
	public crudapps.model.CrudApps addCrudApps(
		crudapps.model.CrudApps crudApps) {

		return _crudAppsLocalService.addCrudApps(crudApps);
	}

	/**
	 * Creates a new crud apps with the primary key. Does not add the crud apps to the database.
	 *
	 * @param appId the primary key for the new crud apps
	 * @return the new crud apps
	 */
	@Override
	public crudapps.model.CrudApps createCrudApps(long appId) {
		return _crudAppsLocalService.createCrudApps(appId);
	}

	/**
	 * Deletes the crud apps from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect CrudAppsLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param crudApps the crud apps
	 * @return the crud apps that was removed
	 */
	@Override
	public crudapps.model.CrudApps deleteCrudApps(
		crudapps.model.CrudApps crudApps) {

		return _crudAppsLocalService.deleteCrudApps(crudApps);
	}

	/**
	 * Deletes the crud apps with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect CrudAppsLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param appId the primary key of the crud apps
	 * @return the crud apps that was removed
	 * @throws PortalException if a crud apps with the primary key could not be found
	 */
	@Override
	public crudapps.model.CrudApps deleteCrudApps(long appId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _crudAppsLocalService.deleteCrudApps(appId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _crudAppsLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _crudAppsLocalService.dynamicQuery();
	}

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {

		return _crudAppsLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>crudapps.model.impl.CrudAppsModelImpl</code>.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @return the range of matching rows
	 */
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {

		return _crudAppsLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>crudapps.model.impl.CrudAppsModelImpl</code>.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching rows
	 */
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {

		return _crudAppsLocalService.dynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows matching the dynamic query
	 */
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {

		return _crudAppsLocalService.dynamicQueryCount(dynamicQuery);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @param projection the projection to apply to the query
	 * @return the number of rows matching the dynamic query
	 */
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection) {

		return _crudAppsLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public crudapps.model.CrudApps fetchCrudApps(long appId) {
		return _crudAppsLocalService.fetchCrudApps(appId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _crudAppsLocalService.getActionableDynamicQuery();
	}

	/**
	 * Returns the crud apps with the primary key.
	 *
	 * @param appId the primary key of the crud apps
	 * @return the crud apps
	 * @throws PortalException if a crud apps with the primary key could not be found
	 */
	@Override
	public crudapps.model.CrudApps getCrudApps(long appId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _crudAppsLocalService.getCrudApps(appId);
	}

	/**
	 * Returns a range of all the crud appses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>crudapps.model.impl.CrudAppsModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of crud appses
	 * @param end the upper bound of the range of crud appses (not inclusive)
	 * @return the range of crud appses
	 */
	@Override
	public java.util.List<crudapps.model.CrudApps> getCrudAppses(
		int start, int end) {

		return _crudAppsLocalService.getCrudAppses(start, end);
	}

	/**
	 * Returns the number of crud appses.
	 *
	 * @return the number of crud appses
	 */
	@Override
	public int getCrudAppsesCount() {
		return _crudAppsLocalService.getCrudAppsesCount();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _crudAppsLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _crudAppsLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _crudAppsLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Updates the crud apps in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect CrudAppsLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param crudApps the crud apps
	 * @return the crud apps that was updated
	 */
	@Override
	public crudapps.model.CrudApps updateCrudApps(
		crudapps.model.CrudApps crudApps) {

		return _crudAppsLocalService.updateCrudApps(crudApps);
	}

	@Override
	public CrudAppsLocalService getWrappedService() {
		return _crudAppsLocalService;
	}

	@Override
	public void setWrappedService(CrudAppsLocalService crudAppsLocalService) {
		_crudAppsLocalService = crudAppsLocalService;
	}

	private CrudAppsLocalService _crudAppsLocalService;

}