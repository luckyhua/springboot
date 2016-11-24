package com.luckyhua.springboot.global.context.utils;

import com.luckyhua.springboot.enums.PublicEnums;
import com.luckyhua.springboot.enums.ResultEnums;
import com.luckyhua.springboot.global.context.easyui.DataGridResult;
import com.luckyhua.springboot.global.context.json.ResponseInfo;
import com.luckyhua.springboot.global.context.model.PageInfo;

import java.util.List;

/**
 * @author luckyhua
 * @date 2016/11/24
 * @description result utils class
 */
public abstract class ResponseUtils {

    public static ResponseInfo buildResponseInfo() {
        return buildResponseInfo(PublicEnums.SUCCESS);
    }

    public static ResponseInfo buildResponseInfo(ResultEnums resultEnums) {
        return new ResponseInfo(resultEnums);
    }

    public static DataGridResult buildDataGridResult(PageInfo pageInfo, List<?> data){
        return new DataGridResult(pageInfo.getTotalCount(), data);
    }

}
