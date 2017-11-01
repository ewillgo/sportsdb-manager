package cc.sportsdb.manager.controller.manager;

import cc.sportsdb.common.dto.Result;
import cc.sportsdb.common.helper.ConstPair;

public interface ManagerConst {
    ConstPair MANAGER_ADD_SUCCESS = ConstPair.make(Result.SUCCESS, "Manager added.");
    ConstPair MANAGER_ADD_FAIL = ConstPair.make(Result.FAIL, "Manager added fail.");
}
