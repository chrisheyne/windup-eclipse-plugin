/*******************************************************************************
 * Copyright (c) 2016 Red Hat, Inc.
 * Distributed under license by Red Hat, Inc. All rights reserved.
 * This program is made available under the terms of the
 * Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   Red Hat, Inc. - initial API and implementation
 ******************************************************************************/
package org.jboss.tools.windup.ui.tests;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.eclipse.swt.widgets.Tree;
import org.jboss.tools.windup.ui.internal.explorer.IssueExplorer;
import org.jboss.tools.windup.windup.ConfigurationElement;
import org.junit.Test;

/**
 * Tests surrounding the Issue Explorer.
 */
public class IssueExplorerTests extends WindupUiTest {
	
	/**
	 * Issue Explorer should be open by default.
	 */
	@Test
	public void testOpenIssueExplorerOpen() {
		assertNotNull(partService.findPart(IssueExplorer.VIEW_ID));
	}
	
	/**
	 * Issue Explorer should contain migration issues after Windup execution. 
	 */
	@Test
	public void testIssueExplorerPopulated() {
		ConfigurationElement configuration = super.createRunConfiguration();
		markerService.deleteAllWindupMarkers();
		super.runWindup(configuration);
		IssueExplorer explorer = super.getIssueExplorer();
		explorer.getCommonViewer().expandAll();
		Tree tree = explorer.getCommonViewer().getTree();
		assertTrue(tree.getItems().length > 0);
	}
}
