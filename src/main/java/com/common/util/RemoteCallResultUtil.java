package com.common.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.fastjson.JSON;
import com.company.project.core.Result;
import com.company.project.core.ResultCode;
import com.company.project.core.ServiceException;

/**
 * 远程调用时候，通常接口包装为统一的返回，比如Result，然后调用方从Result取信息，同时处理Result可能为null、
 * failed的情况，所有的地方都各自处理，会有大量的重复逻辑，可以抽象封装出一个公共的功能；
 * 
 * @author zhangyanxiang 2020年9月15日 下午4:57:57
 */
public class RemoteCallResultUtil {
    private static final Logger logger = LoggerFactory.getLogger(RemoteCallResultUtil.class);

    public static <T> T checkRemoteCallReturnResult(Result<T> result, String msg) {
        String nullErrorMsg = null == msg ? "业务失败的异常" : msg;
        if (null == result) {
            logger.error("=======checkRemoteCallReturnResult,nullErrorMsg:{}", nullErrorMsg);
            throw new ServiceException(nullErrorMsg);
        }
        if (ResultCode.SUCCESS.code() != result.getCode()) {
            String failedMsg = null == result.getMessage() ? nullErrorMsg : result.getMessage();
            logger.error("=======checkRemoteCallReturnResult,result:{},failedMsg:{}", JSON.toJSONString(result),
                    failedMsg);
            throw new ServiceException(failedMsg);
        }
        return result.getData();
    }

    public static <T> T checkRemoteCallReturnResult(Result<T> result) {
        return checkRemoteCallReturnResult(result, null);
    }

}
