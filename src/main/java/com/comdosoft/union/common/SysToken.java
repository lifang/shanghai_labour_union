package com.comdosoft.union.common;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StringUtils;

/**
 * <br>
 * <功能描述>
 *
 * @author zengguang 2014年12月9日
 *
 */
public class SysToken {
    private static final Logger logger = LoggerFactory.getLogger(SysToken.class);
    private static final String TOKEN_LIST_NAME = "tokenList";

    /**
     * 分割符号（英文L小写）
     */
    private static final String SEGMENTATION_MARK = "l";

    /**
     * Generate a token string, and save the string in session, then return the token string.
     * 
     * @param HttpSession
     *            session
     * @param id
     * @return
     */
    public static String getNewToken(HttpSession session, int id) {
        String token = generateToken(id);
        saveToken(token, session);
        return token;
    }

    /**
     * Check whether token string is valid.<br>
     * <if session contains the token string, return true.otherwise, return false.>
     * 
     * @param token
     * @param id
     * @param session
     * @return true: session contains token; false: session is null or token is not in session
     */
    public static boolean isTokenValid(String token, int id, HttpSession session) {
        boolean valid = false;
        if (session != null && !StringUtils.isEmpty(token)) {
            List<String> tokenList = getTokenList(session);
            if (tokenList.contains(token)) {
                if (isTokenExpired(token, id)) {// 判断token是否已过期
                    tokenList.remove(token);
                } else {
                    valid = true;
                }
            }
        }
        return valid;
    }

    /**
     * Remove session token
     * 
     * @param token
     * @param session
     */
    public static void removeToken(String token, HttpSession session) {
        logger.debug("token===>>"+token);
        List<String> tokenList = getTokenList(session);
        if (tokenList.contains(token)) {
            tokenList.remove(token);
        }
    }

    /**
     * 获取session中的tokenList
     * 
     * @param session
     * @return
     */
    @SuppressWarnings("unchecked")
    private static List<String> getTokenList(HttpSession session) {
        Object obj = session.getAttribute(TOKEN_LIST_NAME);
        if (obj != null) {
            return (ArrayList<String>) obj;
        } else {
            List<String> tokenList = new ArrayList<String>();
            session.setAttribute(TOKEN_LIST_NAME, tokenList);
            return tokenList;
        }
    }

    /**
     * 保存token到session
     * 
     * @param token
     * @param session
     */
    private static void saveToken(String token, HttpSession session) {
        List<String> tokenList = getTokenList(session);
        tokenList.add(token);
        session.setAttribute(TOKEN_LIST_NAME, tokenList);
    }

    /**
     * 生成token
     * 
     * @param id
     * @return
     */
    private static String generateToken(int id) {
        return new Long(System.currentTimeMillis()).toString() + SEGMENTATION_MARK + id;
    }

    /**
     * 验证token是否已过期<br>
     * <if token生成时间超过60分钟, return true. otherwise, return false.>
     * 
     * @param token_in
     *            请求时携带的token
     * @param id_in
     *            请求时携带的用户id
     * @return true:已过期; false:未过期
     */
    private static boolean isTokenExpired(String token_in, int id_in) {
        int id_old = Integer.parseInt(token_in.substring(token_in.indexOf(SEGMENTATION_MARK) + 1));
        logger.debug("token ==>>id_old==>>"+id_old+"   id_in>>>"+id_in);
        // String tokenGenerateTime_old = token_in.substring(0, token_in.indexOf(SEGMENTATION_MARK));
        // String token_new = generateToken(id_in);
        // String tokenGenerateTime_new = token_new.substring(0, token_in.indexOf(SEGMENTATION_MARK));
        // long tokenGenerateTimeLong_old = Long.parseLong(tokenGenerateTime_old);
        // long tokenGenerateTimeLong_new = Long.parseLong(tokenGenerateTime_new);
        // long differenceMillisecond = tokenGenerateTimeLong_new - tokenGenerateTimeLong_old;// 得到两者相差的毫秒数
        if (id_in != id_old) {
            return true;
        }
        return false;
    }

}