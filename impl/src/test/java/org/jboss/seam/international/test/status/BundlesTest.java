/*
 * JBoss, Home of Professional Open Source
 * Copyright 2011, Red Hat, Inc., and individual contributors
 * by the @authors tag. See the copyright.txt in the distribution for a
 * full listing of individual contributors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * http://www.apache.org/licenses/LICENSE-2.0
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.jboss.seam.international.test.status;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.ResourceBundle;

import javax.inject.Inject;

import org.jboss.arquillian.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.seam.international.locale.DefaultLocale;
import org.jboss.seam.international.locale.DefaultLocaleProducer;
import org.jboss.seam.international.status.ApplicationBundles;
import org.jboss.seam.international.status.Bundles;
import org.jboss.shrinkwrap.api.ArchivePaths;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.junit.Test;
import org.junit.runner.RunWith;

/**
 * @author <a href="http://community.jboss.org/people/kenfinni">Ken Finnigan</a>
 */
@RunWith(Arquillian.class)
public class BundlesTest {
    private static final String BUNDLE_PATH = "org.jboss.seam.international.test.status.TestBundle";

    @Deployment
    public static WebArchive createTestArchive() {
        return ShrinkWrap
                .create(WebArchive.class, "test.war")
                .addPackage(DefaultLocaleProducer.class.getPackage())
                .addPackage(ApplicationBundles.class.getPackage())
                .addClass(DefaultLocale.class)
                .addClass(Bundles.class)
                .addAsManifestResource(EmptyAsset.INSTANCE, ArchivePaths.create("beans.xml"));
    }

    @Inject
    Bundles bundles;

    @Test
    public void testGetBundles() {
        bundles.put("keyTest", ResourceBundle.getBundle(BUNDLE_PATH));
        assertEquals(1, bundles.size());
        ResourceBundle bdle = bundles.get("keyTest");
        assertNotNull(bdle);
    }
}
