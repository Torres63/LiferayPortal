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

package crudapps.service.persistence;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import crudapps.model.CrudApps;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;
import org.osgi.util.tracker.ServiceTracker;

/**
 * The persistence utility for the crud apps service. This utility wraps <code>crudapps.service.persistence.impl.CrudAppsPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see CrudAppsPersistence
 * @generated
 */
public class CrudAppsUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache()
	 */
	public static void clearCache() {
		getPersistence().clearCache();
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static void clearCache(CrudApps crudApps) {
		getPersistence().clearCache(crudApps);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#countWithDynamicQuery(DynamicQuery)
	 */
	public static long countWithDynamicQuery(DynamicQuery dynamicQuery) {
		return getPersistence().countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#fetchByPrimaryKeys(Set)
	 */
	public static Map<Serializable, CrudApps> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<CrudApps> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<CrudApps> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<CrudApps> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<CrudApps> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static CrudApps update(CrudApps crudApps) {
		return getPersistence().update(crudApps);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static CrudApps update(
		CrudApps crudApps, ServiceContext serviceContext) {

		return getPersistence().update(crudApps, serviceContext);
	}

	/**
	 * Returns all the crud appses where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching crud appses
	 */
	public static List<CrudApps> findByUuid(String uuid) {
		return getPersistence().findByUuid(uuid);
	}

	/**
	 * Returns a range of all the crud appses where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CrudAppsModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of crud appses
	 * @param end the upper bound of the range of crud appses (not inclusive)
	 * @return the range of matching crud appses
	 */
	public static List<CrudApps> findByUuid(String uuid, int start, int end) {
		return getPersistence().findByUuid(uuid, start, end);
	}

	/**
	 * Returns an ordered range of all the crud appses where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CrudAppsModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of crud appses
	 * @param end the upper bound of the range of crud appses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching crud appses
	 */
	public static List<CrudApps> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<CrudApps> orderByComparator) {

		return getPersistence().findByUuid(uuid, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the crud appses where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CrudAppsModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of crud appses
	 * @param end the upper bound of the range of crud appses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching crud appses
	 */
	public static List<CrudApps> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<CrudApps> orderByComparator, boolean useFinderCache) {

		return getPersistence().findByUuid(
			uuid, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first crud apps in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching crud apps
	 * @throws NoSuchCrudAppsException if a matching crud apps could not be found
	 */
	public static CrudApps findByUuid_First(
			String uuid, OrderByComparator<CrudApps> orderByComparator)
		throws crudapps.exception.NoSuchCrudAppsException {

		return getPersistence().findByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the first crud apps in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching crud apps, or <code>null</code> if a matching crud apps could not be found
	 */
	public static CrudApps fetchByUuid_First(
		String uuid, OrderByComparator<CrudApps> orderByComparator) {

		return getPersistence().fetchByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the last crud apps in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching crud apps
	 * @throws NoSuchCrudAppsException if a matching crud apps could not be found
	 */
	public static CrudApps findByUuid_Last(
			String uuid, OrderByComparator<CrudApps> orderByComparator)
		throws crudapps.exception.NoSuchCrudAppsException {

		return getPersistence().findByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the last crud apps in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching crud apps, or <code>null</code> if a matching crud apps could not be found
	 */
	public static CrudApps fetchByUuid_Last(
		String uuid, OrderByComparator<CrudApps> orderByComparator) {

		return getPersistence().fetchByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the crud appses before and after the current crud apps in the ordered set where uuid = &#63;.
	 *
	 * @param appId the primary key of the current crud apps
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next crud apps
	 * @throws NoSuchCrudAppsException if a crud apps with the primary key could not be found
	 */
	public static CrudApps[] findByUuid_PrevAndNext(
			long appId, String uuid,
			OrderByComparator<CrudApps> orderByComparator)
		throws crudapps.exception.NoSuchCrudAppsException {

		return getPersistence().findByUuid_PrevAndNext(
			appId, uuid, orderByComparator);
	}

	/**
	 * Removes all the crud appses where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public static void removeByUuid(String uuid) {
		getPersistence().removeByUuid(uuid);
	}

	/**
	 * Returns the number of crud appses where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching crud appses
	 */
	public static int countByUuid(String uuid) {
		return getPersistence().countByUuid(uuid);
	}

	/**
	 * Caches the crud apps in the entity cache if it is enabled.
	 *
	 * @param crudApps the crud apps
	 */
	public static void cacheResult(CrudApps crudApps) {
		getPersistence().cacheResult(crudApps);
	}

	/**
	 * Caches the crud appses in the entity cache if it is enabled.
	 *
	 * @param crudAppses the crud appses
	 */
	public static void cacheResult(List<CrudApps> crudAppses) {
		getPersistence().cacheResult(crudAppses);
	}

	/**
	 * Creates a new crud apps with the primary key. Does not add the crud apps to the database.
	 *
	 * @param appId the primary key for the new crud apps
	 * @return the new crud apps
	 */
	public static CrudApps create(long appId) {
		return getPersistence().create(appId);
	}

	/**
	 * Removes the crud apps with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param appId the primary key of the crud apps
	 * @return the crud apps that was removed
	 * @throws NoSuchCrudAppsException if a crud apps with the primary key could not be found
	 */
	public static CrudApps remove(long appId)
		throws crudapps.exception.NoSuchCrudAppsException {

		return getPersistence().remove(appId);
	}

	public static CrudApps updateImpl(CrudApps crudApps) {
		return getPersistence().updateImpl(crudApps);
	}

	/**
	 * Returns the crud apps with the primary key or throws a <code>NoSuchCrudAppsException</code> if it could not be found.
	 *
	 * @param appId the primary key of the crud apps
	 * @return the crud apps
	 * @throws NoSuchCrudAppsException if a crud apps with the primary key could not be found
	 */
	public static CrudApps findByPrimaryKey(long appId)
		throws crudapps.exception.NoSuchCrudAppsException {

		return getPersistence().findByPrimaryKey(appId);
	}

	/**
	 * Returns the crud apps with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param appId the primary key of the crud apps
	 * @return the crud apps, or <code>null</code> if a crud apps with the primary key could not be found
	 */
	public static CrudApps fetchByPrimaryKey(long appId) {
		return getPersistence().fetchByPrimaryKey(appId);
	}

	/**
	 * Returns all the crud appses.
	 *
	 * @return the crud appses
	 */
	public static List<CrudApps> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the crud appses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CrudAppsModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of crud appses
	 * @param end the upper bound of the range of crud appses (not inclusive)
	 * @return the range of crud appses
	 */
	public static List<CrudApps> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the crud appses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CrudAppsModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of crud appses
	 * @param end the upper bound of the range of crud appses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of crud appses
	 */
	public static List<CrudApps> findAll(
		int start, int end, OrderByComparator<CrudApps> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the crud appses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CrudAppsModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of crud appses
	 * @param end the upper bound of the range of crud appses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of crud appses
	 */
	public static List<CrudApps> findAll(
		int start, int end, OrderByComparator<CrudApps> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the crud appses from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of crud appses.
	 *
	 * @return the number of crud appses
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static CrudAppsPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<CrudAppsPersistence, CrudAppsPersistence>
		_serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(CrudAppsPersistence.class);

		ServiceTracker<CrudAppsPersistence, CrudAppsPersistence>
			serviceTracker =
				new ServiceTracker<CrudAppsPersistence, CrudAppsPersistence>(
					bundle.getBundleContext(), CrudAppsPersistence.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}