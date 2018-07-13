package thirdpart.singleton.mx;

import lombok.Data;

@Data
public class MailServer {

    /**
     * 优先权
     */
    private int priority;
    /**
     * 服务器名
     */
    private String server;

}
