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

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import crudapps.exception.NoSuchCrudAppsException;

import crudapps.model.CrudApps;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the crud apps service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see CrudAppsUtil
 * @generated
 */
@ProviderType
public interface CrudAppsPersistence extends BasePersistence<CrudApps> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link CrudAppsUtil} to access the crud apps persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the crud appses where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching crud appses
	 */
	public java.util.List<CrudApps> findByUuid(String uuid);

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
	public java.util.List<CrudApps> findByUuid(String uuid, int start, int end);

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
	public java.util.List<CrudApps> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<CrudApps>
			orderByComparator);

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
	public java.util.List<CrudApps> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<CrudApps>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first crud apps in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching crud apps
	 * @throws NoSuchCrudAppsException if a matching crud apps could not be found
	 */
	public CrudApps findByUuid_First(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<CrudApps>
				orderByComparator)
		throws NoSuchCrudAppsException;

	/**
	 * Returns the first crud apps in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching crud apps, or <code>null</code> if a matching crud apps could not be found
	 */
	public CrudApps fetchByUuid_First(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<CrudApps>
			orderByComparator);

	/**
	 * Returns the last crud apps in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching crud apps
	 * @throws NoSuchCrudAppsException if a matching crud apps could not be found
	 */
	public CrudApps findByUuid_Last(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<CrudApps>
				orderByComparator)
		throws NoSuchCrudAppsException;

	/**
	 * Returns the last crud apps in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching crud apps, or <code>null</code> if a matching crud apps could not be found
	 */
	public CrudApps fetchByUuid_Last(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<CrudApps>
			orderByComparator);

	/**
	 * Returns the crud appses before and after the current crud apps in the ordered set where uuid = &#63;.
	 *
	 * @param appId the primary key of the current crud apps
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next crud apps
	 * @throws NoSuchCrudAppsException if a crud apps with the primary key could not be found
	 */
	public CrudApps[] findByUuid_PrevAndNext(
			long appId, String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<CrudApps>
				orderByComparator)
		throws NoSuchCrudAppsException;

	/**
	 * Removes all the crud appses where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public void removeByUuid(String uuid);

	/**
	 * Returns the number of crud appses where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching crud appses
	 */
	public int countByUuid(String uuid);

	/**
	 * Caches the crud apps in the entity cache if it is enabled.
	 *
	 * @param crudApps the crud apps
	 */
	public void cacheResult(CrudApps crudApps);

	/**
	 * Caches the crud appses in the entity cache if it is enabled.
	 *
	 * @param crudAppses the crud appses
	 */
	public void cacheResult(java.util.List<CrudApps> crudAppses);

	/**
	 * Creates a new crud apps with the primary key. Does not add the crud apps to the database.
	 *
	 * @param appId the primary key for the new crud apps
	 * @return the new crud apps
	 */
	public CrudApps create(long appId);

	/**
	 * Removes the crud apps with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param appId the primary key of the crud apps
	 * @return the crud apps that was removed
	 * @throws NoSuchCrudAppsException if a crud apps with the primary key could not be found
	 */
	public CrudApps remove(long appId) throws NoSuchCrudAppsException;

	public CrudApps updateImpl(CrudApps crudApps);

	/**
	 * Returns the crud apps with the primary key or throws a <code>NoSuchCrudAppsException</code> if it could not be found.
	 *
	 * @param appId the primary key of the crud apps
	 * @return the crud apps
	 * @throws NoSuchCrudAppsException if a crud apps with the primary key could not be found
	 */
	public CrudApps findByPrimaryKey(long appId) throws NoSuchCrudAppsException;

	/**
	 * Returns the crud apps with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param appId the primary key of the crud apps
	 * @return the crud apps, or <code>null</code> if a crud apps with the primary key could not be found
	 */
	public CrudApps fetchByPrimaryKey(long appId);

	/**
	 * Returns all the crud appses.
	 *
	 * @return the crud appses
	 */
	public java.util.List<CrudApps> findAll();

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
	public java.util.List<CrudApps> findAll(int start, int end);

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
	public java.util.List<CrudApps> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<CrudApps>
			orderByComparator);

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
	public java.util.List<CrudApps> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<CrudApps>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the crud appses from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of crud appses.
	 *
	 * @return the number of crud appses
	 */
	public int countAll();

}