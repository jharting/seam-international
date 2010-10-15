/*
 * JBoss, Home of Professional Open Source
 * Copyright 2010, Red Hat, Inc., and individual contributors
 * by the @authors tag. See the copyright.txt in the distribution for a
 * full listing of individual contributors.
 *
 * This is free software; you can redistribute it and/or modify it
 * under the terms of the GNU Lesser General Public License as
 * published by the Free Software Foundation; either version 2.1 of
 * the License, or (at your option) any later version.
 *
 * This software is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this software; if not, write to the Free
 * Software Foundation, Inc., 51 Franklin St, Fifth Floor, Boston, MA
 * 02110-1301 USA, or see the FSF site: http://www.fsf.org.
 */
package org.jboss.seam.international.test.locale;

import java.util.List;
import java.util.Locale;

import javax.inject.Inject;

import org.jboss.arquillian.api.Deployment;
import org.jboss.seam.international.locale.AvailableLocales;
import org.jboss.shrinkwrap.api.ArchivePaths;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.junit.Assert;
import org.junit.Test;

//@RunWith(Arquillian.class)
public class AvailableLocalesTest
{
   @Deployment
   public static JavaArchive createTestArchive()
   {
      return ShrinkWrap.create("test.jar", JavaArchive.class).addClasses(AvailableLocales.class).addManifestResource("org/jboss/seam/international/test/locale/override-available.xml", ArchivePaths.create("beans.xml"));
   }

   @Inject
   List<Locale> locales;

   // FIXME XML Override not working
   // @Test
   public void testAvailableLocalesProducer()
   {
      Assert.assertNotNull(locales);
      Assert.assertEquals(2, locales.size());
   }

   @Test
   public void testNothing()
   {
   }
}
