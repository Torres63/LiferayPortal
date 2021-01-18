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

package crudapps.service.persistence.impl;

import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.configuration.Configuration;
import com.liferay.portal.kernel.dao.orm.EntityCache;
import com.liferay.portal.kernel.dao.orm.FinderCache;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.dao.orm.SessionFactory;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.service.persistence.impl.BasePersistenceImpl;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.SetUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.uuid.PortalUUIDUtil;

import crudapps.exception.NoSuchCrudAppsException;

import crudapps.model.CrudApps;
import crudapps.model.impl.CrudAppsImpl;
import crudapps.model.impl.CrudAppsModelImpl;

import crudapps.service.persistence.CrudAppsPersistence;
import crudapps.service.persistence.impl.constants.CrudAppsPersistenceConstants;

import java.io.Serializable;

import java.lang.reflect.InvocationHandler;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

import javax.sql.DataSource;

import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Reference;

/**
 * The persistence implementation for the crud apps service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = CrudAppsPersistence.class)
public class CrudAppsPersistenceImpl
	extends BasePersistenceImpl<CrudApps> implements CrudAppsPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>CrudAppsUtil</code> to access the crud apps persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		CrudAppsImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;
	private FinderPath _finderPathWithPaginationFindByUuid;
	private FinderPath _finderPathWithoutPaginationFindByUuid;
	private FinderPath _finderPathCountByUuid;

	/**
	 * Returns all the crud appses where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching crud appses
	 */
	@Override
	public List<CrudApps> findByUuid(String uuid) {
		return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<CrudApps> findByUuid(String uuid, int start, int end) {
		return findByUuid(uuid, start, end, null);
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
	@Override
	public List<CrudApps> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<CrudApps> orderByComparator) {

		return findByUuid(uuid, start, end, orderByComparator, true);
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
	@Override
	public List<CrudApps> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<CrudApps> orderByComparator, boolean useFinderCache) {

		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByUuid;
				finderArgs = new Object[] {uuid};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByUuid;
			finderArgs = new Object[] {uuid, start, end, orderByComparator};
		}

		List<CrudApps> list = null;

		if (useFinderCache) {
			list = (List<CrudApps>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (CrudApps crudApps : list) {
					if (!uuid.equals(crudApps.getUuid())) {
						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler sb = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					3 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				sb = new StringBundler(3);
			}

			sb.append(_SQL_SELECT_CRUDAPPS_WHERE);

			boolean bindUuid = false;

			if (uuid.isEmpty()) {
				sb.append(_FINDER_COLUMN_UUID_UUID_3);
			}
			else {
				bindUuid = true;

				sb.append(_FINDER_COLUMN_UUID_UUID_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(CrudAppsModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindUuid) {
					queryPos.add(uuid);
				}

				list = (List<CrudApps>)QueryUtil.list(
					query, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					finderCache.putResult(finderPath, finderArgs, list);
				}
			}
			catch (Exception exception) {
				if (useFinderCache) {
					finderCache.removeResult(finderPath, finderArgs);
				}

				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first crud apps in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching crud apps
	 * @throws NoSuchCrudAppsException if a matching crud apps could not be found
	 */
	@Override
	public CrudApps findByUuid_First(
			String uuid, OrderByComparator<CrudApps> orderByComparator)
		throws NoSuchCrudAppsException {

		CrudApps crudApps = fetchByUuid_First(uuid, orderByComparator);

		if (crudApps != null) {
			return crudApps;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchCrudAppsException(sb.toString());
	}

	/**
	 * Returns the first crud apps in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching crud apps, or <code>null</code> if a matching crud apps could not be found
	 */
	@Override
	public CrudApps fetchByUuid_First(
		String uuid, OrderByComparator<CrudApps> orderByComparator) {

		List<CrudApps> list = findByUuid(uuid, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last crud apps in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching crud apps
	 * @throws NoSuchCrudAppsException if a matching crud apps could not be found
	 */
	@Override
	public CrudApps findByUuid_Last(
			String uuid, OrderByComparator<CrudApps> orderByComparator)
		throws NoSuchCrudAppsException {

		CrudApps crudApps = fetchByUuid_Last(uuid, orderByComparator);

		if (crudApps != null) {
			return crudApps;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchCrudAppsException(sb.toString());
	}

	/**
	 * Returns the last crud apps in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching crud apps, or <code>null</code> if a matching crud apps could not be found
	 */
	@Override
	public CrudApps fetchByUuid_Last(
		String uuid, OrderByComparator<CrudApps> orderByComparator) {

		int count = countByUuid(uuid);

		if (count == 0) {
			return null;
		}

		List<CrudApps> list = findByUuid(
			uuid, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public CrudApps[] findByUuid_PrevAndNext(
			long appId, String uuid,
			OrderByComparator<CrudApps> orderByComparator)
		throws NoSuchCrudAppsException {

		uuid = Objects.toString(uuid, "");

		CrudApps crudApps = findByPrimaryKey(appId);

		Session session = null;

		try {
			session = openSession();

			CrudApps[] array = new CrudAppsImpl[3];

			array[0] = getByUuid_PrevAndNext(
				session, crudApps, uuid, orderByComparator, true);

			array[1] = crudApps;

			array[2] = getByUuid_PrevAndNext(
				session, crudApps, uuid, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected CrudApps getByUuid_PrevAndNext(
		Session session, CrudApps crudApps, String uuid,
		OrderByComparator<CrudApps> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_CRUDAPPS_WHERE);

		boolean bindUuid = false;

		if (uuid.isEmpty()) {
			sb.append(_FINDER_COLUMN_UUID_UUID_3);
		}
		else {
			bindUuid = true;

			sb.append(_FINDER_COLUMN_UUID_UUID_2);
		}

		if (orderByComparator != null) {
			String[] orderByConditionFields =
				orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				sb.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						sb.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN);
					}
					else {
						sb.append(WHERE_LESSER_THAN);
					}
				}
			}

			sb.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						sb.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC);
					}
					else {
						sb.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			sb.append(CrudAppsModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		if (bindUuid) {
			queryPos.add(uuid);
		}

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(crudApps)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<CrudApps> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the crud appses where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	@Override
	public void removeByUuid(String uuid) {
		for (CrudApps crudApps :
				findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(crudApps);
		}
	}

	/**
	 * Returns the number of crud appses where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching crud appses
	 */
	@Override
	public int countByUuid(String uuid) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid;

		Object[] finderArgs = new Object[] {uuid};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_CRUDAPPS_WHERE);

			boolean bindUuid = false;

			if (uuid.isEmpty()) {
				sb.append(_FINDER_COLUMN_UUID_UUID_3);
			}
			else {
				bindUuid = true;

				sb.append(_FINDER_COLUMN_UUID_UUID_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindUuid) {
					queryPos.add(uuid);
				}

				count = (Long)query.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception exception) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_UUID_UUID_2 =
		"crudApps.uuid = ?";

	private static final String _FINDER_COLUMN_UUID_UUID_3 =
		"(crudApps.uuid IS NULL OR crudApps.uuid = '')";

	public CrudAppsPersistenceImpl() {
		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("uuid", "uuid_");

		setDBColumnNames(dbColumnNames);

		setModelClass(CrudApps.class);

		setModelImplClass(CrudAppsImpl.class);
		setModelPKClass(long.class);
	}

	/**
	 * Caches the crud apps in the entity cache if it is enabled.
	 *
	 * @param crudApps the crud apps
	 */
	@Override
	public void cacheResult(CrudApps crudApps) {
		entityCache.putResult(
			entityCacheEnabled, CrudAppsImpl.class, crudApps.getPrimaryKey(),
			crudApps);

		crudApps.resetOriginalValues();
	}

	/**
	 * Caches the crud appses in the entity cache if it is enabled.
	 *
	 * @param crudAppses the crud appses
	 */
	@Override
	public void cacheResult(List<CrudApps> crudAppses) {
		for (CrudApps crudApps : crudAppses) {
			if (entityCache.getResult(
					entityCacheEnabled, CrudAppsImpl.class,
					crudApps.getPrimaryKey()) == null) {

				cacheResult(crudApps);
			}
			else {
				crudApps.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all crud appses.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(CrudAppsImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the crud apps.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(CrudApps crudApps) {
		entityCache.removeResult(
			entityCacheEnabled, CrudAppsImpl.class, crudApps.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<CrudApps> crudAppses) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (CrudApps crudApps : crudAppses) {
			entityCache.removeResult(
				entityCacheEnabled, CrudAppsImpl.class,
				crudApps.getPrimaryKey());
		}
	}

	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(
				entityCacheEnabled, CrudAppsImpl.class, primaryKey);
		}
	}

	/**
	 * Creates a new crud apps with the primary key. Does not add the crud apps to the database.
	 *
	 * @param appId the primary key for the new crud apps
	 * @return the new crud apps
	 */
	@Override
	public CrudApps create(long appId) {
		CrudApps crudApps = new CrudAppsImpl();

		crudApps.setNew(true);
		crudApps.setPrimaryKey(appId);

		String uuid = PortalUUIDUtil.generate();

		crudApps.setUuid(uuid);

		return crudApps;
	}

	/**
	 * Removes the crud apps with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param appId the primary key of the crud apps
	 * @return the crud apps that was removed
	 * @throws NoSuchCrudAppsException if a crud apps with the primary key could not be found
	 */
	@Override
	public CrudApps remove(long appId) throws NoSuchCrudAppsException {
		return remove((Serializable)appId);
	}

	/**
	 * Removes the crud apps with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the crud apps
	 * @return the crud apps that was removed
	 * @throws NoSuchCrudAppsException if a crud apps with the primary key could not be found
	 */
	@Override
	public CrudApps remove(Serializable primaryKey)
		throws NoSuchCrudAppsException {

		Session session = null;

		try {
			session = openSession();

			CrudApps crudApps = (CrudApps)session.get(
				CrudAppsImpl.class, primaryKey);

			if (crudApps == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchCrudAppsException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(crudApps);
		}
		catch (NoSuchCrudAppsException noSuchEntityException) {
			throw noSuchEntityException;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	@Override
	protected CrudApps removeImpl(CrudApps crudApps) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(crudApps)) {
				crudApps = (CrudApps)session.get(
					CrudAppsImpl.class, crudApps.getPrimaryKeyObj());
			}

			if (crudApps != null) {
				session.delete(crudApps);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (crudApps != null) {
			clearCache(crudApps);
		}

		return crudApps;
	}

	@Override
	public CrudApps updateImpl(CrudApps crudApps) {
		boolean isNew = crudApps.isNew();

		if (!(crudApps instanceof CrudAppsModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(crudApps.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(crudApps);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in crudApps proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom CrudApps implementation " +
					crudApps.getClass());
		}

		CrudAppsModelImpl crudAppsModelImpl = (CrudAppsModelImpl)crudApps;

		if (Validator.isNull(crudApps.getUuid())) {
			String uuid = PortalUUIDUtil.generate();

			crudApps.setUuid(uuid);
		}

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(crudApps);

				crudApps.setNew(false);
			}
			else {
				crudApps = (CrudApps)session.merge(crudApps);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (!_columnBitmaskEnabled) {
			finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}
		else if (isNew) {
			Object[] args = new Object[] {crudAppsModelImpl.getUuid()};

			finderCache.removeResult(_finderPathCountByUuid, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByUuid, args);

			finderCache.removeResult(_finderPathCountAll, FINDER_ARGS_EMPTY);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindAll, FINDER_ARGS_EMPTY);
		}
		else {
			if ((crudAppsModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByUuid.getColumnBitmask()) !=
					 0) {

				Object[] args = new Object[] {
					crudAppsModelImpl.getOriginalUuid()
				};

				finderCache.removeResult(_finderPathCountByUuid, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByUuid, args);

				args = new Object[] {crudAppsModelImpl.getUuid()};

				finderCache.removeResult(_finderPathCountByUuid, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByUuid, args);
			}
		}

		entityCache.putResult(
			entityCacheEnabled, CrudAppsImpl.class, crudApps.getPrimaryKey(),
			crudApps, false);

		crudApps.resetOriginalValues();

		return crudApps;
	}

	/**
	 * Returns the crud apps with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the crud apps
	 * @return the crud apps
	 * @throws NoSuchCrudAppsException if a crud apps with the primary key could not be found
	 */
	@Override
	public CrudApps findByPrimaryKey(Serializable primaryKey)
		throws NoSuchCrudAppsException {

		CrudApps crudApps = fetchByPrimaryKey(primaryKey);

		if (crudApps == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchCrudAppsException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return crudApps;
	}

	/**
	 * Returns the crud apps with the primary key or throws a <code>NoSuchCrudAppsException</code> if it could not be found.
	 *
	 * @param appId the primary key of the crud apps
	 * @return the crud apps
	 * @throws NoSuchCrudAppsException if a crud apps with the primary key could not be found
	 */
	@Override
	public CrudApps findByPrimaryKey(long appId)
		throws NoSuchCrudAppsException {

		return findByPrimaryKey((Serializable)appId);
	}

	/**
	 * Returns the crud apps with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param appId the primary key of the crud apps
	 * @return the crud apps, or <code>null</code> if a crud apps with the primary key could not be found
	 */
	@Override
	public CrudApps fetchByPrimaryKey(long appId) {
		return fetchByPrimaryKey((Serializable)appId);
	}

	/**
	 * Returns all the crud appses.
	 *
	 * @return the crud appses
	 */
	@Override
	public List<CrudApps> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<CrudApps> findAll(int start, int end) {
		return findAll(start, end, null);
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
	@Override
	public List<CrudApps> findAll(
		int start, int end, OrderByComparator<CrudApps> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
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
	@Override
	public List<CrudApps> findAll(
		int start, int end, OrderByComparator<CrudApps> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindAll;
				finderArgs = FINDER_ARGS_EMPTY;
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindAll;
			finderArgs = new Object[] {start, end, orderByComparator};
		}

		List<CrudApps> list = null;

		if (useFinderCache) {
			list = (List<CrudApps>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_CRUDAPPS);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_CRUDAPPS;

				sql = sql.concat(CrudAppsModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<CrudApps>)QueryUtil.list(
					query, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					finderCache.putResult(finderPath, finderArgs, list);
				}
			}
			catch (Exception exception) {
				if (useFinderCache) {
					finderCache.removeResult(finderPath, finderArgs);
				}

				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Removes all the crud appses from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (CrudApps crudApps : findAll()) {
			remove(crudApps);
		}
	}

	/**
	 * Returns the number of crud appses.
	 *
	 * @return the number of crud appses
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_CRUDAPPS);

				count = (Long)query.uniqueResult();

				finderCache.putResult(
					_finderPathCountAll, FINDER_ARGS_EMPTY, count);
			}
			catch (Exception exception) {
				finderCache.removeResult(
					_finderPathCountAll, FINDER_ARGS_EMPTY);

				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	@Override
	public Set<String> getBadColumnNames() {
		return _badColumnNames;
	}

	@Override
	protected EntityCache getEntityCache() {
		return entityCache;
	}

	@Override
	protected String getPKDBName() {
		return "appId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_CRUDAPPS;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return CrudAppsModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the crud apps persistence.
	 */
	@Activate
	public void activate() {
		CrudAppsModelImpl.setEntityCacheEnabled(entityCacheEnabled);
		CrudAppsModelImpl.setFinderCacheEnabled(finderCacheEnabled);

		_finderPathWithPaginationFindAll = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, CrudAppsImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);

		_finderPathWithoutPaginationFindAll = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, CrudAppsImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll",
			new String[0]);

		_finderPathCountAll = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll",
			new String[0]);

		_finderPathWithPaginationFindByUuid = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, CrudAppsImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUuid",
			new String[] {
				String.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByUuid = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, CrudAppsImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUuid",
			new String[] {String.class.getName()},
			CrudAppsModelImpl.UUID_COLUMN_BITMASK);

		_finderPathCountByUuid = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUuid",
			new String[] {String.class.getName()});
	}

	@Deactivate
	public void deactivate() {
		entityCache.removeCache(CrudAppsImpl.class.getName());

		finderCache.removeCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	@Reference(
		target = CrudAppsPersistenceConstants.SERVICE_CONFIGURATION_FILTER,
		unbind = "-"
	)
	public void setConfiguration(Configuration configuration) {
		super.setConfiguration(configuration);

		_columnBitmaskEnabled = GetterUtil.getBoolean(
			configuration.get(
				"value.object.column.bitmask.enabled.crudapps.model.CrudApps"),
			true);
	}

	@Override
	@Reference(
		target = CrudAppsPersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
		unbind = "-"
	)
	public void setDataSource(DataSource dataSource) {
		super.setDataSource(dataSource);
	}

	@Override
	@Reference(
		target = CrudAppsPersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
		unbind = "-"
	)
	public void setSessionFactory(SessionFactory sessionFactory) {
		super.setSessionFactory(sessionFactory);
	}

	private boolean _columnBitmaskEnabled;

	@Reference
	protected EntityCache entityCache;

	@Reference
	protected FinderCache finderCache;

	private static final String _SQL_SELECT_CRUDAPPS =
		"SELECT crudApps FROM CrudApps crudApps";

	private static final String _SQL_SELECT_CRUDAPPS_WHERE =
		"SELECT crudApps FROM CrudApps crudApps WHERE ";

	private static final String _SQL_COUNT_CRUDAPPS =
		"SELECT COUNT(crudApps) FROM CrudApps crudApps";

	private static final String _SQL_COUNT_CRUDAPPS_WHERE =
		"SELECT COUNT(crudApps) FROM CrudApps crudApps WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "crudApps.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No CrudApps exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No CrudApps exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		CrudAppsPersistenceImpl.class);

	private static final Set<String> _badColumnNames = SetUtil.fromArray(
		new String[] {"uuid"});

	static {
		try {
			Class.forName(CrudAppsPersistenceConstants.class.getName());
		}
		catch (ClassNotFoundException classNotFoundException) {
			throw new ExceptionInInitializerError(classNotFoundException);
		}
	}

}