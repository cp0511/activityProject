package cn.lastwhisper.modular.util;

import java.util.UUID;

/**
 * Created by 程程有小棉被啊 on 2020年04月04日.
 */
public class IDUtil {

    public IDUtil() {
    }
    /**
     * 自动生成32位的UUid，对应数据库的主键id进行插入用。
     * @return
     */
    public static String getUUID() {

        return UUID.randomUUID().toString().replace("-", "");
    }
}
