package com.dangkang.infrastructure.reportcontext.converter;

import com.dangkang.domain.reportcontext.model.Node;
import com.dangkang.domain.reportcontext.model.openedaccounts.node.OpenedAccountNode;
import com.dangkang.infrastructure.reportcontext.repositoryimpl.dataobject.OpenedAccountDO;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Orkesh
 * @date 2023/2/23 12:22
 * 描述 :         开户数据DO(DATA OBJECT) 和 Node对象之间的 Converter
 */
public class OpenedAccountConverter {

    public static List<Node> convertToNodeList (List<OpenedAccountDO> openedAccountDOS) {
        List<Node> nodeList = new ArrayList<>() ;
        for(int i = 0 ; i < openedAccountDOS.size() ; ++ i) {
            nodeList.add(
                    new OpenedAccountNode()
                            .setDate(openedAccountDOS.get(i).getCreateDate())
                            .setInvestorFullName(openedAccountDOS.get(i).getFullName())
                            .setEscrowAccount(openedAccountDOS.get(i).getEscrowAccountNumber())
                            .setIdentityNumber(openedAccountDOS.get(i).getIdentityCode())
            );
        }
        return nodeList ;
    }
}
