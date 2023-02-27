package com.dangkang.infrastructure.reportcontext.sh.openedaccounts;

import com.dangkang.domain.reportcontext.model.Node;
import com.dangkang.domain.reportcontext.model.sh.openedaccounts.node.OpenedAccountNode;
import com.dangkang.infrastructure.reportcontext.sh.openedaccounts.repositoryimpl.dataobject.OpenedAccountDO;
import com.dangkang.infrastructure.reportcontext.sh.openedaccounts.repositoryimpl.dataobject.ibatis.OpenedAccountDOIbatis;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.ArrayList;
import java.util.List;

@Mapper
public interface OpenedAccountConverter {
    OpenedAccountConverter INSTANCE= Mappers.getMapper(OpenedAccountConverter.class);

    @Mapping(source="fullName" ,target="investorFullName")
    public OpenedAccountNode toNode(OpenedAccountDOIbatis openedAccountDO );

    public static List<Node> convert2NodeList(List<OpenedAccountDOIbatis> openedAccountDOList) {
        List<Node> nodeList = new ArrayList<>() ;
        for(OpenedAccountDOIbatis openedAccountDO:openedAccountDOList) {
            nodeList.add(OpenedAccountConverter.INSTANCE.toNode(openedAccountDO));
                   /* new OpenedAccountNode()
                            .setCreatedDate(openedAccountDOList.get(i).getCreateDate())
                            .setInvestorFullName(openedAccountDOList.get(i).getFullName())
                            .setEscrowAccountNumber(openedAccountDOList.get(i).getEscrowAccountNumber())
                            .setIdentityCode(openedAccountDOList.get(i).getIdentityCode())*/

        }
        return nodeList ;
    }
}
