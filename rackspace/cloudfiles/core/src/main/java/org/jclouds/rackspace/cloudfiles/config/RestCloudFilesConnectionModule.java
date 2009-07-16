/**
 *
 * Copyright (C) 2009 Global Cloud Specialists, Inc. <info@globalcloudspecialists.com>
 *
 * ====================================================================
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 * ====================================================================
 */
package org.jclouds.rackspace.cloudfiles.config;

import java.net.URI;

import org.jclouds.cloud.ConfiguresCloudConnection;
import org.jclouds.http.RequiresHttp;
import org.jclouds.rackspace.Storage;
import org.jclouds.rackspace.cloudfiles.CloudFilesConnection;
import org.jclouds.rackspace.cloudfiles.CloudFilesContext;
import org.jclouds.rackspace.cloudfiles.internal.GuiceCloudFilesContext;
import org.jclouds.rest.RestClientFactory;

import com.google.inject.AbstractModule;
import com.google.inject.Provides;
import com.google.inject.Singleton;

/**
 * Configures the Cloud Files connection, including logging and http transport.
 * 
 * @author Adrian Cole
 */
@ConfiguresCloudConnection
@RequiresHttp
public class RestCloudFilesConnectionModule extends AbstractModule {

   @Override
   protected void configure() {
      bind(CloudFilesContext.class).to(GuiceCloudFilesContext.class);
   }
   
   @Provides
   @Singleton
   protected CloudFilesConnection provideConnection(@Storage URI authenticationUri,
            RestClientFactory factory) {
      return factory.create(authenticationUri, CloudFilesConnection.class);
   }

}