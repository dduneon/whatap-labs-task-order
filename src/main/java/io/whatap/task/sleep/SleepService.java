package io.whatap.task.sleep;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;

/**
 * sleep 에 관한 기능을 제공하는 서비스 클래스
 *
 * @author 김준현
 * @version 2024. 03. 09
 */
@ApplicationScoped
public class SleepService {
    private final EntityManager entityManager;

    public SleepService(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    /**
     * 특정 시간(초)동안 실행 지연을 DB에 요청하는 메서드
     * 단, DataSource 가 PostgreSQL 일 경우에만 동작
     *
     * @param interval 프로세스가 진행되기 전 반드시 경과해야 하는 시간(초)
     */
    public void callPgSleep(Double interval) {
        Query query = entityManager.createNativeQuery("SELECT pg_sleep(?)")
                .setParameter(1, interval);
        query.getResultList();
    }
}
