package com.dangkang.infrastructure.reportcontext.sh.openedaccounts;

import com.dangkang.domain.reportcontext.model.sh.openedaccounts.node.OpenedAccountNode;
import com.dangkang.infrastructure.reportcontext.sh.openedaccounts.repositoryimpl.dataobject.OpenedAccountDO;
import javax.annotation.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-03-21T15:48:35+0800",
    comments = "version: 1.5.0.Beta1, compiler: javac, environment: Java 19.0.1 (Oracle Corporation)"
)
public class OpenedAccountConverterImpl implements OpenedAccountConverter {

    @Override
    public OpenedAccountNode toNode(OpenedAccountDO openedAccountDO) {
        if ( openedAccountDO == null ) {
            return null;
        }

        OpenedAccountNode openedAccountNode = new OpenedAccountNode();

        openedAccountNode.setInvestorFullName( openedAccountDO.getFullName() );
        openedAccountNode.setEscrowAccountNumber( openedAccountDO.getEscrowAccountNumber() );
        openedAccountNode.setIdentityCode( openedAccountDO.getIdentityCode() );
        openedAccountNode.setCreatedDate( openedAccountDO.getCreatedDate() );

        return openedAccountNode;
    }
}
