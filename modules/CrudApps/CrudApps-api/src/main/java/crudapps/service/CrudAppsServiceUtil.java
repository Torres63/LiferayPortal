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

import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;
import org.osgi.util.tracker.ServiceTracker;

/**
 * Provides the remote service utility for CrudApps. This utility wraps
 * <code>crudapps.service.impl.CrudAppsServiceImpl</code> and is an
 * access point for service operations in application layer code running on a
 * remote server. Methods of this service are expected to have security checks
 * based on the propagated JAAS credentials because this service can be
 * accessed remotely.
 *
 * @author Brian Wing Shun Chan
 * @see CrudAppsService
 * @generated
 */
public class CrudAppsServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>crudapps.service.impl.CrudAppsServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	public static String getOSGiServiceIdentifier() {
		return getService().getOSGiServiceIdentifier();
	}

	public static CrudAppsService getService() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<CrudAppsService, CrudAppsService>
		_serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(CrudAppsService.class);

		ServiceTracker<CrudAppsService, CrudAppsService> serviceTracker =
			new ServiceTracker<CrudAppsService, CrudAppsService>(
				bundle.getBundleContext(), CrudAppsService.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}