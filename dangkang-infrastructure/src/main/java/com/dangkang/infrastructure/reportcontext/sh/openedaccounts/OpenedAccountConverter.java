package com.dangkang.infrastructure.reportcontext.sh.openedaccounts;

import com.dangkang.domain.reportcontext.model.Node;
import com.dangkang.domain.reportcontext.model.sh.openedaccounts.node.OpenedAccountNode;
import com.dangkang.infrastructure.reportcontext.sh.openedaccounts.repositoryimpl.dataobject.OpenedAccountDO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.ArrayList;
import java.util.List;

@Mapper
public interface OpenedAccountConverter {
    OpenedAccountConverter INSTANCE= Mappers.getMapper(OpenedAccountConverter.class);

    @Mapping(source="fullName" ,target="investorFullName")
    public OpenedAccountNode toNode(OpenedAccountDO openedAccountDO );

    public static List<Node> convert2NodeList(List<OpenedAccountDO> openedAccountDOList) {
        List<Node> nodeList = new ArrayList<>() ;
        for(OpenedAccountDO openedAccountDO:openedAccountDOList) {
            nodeList.add(OpenedAccountConverter.INSTANCE.toNode(openedAccountDO));
        }
        return nodeList ;
    }

}
