// ============================================================================
//
// Copyright (C) 2006-2012 Talend Inc. - www.talend.com
//
// This source code is available under agreement available at
// %InstallDIR%\features\org.talend.rcp.branding.%PRODUCTNAME%\%PRODUCTNAME%license.txt
//
// You should have received a copy of the agreement
// along with this program; if not, write to Talend SA
// 9 rue Pages 92150 Suresnes, France
//
// ============================================================================
package tosstudio.metadata.ldap;

import org.eclipse.swtbot.swt.finder.junit.SWTBotJunit4ClassRunner;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.talend.core.model.repository.ERepositoryObjectType;
import org.talend.swtbot.TalendSwtBotForTos;
import org.talend.swtbot.items.TalendLdapItem;

/**
 * DOC Administrator class global comment. Detailled comment
 */
@RunWith(SWTBotJunit4ClassRunner.class)
public class DuplicateLdapTest extends TalendSwtBotForTos {

    private TalendLdapItem ldapItem;

    private static final String LDAPNAME = "ldap1"; //$NON-NLS-1$

    private static final String NEW_LDAPNAME = "duplicate_ldap1"; //$NON-NLS-1$

    @Before
    public void initialisePrivateFields() {
        repositories.add(ERepositoryObjectType.METADATA_LDAP_SCHEMA);
        ldapItem = new TalendLdapItem(LDAPNAME);
        ldapItem.create();
    }

    @Test
    public void duplicateLdap() {
        ldapItem.duplicate(NEW_LDAPNAME);
    }

}