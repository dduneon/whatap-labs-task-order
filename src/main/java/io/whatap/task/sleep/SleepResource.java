package io.whatap.task.sleep;

import jakarta.ws.rs.DefaultValue;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.Response;

/**
 * /api/sleep 하위로 들어오는 요청을 받아 적절한 응답을 보내는 리소스 클래스
 *
 * @author 김준현
 * @version 2024. 03. 09
 */

@Path("/api/sleep")
public class SleepResource {
    private final SleepService sleepService;

    public SleepResource(SleepService sleepService) {
        this.sleepService = sleepService;
    }

    /**
     * 지정한 interval 과 함께 지연(sleep) 요청을 받는 메서드
     *
     * @param interval 지연시키고 싶은 시간 (단위: 초), 초기 값은 10
     * @return 성공시 NO_Content, interval (초) 이후 응답
     */
    @GET
    public Response callSleep(@QueryParam("interval") @DefaultValue("10") Double interval) {
        sleepService.callPgSleep(interval);
        return Response.noContent().build();
    }
}
