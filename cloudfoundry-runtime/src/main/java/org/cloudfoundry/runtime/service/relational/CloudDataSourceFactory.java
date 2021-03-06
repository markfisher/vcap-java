package org.cloudfoundry.runtime.service.relational;

import javax.sql.DataSource;

import org.cloudfoundry.runtime.env.CloudEnvironment;
import org.cloudfoundry.runtime.env.MysqlServiceInfo;
import org.cloudfoundry.runtime.service.AbstractCloudServiceFactory;

/**
 * Spring factory bean for datasource service.
 * 
 * @author Ramnivas Laddad
 *
 */
public class CloudDataSourceFactory extends AbstractCloudServiceFactory<DataSource, MysqlServiceInfo> {
	public CloudDataSourceFactory(CloudEnvironment cloudEnvironment) {
		super(new MysqlServiceCreator(cloudEnvironment));
	}

	public CloudDataSourceFactory() {
		super(new MysqlServiceCreator(new CloudEnvironment()));
	}

	@Override
	public Class<? extends DataSource> getObjectType() {
		return DataSource.class;
	}
}
